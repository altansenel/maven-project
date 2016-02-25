/*
 * Created on 24 �ub 2016 ( Time 16:05:22 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.InvoiceTransCurrency;
import org.demo.web.common.ListItem;

public class InvoiceTransCurrencyListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public InvoiceTransCurrencyListItem(InvoiceTransCurrency invoiceTransCurrency) {
		super();

		this.value = ""
			 + invoiceTransCurrency.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = invoiceTransCurrency.toString();
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

}