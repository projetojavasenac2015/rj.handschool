package rj.handschool.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import rj.handschool.dao.ListaPresencaDAO;
import rj.handschool.dao.TurmaDAO;
import rj.handschool.dao.AulaDAO;
import rj.handschool.dao.DisciplinaDAO;
import rj.handschool.model.Aluno;
import rj.handschool.model.Aulas;
import rj.handschool.model.Disciplina;
import rj.handschool.model.ListaPresenca;
import rj.handschool.model.Turma;

@Controller
public class ListaPresencaController {

	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	@Autowired
	private AulaDAO aulaDAO;
	
	@Autowired
	private TurmaDAO turmaDAO;
	
	@Autowired
	private ListaPresencaDAO listaPresencaDAO;
	
	static final String  modelo_pagina = "registro_frequencia";
	
	@RequestMapping("RegistroFrequencia")
	public ModelAndView novaAula(@ModelAttribute("lista_presenca") ListaPresenca lista){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modelView.addObject("lista",new ListaPresenca());
		rotuloPagina(modelView,"Lancamento");
		return modelView;
	}
	
	public void rotuloPagina(ModelAndView modelView,String rotulo){
		modelView.addObject("rotulo",rotulo);
	}

	@RequestMapping(value = "TurmaProfessor/{matricula}")
	public @ResponseBody List<Turma> turmaProfessor(
			@PathVariable("matricula") String matricula_profssor) throws Exception {
		
		List<Turma> turmas =  new ArrayList<Turma>();
		
		List<Object[]> objs = turmaDAO.findByTurmaProfessor(matricula_profssor);
		
		for (Object[] objects : objs) {
			Turma turma = new Turma();
			turma.setIdturma((Integer)objects[0]);
			turma.setDescricao((String)objects[1]);
			turmas.add(turma);
		}
		
		return turmas;
	}
	
	@RequestMapping(value = "DisciplinasTurma/{idturma}")
	public @ResponseBody List<Disciplina> disciplinaTurma(
			@PathVariable("idturma") int idturma) throws Exception {
		
		List<Disciplina> disciplinas =  new ArrayList<Disciplina>();
		
		List<Object[]> objs = disciplinaDAO.findByDisciplinaTurma(idturma);
		
		for (Object[] objects : objs) {
			Disciplina disciplina = new Disciplina();
			disciplina.setIddisciplina((Integer)objects[0]);
			disciplina.setNome((String)objects[1]);
			disciplinas.add(disciplina);
		}
		
		return disciplinas;
	}
	
	@RequestMapping(value = "ListaPresenca/{idturma}/{iddisciplina}/{data_aula}/{matricula}")
	public @ResponseBody List<ListaPresenca> procurarTurmasAtivas(
			@PathVariable("idturma") Integer idturma
			,@PathVariable("iddisciplina") Integer iddisciplina
			,@PathVariable("data_aula") String data_aula
			,@PathVariable("matricula") String matricula) throws Exception {
		
		List<ListaPresenca> lista = new ArrayList<ListaPresenca>();
		List<Object[]> obj  = listaPresencaDAO.findByListaPresenca(idturma,iddisciplina,data_aula,matricula);
		
		for (Object[] objects : obj) {
			ListaPresenca lista_p = new ListaPresenca();
			lista_p.setAluno(new Aluno());
			lista_p.getAluno().setMatricula((String) objects[0]);;
			lista_p.getAluno().setNome((String) objects[1]);
			lista_p.setTurma(new Turma());
			lista_p.getTurma().setDescricao((String) objects[2]);
			lista_p.setDisciplina(new Disciplina());
			lista_p.getDisciplina().setNome((String) objects[3]);
			lista_p.setAulas(new Aulas());
			lista_p.getAulas().setDataAula((Date) objects[4]);
			lista_p.getAulas().setHoraInicio((String) objects[5]);
			lista_p.getAulas().setHoraFim((String) objects[6]);
			lista_p.getTurma().setIdturma((Integer) objects[7]);;
			lista_p.getDisciplina().setIddisciplina((Integer) objects[8]);
			lista.add(lista_p);
		}
		
		return lista;
	}
}
