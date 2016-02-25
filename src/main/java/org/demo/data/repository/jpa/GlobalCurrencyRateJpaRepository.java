package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.GlobalCurrencyRateEntity;

/**
 * Repository : GlobalCurrencyRate.
 */
public interface GlobalCurrencyRateJpaRepository extends PagingAndSortingRepository<GlobalCurrencyRateEntity, Integer> {

}
