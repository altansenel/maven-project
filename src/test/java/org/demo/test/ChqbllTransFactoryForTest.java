package org.demo.test;

import org.demo.bean.ChqbllTrans;

public class ChqbllTransFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllTrans newChqbllTrans() {

		Integer id = mockValues.nextInteger();

		ChqbllTrans chqbllTrans = new ChqbllTrans();
		chqbllTrans.setId(id);
		return chqbllTrans;
	}
	
}
