package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.OrderTransStatusEntity;

/**
 * Repository : OrderTransStatus.
 */
public interface OrderTransStatusJpaRepository extends PagingAndSortingRepository<OrderTransStatusEntity, Integer> {

}
