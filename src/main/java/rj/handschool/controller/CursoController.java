package rj.handschool.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.CursoDAO;
import rj.handschool.model.Curso;

@Controller
public class CursoController {
	@Autowired
	private CursoDAO cursoDAO;
	
	@RequestMapping("NovoCurso")
	public ModelAndView novoCurso(Curso curso){
		ModelAndView modelView = new ModelAndView("curso_novo");
		modelView.addObject("Curso",new Curso());
		modelView.addObject("listaUltimosCursosCastrados",cursoDAO.findUltimosCadastrados(5));
		return modelView;
	}
	
	@RequestMapping(value = "GravaCurso", method = RequestMethod.POST)
	public String gravaCurso(@Valid Curso curso, ModelMap model, HttpServletRequest request, BindingResult bind) throws Exception{
		if(!bind.hasErrors()){
			if(curso.getIdcurso() == null){
				cursoDAO.insert(curso);
			}
			else{
				cursoDAO.update(curso);
			}
		}
		
		return "redirect:NovoCurso";
	}
	
	@RequestMapping(value = "DadosCurso/{id}", method = RequestMethod.GET)
	public ModelAndView dadosCurso(@PathVariable("id") int id) throws Exception{
		ModelAndView modelView = new ModelAndView("curso_novo");
		Curso curso = null;
		if(id != 0){
			curso = cursoDAO.findById(id);
		}
		modelView.addObject("Curso", curso);
		return modelView;
	}
	
	@RequestMapping(value = "EditaCurso")
	public String dadosCurso(Curso curso) throws Exception{
		if(curso != null){
			cursoDAO.update(curso);
		}
		return "redirect:NovoCurso";
	}
	
	@RequestMapping(value = "DeletarCurso/{id}")
	public String deleteCurso(@PathVariable("id") int id, Curso curso) throws Exception{
		if(id != 0){
			cursoDAO.remove(id);
		}
		return "redirect:NovoCurso";
	}
	
	@RequestMapping(value="/ListaUltimosCursosCadastrados")
	public ModelAndView listaUltimosCursosCadastrados(){
		ModelAndView modelView = new ModelAndView("ultimos_cursos");
		modelView.addObject("listaUltimosCursosCastrados",cursoDAO.findUltimosCadastrados(100));
		return modelView;
	}
}
