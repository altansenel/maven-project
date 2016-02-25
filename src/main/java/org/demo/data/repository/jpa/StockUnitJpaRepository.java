package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockUnitEntity;

/**
 * Repository : StockUnit.
 */
public interface StockUnitJpaRepository extends PagingAndSortingRepository<StockUnitEntity, Integer> {

}
