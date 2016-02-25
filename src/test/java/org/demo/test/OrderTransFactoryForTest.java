package org.demo.test;

import org.demo.bean.OrderTrans;

public class OrderTransFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTrans newOrderTrans() {

		Integer id = mockValues.nextInteger();

		OrderTrans orderTrans = new OrderTrans();
		orderTrans.setId(id);
		return orderTrans;
	}
	
}
