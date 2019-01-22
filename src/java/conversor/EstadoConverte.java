/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

import bean.EstadoBean;
import javax.faces.bean.SessionScoped;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import modelo.Estado;

/**
 *
 * @author nailton viana gloria
 */
@Named("estadoConverter")
@SessionScoped
public class EstadoConverte implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        EstadoBean bean = (EstadoBean) context.getApplication().evaluateExpressionGet(context, "#{estadoBean}", EstadoBean.class);
        if (value == null || value.isEmpty()) {
            //System.out.println("converteu " + value);

        }
        if (bean != null) {
            //System.out.println("nao é nulo");
        } else {
           // System.out.println("é nulo");
        }
        return bean.consultaEstado(Long.parseLong(value));

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Estado estado = (Estado) value;
        if (estado == null || estado.getId() == 0) {
            return null;
        }

        return String.valueOf(estado.getId());

    }
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

}
