package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.ContactExtraFieldsEntity;

/**
 * Repository : ContactExtraFields.
 */
public interface ContactExtraFieldsJpaRepository extends PagingAndSortingRepository<ContactExtraFieldsEntity, Integer> {

}
