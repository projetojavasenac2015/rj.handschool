package rj.handschool.propertys;

import java.beans.PropertyEditorSupport;

import rj.handschool.dao.CursoDAO;
import rj.handschool.model.Curso;

public class CursoPropertyEditor  extends PropertyEditorSupport{
	private CursoDAO cursoDao;
	
	public CursoPropertyEditor(CursoDAO cursoDao){
		this.cursoDao = cursoDao;
	}
	
	@Override  
    public void setAsText(String text) {  
        Integer id = new Integer(text);  
        Curso curso = cursoDao.findById(id);  
        super.setValue(curso);  
    }  
}
