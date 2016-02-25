package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.GlobalTransPointEntity;

/**
 * Repository : GlobalTransPoint.
 */
public interface GlobalTransPointJpaRepository extends PagingAndSortingRepository<GlobalTransPointEntity, Integer> {

}
