package rj.handschool.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

















import rj.handschool.dao.PerfilDAO;
import rj.handschool.dao.PerfilPessoaDAO;
import rj.handschool.dao.ProfessorDAO;
import rj.handschool.model.Aluno;
import rj.handschool.model.Perfil;
import rj.handschool.model.PerfilPessoa;
import rj.handschool.model.Professor;

@Controller
public class PerfilController {

	static final String  modelo_pagina = "add_perfil";
	
	@Autowired
	private ProfessorDAO professorDAO;
	
	@Autowired
	private PerfilDAO perfilDAO;
	
	@Autowired
	private PerfilPessoaDAO perfilpessoaDAO;
	
	@RequestMapping("NovoPerfil")
	public ModelAndView novoPerfil(@ModelAttribute("perfilPessoa") PerfilPessoa perfilPessoa){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		listaProfessores(modelView);
		listaPerfil(modelView);
		return modelView;
	}
	
	public void listaProfessores(ModelAndView modelView) {
		List<Professor> lista_professores = professorDAO.findAll();
		modelView.addObject("listaprofessor", lista_professores);
	}

	public void listaPerfil(ModelAndView modelView) {
		List<Perfil> lista_perfil = perfilDAO.findAll();
		modelView.addObject("listaperfil", lista_perfil);
	}
	
	@RequestMapping(value="GravarPerfil/{idprof}/{idperfil}", method = RequestMethod.POST)
	public ModelAndView incluirPerfil(Model model, @PathVariable("idprof") Integer profs
			,@PathVariable("idperfil") Integer perfs
			) {
		
		if(profs != 0 && perfs != 0){
			Professor prof = professorDAO.findById(profs);
			Perfil perf = perfilDAO.findById(perfs);
			
			if(perfilpessoaDAO.isExistis(perf, prof) == 0){
				PerfilPessoa p = new PerfilPessoa(prof,perf);
				try {
					perfilpessoaDAO.insert(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PerfilPessoa perfilPessoa = new PerfilPessoa();
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		modelView.addObject(perfilPessoa);
		
		return modelView;
	}
	
	@RequestMapping(value="ConsultarPerfil", method = RequestMethod.GET)
	private ModelAndView consultarPerfil(){
		ModelAndView modelView = new ModelAndView("consultar_perfil");
		listaPerfilPessoa(modelView);
		return modelView;
	}
	
	public void listaPerfilPessoa(ModelAndView modelView) {
		List<Object[]> lista_perfil_pessoa = perfilpessoaDAO.findPessoaPerfilAll();
		List<PerfilPessoa>  pp = new ArrayList<PerfilPessoa>();
				
		for (Object[] lista : lista_perfil_pessoa) {
			PerfilPessoa p = new PerfilPessoa();
			//p.setDataPerfil((Date)lista[0]);
			Perfil pe = new Perfil();
			p.setIdPerfil(pe);
			p.getIdPerfil().setDescricao((String)lista[1]);
			Professor prof = new Professor();
			p.setIdPessoa(prof);
			p.getIdPessoa().setNome((String)lista[2]);;;
			
			pp.add(p);
		}
		
		modelView.addObject("listaPerfilPessoa", pp);
	}
}
