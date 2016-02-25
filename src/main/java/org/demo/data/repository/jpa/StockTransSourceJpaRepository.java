package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockTransSourceEntity;

/**
 * Repository : StockTransSource.
 */
public interface StockTransSourceJpaRepository extends PagingAndSortingRepository<StockTransSourceEntity, Integer> {

}
