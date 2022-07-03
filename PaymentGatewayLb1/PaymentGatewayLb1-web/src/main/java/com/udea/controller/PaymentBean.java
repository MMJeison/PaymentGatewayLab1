/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.entity.Client;
import com.udea.entity.CreditCard;
import com.udea.entity.Payment;
import com.udea.session.ClientManagerLocal;
import com.udea.session.CreditCardManagerLocal;
import com.udea.session.PaymentManagerLocal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author User
 */
public class PaymentBean implements Serializable{
    
    @EJB
    private ClientManagerLocal clientManager;
    
    @EJB
    private CreditCardManagerLocal creditCardManager;

    @EJB
    private PaymentManagerLocal paymentManager;

    /**
     * Creates a new instance of PaymentBean
     */
    
    private Payment payment;
    private List<Payment> payments;
    private Client client;
    private CreditCard creditCard;
    private String result;
    private String message;
    
    public PaymentBean() {
    }
    
    public List<Payment> getPayments(){
        if((payments == null) || (payments.isEmpty())){
            refresh();
        }
        return payments;
    }

    public void refresh() {
        this.payments = paymentManager.getAllPayments();
    }
    
    public Payment getDetails(){
        return this.payment;
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
        //Mensaje que se mostrará en el codigo qr
        this.message = "";
        this.client = clientManager.getClient(cltId);
        this.creditCard = creditCardManager.getCreditCard(ccNumber);
        if(client != null){
            //Si el clienta ya esta registrado en la base de datos
            //Validamos que todos los datos del cliente sean correctos
            if(!name.equalsIgnoreCase(client.getName()) || !email.equalsIgnoreCase(client.getEmail())){
                message = "Datos del cliente incorrectos";
                result = "FAILED";
                return "PAYMENTRESULT";
            }
        }
        if(creditCard != null){
            //Si la tarjeta ya se encuentra registrada
            //Validamos que todos los datos del cliente sean correctos
            if(Integer.parseInt(ccv) != creditCard.getCcv() || !ceDate.equals(creditCard.getCardExpirationDate())){
                message = "Datos de la tarjeta de credito incorrectos";
                result = "FAILED";
                return "PAYMENTRESULT";
            }
        }
        
        if(creditCard == null){
            this.creditCard = new CreditCard(ccNumber);
            this.creditCard.setCcv(Integer.parseInt(ccv));
            this.creditCard.setCardExpirationDate(ceDate);
            this.assingCardType();
            if(creditCard.getCardType().equalsIgnoreCase("UNDEFINED")){
                message = "Tajeta de credito no valida";
                result = "FAILED";
                return "PAYMENTRESULT";
            }
            creditCardManager.persist(creditCard);
        }
        
        if(client == null){
            this.client = new Client(Integer.parseInt(cltId), name, email);
            clientManager.persist(client);
        }
        this.payment = new Payment();
        this.payment.setClientId(client);
        this.payment.setNumCreditCard(creditCard);
        this.payment.setAmount(Double.parseDouble(amount));
        this.payment.setTimeStamp(new Timestamp(System.currentTimeMillis()));
        paymentManager.persist(payment);
        
        //Mensaje que se mostrará en el codigo qr
        message = "Client Id: " + cltId + "\n"
                + "Transaccion Value: " + amount + "\n"
                + "Time Stamp: " + payment.getTimeStamp();
        this.result = "SUCCESSFULL";
        return "PAYMENTRESULT";
    }
    
    public String endPayment(){
        System.out.println("###ENDPAYMENT###");
        return "ENDPAYMENT";
    }
    
    
    
    public void assingCardType(){
        int a = Integer.parseInt(this.creditCard.getNumCreditCard().substring(0, 5));
        if ((a >= 11111) && (a <= 22222)) {
            this.creditCard.setCardType("American Express");
            return;
        }
        if ((a >= 33334) && (a <= 44444)) {
            this.creditCard.setCardType("Diners");
            return;
        }

        if ((a >= 55555) && (a <= 66666)) {
            this.creditCard.setCardType("Visa");
            return;
        }

        if ((a >= 77777) && (a <= 88888)) {
            this.creditCard.setCardType("Master Card");
            return;
        }
        this.creditCard.setCardType("UNDEFINED");
    }
    
    public String getResult(){
        return this.result;
    }
    
    public String getMessage(){
        return this.message;
    }
}
