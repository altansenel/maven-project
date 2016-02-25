package org.demo.test;

import org.demo.bean.jpa.ChqbllPayrollSourceEntity;

public class ChqbllPayrollSourceEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllPayrollSourceEntity newChqbllPayrollSourceEntity() {

		Integer id = mockValues.nextInteger();

		ChqbllPayrollSourceEntity chqbllPayrollSourceEntity = new ChqbllPayrollSourceEntity();
		chqbllPayrollSourceEntity.setId(id);
		return chqbllPayrollSourceEntity;
	}
	
}
