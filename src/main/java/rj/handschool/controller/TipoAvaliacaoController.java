package rj.handschool.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.CursoDAO;
import rj.handschool.dao.TipoAvaliacaoDAO;
import rj.handschool.model.Curso;
import rj.handschool.model.TipoAvaliacao;

@Controller
public class TipoAvaliacaoController {
	@Autowired
	private TipoAvaliacaoDAO tipoAvaliacaoDAO;
	
	static final String  modelo_pagina = "tipo_avaliacao";
	
	public void rotuloPagina(ModelAndView modelView,String rotulo){
		modelView.addObject("rotulo",rotulo);
	}
	
	public ModelAndView modeloTipoAvaliacao(ModelAndView modelView){
		modelView.addObject("tipoAvaliacao",new TipoAvaliacao());
		rotuloPagina(modelView,"Novo");
		return modelView;
	}
	
	@RequestMapping("CadastroTipoAvaliacao")
	public ModelAndView novoTipo(@ModelAttribute("tipoAvaliacao") TipoAvaliacao tipoAvaliacao){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modeloTipoAvaliacao(modelView);
		return modelView;
	}
	
	@RequestMapping(value = "GravaTipoAvaliacao", method = RequestMethod.POST)
	public ModelAndView gravaTipoAvaliacao(@Valid @ModelAttribute("tipoAvaliacao")TipoAvaliacao tipoAvaliacao, BindingResult bind) throws Exception{
		ModelAndView modelView;
		
		String msg = "";
		
		if(!bind.hasErrors()){
			try{
				tipoAvaliacaoDAO.insert(tipoAvaliacao);
				msg = "Registro Gravado com Sucesso";
			}
			catch(Exception e){
				msg = e.getMessage();
			}
			modelView = new ModelAndView(modelo_pagina);
			novoTipo(tipoAvaliacao);
		}
		else{
			modelView = new ModelAndView(modelo_pagina,bind.getModel());
		}
		
		return modelView;
	}
}
