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
import rj.handschool.model.Aulas;
import rj.handschool.model.Avaliacao;
import rj.handschool.model.Disciplina;
import rj.handschool.model.TipoAvaliacao;


@Controller
public class AvaliacaoController {
	
	@Autowired
	private TipoAvaliacaoDAO tipoavaliacaoDAO;
	
	@Autowired
	private AulaDAO aulasDAO;
	
	@Autowired
	private AvaliacaoDAO avaliacaoDAO;
	
	static final String  modelo_pagina = "agendamento_avaliacao";
	
	@RequestMapping("AgendarAvaliacao")
	public ModelAndView novaAvaliacao(@ModelAttribute("avaliacao") Avaliacao avaliacao){
		ModelAndView modelView = new ModelAndView(modelo_pagina);
		listaTipoAvaliacao(modelView);
		return modelView;
	}
	
	public void listaTipoAvaliacao(ModelAndView modelView) {
		List<TipoAvaliacao> lista = tipoavaliacaoDAO.findAll();
		modelView.addObject("listaTipoAvaliacao", lista);
	}
	
	@RequestMapping(value = "AulasDisciplinas/{idturma}/{iddisciplina}/{matricula}")
	public @ResponseBody List<String> aulasDisciplinas(
			@PathVariable("idturma") int idturma
			,@PathVariable("iddisciplina") int iddisciplina
			,@PathVariable("matricula") String matricula
			) throws Exception {
		List<String> aulas_disciplinas = aulasDAO.findAulasDisciplinasTurma(idturma,iddisciplina,matricula);
		return aulas_disciplinas;
	}
	
	@RequestMapping(value = "AulasDisciplinas/{idturma}/{iddisciplina}/{matricula}/{data}")
	public @ResponseBody List<String> aulasDisciplinas(
			@PathVariable("idturma") int idturma
			,@PathVariable("iddisciplina") int iddisciplina
			,@PathVariable("matricula") String matricula
			,@PathVariable("data") String data
			) throws Exception {
		List<String> aulas_disciplinas = aulasDAO.findAulasDisciplinasTurma(idturma,iddisciplina,matricula, data);
		return aulas_disciplinas;
	}
	
	@RequestMapping(value = "ConfirmaAgendaAvaliacao/{idaula}/{tipoavaliacao}")
	public @ResponseBody String  confirmaAgendamentoAvaliacao(
			@PathVariable("idaula") int idaula
			,@PathVariable("tipoavaliacao") int tipoavaliacao
			) throws Exception {
		
		if(idaula != 0 && tipoavaliacao != 0){
			Avaliacao avaliacao = new Avaliacao();
			TipoAvaliacao tipo = new TipoAvaliacao();
			tipo.setIdtipoAvaliacao(tipoavaliacao);
			avaliacao.setTipoAvaliacao(tipo);
			Aulas aula = new Aulas(idaula);
			avaliacao.setAula(aula);
			avaliacaoDAO.insert(avaliacao);
		}
		
		return "ok";
	}
	
	
}
