/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.CreditCard;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class CreditCardManager implements CreditCardManagerLocal {

    @PersistenceContext(unitName = "com.udea_PaymentGatewayLb1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    /*
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    */
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<CreditCard> getAllCreditCards() {
        Query query = em.createNamedQuery("CreditCard.findAll");
        return query.getResultList();
    }

    @Override
    public boolean persist(CreditCard creditCard) {
        try {
            utx.begin();
            em.persist(creditCard);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public CreditCard getCreditCard(String creditCardNumber) {
        Query query = em.createNamedQuery("CreditCard.findAll");
        query.setParameter("clientId", creditCardNumber);
        try {
            return (CreditCard) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    
}
