package com.epam.week4.exchange.behavior;

import com.epam.week4.exchange.entity.PriceAnalyst;
import com.epam.week4.exchange.entity.Stock;

import java.util.Set;

/**
 * Created by Sofya_Zhuk on 6/22/2016.
 */
public interface OutputPriceBehavior {


    void display(Set<Stock> stocks, PriceAnalyst analyst);


}
