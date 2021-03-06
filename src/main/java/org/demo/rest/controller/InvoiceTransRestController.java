/*
 * Created on 24 �ub 2016 ( Time 15:56:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.demo.bean.InvoiceTrans;
import org.demo.business.service.InvoiceTransService;
import org.demo.web.listitem.InvoiceTransListItem;

/**
 * Spring MVC controller for 'InvoiceTrans' management.
 */
@Controller
public class InvoiceTransRestController {

	@Resource
	private InvoiceTransService invoiceTransService;
	
	@RequestMapping( value="/items/invoiceTrans",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<InvoiceTransListItem> findAllAsListItems() {
		List<InvoiceTrans> list = invoiceTransService.findAll();
		List<InvoiceTransListItem> items = new LinkedList<InvoiceTransListItem>();
		for ( InvoiceTrans invoiceTrans : list ) {
			items.add(new InvoiceTransListItem( invoiceTrans ) );
		}
		return items;
	}
	
	@RequestMapping( value="/invoiceTrans",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<InvoiceTrans> findAll() {
		return invoiceTransService.findAll();
	}

	@RequestMapping( value="/invoiceTrans/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public InvoiceTrans findOne(@PathVariable("id") Integer id) {
		return invoiceTransService.findById(id);
	}
	
	@RequestMapping( value="/invoiceTrans",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public InvoiceTrans create(@RequestBody InvoiceTrans invoiceTrans) {
		return invoiceTransService.create(invoiceTrans);
	}

	@RequestMapping( value="/invoiceTrans/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public InvoiceTrans update(@PathVariable("id") Integer id, @RequestBody InvoiceTrans invoiceTrans) {
		return invoiceTransService.update(invoiceTrans);
	}

	@RequestMapping( value="/invoiceTrans/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		invoiceTransService.delete(id);
	}
	
}
