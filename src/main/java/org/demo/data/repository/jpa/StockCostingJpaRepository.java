package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockCostingEntity;

/**
 * Repository : StockCosting.
 */
public interface StockCostingJpaRepository extends PagingAndSortingRepository<StockCostingEntity, Integer> {

}
