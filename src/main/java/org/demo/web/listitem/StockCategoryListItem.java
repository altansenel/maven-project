/*
 * Created on 24 �ub 2016 ( Time 16:05:22 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.StockCategory;
import org.demo.web.common.ListItem;

public class StockCategoryListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public StockCategoryListItem(StockCategory stockCategory) {
		super();

		this.value = ""
			 + stockCategory.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = stockCategory.toString();
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

}
