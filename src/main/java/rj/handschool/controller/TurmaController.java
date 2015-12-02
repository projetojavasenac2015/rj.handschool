package rj.handschool.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.AlunoDAO;
import rj.handschool.dao.CursoDAO;
import rj.handschool.dao.ModuloDAO;
import rj.handschool.dao.TurmaDAO;
import rj.handschool.model.Aluno;
import rj.handschool.model.Curso;
import rj.handschool.model.Modulo;
import rj.handschool.model.Turma;
import rj.handschool.propertys.CursoPropertyEditor;
import rj.handshool.util.RotuloFormatacao;
import rj.handshool.util.Situacao;
import rj.handshool.util.Utilidades;

@Controller
public class TurmaController {
	private final static int qtd_anos_abertura_turma = 3;
	static final String modelo_pagina = "turma_nova";
	static final String modelo_pagina2 = "composicao_turma";

	@Autowired
	private CursoDAO cursoDAO;

	@Autowired
	private TurmaDAO turmaDAO;

	@Autowired
	private ModuloDAO moduloDAO;
	
	@Autowired
	private AlunoDAO alunoDAO;

	@RequestMapping("/NovaTurma")
	public ModelAndView novaTurma(@ModelAttribute("turma") Turma turma) {
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		listaCurso(modelView);
		dadosAno(modelView);
		modelView.addObject("turma",new Turma(Utilidades.formato(RotuloFormatacao.Turma.getRotuloFormatacao())));
		return modelView;
	}

	public void dadosAno(ModelAndView modelView){
		modelView.addObject("ano_ini", Calendar.getInstance()
				.get(Calendar.YEAR));
		modelView.addObject("ano_fim",
				(Calendar.getInstance().get(Calendar.YEAR))
						+ qtd_anos_abertura_turma);
	}
	
	@RequestMapping("ListaCursoTodosAtivos")
	public void listaCurso(ModelAndView modelView) {
		List<Curso> lista_curso = cursoDAO.findCursoSituacao(Situacao.Ativo
				.getSituacao());
		modelView.addObject("listacurso", lista_curso);
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Curso.class, new CursoPropertyEditor(
				cursoDAO));
	}

	@RequestMapping(value = "GravaTurma", method = RequestMethod.POST)
	public ModelAndView gravaTurma(
			@Valid @ModelAttribute("turma") Turma turma, BindingResult bind)
			throws Exception {
		ModelAndView modelView;

		String msg = "";

		if (!bind.hasErrors()) {
			try {
				if (turma.getIdturma() == null) {
					turmaDAO.insert(turma);
				}
				msg = "Registro Gravado com Sucesso";
			} catch (Exception e) {
				msg = e.getMessage();
			}
			modelView = new ModelAndView(modelo_pagina);
			modelView.addObject("menssagem", msg);
			return novaTurma(turma);

		} else {
			modelView = new ModelAndView(modelo_pagina, bind.getModel());
			listaCurso(modelView);
			dadosAno(modelView);
		}
		return modelView;
	}

	@ResponseBody
	@RequestMapping(value = "ListaModulosCurso/{idcurso}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public List<Modulo> procurarModuloporCurso(
			@PathVariable("idcurso") Integer idcurso) throws Exception {
		List<Modulo> modulos = new ArrayList<Modulo>();
		modulos = this.moduloDAO.findModuloPorCurso(idcurso);
		return modulos;
	}
	
	@RequestMapping(value = "TurmasAtivas/{idcurso}")
	public @ResponseBody List<Turma> procurarTurmasAtivas(
			@PathVariable("idcurso") Integer idcurso) throws Exception {
		
		List<Turma> turmas = new ArrayList<Turma>();
		List<Object[]> obj  = this.turmaDAO.findByPorCurso(idcurso);
		
		for (Object[] obj1 : obj) {
			Turma turma = new Turma();
			turma.setQuantidadeAlunos((Integer) obj1[0]);
			turma.setAtivo((Character) obj1[1]);
			turma.setDescricao((String) obj1[2]);
			turma.setAno((Integer) obj1[3]);
			turma.setIdturma((Integer) obj1[4]);
			turmas.add(turma);
		}
		
		return turmas;
	}
	
	@RequestMapping(value = "AlunosMatriculadosTurma/{idturma}")
	public @ResponseBody List<Aluno> alunosMatriculadosTurma(
			@PathVariable("idturma") Integer idturma) throws Exception {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Object[]> obj  = this.alunoDAO.findByAlunosMatriculadosTurma(idturma);
		
		for (Object[] obj1 : obj) {
			Aluno aluno = new Aluno();
			aluno.setMatricula((String) obj1[0]);
			aluno.setNome((String) obj1[1]);
			alunos.add(aluno);
		}
		
		return alunos;
	}
	
	@RequestMapping("/ComporTurma")
	public ModelAndView comporTurma(@ModelAttribute("turma") Turma turma) {
		ModelAndView modelView = new ModelAndView(modelo_pagina2);
		listaCurso(modelView);
		alunoNaoMatriculado(modelView);
		return modelView;
	}
	
	public void alunoNaoMatriculado(ModelAndView model){
		model.addObject("listaAlunoNaoMatriculado", alunoDAO.findByNaoMatriculado());
	}
	
	
	@RequestMapping(value="EfetuaMatricula/{idturma}/{matricula}", method=RequestMethod.POST )
	@ResponseBody
	public void efetuarMatricula(@PathVariable("idturma") int idturma, @PathVariable("matricula") String matricula){
		if(idturma !=0 && matricula != ""){
			alunoDAO.EfetuarMatricula( idturma, matricula);
		}
	}
}
