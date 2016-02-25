package org.demo.test;

import org.demo.bean.OrderTransDetail;

public class OrderTransDetailFactoryForTest {

	private MockValues mockValues = new MockValues();
	
	public OrderTransDetail newOrderTransDetail() {

		Integer id = mockValues.nextInteger();

		OrderTransDetail orderTransDetail = new OrderTransDetail();
		orderTransDetail.setId(id);
		return orderTransDetail;
	}
	
}
