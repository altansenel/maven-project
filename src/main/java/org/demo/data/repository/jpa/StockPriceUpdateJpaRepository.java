package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockPriceUpdateEntity;

/**
 * Repository : StockPriceUpdate.
 */
public interface StockPriceUpdateJpaRepository extends PagingAndSortingRepository<StockPriceUpdateEntity, Integer> {

}
