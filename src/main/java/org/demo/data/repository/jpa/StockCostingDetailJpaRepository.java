package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockCostingDetailEntity;

/**
 * Repository : StockCostingDetail.
 */
public interface StockCostingDetailJpaRepository extends PagingAndSortingRepository<StockCostingDetailEntity, Integer> {

}
