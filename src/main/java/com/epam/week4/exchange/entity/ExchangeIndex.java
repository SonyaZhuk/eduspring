package com.epam.week4.exchange.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


/**
 * Created by Sofya_Zhuk on 7/9/2016.
 */

@Entity
@Table(name = "ExchangesIndexes")
public class ExchangeIndex {

    @Id
    @Column(name = "idI")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "IndexExchange")
    private Double index;

    public ExchangeIndex(){}

    public double getIndex(){
        return index;
    }

    public void setIndex(Double index){
        this.index = index;
    }

}
