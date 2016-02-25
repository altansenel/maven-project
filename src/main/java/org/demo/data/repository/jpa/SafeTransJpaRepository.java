package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.SafeTransEntity;

/**
 * Repository : SafeTrans.
 */
public interface SafeTransJpaRepository extends PagingAndSortingRepository<SafeTransEntity, Integer> {

}
