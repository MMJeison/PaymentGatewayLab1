package com.udea.entity;

import com.udea.entity.Payment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-02T19:41:30")
@StaticMetamodel(CreditCard.class)
public class CreditCard_ { 

    public static volatile SingularAttribute<CreditCard, String> cardExpirationDate;
    public static volatile SingularAttribute<CreditCard, Integer> ccv;
    public static volatile SingularAttribute<CreditCard, String> cardType;
    public static volatile SingularAttribute<CreditCard, String> numCreditCard;
    public static volatile CollectionAttribute<CreditCard, Payment> paymentCollection;

}