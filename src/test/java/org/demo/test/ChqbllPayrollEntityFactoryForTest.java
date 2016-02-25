package org.demo.test;

import org.demo.bean.jpa.ChqbllPayrollEntity;

public class ChqbllPayrollEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllPayrollEntity newChqbllPayrollEntity() {

		Integer id = mockValues.nextInteger();

		ChqbllPayrollEntity chqbllPayrollEntity = new ChqbllPayrollEntity();
		chqbllPayrollEntity.setId(id);
		return chqbllPayrollEntity;
	}
	
}
