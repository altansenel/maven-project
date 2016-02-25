package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.StockBarcodeEntity;

/**
 * Repository : StockBarcode.
 */
public interface StockBarcodeJpaRepository extends PagingAndSortingRepository<StockBarcodeEntity, Integer> {

}
