package rj.handschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AtividadeController {
	@RequestMapping("/Atividades")
	public String atividades(){
		return "atividades";
	}
}
