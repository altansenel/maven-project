package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.BankExpenseEntity;

/**
 * Repository : BankExpense.
 */
public interface BankExpenseJpaRepository extends PagingAndSortingRepository<BankExpenseEntity, Integer> {

}
