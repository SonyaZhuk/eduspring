package com.epam.week4.exchange.repositories;

import com.epam.week4.exchange.entity.Exchange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sofya_Zhuk on 7/10/2016.
 */
public interface ExchangeRepository extends CrudRepository<Exchange,Integer> {

}
