package rj.handschool.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.AmbienteDAO;
import rj.handschool.model.Ambiente;

@Controller
public class AmbienteController {
	@Autowired
	private AmbienteDAO ambienteDAO;
	
	static final String  modelo_pagina = "ambiente_cadastro";
	
	public void rotuloPagina(ModelAndView modelView,String rotulo){
		modelView.addObject("rotulo",rotulo);
	}
	
	public ModelAndView modeloAmbiente(ModelAndView modelView){
		modelView.addObject("ambiente",new Ambiente());
		rotuloPagina(modelView,"Novo");
		return modelView;
	}
	
	@RequestMapping("CadastroAmbiente")
	public ModelAndView novoAmbiente(@ModelAttribute("ambiente") Ambiente ambiente){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modeloAmbiente(modelView);
		return modelView;
	}
	
	@RequestMapping(value = "GravaAmbiente", method = RequestMethod.POST)
	public ModelAndView gravaAmbinte(@Valid @ModelAttribute("ambiente")Ambiente ambiente, BindingResult bind) throws Exception{
		ModelAndView modelView = new ModelAndView();
		
		String msg = "";
		
		if(!bind.hasErrors()){
			try{
				ambienteDAO.insert(ambiente);
				msg = "Registro Gravado com Sucesso";
			}
			catch(Exception e){
				msg = e.getMessage();
			}
			modelView = new ModelAndView(modelo_pagina);
			modelView.addObject("menssagem",msg);
			modeloAmbiente(modelView);
		}
		else{
			modelView = new ModelAndView(modelo_pagina,bind.getModel());
		}
		return modelView;
	}
}
