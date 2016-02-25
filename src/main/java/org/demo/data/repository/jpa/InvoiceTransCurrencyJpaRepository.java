package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.InvoiceTransCurrencyEntity;

/**
 * Repository : InvoiceTransCurrency.
 */
public interface InvoiceTransCurrencyJpaRepository extends PagingAndSortingRepository<InvoiceTransCurrencyEntity, Integer> {

}
