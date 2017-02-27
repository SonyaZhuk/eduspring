package com.epam.week4.exchange.observers.implobservers;

import com.epam.week4.exchange.behavior.OutputIndexBehavior;
import com.epam.week4.exchange.entity.IndexAnalyst;
import com.epam.week4.exchange.observers.Subject;
import com.epam.week4.exchange.observers.ObserverIndex;


/**
 * Created by Sofya_Zhuk on 6/25/2016.
 */

public class ObserverIndexImpl implements ObserverIndex {

    private Double index;

    private Subject exchangeData;

    private IndexAnalyst analyst;

    public ObserverIndexImpl(){}

    public ObserverIndexImpl(Subject exchangeData, IndexAnalyst analyst){
        this.exchangeData = exchangeData;
        this.analyst = analyst;
        exchangeData.registerObserverIndex(this);
    }

    public IndexAnalyst getAnalyst(){
        return analyst;
    }
    public void setAnalyst(IndexAnalyst analyst){
        this.analyst = analyst;
    }

    @Override
    public void update(Double index) {
        this.index = index;
        OutputIndexBehavior output = analyst.getOutputBehavior();
        output.display(index, analyst);
    }
}
