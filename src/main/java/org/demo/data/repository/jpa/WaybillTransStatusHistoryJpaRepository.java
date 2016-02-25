package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.WaybillTransStatusHistoryEntity;

/**
 * Repository : WaybillTransStatusHistory.
 */
public interface WaybillTransStatusHistoryJpaRepository extends PagingAndSortingRepository<WaybillTransStatusHistoryEntity, Integer> {

}
