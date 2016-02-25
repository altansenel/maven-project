package org.demo.test;

import org.demo.bean.SaleCampaign;

public class SaleCampaignFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public SaleCampaign newSaleCampaign() {

		Integer id = mockValues.nextInteger();

		SaleCampaign saleCampaign = new SaleCampaign();
		saleCampaign.setId(id);
		return saleCampaign;
	}
	
}
