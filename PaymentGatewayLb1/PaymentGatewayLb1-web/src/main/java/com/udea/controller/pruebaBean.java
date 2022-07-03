/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author User
 */
public class pruebaBean implements Serializable{

    /**
     * Creates a new instance of pruebaBean
     */
    private String result;
    private String message;
    
    public pruebaBean() {
    }
          
    public String getResult(){
        return this.result;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public String newPayment(){
        System.out.println("###NEWPAYMENT###");
        return "NEWPAYMENT";
    }
    
    public String cancelPayment(){
        System.out.println("###CANCELPAYMENT###");
        return "CANCELPAYMENT";
    }
    
    public String paymentResult(String cltId, String name, String email, String ccNumber, String ccv, String ceDate, String amount){
        System.out.println("###PAYMENTRESULT###");
        Random rand = new Random();
        int n = rand.nextInt(100);
        if(n % 2 == 0){
            this.message = "Mensaje de Exito de prueba";
            this.result = "SUCCESSFULL";
        }else{
            this.message = "Mensaje de Error de prueba";
            this.result = "FAILED";
        }
        return "PAYMENTRESULT";
    }
    
    public String endPayment(){
        System.out.println("###ENDPAYMENT###");
        return "ENDPAYMENT";
    }

}