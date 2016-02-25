package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockExtraFieldsEntity;

/**
 * Repository : StockExtraFields.
 */
public interface StockExtraFieldsJpaRepository extends PagingAndSortingRepository<StockExtraFieldsEntity, Integer> {

}
