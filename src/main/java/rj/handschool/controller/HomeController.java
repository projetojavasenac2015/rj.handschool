package rj.handschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rj.handschool.dao.ProfessorDAO;
import rj.handschool.model.Professor;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private ProfessorDAO professorDAO;
	
	@RequestMapping(value = {"/login","/"}, method = RequestMethod.GET)
	public String firstPage(Model model) {
		model.addAttribute("firstPageMessage", "This is the first page");
		return "login";
	}
	
	@RequestMapping(value="/CadastramentoTurma", method = RequestMethod.GET)
	public String turmaNova(Model model) {
		return "turma_nova";
	}
	
	@RequestMapping(value="/CadastramentoMateria", method = RequestMethod.GET)
	public String materiaNova(Model model) {
		return "materia_nova";
	}
	
	@RequestMapping(value="/Curso", method = RequestMethod.GET)
	public String cursoNovo(Model model) {
		return "curso_novo";
	}
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String secondPage(Model model) {
		model.addAttribute("secondPageMessage", "This is the second page");
		return "secondpage";
	}
	
}
