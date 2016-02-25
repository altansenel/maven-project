package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.SafeExpenseEntity;

/**
 * Repository : SafeExpense.
 */
public interface SafeExpenseJpaRepository extends PagingAndSortingRepository<SafeExpenseEntity, Integer> {

}
