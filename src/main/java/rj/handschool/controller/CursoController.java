package rj.handschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rj.handschool.model.Curso;

@Controller
public class CursoController {
	@RequestMapping("/NovoCurso")
	public String novoCurso(Curso curso){
		return "curso_novo";
	}
}
