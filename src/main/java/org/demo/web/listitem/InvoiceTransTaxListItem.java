/*
 * Created on 24 �ub 2016 ( Time 16:05:22 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.InvoiceTransTax;
import org.demo.web.common.ListItem;

public class InvoiceTransTaxListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public InvoiceTransTaxListItem(InvoiceTransTax invoiceTransTax) {
		super();

		this.value = ""
			 + invoiceTransTax.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = invoiceTransTax.toString();
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

}
