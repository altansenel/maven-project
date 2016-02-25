package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.InvoiceTransTaxEntity;

/**
 * Repository : InvoiceTransTax.
 */
public interface InvoiceTransTaxJpaRepository extends PagingAndSortingRepository<InvoiceTransTaxEntity, Integer> {

}
