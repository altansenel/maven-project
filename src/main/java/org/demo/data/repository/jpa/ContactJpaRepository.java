package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.ContactEntity;

/**
 * Repository : Contact.
 */
public interface ContactJpaRepository extends PagingAndSortingRepository<ContactEntity, Integer> {

}
