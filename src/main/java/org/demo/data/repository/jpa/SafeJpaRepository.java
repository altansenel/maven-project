package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.SafeEntity;

/**
 * Repository : Safe.
 */
public interface SafeJpaRepository extends PagingAndSortingRepository<SafeEntity, Integer> {

}
