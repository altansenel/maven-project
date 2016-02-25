package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.WaybillTransEntity;

/**
 * Repository : WaybillTrans.
 */
public interface WaybillTransJpaRepository extends PagingAndSortingRepository<WaybillTransEntity, Integer> {

}
