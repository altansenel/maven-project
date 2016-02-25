package org.demo.test;

import org.demo.bean.jpa.ChqbllTransEntity;

public class ChqbllTransEntityFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllTransEntity newChqbllTransEntity() {

		Integer id = mockValues.nextInteger();

		ChqbllTransEntity chqbllTransEntity = new ChqbllTransEntity();
		chqbllTransEntity.setId(id);
		return chqbllTransEntity;
	}
	
}
