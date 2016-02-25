package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.OrderTransFactorEntity;

/**
 * Repository : OrderTransFactor.
 */
public interface OrderTransFactorJpaRepository extends PagingAndSortingRepository<OrderTransFactorEntity, Integer> {

}
