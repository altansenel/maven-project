package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.InvoiceTransStatusEntity;

/**
 * Repository : InvoiceTransStatus.
 */
public interface InvoiceTransStatusJpaRepository extends PagingAndSortingRepository<InvoiceTransStatusEntity, Integer> {

}
