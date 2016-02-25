package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminUserGroupEntity;

/**
 * Repository : AdminUserGroup.
 */
public interface AdminUserGroupJpaRepository extends PagingAndSortingRepository<AdminUserGroupEntity, Integer> {

}
