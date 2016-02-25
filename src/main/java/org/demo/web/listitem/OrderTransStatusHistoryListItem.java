/*
 * Created on 24 �ub 2016 ( Time 16:05:22 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.OrderTransStatusHistory;
import org.demo.web.common.ListItem;

public class OrderTransStatusHistoryListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public OrderTransStatusHistoryListItem(OrderTransStatusHistory orderTransStatusHistory) {
		super();

		this.value = ""
			 + orderTransStatusHistory.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = orderTransStatusHistory.toString();
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

}