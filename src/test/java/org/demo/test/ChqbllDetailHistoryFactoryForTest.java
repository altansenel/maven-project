package org.demo.test;

import org.demo.bean.ChqbllDetailHistory;

public class ChqbllDetailHistoryFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public ChqbllDetailHistory newChqbllDetailHistory() {

		Integer id = mockValues.nextInteger();

		ChqbllDetailHistory chqbllDetailHistory = new ChqbllDetailHistory();
		chqbllDetailHistory.setId(id);
		return chqbllDetailHistory;
	}
	
}
