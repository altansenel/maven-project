package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockCategoryEntity;

/**
 * Repository : StockCategory.
 */
public interface StockCategoryJpaRepository extends PagingAndSortingRepository<StockCategoryEntity, Integer> {

}
