package org.demo.test;

import org.demo.bean.jpa.SaleCampaignEntity;

public class SaleCampaignEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SaleCampaignEntity newSaleCampaignEntity() {

		Integer id = mockValues.nextInteger();

		SaleCampaignEntity saleCampaignEntity = new SaleCampaignEntity();
		saleCampaignEntity.setId(id);
		return saleCampaignEntity;
	}
	
}
