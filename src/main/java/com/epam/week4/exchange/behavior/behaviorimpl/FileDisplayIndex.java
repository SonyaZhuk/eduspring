package com.epam.week4.exchange.behavior.behaviorimpl;

import com.epam.week4.Utils;
import com.epam.week4.exchange.entity.IndexAnalyst;
import com.epam.week4.exchange.behavior.OutputIndexBehavior;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;

/**
 * Created by Sofya_Zhuk on 6/22/2016.
 */
public class FileDisplayIndex implements OutputIndexBehavior {


    public FileDisplayIndex(){

    }

    @Override
    public void display(Double index, IndexAnalyst analyst) {
        NumberFormat nf = NumberFormat.getNumberInstance(analyst.getLocale());
        try{
            String fileName = Utils.pathFile;
            FileWriter fstream = new FileWriter(fileName, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("The stock exchange index for " + analyst.getName() + ": " + nf.format(index));
            out.close();
        }catch(IOException ex){
            System.err.println("Sorry, something went wrong...");
            ex.printStackTrace();
        }
    }
}
