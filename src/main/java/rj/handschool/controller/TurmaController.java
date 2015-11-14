package rj.handschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.model.Turma;

import java.util.Calendar;

@Controller
public class TurmaController {
	private final static int qtd_anos_abertura_turma = 3;
	
	@RequestMapping("/NovaTurma")
	public ModelAndView novoCurso(Turma turma){
		ModelAndView modelView = new ModelAndView("turma_nova");
		modelView.addObject("ano_ini", Calendar.getInstance().get(Calendar.YEAR) );
		modelView.addObject("ano_fim", (Calendar.getInstance().get(Calendar.YEAR)) + qtd_anos_abertura_turma);
		modelView.addObject("Turma", new Turma());
		return modelView;
	}
}
