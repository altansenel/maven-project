package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.ContactCategoryEntity;

/**
 * Repository : ContactCategory.
 */
public interface ContactCategoryJpaRepository extends PagingAndSortingRepository<ContactCategoryEntity, Integer> {

}
