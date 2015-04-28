/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import model.StatefulBen;

/**
 *
 * @author danecek
 */
@Named
@RequestScoped
public class TemplateBean {

    @Inject
    StatefulBen stateful;

    /**
     * Creates a new instance of TemplateBean
     */
    public TemplateBean() {
    }

    public int getX() {
        return stateful.getX();
    }

    public void inc() {
        stateful.inc();
    }

//    Future<Integer> ftr;

//    public void f() {
//        ftr = customersFacade.f();
//    }
//
//    public String getResult() {
//
//        try {
//            if (ftr == null || !ftr.isDone()) {
//                return "not finished";
//            }
//            return ftr.get() + "";
//        } catch (InterruptedException | ExecutionException ex) {
//            Logger.getLogger(IndexBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
}
