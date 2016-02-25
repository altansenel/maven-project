package org.demo.test;

import org.demo.bean.jpa.ChqbllDetailHistoryEntity;

public class ChqbllDetailHistoryEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllDetailHistoryEntity newChqbllDetailHistoryEntity() {

		Integer id = mockValues.nextInteger();

		ChqbllDetailHistoryEntity chqbllDetailHistoryEntity = new ChqbllDetailHistoryEntity();
		chqbllDetailHistoryEntity.setId(id);
		return chqbllDetailHistoryEntity;
	}
	
}
