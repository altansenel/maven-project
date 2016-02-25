package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminUserRightEntity;

/**
 * Repository : AdminUserRight.
 */
public interface AdminUserRightJpaRepository extends PagingAndSortingRepository<AdminUserRightEntity, Integer> {

}
