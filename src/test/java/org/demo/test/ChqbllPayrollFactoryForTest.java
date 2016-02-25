package org.demo.test;

import org.demo.bean.ChqbllPayroll;

public class ChqbllPayrollFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllPayroll newChqbllPayroll() {

		Integer id = mockValues.nextInteger();

		ChqbllPayroll chqbllPayroll = new ChqbllPayroll();
		chqbllPayroll.setId(id);
		return chqbllPayroll;
	}
	
}
