package org.demo.test;

import org.demo.bean.jpa.ChqbllDetailPartialEntity;

public class ChqbllDetailPartialEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllDetailPartialEntity newChqbllDetailPartialEntity() {

		Integer id = mockValues.nextInteger();

		ChqbllDetailPartialEntity chqbllDetailPartialEntity = new ChqbllDetailPartialEntity();
		chqbllDetailPartialEntity.setId(id);
		return chqbllDetailPartialEntity;
	}
	
}
