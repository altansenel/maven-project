package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.WaybillTransSourceEntity;

/**
 * Repository : WaybillTransSource.
 */
public interface WaybillTransSourceJpaRepository extends PagingAndSortingRepository<WaybillTransSourceEntity, Integer> {

}
