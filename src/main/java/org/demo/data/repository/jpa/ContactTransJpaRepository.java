package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.ContactTransEntity;

/**
 * Repository : ContactTrans.
 */
public interface ContactTransJpaRepository extends PagingAndSortingRepository<ContactTransEntity, Integer> {

}
