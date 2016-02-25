package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.WaybillTransStatusEntity;

/**
 * Repository : WaybillTransStatus.
 */
public interface WaybillTransStatusJpaRepository extends PagingAndSortingRepository<WaybillTransStatusEntity, Integer> {

}
