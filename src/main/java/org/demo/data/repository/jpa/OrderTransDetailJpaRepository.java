package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.OrderTransDetailEntity;

/**
 * Repository : OrderTransDetail.
 */
public interface OrderTransDetailJpaRepository extends PagingAndSortingRepository<OrderTransDetailEntity, Integer> {

}
