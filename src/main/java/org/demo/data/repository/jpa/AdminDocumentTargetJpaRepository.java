package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminDocumentTargetEntity;

/**
 * Repository : AdminDocumentTarget.
 */
public interface AdminDocumentTargetJpaRepository extends PagingAndSortingRepository<AdminDocumentTargetEntity, Integer> {

}
