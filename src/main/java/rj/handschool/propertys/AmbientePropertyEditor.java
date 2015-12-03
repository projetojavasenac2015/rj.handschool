package rj.handschool.propertys;

import java.beans.PropertyEditorSupport;

import rj.handschool.dao.AmbienteDAO;
import rj.handschool.model.Ambiente;

public class AmbientePropertyEditor  extends PropertyEditorSupport{
	private AmbienteDAO daoDao;
	
	public AmbientePropertyEditor(AmbienteDAO daoDao){
		this.daoDao = daoDao;
	}
	
	@Override  
    public void setAsText(String text) {  
        Integer id = new Integer(text);  
        Ambiente ambiente = daoDao.findById(id);  
        super.setValue(ambiente);  
    }  
}
