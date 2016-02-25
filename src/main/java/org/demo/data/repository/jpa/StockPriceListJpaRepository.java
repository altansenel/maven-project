package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockPriceListEntity;

/**
 * Repository : StockPriceList.
 */
public interface StockPriceListJpaRepository extends PagingAndSortingRepository<StockPriceListEntity, Integer> {

}
