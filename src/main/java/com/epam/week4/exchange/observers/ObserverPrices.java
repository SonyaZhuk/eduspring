package com.epam.week4.exchange.observers;


import com.epam.week4.exchange.entity.Stock;

import java.util.Set;

/**
 * Created by Sofya_Zhuk on 6/19/2016.
 */
public interface ObserverPrices  {

    void update(Set<Stock> stocks);
}


