package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminUserGivenRoleEntity;

/**
 * Repository : AdminUserGivenRole.
 */
public interface AdminUserGivenRoleJpaRepository extends PagingAndSortingRepository<AdminUserGivenRoleEntity, Integer> {

}
