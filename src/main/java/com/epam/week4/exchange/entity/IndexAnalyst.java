package com.epam.week4.exchange.entity;

import com.epam.week4.exchange.TypeDisplay;
import com.epam.week4.exchange.behavior.OutputIndexBehavior;
import com.epam.week4.exchange.simplefactory.DisplayIndexFactory;
import com.epam.week4.exchange.simplefactory.DisplayIndexFactoryImpl;

import javax.persistence.*;
import java.util.Locale;

/**
 * Created by Sofya_Zhuk on 7/7/2016.
 */
@Entity
@Table(name = "IndexAnalyst")
public class IndexAnalyst {

    @Id
    @Column(name = "idAI")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "PersonName")
    private String name;

    @Transient
    private Locale locale;

    @Transient
    private DisplayIndexFactory factory;

    @Transient
    private OutputIndexBehavior output;

    public IndexAnalyst(){}

    public IndexAnalyst(String name, TypeDisplay type, Locale locale){
        this.name = name;
        this.locale = locale;
        factory = new DisplayIndexFactoryImpl();
        output = factory.createDisplayIndex(type);
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

    public OutputIndexBehavior getOutputBehavior(){
        return output;
    }

    public void setOutputBehavior(OutputIndexBehavior output){
        this.output = output;
    }

}
