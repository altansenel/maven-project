package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.GlobalProfileEntity;

/**
 * Repository : GlobalProfile.
 */
public interface GlobalProfileJpaRepository extends PagingAndSortingRepository<GlobalProfileEntity, Integer> {

}
