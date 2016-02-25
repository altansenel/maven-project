package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.BankTransSourceEntity;

/**
 * Repository : BankTransSource.
 */
public interface BankTransSourceJpaRepository extends PagingAndSortingRepository<BankTransSourceEntity, Integer> {

}
