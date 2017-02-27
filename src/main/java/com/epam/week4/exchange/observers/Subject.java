package com.epam.week4.exchange.observers;

import com.epam.week4.exchange.observers.ObserverIndex;
import com.epam.week4.exchange.observers.ObserverPrices;

/**
 * Created by Sofya_Zhuk on 6/18/2016.
 */
public interface Subject {

    void registerObserverPrices(ObserverPrices o);
    void removeObserverPrices(ObserverPrices o);

    void registerObserverIndex(ObserverIndex o);
    void removeObserverIndex(ObserverIndex o);

    void notifyObserver();

}
