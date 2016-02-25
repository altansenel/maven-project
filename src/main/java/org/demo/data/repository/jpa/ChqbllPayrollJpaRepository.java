package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.ChqbllPayrollEntity;

/**
 * Repository : ChqbllPayroll.
 */
public interface ChqbllPayrollJpaRepository extends PagingAndSortingRepository<ChqbllPayrollEntity, Integer> {

}
