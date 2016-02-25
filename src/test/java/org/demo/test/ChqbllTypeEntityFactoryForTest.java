package org.demo.test;

import org.demo.bean.jpa.ChqbllTypeEntity;

public class ChqbllTypeEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllTypeEntity newChqbllTypeEntity() {

		Integer id = mockValues.nextInteger();

		ChqbllTypeEntity chqbllTypeEntity = new ChqbllTypeEntity();
		chqbllTypeEntity.setId(id);
		return chqbllTypeEntity;
	}
	
}
