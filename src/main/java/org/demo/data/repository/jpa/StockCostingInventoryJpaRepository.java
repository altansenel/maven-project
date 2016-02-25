package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockCostingInventoryEntity;

/**
 * Repository : StockCostingInventory.
 */
public interface StockCostingInventoryJpaRepository extends PagingAndSortingRepository<StockCostingInventoryEntity, Integer> {

}
