package rj.handschool.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.LoginDAO;
import rj.handschool.model.Pessoa;
import rj.handschool.model.Aluno;
import rj.handschool.model.Login;
import rj.handschool.model.TipoPessoa;
import rj.handshool.util.RotuloFormatacao;
import rj.handshool.util.Utilidades;

@Controller
public class LoginController {
	@Autowired
	private LoginDAO loginDAO;
	
	static final String  modelo_pagina = "longin";
	static final Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping("CadastroLogin")
	public ModelAndView novoAluno(@ModelAttribute("login") Login login){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		
		return modelView;
	}

}
