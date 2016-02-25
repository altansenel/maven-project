package org.demo.data.repository.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.demo.bean.jpa.SaleCampaignEntity;

/**
 * Repository : SaleCampaign.
 */
public interface SaleCampaignJpaRepository extends PagingAndSortingRepository<SaleCampaignEntity, Integer> {

}
