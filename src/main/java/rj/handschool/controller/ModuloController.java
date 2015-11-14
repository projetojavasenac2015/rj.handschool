package rj.handschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModuloController {
	@RequestMapping("/NovoModulo")
	public String novoModulo(){
		return "modulo";
	}
}
