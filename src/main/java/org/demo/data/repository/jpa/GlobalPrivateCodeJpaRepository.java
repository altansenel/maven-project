package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.GlobalPrivateCodeEntity;

/**
 * Repository : GlobalPrivateCode.
 */
public interface GlobalPrivateCodeJpaRepository extends PagingAndSortingRepository<GlobalPrivateCodeEntity, Integer> {

}
