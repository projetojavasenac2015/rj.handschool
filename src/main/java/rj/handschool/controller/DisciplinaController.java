package rj.handschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rj.handschool.model.Disciplina;

@Controller
public class DisciplinaController {
	@RequestMapping("/NovaDisciplina")
	public String novoCurso(Disciplina disciplina){
		return "disciplina_nova";
	}
}
