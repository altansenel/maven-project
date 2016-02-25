package org.demo.test;

import org.demo.bean.ChqbllPayrollDetail;

public class ChqbllPayrollDetailFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllPayrollDetail newChqbllPayrollDetail() {

		Integer id = mockValues.nextInteger();

		ChqbllPayrollDetail chqbllPayrollDetail = new ChqbllPayrollDetail();
		chqbllPayrollDetail.setId(id);
		return chqbllPayrollDetail;
	}
	
}
