package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminUserEntity;

/**
 * Repository : AdminUser.
 */
public interface AdminUserJpaRepository extends PagingAndSortingRepository<AdminUserEntity, Integer> {

}
