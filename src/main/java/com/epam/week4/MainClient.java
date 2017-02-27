package com.epam.week4;

import com.epam.week4.exchange.ExchangeData;
import com.epam.week4.exchange.entity.*;

import com.epam.week4.exchange.observers.implobservers.ObserverIndexImpl;
import com.epam.week4.exchange.observers.implobservers.ObserverPricesImpl;
import com.epam.week4.exchange.repositories.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.CrudRepository;

import java.util.*;


/**
 * Created by Sofya_Zhuk on 6/18/2016.
 *
 * Used patterns Observer, Strategy, Simple Factory
 * Example: http://coderevisited.com/beginng-with-spring-data-jpa/
 * https://spring.io/blog/2009/03/08/rest-in-spring-3-mvc
 * http://websystique.com/springmvc/springmvc-hibernate-many-to-many-example-annotation-using-join-table/
 */
public class MainClient {

    private AbstractApplicationContext context;
    private static CrudRepository repositoryExchange;
    private static CrudRepository repositoryIndexAnalyst;
    private static CrudRepository repositoryIndex;
    private static CrudRepository repositoryPriceAnalyst;
    private static CrudRepository repositoryStock;

    public static void main(String[] args) {

        MainClient mainClient = new MainClient();
        mainClient.initContext();


////Old implementation
//        Exchange exchange = new Exchange("MyExchange");
//        ExchangeData exchangeData = new ExchangeData(exchange);
//        //for test
//        Locale locale1 = new Locale("en", "US");
//        Locale locale2 = new Locale("fr", "CA");
//        PriceAnalyst analyst0 = new PriceAnalyst("Sonya Zhuk", TypeDisplay.CONSOLE, locale1);
//        PriceAnalyst analyst1 = new PriceAnalyst("Vasya Petrov", TypeDisplay.CONSOLE, locale2);
//
//
//        IndexAnalyst analyst2 = new IndexAnalyst("Vasya Petrov", TypeDisplay.CONSOLE, locale2);
//        IndexAnalyst analyst3 = new IndexAnalyst("Sonya Zhuk", TypeDisplay.CONSOLE, locale1);
//
//
//        ObserverPrices consoleDisplayPrices = new ObserverPricesImpl(exchangeData , analyst0);
//
//       // ObserverPricesImpl consoleDisplayPrices1 = new ObserverPricesImpl(exchangeData , "Vasya Petrov",DisplayLocale.DEF, TypeDisplay.CONSOLE);
//       // exchangeData.removeObserverPrices(consoleDisplayPrices);
//
//        ObserverIndex consoleDisplayIndex = new ObserverIndexImpl(exchangeData, analyst2);
//        Stock stock = new Stock("IBM", 100.1);
//        Stock stock1 = new Stock("APPLE", 200.1);
//        Set<Stock> stocks = new HashSet<>();
//        stocks.add(stock);
//        stocks.add(stock1);
//        exchangeData.setPrices(stocks);

    }

    private void initContext() {
        context = new ClassPathXmlApplicationContext("spring.xml");
        fillInitialData();
    }

    private void fillInitialData() {

        Exchange exchange = (Exchange)context.getBean("ExchangeBean");
        Stock stock1 = (Stock)context.getBean("FirstStockBean");
        Stock stock2 = (Stock)context.getBean("SecondStockBean");
        PriceAnalyst priceAnalyst = (PriceAnalyst)context.getBean("PriceAnalystBean");
        IndexAnalyst indexAnalyst = (IndexAnalyst)context.getBean("IndexAnalystBean");

        exchange.addPriceAnalyst(priceAnalyst);
        exchange.addIndexAnalyst(indexAnalyst);

        Set<Stock> stocks = new HashSet<>();
        stocks.add(stock1);
        stocks.add(stock2);
        for(Stock stock: stocks){
            exchange.addStock(stock);
        }

        ExchangeData exchangeData = (ExchangeData)context.getBean("ExchangeDataBean");
        exchangeData.setPrices(stocks);

        ExchangeIndex exchangeIndex = (ExchangeIndex)context.getBean("ExchangeIndexBean");
        exchangeIndex.setIndex(exchangeData.getExchangeIndex().getIndex());


        ObserverPricesImpl observerPrices = (ObserverPricesImpl)context.getBean("ObserverPricesBean");
        ObserverIndexImpl observerIndex = (ObserverIndexImpl)context.getBean("ObserverIndexBean");


        //TODO multith
        repositoryExchange = context.getBean(ExchangeRepository.class);
        saveExchange(exchange);
        repositoryIndexAnalyst = context.getBean(IndexAnalystRepository.class);
        saveIndexAnalyst(indexAnalyst);
        repositoryPriceAnalyst = context.getBean(PriceAnalystRepositoy.class);
        savePriceAnalyst(priceAnalyst);
        repositoryStock = context.getBean(StockRepository.class);
        saveStock(stock1);
        saveStock(stock2);
        repositoryIndex = context.getBean(IndexRepository.class);
        saveIndex(exchangeIndex);

    }

    private static void saveExchange(Exchange exchange) {
        repositoryExchange.save(exchange);
    }

    private static void saveIndexAnalyst(IndexAnalyst indexAnalyst) {
        repositoryIndexAnalyst.save(indexAnalyst);
    }

    private static void saveIndex(ExchangeIndex index) {
        repositoryIndex.save(index);
    }

    private static void savePriceAnalyst(PriceAnalyst priceAnalyst) {
        repositoryPriceAnalyst.save(priceAnalyst);
    }

    private static void saveStock(Stock stock) {
        repositoryStock.save(stock);
    }


}
