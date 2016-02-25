package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.WaybillTransRelationEntity;

/**
 * Repository : WaybillTransRelation.
 */
public interface WaybillTransRelationJpaRepository extends PagingAndSortingRepository<WaybillTransRelationEntity, Integer> {

}
