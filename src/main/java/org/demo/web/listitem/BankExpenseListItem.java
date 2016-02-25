/*
 * Created on 24 �ub 2016 ( Time 16:05:22 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.BankExpense;
import org.demo.web.common.ListItem;

public class BankExpenseListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public BankExpenseListItem(BankExpense bankExpense) {
		super();

		this.value = ""
			 + bankExpense.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = bankExpense.toString();
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

}