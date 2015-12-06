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

import rj.handschool.dao.AlunoDAO;
import rj.handschool.model.Aluno;
import rj.handschool.model.Login;
import rj.handschool.dao.LoginDAO;
import rj.handschool.model.TipoPessoa;
import rj.handshool.util.RotuloFormatacao;
import rj.handshool.util.Utilidades;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoDAO alunoDAO;
	private LoginDAO loginDAO;
	
	static final String  modelo_pagina = "aluno_novo";
	static final Logger logger = Logger.getLogger(AlunoController.class);
	
	@RequestMapping("CadastroALuno")
	public ModelAndView novoAluno(@ModelAttribute("aluno") Aluno aluno){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modelView.addObject("aluno",new Aluno(Utilidades.formato(RotuloFormatacao.Matricula.getRotuloFormatacao()),TipoPessoa.Aluno));
		rotuloPagina(modelView,"Novo");
		return modelView;
	}
	
	public void rotuloPagina(ModelAndView modelView,String rotulo){
		modelView.addObject("rotulo",rotulo);
	}
	
	@RequestMapping(value = "GravaAluno", method = RequestMethod.POST)
	public ModelAndView gravaAluno(@Valid @ModelAttribute("aluno")Aluno aluno, BindingResult bind) throws Exception{
		ModelAndView modelView;
		String msg = "";
		
		if(!bind.hasErrors()){
			try{
				Aluno aluno_cadatrado = alunoDAO.findByMatricula(aluno);
				Login login = new Login();
				login.setAtivo('S');				
				login.setPessoa(aluno);
				if(aluno_cadatrado != null){
					aluno.setIdpessoa(aluno_cadatrado.getIdpessoa());
					alunoDAO.update(aluno);
					loginDAO.update(login);
				}
				else{
					alunoDAO.insert(aluno);
					loginDAO.insert(login);
				}
				
				msg = "Registro Gravado com Sucesso";
			}
			catch(Exception e){
				msg = e.getMessage();
			}
			
			modelView = new ModelAndView(modelo_pagina);
			modelView.addObject("menssagem",msg);
			novoAluno(aluno);
		}
		else{
			modelView = new ModelAndView(modelo_pagina,bind.getModel());
		}
		return modelView;
	}
	
}
