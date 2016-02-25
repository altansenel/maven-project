package org.demo.test;

import org.demo.bean.ChqbllTransDetail;

public class ChqbllTransDetailFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllTransDetail newChqbllTransDetail() {

		Integer id = mockValues.nextInteger();

		ChqbllTransDetail chqbllTransDetail = new ChqbllTransDetail();
		chqbllTransDetail.setId(id);
		return chqbllTransDetail;
	}
	
}
