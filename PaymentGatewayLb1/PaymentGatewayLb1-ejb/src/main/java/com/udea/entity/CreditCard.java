/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "credit_card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditCard.findAll", query = "SELECT c FROM CreditCard c")
    , @NamedQuery(name = "CreditCard.findByNumCreditCard", query = "SELECT c FROM CreditCard c WHERE c.numCreditCard = :numCreditCard")
    , @NamedQuery(name = "CreditCard.findByCcv", query = "SELECT c FROM CreditCard c WHERE c.ccv = :ccv")
    , @NamedQuery(name = "CreditCard.findByCardExpirationDate", query = "SELECT c FROM CreditCard c WHERE c.cardExpirationDate = :cardExpirationDate")
    , @NamedQuery(name = "CreditCard.findByCardType", query = "SELECT c FROM CreditCard c WHERE c.cardType = :cardType")})
public class CreditCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "num_credit_card")
    private String numCreditCard;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ccv")
    private int ccv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "card_expiration_date")
    private String cardExpirationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "card_type")
    private String cardType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numCreditCard")
    private Collection<Payment> paymentCollection;

    public CreditCard() {
    }

    public CreditCard(String numCreditCard) {
        this.numCreditCard = numCreditCard;
    }

    public CreditCard(String numCreditCard, int ccv, String cardExpirationDate, String cardType) {
        this.numCreditCard = numCreditCard;
        this.ccv = ccv;
        this.cardExpirationDate = cardExpirationDate;
        this.cardType = cardType;
    }

    public String getNumCreditCard() {
        return numCreditCard;
    }

    public void setNumCreditCard(String numCreditCard) {
        this.numCreditCard = numCreditCard;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCreditCard != null ? numCreditCard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditCard)) {
            return false;
        }
        CreditCard other = (CreditCard) object;
        if ((this.numCreditCard == null && other.numCreditCard != null) || (this.numCreditCard != null && !this.numCreditCard.equals(other.numCreditCard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.CreditCard[ numCreditCard=" + numCreditCard + " ]";
    }
    
}
