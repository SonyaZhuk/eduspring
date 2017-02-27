package com.epam.week4.exchange.behavior.behaviorimpl;

import com.epam.week4.exchange.entity.PriceAnalyst;
import com.epam.week4.exchange.entity.Stock;
import com.epam.week4.exchange.behavior.OutputPriceBehavior;

import java.text.NumberFormat;
import java.util.Set;

/**
 * Created by Sofya_Zhuk on 6/22/2016.
 */
public class ConsoleDisplayPrice implements OutputPriceBehavior {

    public ConsoleDisplayPrice(){}


    @Override
    public void display(Set<Stock> stocks, PriceAnalyst analyst) {
        NumberFormat nf = NumberFormat.getNumberInstance(analyst.getLocale());
        System.out.println("The current stock price for " + analyst.getName() + ": ");
        for (Stock entry : stocks) {
            System.out.println(entry.getName() + " : Price = " + nf.format(entry.getPrice()));
        }

    }
}
