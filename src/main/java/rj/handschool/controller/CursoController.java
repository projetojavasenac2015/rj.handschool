package rj.handschool.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rj.handschool.dao.CursoDAO;
import rj.handschool.model.Curso;

@Controller
public class CursoController {
	@Autowired
	private CursoDAO cursoDAO;
	
	public void rotuloPagina(ModelAndView modelView,String rotulo){
		modelView.addObject("rotulo",rotulo);
	}
	
	public ModelAndView modeloCurso(ModelAndView modelView){
		modelView.addObject("curso",new Curso());
		modelView.addObject("listaUltimosCursosCastrados",cursoDAO.findUltimosCadastrados(5));
		rotuloPagina(modelView,"Novo");
		return modelView;
	}
	
	@RequestMapping("NovoCurso")
	public ModelAndView novoCurso(@ModelAttribute("curso") Curso curso){
		ModelAndView modelView = new ModelAndView("curso_novo");
		modeloCurso(modelView);
		return modelView;
	}
	
	@RequestMapping(value = "GravaCurso", method = RequestMethod.POST)
	public ModelAndView gravaCurso(@Valid @ModelAttribute("curso")Curso curso, BindingResult bind) throws Exception{
		ModelAndView modelView;
		
		String msg = "";
		
		if(!bind.hasErrors()){
			try{
				if(curso.getIdcurso() == null){
					cursoDAO.insert(curso);
				}
				else{
					cursoDAO.update(curso);
				}
				
				msg = "Registro Gravado com Sucesso";
			}
			catch(Exception e){
				msg = e.getMessage();
			}
			modelView = new ModelAndView("curso_novo");
			modelView.addObject("menssagem",msg);
		}
		else{
			modelView = new ModelAndView("curso_novo",bind.getModel());
		}
		modeloCurso(modelView);
		return modelView;
	}
	
	@RequestMapping(value = "DadosCurso/{id}", method = RequestMethod.GET)
	public ModelAndView dadosCurso(@PathVariable("id") int id) throws Exception{
		ModelAndView modelView = new ModelAndView("curso_novo");
		Curso curso = new Curso();
		if(id != 0){
			curso = cursoDAO.findById(id);
		}
		modelView.addObject("curso", curso);
		rotuloPagina(modelView,"Alteração");
		return modelView;
	}
	
	@RequestMapping(value = "EditaCurso")
	public String dadosCurso(Curso curso) throws Exception{
		if(curso != null){
			cursoDAO.update(curso);
		}
		return "redirect:NovoCurso";
	}
	
	@RequestMapping(value="/ListaUltimosCursosCadastrados")
	public ModelAndView listaUltimosCursosCadastrados(){
		ModelAndView modelView = new ModelAndView("ultimos_cursos");
		modelView.addObject("listaUltimosCursosCastrados",cursoDAO.findUltimosCadastrados(100));
		return modelView;
	}
}
