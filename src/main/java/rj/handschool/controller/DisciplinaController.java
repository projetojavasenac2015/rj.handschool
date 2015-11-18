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


import rj.handschool.dao.DisciplinaDAO;
import rj.handschool.model.Disciplina;

@Controller
public class DisciplinaController {
	
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	static final String  modelo_pagina = "disciplina_nova";
	
	public void rotuloPagina(ModelAndView modelView,String rotulo){
		modelView.addObject("rotulo",rotulo);
	}
	
	@RequestMapping("NovaDisciplina")
	public ModelAndView novoDisciplina(@ModelAttribute("disciplina") Disciplina disciplina){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modelView.addObject("disciplina",new Disciplina());
		rotuloPagina(modelView,"Nova");
		return modelView;
	}
	
	@RequestMapping(value = "GravaDisciplina", method = RequestMethod.POST)
	public ModelAndView gravaDisciplina(@Valid @ModelAttribute("disciplina")Disciplina disciplina, BindingResult bind) throws Exception{
		ModelAndView modelView;
		
		String msg = "";
		
		if(!bind.hasErrors()){
			try{
				if(disciplina.getIddisciplina() == null){
					disciplinaDAO.insert(disciplina);
				}
				else{
					disciplinaDAO.update(disciplina);
				}
				
				msg = "Registro Gravado com Sucesso";
			}
			catch(Exception e){
				msg = e.getMessage();
			}
			modelView = new ModelAndView(modelo_pagina);
			modelView.addObject("menssagem",msg);
		}
		else{
			modelView = new ModelAndView(modelo_pagina,bind.getModel());
		}
		return modelView;
	}
	
	@RequestMapping(value = "DadosDisciplina/{id}", method = RequestMethod.GET)
	public ModelAndView dadosDisciplina(@PathVariable("id") int id) throws Exception{
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		Disciplina disciplina = new Disciplina();
		if(id != 0){
			disciplina = disciplinaDAO.findById(id);
		}
		modelView.addObject("disciplina", disciplina);
		rotuloPagina(modelView,"Alteração");
		return modelView;
	}
	
	@RequestMapping(value = "EditaDiscplina")
	public String dadosDisciplina(Disciplina disciplina) throws Exception{
		if(disciplina != null){
			disciplinaDAO.update(disciplina);
		}
		return "redirect:NovaDisciplina";
	}
}
