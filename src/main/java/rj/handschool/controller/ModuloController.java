package rj.handschool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.CursoDAO;
import rj.handschool.dao.DisciplinaDAO;
import rj.handschool.dao.ModuloDAO;
import rj.handschool.model.Curso;
import rj.handschool.model.Disciplina;
import rj.handschool.model.Modulo;
import rj.handschool.propertys.CursoPropertyEditor;
import rj.handschool.propertys.DisciplinaPropertyEditor;

@Controller
public class ModuloController {

	@Autowired
	private CursoDAO cursoDAO;

	@Autowired
	private DisciplinaDAO disciplinaDAO;

	@Autowired
	private ModuloDAO moduloDAO;

	public void rotuloPagina(ModelAndView modelView, String rotulo) {
		modelView.addObject("rotulo", rotulo);
	}

	static final String modelo_pagina = "modulo";

	@RequestMapping("NovoModulo")
	public ModelAndView novoModulo(@ModelAttribute("modulo") Modulo modulo) {
		ModelAndView modelView = new ModelAndView(modelo_pagina);

		modelView.addObject("modulo", new Modulo());
		rotuloPagina(modelView, "Novo");
		listaCurso(modelView);
		listaDisciplina(modelView);
		return modelView;
	}

	@RequestMapping("ListaCursoTodos")
	public void listaCurso(ModelAndView modelView) {
		List<Curso> lista_curso = cursoDAO.findAll();
		modelView.addObject("listacurso", lista_curso);
	}

	@RequestMapping("ListaDisciplina")
	public void listaDisciplina(ModelAndView modelView) {
		List<Disciplina> lista_disciplina = disciplinaDAO.findAll();
		modelView.addObject("listadisciplina", lista_disciplina);
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Curso.class, new CursoPropertyEditor(
				cursoDAO));
		binder.registerCustomEditor(Disciplina.class, new DisciplinaPropertyEditor(disciplinaDAO));
	}

	@RequestMapping(value = "GravaModulo", method = RequestMethod.POST)
	public ModelAndView gravaDisciplina(
			@Valid @ModelAttribute("modulo") Modulo modulo, BindingResult bind)
			throws Exception {
		ModelAndView modelView;

		String msg = "";

		if (!bind.hasErrors()) {
			try {
				if (modulo.getIdmodulo() == null) {
					moduloDAO.insert(modulo);
				}
				msg = "Registro Gravado com Sucesso";
			} catch (Exception e) {
				msg = e.getMessage();
			}
			modelView = new ModelAndView(modelo_pagina);
			modelView.addObject("menssagem", msg);
			return novoModulo(modulo);
			
		} else {
			modelView = new ModelAndView(modelo_pagina, bind.getModel());
			listaCurso(modelView);
			listaDisciplina(modelView);
		}
		return modelView;
	}
}
