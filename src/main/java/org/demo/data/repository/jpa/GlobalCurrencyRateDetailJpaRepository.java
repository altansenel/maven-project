package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.GlobalCurrencyRateDetailEntity;

/**
 * Repository : GlobalCurrencyRateDetail.
 */
public interface GlobalCurrencyRateDetailJpaRepository extends PagingAndSortingRepository<GlobalCurrencyRateDetailEntity, Integer> {

}
