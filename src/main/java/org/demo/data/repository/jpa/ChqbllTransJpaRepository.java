package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.ChqbllTransEntity;

/**
 * Repository : ChqbllTrans.
 */
public interface ChqbllTransJpaRepository extends PagingAndSortingRepository<ChqbllTransEntity, Integer> {

}
