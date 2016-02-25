package org.demo.test;

import org.demo.bean.jpa.ChqbllTransDetailEntity;

public class ChqbllTransDetailEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllTransDetailEntity newChqbllTransDetailEntity() {

		Integer id = mockValues.nextInteger();

		ChqbllTransDetailEntity chqbllTransDetailEntity = new ChqbllTransDetailEntity();
		chqbllTransDetailEntity.setId(id);
		return chqbllTransDetailEntity;
	}
	
}
