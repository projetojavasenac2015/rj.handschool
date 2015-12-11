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

import rj.handschool.dao.AlunoDAO;
import rj.handschool.dao.AulaDAO;
import rj.handschool.dao.AvaliacaoAlunoDAO;
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
	
	@Autowired
	private AvaliacaoAlunoDAO avaliacaoAlunoDAO;
	
	@Autowired
	private AlunoDAO alunoDAO;
	
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
	
	@RequestMapping(value="AlunosNaoAvaliados/{idaula}/{id_tipo_avaliacao}")
	public @ResponseBody List<AvaliacaoAluno> alunosNaoAvaliados(
			@PathVariable("idaula") int idaula
			,@PathVariable("id_tipo_avaliacao") int id_tipo_avaliacao){
		List<Object[]> objs = aulasDAO.findByALunoAulas(idaula,id_tipo_avaliacao);
		List<AvaliacaoAluno> lista = new ArrayList<AvaliacaoAluno>();
		
		for (Object[] objects : objs) {
			AvaliacaoAluno avaliacao_aluno = new AvaliacaoAluno();
		
			Aluno aluno = new Aluno();
			aluno.setIdpessoa((Integer)objects[2]);
			aluno.setMatricula((String) objects[0]);
			aluno.setNome((String) objects[1]);
			
			Avaliacao avaliacao = new Avaliacao();
			avaliacao.setIdavaliacao((Integer)objects[4]);
			
			avaliacao_aluno.setAluno(aluno);
			avaliacao_aluno.setAvaliacao(avaliacao);
			
			lista.add(avaliacao_aluno);
		}
		return lista;
	}
	
	@RequestMapping(value="EfetuaLancamentoNota/{idavaliacao}/{matricula_aluno}/{nota}")
	public @ResponseBody void efetuaAvaliacaoAluno(
			@PathVariable("idavaliacao") int idavaliacao
			,@PathVariable("matricula_aluno") String  matricula_aluno
			,@PathVariable("nota") Double  nota) throws Exception{
		
			if(idavaliacao !=0 && matricula_aluno != "" && nota != 0){
				AvaliacaoAluno avaliacao_aluno = new AvaliacaoAluno();
				
				Aluno aluno_pesq = new Aluno();
				aluno_pesq.setMatricula(matricula_aluno);
				Aluno aluno = alunoDAO.findByMatricula(aluno_pesq);
				avaliacao_aluno.setAluno(aluno);
				
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setIdavaliacao(idavaliacao);
				avaliacao_aluno.setAvaliacao(avaliacao);
				
				avaliacao_aluno.setValor(nota);
				
				avaliacaoAlunoDAO.insert(avaliacao_aluno);
			}
	}
}
