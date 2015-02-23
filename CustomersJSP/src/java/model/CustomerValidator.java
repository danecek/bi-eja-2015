/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danecek
 */
public class CustomerValidator {

    private String namePar;
    private String agePar;
    private int age;
    private List<String> errorMessages = new ArrayList<>();

    public CustomerValidator() {
    }

    public CustomerValidator(String namePar, String agePar) {
        this.namePar = namePar;
        this.agePar = agePar;
    }

    public boolean validate() {
        if (getNamePar().isEmpty() || Character.isLowerCase(getNamePar().charAt(0))) {
            errorMessages.add("Name must start by uppercase!");
        }
        try {
            age = Integer.parseInt(getAgePar());
            if (getAge() <= 0) {
                errorMessages.add("Invalid age");
            }
        } catch (NumberFormatException nfe) {
            errorMessages.add("Invalid age");
        }
        return errorMessages.isEmpty();
    }

    /**
     * @return the name
     */
    public String getName() {
        return getNamePar();
    }

    /**
     * @return the error
     */
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the namePar
     */
    public String getNamePar() {
        return namePar;
    }

    /**
     * @return the agePar
     */
    public String getAgePar() {
        return agePar;
    }

}
