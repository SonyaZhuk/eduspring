package com.epam.week4.exchange.simplefactory;


import com.epam.week4.exchange.TypeDisplay;
import com.epam.week4.exchange.behavior.OutputIndexBehavior;
import com.epam.week4.exchange.behavior.behaviorimpl.ConsoleDisplayIndex;
import com.epam.week4.exchange.behavior.behaviorimpl.FileDisplayIndex;


/**
 * Created by Sofya_Zhuk on 6/25/2016.
 */
public class DisplayIndexFactoryImpl implements DisplayIndexFactory {

    public OutputIndexBehavior createDisplayIndex(TypeDisplay type){
        OutputIndexBehavior output;
        if (type == TypeDisplay.CONSOLE) {
            output = new ConsoleDisplayIndex();
        } else if(type == TypeDisplay.FILE) {
            output = new FileDisplayIndex();
        } else {
            output = new ConsoleDisplayIndex();
        }
        return output;
    }

}
