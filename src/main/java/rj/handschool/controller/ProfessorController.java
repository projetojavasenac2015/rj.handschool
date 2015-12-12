package rj.handschool.controller;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.AulaDAO;
import rj.handschool.dao.DisciplinaDAO;
import rj.handschool.dao.PessoaDAO;
import rj.handschool.dao.ProfessorDAO;
import rj.handschool.model.Aluno;
import rj.handschool.model.Ambiente;
import rj.handschool.model.Aulas;
import rj.handschool.model.Disciplina;
import rj.handschool.model.Pessoa;
import rj.handschool.model.Professor;
import rj.handschool.model.TipoPessoa;
import rj.handschool.propertys.DisciplinaPropertyEditor;
import rj.handshool.util.RotuloFormatacao;
import rj.handshool.util.Utilidades;


@Controller
public class ProfessorController {
	@Autowired
	private ProfessorDAO professorDAO;

	@Autowired
	private DisciplinaDAO disciplinaDAO;

	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Autowired
	private AulaDAO aulaDAO;

	static final String modelo_pagina = "professor_novo";
	static final Logger logger = Logger.getLogger(ProfessorController.class);

	private int qtd_aulas_dia = 0;
	
	@RequestMapping("CadastroProfessor")
	public ModelAndView novoProfessor(
			@ModelAttribute("professor") Professor professor) {
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modelView.addObject(
				"professor",
				new Professor(Utilidades.formato(RotuloFormatacao.Matricula
						.getRotuloFormatacao()), TipoPessoa.Professor));
		rotuloPagina(modelView, "Novo");
		listaDisciplina(modelView);
		return modelView;
	}

	public void rotuloPagina(ModelAndView modelView, String rotulo) {
		modelView.addObject("rotulo", rotulo);
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Disciplina.class,
				new DisciplinaPropertyEditor(disciplinaDAO));
	}

	@RequestMapping(value = "GravaProfessor", method = RequestMethod.POST)
	public ModelAndView GravaProfessor(
			@Valid @ModelAttribute("professor") Professor professor,
			BindingResult bind) throws Exception {
		ModelAndView modelView;
		String msg = "";

		if (!bind.hasErrors()) {
			try {
				Professor professor_cadastrado = professorDAO
						.findByMatricula(professor);

				if (professor_cadastrado != null) {
					professor.setIdpessoa(professor_cadastrado.getIdpessoa());
					professorDAO.update(professor);
				} else {
					professorDAO.insert(professor);
				}

				msg = "Registro Gravado com Sucesso";
			} catch (Exception e) {
				msg = e.getMessage();
			}

			modelView = new ModelAndView(modelo_pagina);
			modelView.addObject("menssagem", msg);
			return novoProfessor(professor);
		} else {
			modelView = new ModelAndView(modelo_pagina, bind.getModel());
			listaDisciplina(modelView);
		}
		return modelView;
	}

	public void listaDisciplina(ModelAndView modelView) {
		List<Disciplina> lista_disciplina = disciplinaDAO.findAll();
		modelView.addObject("listadisciplina", lista_disciplina);
	}

	@RequestMapping(value = "ProfessorDisciplina/{iddisciplina}")
	public @ResponseBody List<Professor> listarProfessorDisciplina(
			@PathVariable("iddisciplina") Integer iddisciplina)
			throws Exception {

		List<Professor> professores = new ArrayList<Professor>();

		List<Object[]> objs = professorDAO.findByDisciplina(iddisciplina);

		for (Object[] obj1 : objs) {
			Professor prof = new Professor();
			prof.setMatriculaProfessor((String) obj1[0]);
			prof.setNome((String) obj1[1]);
			professores.add(prof);
		}

		return professores;
	}

	@RequestMapping(value = "/Professor", method = RequestMethod.GET)
	public String professorInicial(Model model, Principal principal,
			HttpSession session) {
		Professor prof = new Professor();
		String email = principal.getName();

		Pessoa p = pessoaDAO.findByPessoa(email);
		prof = professorDAO.findById(p.getIdpessoa());
		session.setAttribute("profLogado", prof);
		model.addAttribute("nome_professor", prof.getNome());
		model.addAttribute("matriculaProfessor", prof.getMatriculaProfessor());
		model.addAttribute("aulasProfessor",retornaAulaDia(prof));
		model.addAttribute("qtdaulasProfessor",qtd_aulas_dia);
		
		return "professor";
	}

	@RequestMapping(value = "/alunoVinculadosProfessor/{matricula}/{turma}", method = RequestMethod.GET)
	public @ResponseBody List<Aluno> alunoVinculadosProfessor(
			@PathVariable("matricula") String matricula,
			@PathVariable("turma") int turma) {

		List<Aluno> alunos = new ArrayList<Aluno>();

		List<Object[]> obj = professorDAO.findByAlunoTurmaProfessor(matricula,
				turma);

		for (Object[] objects : obj) {
			Aluno aluno = new Aluno();
			aluno.setNome((String) objects[0]);
			aluno.setMatricula((String) objects[1]);
			aluno.setDataNascimento((Date) objects[2]);
			aluno.setEmail((String) objects[3]);
			alunos.add(aluno);
		}

		return alunos;
	}
	
	public List<Aulas> retornaAulaDia(Professor prof){
		List<Aulas> aulas = new ArrayList<Aulas>();
		
		List<Object[]> obj = aulaDAO.findByAulasDoProfessor(prof.getMatriculaProfessor());
		
		for (Object[] objects : obj) {
			Aulas aula = new Aulas();
			aula.setDataAula((Date) objects[0]);
			aula.setHoraInicio((String) objects[1]);
			aula.setHoraFim((String) objects[2]);
			aula.setAtivo((Character) objects[4]);
			
			Ambiente amb = new Ambiente();
			amb.setDescricao((String) objects[3]);
			aula.setListaambiente(amb);
			aulas.add(aula);
		}
		
		qtd_aulas_dia = aulas.size();
		return aulas;
	}
	
}
