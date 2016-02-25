package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.WaybillTransDetailEntity;

/**
 * Repository : WaybillTransDetail.
 */
public interface WaybillTransDetailJpaRepository extends PagingAndSortingRepository<WaybillTransDetailEntity, Integer> {

}
