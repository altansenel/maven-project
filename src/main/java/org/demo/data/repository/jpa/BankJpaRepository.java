package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.BankEntity;

/**
 * Repository : Bank.
 */
public interface BankJpaRepository extends PagingAndSortingRepository<BankEntity, Integer> {

}
