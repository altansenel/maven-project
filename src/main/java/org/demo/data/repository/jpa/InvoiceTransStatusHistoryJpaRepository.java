package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.InvoiceTransStatusHistoryEntity;

/**
 * Repository : InvoiceTransStatusHistory.
 */
public interface InvoiceTransStatusHistoryJpaRepository extends PagingAndSortingRepository<InvoiceTransStatusHistoryEntity, Integer> {

}
