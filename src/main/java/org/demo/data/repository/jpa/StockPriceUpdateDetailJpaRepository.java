package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockPriceUpdateDetailEntity;

/**
 * Repository : StockPriceUpdateDetail.
 */
public interface StockPriceUpdateDetailJpaRepository extends PagingAndSortingRepository<StockPriceUpdateDetailEntity, Integer> {

}
