package com.epam.week4.exchange.behavior.behaviorimpl;

import com.epam.week4.Utils;
import com.epam.week4.exchange.entity.PriceAnalyst;
import com.epam.week4.exchange.entity.Stock;
import com.epam.week4.exchange.behavior.OutputPriceBehavior;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Set;

/**
 * Created by Sofya_Zhuk on 6/22/2016.
 */
public class FileDisplayPrice implements OutputPriceBehavior {

    public FileDisplayPrice(){}

    @Override
    public void display(Set<Stock> stocks, PriceAnalyst analyst) {
        NumberFormat nf = NumberFormat.getNumberInstance(analyst.getLocale());
        try{
            String fileName = Utils.pathFile;
            FileWriter fstream = new FileWriter(fileName, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("The current stock price for " + analyst.getName() + ":\n");
            for (Stock entry : stocks) {
                out.write(entry.getName() + ": Price = " + nf.format(entry.getPrice())+";\t");
                out.flush();
            }
            out.close();
        }catch(IOException ex){
            System.err.println("Sorry, something went wrong...");
            ex.printStackTrace();
        }
    }
}
