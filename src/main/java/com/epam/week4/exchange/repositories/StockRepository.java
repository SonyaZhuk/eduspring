package com.epam.week4.exchange.repositories;

import com.epam.week4.exchange.entity.Stock;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sofya_Zhuk on 7/10/2016.
 */
public interface StockRepository extends CrudRepository<Stock,Integer> {
}
