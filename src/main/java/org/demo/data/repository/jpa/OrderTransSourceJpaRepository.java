package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.OrderTransSourceEntity;

/**
 * Repository : OrderTransSource.
 */
public interface OrderTransSourceJpaRepository extends PagingAndSortingRepository<OrderTransSourceEntity, Integer> {

}
