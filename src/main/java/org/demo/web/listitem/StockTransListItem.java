/*
 * Created on 24 �ub 2016 ( Time 16:05:22 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.StockTrans;
import org.demo.web.common.ListItem;

public class StockTransListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public StockTransListItem(StockTrans stockTrans) {
		super();

		this.value = ""
			 + stockTrans.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = stockTrans.toString();
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

}
