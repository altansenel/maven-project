package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockEntity;

/**
 * Repository : Stock.
 */
public interface StockJpaRepository extends PagingAndSortingRepository<StockEntity, Integer> {

}
