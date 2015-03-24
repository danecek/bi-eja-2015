/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import model.StatefulBen;

/**
 *
 * @author danecek
 */
@ManagedBean
@RequestScoped
public class TemplateBean {

    @EJB
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

    Future<Integer> ftr;

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
