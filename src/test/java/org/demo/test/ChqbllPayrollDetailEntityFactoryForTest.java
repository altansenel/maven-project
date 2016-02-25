package org.demo.test;

import org.demo.bean.jpa.ChqbllPayrollDetailEntity;

public class ChqbllPayrollDetailEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllPayrollDetailEntity newChqbllPayrollDetailEntity() {

		Integer id = mockValues.nextInteger();

		ChqbllPayrollDetailEntity chqbllPayrollDetailEntity = new ChqbllPayrollDetailEntity();
		chqbllPayrollDetailEntity.setId(id);
		return chqbllPayrollDetailEntity;
	}
	
}
