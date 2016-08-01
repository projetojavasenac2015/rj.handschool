package rj.handschool.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import rj.handschool.dao.NotificacaoDAO;
import rj.handschool.dao.ProfessorDAO;
import rj.handschool.dao.TurmaDAO;
import rj.handschool.model.Notificacao;
import rj.handschool.model.Professor;
import rj.handschool.model.Turma;

@Controller
public class NotificacaoController {
	
	@Autowired
	private ProfessorDAO professorDAO;
	
	@Autowired
	private NotificacaoDAO notificacaoDAO;
	
	@Autowired
	private TurmaDAO turmaDAO;
	
	
	@RequestMapping(value="Notificar/{idturma}/{idprofessor}/{notificacao}")
	private @ResponseBody String notificar(@PathVariable("idturma") int idturma, @PathVariable("idprofessor") int idprofessor
			, @PathVariable("notificacao") String text_notificacao
			){
		String msg = "";
		
		if(idturma != 0 && idprofessor != 0){
			Professor prof = professorDAO.findById(idprofessor);
			Turma turma = turmaDAO.findById(idturma);
			
			Notificacao notificacao = new Notificacao(turma,prof,text_notificacao);
						
			try {
				notificacaoDAO.insert(notificacao);
				msg = "Notificação Realizada";
			} catch (Exception e) {
				e.printStackTrace();
				msg = e.getMessage();
			}
		}
		return msg;
	}
	
	@RequestMapping(value="GetNotificacao", method= RequestMethod.GET)
	private @ResponseBody List<Notificacao> getNotificacao(){
		List<Notificacao> notificacoes = new ArrayList<Notificacao>();
		
		List<Object[]> objs = notificacaoDAO.find();
		
		for (Object[] obj1 : objs) {
			Notificacao notificacao = new Notificacao();
			notificacao.setDataNotificacao((Date)obj1[0]);
			notificacao.setNotificacao((String) obj1[1]);
			
			Turma turma = new Turma();
			turma.setIdturma((Integer)obj1[5]);
			
			notificacao.setTurma(turma);
			notificacao.getTurma().setDescricao((String) obj1[4]);
			
			Professor professor = new Professor();
			professor.setIdpessoa((Integer) obj1[3]);
			
			notificacao.setProfessor(professor);
			notificacao.getProfessor().setNome((String) obj1[2]);
			
			notificacoes.add(notificacao);
		}
		
		return notificacoes;
	}
}
