package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.InvoiceTransFactorEntity;

/**
 * Repository : InvoiceTransFactor.
 */
public interface InvoiceTransFactorJpaRepository extends PagingAndSortingRepository<InvoiceTransFactorEntity, Integer> {

}
