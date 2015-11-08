package rj.handschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rj.handschool.model.Aluno;

@Controller
public class AlunoController {
	@RequestMapping("/NovoAluno")
	public String novoAluno(Aluno aluno){
		return "aluno_novo";
	}
}
