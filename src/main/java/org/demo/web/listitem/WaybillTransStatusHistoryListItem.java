/*
 * Created on 24 �ub 2016 ( Time 16:05:22 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.WaybillTransStatusHistory;
import org.demo.web.common.ListItem;

public class WaybillTransStatusHistoryListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public WaybillTransStatusHistoryListItem(WaybillTransStatusHistory waybillTransStatusHistory) {
		super();

		this.value = ""
			 + waybillTransStatusHistory.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = waybillTransStatusHistory.toString();
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

}
