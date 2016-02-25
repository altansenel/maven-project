package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockTransCurrencyEntity;

/**
 * Repository : StockTransCurrency.
 */
public interface StockTransCurrencyJpaRepository extends PagingAndSortingRepository<StockTransCurrencyEntity, Integer> {

}
