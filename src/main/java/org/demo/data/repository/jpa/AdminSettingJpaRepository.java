package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.AdminSettingEntity;

/**
 * Repository : AdminSetting.
 */
public interface AdminSettingJpaRepository extends PagingAndSortingRepository<AdminSettingEntity, Integer> {

}
