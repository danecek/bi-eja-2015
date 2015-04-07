/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Group;

/**
 *
 * @author danecek
 */
@FacesConverter(value = "groupConverter")
public class GroupConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
      return new Group(33, value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      return value.toString();//(Group)value).getName();
    }

}
