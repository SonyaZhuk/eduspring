package com.epam.week4.exchange;

import com.epam.week4.exchange.entity.Exchange;
import com.epam.week4.exchange.entity.ExchangeIndex;
import com.epam.week4.exchange.entity.Stock;
import com.epam.week4.exchange.observers.ObserverIndex;
import com.epam.week4.exchange.observers.ObserverPrices;
import com.epam.week4.exchange.observers.Subject;

import javax.persistence.Column;
import java.util.*;

/**
 * Created by Sofya_Zhuk on 6/18/2016.
 */
public class ExchangeData implements Subject {

    private List<ObserverPrices> observersPrices;
    private List<ObserverIndex> observersIndex;
    private Exchange exchange;

    private ExchangeIndex exchangeIndex;

    private Set<Stock> stocks = new HashSet<>();

    public ExchangeData(Exchange exchange){
        this.exchange = exchange;
        exchangeIndex = new ExchangeIndex();
        observersPrices = new ArrayList<>();
        observersIndex = new ArrayList<>();
    }

    @Override
    public void registerObserverPrices(ObserverPrices o) {
        observersPrices.add(o);
    }

    @Override
    public void removeObserverPrices(ObserverPrices o) {
        int i = observersPrices.indexOf(o);
        if(i >= 0){
            System.out.println(" Observer of prices "+ i +" deleted ");
            observersPrices.remove(i);
        }
    }

    @Override
    public void registerObserverIndex(ObserverIndex o) {
        observersIndex.add(o);
    }

    @Override
    public void removeObserverIndex(ObserverIndex o) {
        int i = observersIndex.indexOf(o);
        if(i >= 0){
            System.out.println(" Observer of index "+ i +" deleted ");
            observersIndex.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for(ObserverPrices observer: observersPrices){
            observer.update(this.stocks);
        }
        for(ObserverIndex observer: observersIndex){
            observer.update(this.exchangeIndex.getIndex());
        }

    }

    public void measurementsChangedPrices(){
        notifyObserver();
    }

    public void setPrices(Set<Stock> stocks){
        this.stocks = stocks;
        double itemIndex = countIndex(this.stocks);
        exchangeIndex.setIndex(itemIndex);
        measurementsChangedPrices();
    }
    
    public Set<Stock> getPrices(){
        return this.stocks;
    }

    public void setExchangeIndex(ExchangeIndex index){
        this.exchangeIndex = exchangeIndex;
    }

    public ExchangeIndex getExchangeIndex(){
        return this.exchangeIndex;
    }

    public double countIndex(Set<Stock> stocks){
        double sumPrices = 0;
        for (Stock entry : stocks) {
            sumPrices += entry.getPrice();
        }
        return sumPrices/stocks.size();
    }

    public void setExchange(Exchange exchange){
        this.exchange = exchange;
    }

    public Exchange getExchange(){
        return exchange;
    }

}
