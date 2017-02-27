package com.epam.week4.exchange.entity;

import com.epam.week4.exchange.TypeDisplay;
import com.epam.week4.exchange.behavior.OutputPriceBehavior;
import com.epam.week4.exchange.simplefactory.DisplayPriceFactory;
import com.epam.week4.exchange.simplefactory.DisplayPriceFactoryImpl;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Sofya_Zhuk on 7/7/2016.
 */

@Entity
@Table(name = "PriceAnalyst")
public class PriceAnalyst {

    @Id
    @Column(name = "idAP")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "PersonName")
    private String name;

    @Transient
    private Locale locale;

    @Transient
    private DisplayPriceFactory factory;

    @Transient
    private OutputPriceBehavior output;

    public PriceAnalyst(){}

    public PriceAnalyst(String name, TypeDisplay type, Locale locale){
        this.name = name;
        this.locale = locale;
        factory = new DisplayPriceFactoryImpl();
        output = factory.createDisplayPrice(type);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Locale getLocale(){
        return locale;
    }

    public void setLocale(Locale locale){
        this.locale = locale;
    }

    public OutputPriceBehavior getOutputBehavior(){
        return output;
    }

    public void setOutputBehavior(OutputPriceBehavior output){
        this.output = output;
    }

}
