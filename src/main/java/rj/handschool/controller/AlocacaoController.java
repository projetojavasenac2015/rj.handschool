package rj.handschool.controller;

import java.math.BigInteger;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.AlocacaoDAO;
import rj.handschool.dao.AmbienteDAO;
import rj.handschool.dao.AulaDAO;
import rj.handschool.dao.DisciplinaDAO;
import rj.handschool.dao.ProfessorDAO;
import rj.handschool.model.Alocacao;
import rj.handschool.model.Aluno;
import rj.handschool.model.Ambiente;
import rj.handschool.model.Aulas;
import rj.handschool.model.Curso;
import rj.handschool.model.Disciplina;
import rj.handschool.model.ListaPresenca;
import rj.handschool.model.Professor;
import rj.handschool.model.TipoPessoa;
import rj.handschool.propertys.AmbientePropertyEditor;
import rj.handschool.propertys.DisciplinaPropertyEditor;
import rj.handshool.util.RotuloFormatacao;
import rj.handshool.util.Situacao;
import rj.handshool.util.Utilidades;

@Controller
public class AlocacaoController {
	
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	@Autowired
	private AulaDAO aulaDAO;
	
	@Autowired
	private AmbienteDAO ambienteDAO;
	
	@Autowired
	private AlocacaoDAO alocacaoDAO;
	
	@Autowired
	private ProfessorDAO professorDAO;
		
	static final String  modelo_pagina = "alocacao_professor";
	
	@RequestMapping("AlocacaoProfessor")
	public ModelAndView novaAula(@ModelAttribute("alocacao") Alocacao alocacao){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modelView.addObject("alocacao",new Alocacao());
		rotuloPagina(modelView,"Alocação");
		listaDisciplina(modelView);
		return modelView;
	}
	
	public void rotuloPagina(ModelAndView modelView,String rotulo){
		modelView.addObject("rotulo",rotulo);
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Disciplina.class, new DisciplinaPropertyEditor(disciplinaDAO));
	}
	
	public void listaDisciplina(ModelAndView modelView) {
		List<Disciplina> lista_disciplina = disciplinaDAO.findAll();
		modelView.addObject("listadisciplina", lista_disciplina);
	}

	@RequestMapping(value = "AulasNaoAlocadas/{iddisciplina}/{data}")
	public @ResponseBody List<Aulas> aulasNaoALocadas(
			@PathVariable("data") String data, @PathVariable("iddisciplina") Integer iddisciplina ) throws Exception {
			
		List<Aulas> aulas =  new ArrayList<Aulas>();
		
		List<Object[]> objs = aulaDAO.findByAulasNaoAlocadas(iddisciplina, data);
			 
		String data_aux = "";
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		
		for (Object[] obj1 : objs) {
			Aulas aula = new Aulas();
			data_aux = (String)obj1[0];
			
			aula.setDataAula(df.parse(data_aux));
			aula.setHoraInicio((String)obj1[1]);
			aula.setHoraFim((String)obj1[2]);
			Ambiente ambiente = new Ambiente();
			ambiente.setNome((String)obj1[3]);
			aula.setListaambiente(ambiente);
			aula.setIdaulas((Integer) obj1[4] );
			aulas.add(aula);
		}
		
		return aulas;
	}
	
	@RequestMapping(value = "AlocacaoProfessorAula/{matricula}/{aula}")
	public @ResponseBody void alocarProfessor(@PathVariable("matricula") String matricula_professor
			, @PathVariable("aula") int idaula) throws Exception{
		Aulas aula = aulaDAO.findById(idaula);
		Professor prof2 = new Professor(matricula_professor);
		Professor prof = professorDAO.findByMatricula(prof2);
		Alocacao alocacao = new Alocacao(prof,aula);
		alocacaoDAO.insert(alocacao);
	}
}
