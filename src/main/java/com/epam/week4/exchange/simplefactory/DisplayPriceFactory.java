package com.epam.week4.exchange.simplefactory;

import com.epam.week4.exchange.TypeDisplay;
import com.epam.week4.exchange.behavior.OutputPriceBehavior;

/**
 * Created by Sofya_Zhuk on 6/30/2016.
 */
public interface DisplayPriceFactory {

    OutputPriceBehavior createDisplayPrice(TypeDisplay type);

}
