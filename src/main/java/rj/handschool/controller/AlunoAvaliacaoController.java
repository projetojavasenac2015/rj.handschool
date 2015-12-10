package rj.handschool.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.AulaDAO;
import rj.handschool.dao.AvaliacaoDAO;
import rj.handschool.dao.TipoAvaliacaoDAO;
import rj.handschool.model.Aluno;
import rj.handschool.model.Aulas;
import rj.handschool.model.Avaliacao;
import rj.handschool.model.AvaliacaoAluno;
import rj.handschool.model.Disciplina;
import rj.handschool.model.ListaPresenca;
import rj.handschool.model.TipoAvaliacao;


@Controller
public class AlunoAvaliacaoController {
	
	@Autowired
	private TipoAvaliacaoDAO tipoavaliacaoDAO;
	
	@Autowired
	private AulaDAO aulasDAO;
	
	@Autowired
	private AvaliacaoDAO avaliacaoDAO;
	
	static final String  modelo_pagina = "lancamento_notas_avaliacao";
	
	@RequestMapping("LancamentoNotas")
	public ModelAndView novaNotaAvaliacao(@ModelAttribute("avaliacaoaluno") AvaliacaoAluno avaliacaoaluno){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		listaTipoAvaliacao(modelView);
		return modelView;
	}
	
	public void listaTipoAvaliacao(ModelAndView modelView) {
		List<TipoAvaliacao> lista = tipoavaliacaoDAO.findAll();
		modelView.addObject("listaTipoAvaliacao", lista);
	}
	
	@RequestMapping(value="AlunosNaoAvaliados/{idaula}")
	public @ResponseBody List<Aluno> alunosNaoAvaliados(@PathVariable("idaula") int idaula){
		List<Object[]> objs = aulasDAO.findByALunoAulas(idaula);
		List<Aluno> lista = new ArrayList<Aluno>();
		
		for (Object[] objects : objs) {
			Aluno aluno = new Aluno();
			aluno.setIdpessoa((Integer)objects[2]);
			aluno.setMatricula((String) objects[0]);
			aluno.setNome((String) objects[1]);
			lista.add(aluno);
		}
		return lista;
	}
}
