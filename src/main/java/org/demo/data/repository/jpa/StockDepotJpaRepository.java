package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockDepotEntity;

/**
 * Repository : StockDepot.
 */
public interface StockDepotJpaRepository extends PagingAndSortingRepository<StockDepotEntity, Integer> {

}
