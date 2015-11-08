package rj.handschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rj.handschool.model.Turma;

@Controller
public class TurmaController {
	@RequestMapping("/NovaTurma")
	public String novoCurso(Turma turma){
		return "turma_nova";
	}
}
