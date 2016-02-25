package org.demo.test;

import org.demo.bean.ChqbllPayrollSource;

public class ChqbllPayrollSourceFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllPayrollSource newChqbllPayrollSource() {

		Integer id = mockValues.nextInteger();

		ChqbllPayrollSource chqbllPayrollSource = new ChqbllPayrollSource();
		chqbllPayrollSource.setId(id);
		return chqbllPayrollSource;
	}
	
}
