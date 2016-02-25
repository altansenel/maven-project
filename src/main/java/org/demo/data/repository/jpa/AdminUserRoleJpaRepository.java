package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminUserRoleEntity;

/**
 * Repository : AdminUserRole.
 */
public interface AdminUserRoleJpaRepository extends PagingAndSortingRepository<AdminUserRoleEntity, Integer> {

}
