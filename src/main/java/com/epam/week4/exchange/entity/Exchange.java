package com.epam.week4.exchange.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sofya_Zhuk on 7/7/2016.
 */
@Entity
@Table(name = "MyExchange")
public class Exchange {

    @Id
    @Column(name = "idEx")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEx;

    @Column(name = "ExchangeName")
    private String exchangeName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ExPA",
            joinColumns = @JoinColumn(name = "idEx"),
            inverseJoinColumns = @JoinColumn(name = "idAP")
    )
    private Set<PriceAnalyst> priceAnalysts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ExAI",
            joinColumns = @JoinColumn(name = "idEx"),
            inverseJoinColumns = @JoinColumn(name = "idAI")
    )
    private Set<IndexAnalyst> indexAnalysts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ExSt",
            joinColumns = @JoinColumn(name = "idEx"),
            inverseJoinColumns = @JoinColumn(name = "idS")
    )
    private Set<Stock> stocks = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ExPI",
            joinColumns = @JoinColumn(name = "idEx"),
            inverseJoinColumns = @JoinColumn(name = "idI")
    )
    private Set<IndexAnalyst> indexes = new HashSet<>();

    public Exchange(){}

    public Exchange(String exchangeName){
        this.exchangeName = exchangeName;
    }

    public void addPriceAnalyst(PriceAnalyst priceAnalyst) {
        this.priceAnalysts.add(priceAnalyst);
    }

    public void addIndexAnalyst(IndexAnalyst indexAnalyst) {
        this.indexAnalysts.add(indexAnalyst);
    }

    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }

    public int getIdEx(){
        return idEx;
    }

    public void setIdEx(int idEx){
        this.idEx = idEx;
    }

    public String getExchangeName(){
        return exchangeName;
    }

    public void setExchangeName(String exchangeName){
        this.exchangeName = exchangeName;
    }

    public Set<PriceAnalyst> getPriceAnalysts(){
        return priceAnalysts;
    }

    public void setPriceAnalysts(Set<PriceAnalyst> priceAnalysts){
        this.priceAnalysts = priceAnalysts;
    }

    public Set<IndexAnalyst> getIndexAnalysts(){
        return indexAnalysts;
    }

    public void setIndexAnalysts(Set<IndexAnalyst> indexAnalysts){
        this.indexAnalysts = indexAnalysts;
    }

    public Set<Stock> getStocks(){
        return stocks;
    }

    public void setStocks(Set<Stock> stocks){
        this.stocks = stocks;
    }

    public Set<IndexAnalyst> getIndexAnalyst(){
        return indexes;
    }

    public void setIndexAnalyst(Set<IndexAnalyst> indexes){
        this.indexes = indexes;
    }

}
