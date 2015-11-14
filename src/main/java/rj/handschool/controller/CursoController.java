package rj.handschool.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.CursoDAO;
import rj.handschool.model.Curso;

@Controller
public class CursoController {
	
	@RequestMapping("/NovoCurso")
	public ModelAndView novoCurso(Curso curso){
		return new ModelAndView("curso_novo", "Curso", new Curso());
	}
	
	@Autowired
	private CursoDAO cursoDAO;
	
	@RequestMapping(value = "/GravaCurso", method = RequestMethod.POST)
	public String gravaCurso(Curso curso, ModelMap model, HttpServletRequest request) throws Exception{
		if(curso != null){
			cursoDAO.insert(curso);
		}
		return "curso_novo";
	}
}
