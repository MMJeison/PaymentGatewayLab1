package com.udea.entity;

import com.udea.entity.Client;
import com.udea.entity.CreditCard;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-02T19:41:30")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, Date> timeStamp;
    public static volatile SingularAttribute<Payment, Double> amount;
    public static volatile SingularAttribute<Payment, Client> clientId;
    public static volatile SingularAttribute<Payment, Integer> paymentId;
    public static volatile SingularAttribute<Payment, CreditCard> numCreditCard;

}