package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.InvoiceTransEntity;

/**
 * Repository : InvoiceTrans.
 */
public interface InvoiceTransJpaRepository extends PagingAndSortingRepository<InvoiceTransEntity, Integer> {

}
