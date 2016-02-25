package org.demo.test;

import org.demo.bean.ChqbllType;

public class ChqbllTypeFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllType newChqbllType() {

		Integer id = mockValues.nextInteger();

		ChqbllType chqbllType = new ChqbllType();
		chqbllType.setId(id);
		return chqbllType;
	}
	
}
