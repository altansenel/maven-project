/*
 * Created on 24 �ub 2016 ( Time 16:05:22 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.StockTransDetail;
import org.demo.web.common.ListItem;

public class StockTransDetailListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public StockTransDetailListItem(StockTransDetail stockTransDetail) {
		super();

		this.value = ""
			 + stockTransDetail.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = stockTransDetail.toString();
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

}