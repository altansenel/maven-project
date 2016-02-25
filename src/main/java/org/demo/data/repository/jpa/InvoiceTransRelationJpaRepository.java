package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.InvoiceTransRelationEntity;

/**
 * Repository : InvoiceTransRelation.
 */
public interface InvoiceTransRelationJpaRepository extends PagingAndSortingRepository<InvoiceTransRelationEntity, Integer> {

}
