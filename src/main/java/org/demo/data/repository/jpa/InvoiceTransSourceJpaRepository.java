package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.InvoiceTransSourceEntity;

/**
 * Repository : InvoiceTransSource.
 */
public interface InvoiceTransSourceJpaRepository extends PagingAndSortingRepository<InvoiceTransSourceEntity, Integer> {

}
