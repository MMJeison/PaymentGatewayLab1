/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.CreditCard;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface CreditCardManagerLocal {

    List<CreditCard> getAllCreditCards();

    boolean persist(CreditCard creditCard);

    CreditCard getCreditCard(String creditCardNumber);
    
}
