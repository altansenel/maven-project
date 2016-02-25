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
import org.demo.bean.InvoiceTransFactor;
import org.demo.business.service.InvoiceTransFactorService;
import org.demo.web.listitem.InvoiceTransFactorListItem;

/**
 * Spring MVC controller for 'InvoiceTransFactor' management.
 */
@Controller
public class InvoiceTransFactorRestController {

	@Resource
	private InvoiceTransFactorService invoiceTransFactorService;
	
	@RequestMapping( value="/items/invoiceTransFactor",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<InvoiceTransFactorListItem> findAllAsListItems() {
		List<InvoiceTransFactor> list = invoiceTransFactorService.findAll();
		List<InvoiceTransFactorListItem> items = new LinkedList<InvoiceTransFactorListItem>();
		for ( InvoiceTransFactor invoiceTransFactor : list ) {
			items.add(new InvoiceTransFactorListItem( invoiceTransFactor ) );
		}
		return items;
	}
	
	@RequestMapping( value="/invoiceTransFactor",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<InvoiceTransFactor> findAll() {
		return invoiceTransFactorService.findAll();
	}

	@RequestMapping( value="/invoiceTransFactor/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public InvoiceTransFactor findOne(@PathVariable("id") Integer id) {
		return invoiceTransFactorService.findById(id);
	}
	
	@RequestMapping( value="/invoiceTransFactor",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public InvoiceTransFactor create(@RequestBody InvoiceTransFactor invoiceTransFactor) {
		return invoiceTransFactorService.create(invoiceTransFactor);
	}

	@RequestMapping( value="/invoiceTransFactor/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public InvoiceTransFactor update(@PathVariable("id") Integer id, @RequestBody InvoiceTransFactor invoiceTransFactor) {
		return invoiceTransFactorService.update(invoiceTransFactor);
	}

	@RequestMapping( value="/invoiceTransFactor/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		invoiceTransFactorService.delete(id);
	}
	
}