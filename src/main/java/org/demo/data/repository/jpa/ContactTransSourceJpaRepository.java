package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.ContactTransSourceEntity;

/**
 * Repository : ContactTransSource.
 */
public interface ContactTransSourceJpaRepository extends PagingAndSortingRepository<ContactTransSourceEntity, Integer> {

}
