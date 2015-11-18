package rj.handschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.CursoDAO;
import rj.handschool.dao.DisciplinaDAO;
import rj.handschool.model.Curso;
import rj.handschool.model.Disciplina;
import rj.handschool.model.Modulo;

@Controller
public class ModuloController {
	
	@Autowired
	private CursoDAO cursoDAO;
	
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	public void rotuloPagina(ModelAndView modelView,String rotulo){
		modelView.addObject("rotulo",rotulo);
	}
	
	static final String  modelo_pagina = "modulo";
	
	@RequestMapping("NovoModulo")
	public ModelAndView novoModulo(@ModelAttribute("modulo") Modulo modulo){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modelView.addObject("modulo",new Modulo());
		rotuloPagina(modelView,"Novo");
		listaCurso(modelView);
		listaDisciplina(modelView);
		return modelView;
	}
	
	@RequestMapping("ListaCursoTodos")
	public void listaCurso(ModelAndView modelView){
		List<Curso> lista_curso =  cursoDAO.findAll();
		modelView.addObject("listacurso",lista_curso);
	}
	
	@RequestMapping("ListaDisciplina")
	public void listaDisciplina(ModelAndView modelView){
		List<Disciplina> lista_disciplina =  disciplinaDAO.findAll();
		modelView.addObject("listadisciplina",lista_disciplina);
	}
}
