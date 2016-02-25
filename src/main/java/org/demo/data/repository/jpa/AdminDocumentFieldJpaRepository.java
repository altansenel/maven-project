package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminDocumentFieldEntity;

/**
 * Repository : AdminDocumentField.
 */
public interface AdminDocumentFieldJpaRepository extends PagingAndSortingRepository<AdminDocumentFieldEntity, Integer> {

}
