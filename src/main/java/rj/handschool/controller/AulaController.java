package rj.handschool.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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

import rj.handschool.dao.AulaDAO;
import rj.handschool.dao.DisciplinaDAO;
import rj.handschool.model.Aluno;
import rj.handschool.model.Aulas;
import rj.handschool.model.Curso;
import rj.handschool.model.Disciplina;
import rj.handschool.model.ListaPresenca;
import rj.handschool.model.Professor;
import rj.handschool.model.TipoPessoa;
import rj.handschool.propertys.DisciplinaPropertyEditor;
import rj.handshool.util.RotuloFormatacao;
import rj.handshool.util.Utilidades;

@Controller
public class AulaController {
	@RequestMapping("/RegistroFrequencia")
	public String novoAluno(ListaPresenca lista){
		return "registro_frequencia";
	}
	
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	@Autowired
	private AulaDAO aulaDAO;
	
	static final String  modelo_pagina = "lancamento_aula";
	
	@RequestMapping("LancamentoAula")
	public ModelAndView novoProfessor(@ModelAttribute("aula") Aulas aula){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modelView.addObject("professor",new Professor(Utilidades.formato(RotuloFormatacao.Matricula.getRotuloFormatacao()),TipoPessoa.Professor));
		rotuloPagina(modelView,"Lancamento");
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

	@RequestMapping(value = "VerificaHorarioDisponivelAula/{data}/{iddisciplina}")
	public @ResponseBody List<String> alunosMatriculadosTurma(
			@PathVariable("data") String data, @PathVariable("iddisciplina") Integer iddisciplina ) throws Exception {
		
		List<String> horarios =  new ArrayList<String>();
		
		List<Object[]> objs = aulaDAO.findVerificaHorarios(data,iddisciplina);
			 
		for (Object[] objects : objs) {
			horarios.add(objects.toString());
		}
		
		return horarios;
	}
	
	@RequestMapping(value = "GravaAula", method = RequestMethod.POST)
	public ModelAndView gravaCurso(@Valid @ModelAttribute("aula")Aulas aula, BindingResult bind) throws Exception{
		ModelAndView modelView;
		
		String msg = "";
		
		if(!bind.hasErrors()){
			try{
				aulaDAO.insert(aula);
				msg = "Registro Gravado com Sucesso";
			}
			catch(Exception e){
				msg = e.getMessage();
			}
			modelView = new ModelAndView(modelo_pagina);
			modelView.addObject("menssagem",msg);
		}
		else{
			modelView = new ModelAndView(modelo_pagina,bind.getModel());
			listaDisciplina(modelView);
		}
		
		return modelView;
	}
}
