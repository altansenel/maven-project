package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.SafeTransSourceEntity;

/**
 * Repository : SafeTransSource.
 */
public interface SafeTransSourceJpaRepository extends PagingAndSortingRepository<SafeTransSourceEntity, Integer> {

}
