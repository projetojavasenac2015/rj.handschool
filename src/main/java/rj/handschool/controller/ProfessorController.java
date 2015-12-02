package rj.handschool.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.DisciplinaDAO;
import rj.handschool.dao.ProfessorDAO;
import rj.handschool.model.Disciplina;
import rj.handschool.model.Professor;
import rj.handschool.model.TipoPessoa;
import rj.handschool.propertys.DisciplinaPropertyEditor;
import rj.handshool.util.RotuloFormatacao;
import rj.handshool.util.Utilidades;

@Controller
public class ProfessorController {
	@Autowired
	private ProfessorDAO professorDAO;
	
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	static final String  modelo_pagina = "professor_novo";
	static final Logger logger = Logger.getLogger(ProfessorController.class);
	
	@RequestMapping("CadastroProfessor")
	public ModelAndView novoProfessor(@ModelAttribute("professor") Professor professor){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modelView.addObject("professor",new Professor(Utilidades.formato(RotuloFormatacao.Matricula.getRotuloFormatacao()),TipoPessoa.Professor));
		rotuloPagina(modelView,"Novo");
		listaDisciplina(modelView);
		return modelView;
	}

	public void rotuloPagina(ModelAndView modelView,String rotulo){
		modelView.addObject("rotulo",rotulo);
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Disciplina.class, new DisciplinaPropertyEditor(disciplinaDAO));
	}
	
	@RequestMapping(value = "GravaProfessor", method = RequestMethod.POST)
	public ModelAndView GravaProfessor(@Valid @ModelAttribute("professor") Professor professor, BindingResult bind) throws Exception{
		ModelAndView modelView;
		String msg = "";
		
		if(!bind.hasErrors()){
			try{
				Professor professor_cadastrado = professorDAO.findByMatricula(professor);
				
				if(professor_cadastrado != null){
					professor.setIdpessoa(professor_cadastrado.getIdpessoa());
					professorDAO.update(professor);
				}
				else{
					professorDAO.insert(professor);
				}
				
				msg = "Registro Gravado com Sucesso";
			}
			catch(Exception e){
				msg = e.getMessage();
			}
			
			modelView = new ModelAndView(modelo_pagina);
			modelView.addObject("menssagem",msg);
			novoProfessor(professor);
		}
		else{
			modelView = new ModelAndView(modelo_pagina,bind.getModel());
			listaDisciplina(modelView);
		}
		return modelView;
	}
	
	public void listaDisciplina(ModelAndView modelView) {
		List<Disciplina> lista_disciplina = disciplinaDAO.findAll();
		modelView.addObject("listadisciplina", lista_disciplina);
	}
}
