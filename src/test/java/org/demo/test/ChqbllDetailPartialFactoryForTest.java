package org.demo.test;

import org.demo.bean.ChqbllDetailPartial;

public class ChqbllDetailPartialFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllDetailPartial newChqbllDetailPartial() {

		Integer id = mockValues.nextInteger();

		ChqbllDetailPartial chqbllDetailPartial = new ChqbllDetailPartial();
		chqbllDetailPartial.setId(id);
		return chqbllDetailPartial;
	}
	
}
