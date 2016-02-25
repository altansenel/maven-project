package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.TempContactAgingEntity;

/**
 * Repository : TempContactAging.
 */
public interface TempContactAgingJpaRepository extends PagingAndSortingRepository<TempContactAgingEntity, Integer> {

}
