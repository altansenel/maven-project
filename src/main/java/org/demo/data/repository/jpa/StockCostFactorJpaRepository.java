package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockCostFactorEntity;

/**
 * Repository : StockCostFactor.
 */
public interface StockCostFactorJpaRepository extends PagingAndSortingRepository<StockCostFactorEntity, Integer> {

}
