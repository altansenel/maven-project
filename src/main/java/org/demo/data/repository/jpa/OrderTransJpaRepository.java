package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.OrderTransEntity;

/**
 * Repository : OrderTrans.
 */
public interface OrderTransJpaRepository extends PagingAndSortingRepository<OrderTransEntity, Integer> {

}
