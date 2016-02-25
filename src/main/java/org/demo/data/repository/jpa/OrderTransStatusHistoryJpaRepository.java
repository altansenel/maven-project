package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.OrderTransStatusHistoryEntity;

/**
 * Repository : OrderTransStatusHistory.
 */
public interface OrderTransStatusHistoryJpaRepository extends PagingAndSortingRepository<OrderTransStatusHistoryEntity, Integer> {

}
