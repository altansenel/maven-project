package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.WaybillTransFactorEntity;

/**
 * Repository : WaybillTransFactor.
 */
public interface WaybillTransFactorJpaRepository extends PagingAndSortingRepository<WaybillTransFactorEntity, Integer> {

}
