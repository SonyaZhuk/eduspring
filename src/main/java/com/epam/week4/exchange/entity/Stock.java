package com.epam.week4.exchange.entity;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

/**
 * Created by Sofya_Zhuk on 6/22/2016.
 */

@Entity
@Table(name = "Stocks")
public class Stock {

    @Id
    @Column(name = "idS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CompanyName")
    private String name;

    @Column(name = "Price")
    private Double price;

    public Stock(){}

    public Stock(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}
