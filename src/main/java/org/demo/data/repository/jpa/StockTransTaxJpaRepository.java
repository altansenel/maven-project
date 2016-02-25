package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockTransTaxEntity;

/**
 * Repository : StockTransTax.
 */
public interface StockTransTaxJpaRepository extends PagingAndSortingRepository<StockTransTaxEntity, Integer> {

}
