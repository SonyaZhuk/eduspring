package com.epam.week4.exchange.simplefactory;

import com.epam.week4.exchange.TypeDisplay;
import com.epam.week4.exchange.behavior.OutputPriceBehavior;
import com.epam.week4.exchange.behavior.behaviorimpl.ConsoleDisplayPrice;
import com.epam.week4.exchange.behavior.behaviorimpl.FileDisplayPrice;


/**
 * Created by Sofya_Zhuk on 6/25/2016.
 */
public class DisplayPriceFactoryImpl implements DisplayPriceFactory {

    public OutputPriceBehavior createDisplayPrice(TypeDisplay type){
        OutputPriceBehavior output;
        if (type == TypeDisplay.CONSOLE) {
            output = new ConsoleDisplayPrice();
        } else if(type == TypeDisplay.FILE){
            output = new FileDisplayPrice();
        } else {
            output = new ConsoleDisplayPrice();
        }

        return output;
    }

}
