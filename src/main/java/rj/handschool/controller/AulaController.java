package rj.handschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rj.handschool.model.Aulas;
import rj.handschool.model.ListaPresenca;

@Controller
public class AulaController {
	@RequestMapping("/RegistroFrequencia")
	public String novoAluno(ListaPresenca lista){
		return "registro_frequencia";
	}
}
