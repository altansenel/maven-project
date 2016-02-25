package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockTransEntity;

/**
 * Repository : StockTrans.
 */
public interface StockTransJpaRepository extends PagingAndSortingRepository<StockTransEntity, Integer> {

}
