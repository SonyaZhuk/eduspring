package com.epam.week4.exchange.observers.implobservers;

import com.epam.week4.exchange.behavior.OutputPriceBehavior;
import com.epam.week4.exchange.entity.PriceAnalyst;
import com.epam.week4.exchange.entity.Stock;
import com.epam.week4.exchange.observers.Subject;
import com.epam.week4.exchange.observers.ObserverPrices;

import java.util.Set;

/**
 * Created by Sofya_Zhuk on 6/18/2016.
 */
public class ObserverPricesImpl implements ObserverPrices {

    private Set<Stock> stocks;

    private Subject exchangeData;

    private PriceAnalyst analyst;

    public ObserverPricesImpl(){}

    public ObserverPricesImpl(Subject exchangeData, PriceAnalyst analyst){
        this.exchangeData = exchangeData;
        this.analyst = analyst;
        exchangeData.registerObserverPrices(this);
    }

    public PriceAnalyst getAnalyst(){
        return analyst;
    }

    public void setAnalyst(PriceAnalyst analyst){
        this.analyst = analyst;
    }

    public Set<Stock> getStock(){
        return this.stocks;
    }

    public void setStock(Set<Stock> stocks){
        this.stocks = stocks;
    }

    @Override
    public void update(Set<Stock> stocks) {
        this.stocks = stocks;
        OutputPriceBehavior output = analyst.getOutputBehavior();
        output.display(stocks, analyst);
    }
}
