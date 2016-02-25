package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.SaleSellerEntity;

/**
 * Repository : SaleSeller.
 */
public interface SaleSellerJpaRepository extends PagingAndSortingRepository<SaleSellerEntity, Integer> {

}
