package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockTransDetailEntity;

/**
 * Repository : StockTransDetail.
 */
public interface StockTransDetailJpaRepository extends PagingAndSortingRepository<StockTransDetailEntity, Integer> {

}
