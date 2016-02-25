package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminWorkspaceEntity;

/**
 * Repository : AdminWorkspace.
 */
public interface AdminWorkspaceJpaRepository extends PagingAndSortingRepository<AdminWorkspaceEntity, Integer> {

}
