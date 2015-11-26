package rj.handschool.propertys;

import java.beans.PropertyEditorSupport;

import rj.handschool.dao.DisciplinaDAO;
import rj.handschool.model.Disciplina;

public class DisciplinaPropertyEditor  extends PropertyEditorSupport{
	private DisciplinaDAO disciplinaDao;
	
	public DisciplinaPropertyEditor(DisciplinaDAO disciplinaDao){
		this.disciplinaDao = disciplinaDao;
	}
	
	@Override  
    public void setAsText(String text) {  
        Integer id = new Integer(text);  
        Disciplina disciplina = disciplinaDao.findById(id);  
        super.setValue(disciplina);  
    }  
}
