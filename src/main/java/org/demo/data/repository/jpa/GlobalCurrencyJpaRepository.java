package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.GlobalCurrencyEntity;

/**
 * Repository : GlobalCurrency.
 */
public interface GlobalCurrencyJpaRepository extends PagingAndSortingRepository<GlobalCurrencyEntity, Integer> {

}
