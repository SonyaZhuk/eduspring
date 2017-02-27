package com.epam.week4.exchange.behavior.behaviorimpl;

import com.epam.week4.exchange.entity.IndexAnalyst;
import com.epam.week4.exchange.behavior.OutputIndexBehavior;


import java.text.NumberFormat;

/**
 * Created by Sofya_Zhuk on 6/22/2016.
 */
public class ConsoleDisplayIndex implements OutputIndexBehavior {

    public ConsoleDisplayIndex(){

    }

    @Override
    public void display(Double index, IndexAnalyst analyst) {
        NumberFormat nf = NumberFormat.getNumberInstance(analyst.getLocale());
        System.out.println("The stock exchange index for " + analyst.getName() + ": " + nf.format(index));
    }
}
