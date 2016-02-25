package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminUserAuditEntity;

/**
 * Repository : AdminUserAudit.
 */
public interface AdminUserAuditJpaRepository extends PagingAndSortingRepository<AdminUserAuditEntity, Integer> {

}
