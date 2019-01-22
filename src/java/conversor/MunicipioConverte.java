/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

import bean.EstadoBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import modelo.Cidade;

/**
 *
 * @author nailton viana gloria
 */
@Named("cidadecConverter")
@ViewScoped
public class MunicipioConverte implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
          EstadoBean bean = (EstadoBean) context.getApplication().evaluateExpressionGet(context, "#{estadoBean}", EstadoBean.class);

        if (value == null || value.isEmpty()) {
            return null;
        }
        return bean.consultaCidade(Long.parseLong(value));
       
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
         Cidade cidade = (Cidade) value;
        if (cidade == null || cidade.getId() == 0) {
            return null;
        }
        return String.valueOf(cidade.getId());
    }
    
    
}
