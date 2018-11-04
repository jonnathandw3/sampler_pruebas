/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.converter;

/**
 *
 * @author jonnathanmurcia
 */
import edu.sampler.entity.Sala;
import edu.sampler.facade.SalaFacadeLocal;
import javax.ejb.EJB;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "salaConverter")
public class SalaConverter implements Converter{

    private SalaFacadeLocal salaFacadeLocal;
    
    public SalaConverter(){
        salaFacadeLocal = CDI.current().select(SalaFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return salaFacadeLocal.find(Integer.valueOf(value));
        } catch (Exception e) {
            return null;
        }
         
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            return ((Sala) value).getIdsala().toString();
        } catch (Exception e) {
            return "";
        }
    }
    
}
