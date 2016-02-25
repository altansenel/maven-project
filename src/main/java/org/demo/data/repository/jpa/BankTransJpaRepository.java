package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.BankTransEntity;

/**
 * Repository : BankTrans.
 */
public interface BankTransJpaRepository extends PagingAndSortingRepository<BankTransEntity, Integer> {

}
