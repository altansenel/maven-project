package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.InvoiceTransDetailEntity;

/**
 * Repository : InvoiceTransDetail.
 */
public interface InvoiceTransDetailJpaRepository extends PagingAndSortingRepository<InvoiceTransDetailEntity, Integer> {

}
