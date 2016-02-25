package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminExtraFieldsEntity;

/**
 * Repository : AdminExtraFields.
 */
public interface AdminExtraFieldsJpaRepository extends PagingAndSortingRepository<AdminExtraFieldsEntity, Integer> {

}
