package com.udea.entity;

import com.udea.entity.Payment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-02T19:41:30")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> clientId;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile CollectionAttribute<Client, Payment> paymentCollection;
    public static volatile SingularAttribute<Client, String> email;

}