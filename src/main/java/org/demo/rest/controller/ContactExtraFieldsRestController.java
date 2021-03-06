/*
 * Created on 24 �ub 2016 ( Time 15:56:48 )
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
import org.demo.bean.ContactExtraFields;
import org.demo.business.service.ContactExtraFieldsService;
import org.demo.web.listitem.ContactExtraFieldsListItem;

/**
 * Spring MVC controller for 'ContactExtraFields' management.
 */
@Controller
public class ContactExtraFieldsRestController {

	@Resource
	private ContactExtraFieldsService contactExtraFieldsService;
	
	@RequestMapping( value="/items/contactExtraFields",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ContactExtraFieldsListItem> findAllAsListItems() {
		List<ContactExtraFields> list = contactExtraFieldsService.findAll();
		List<ContactExtraFieldsListItem> items = new LinkedList<ContactExtraFieldsListItem>();
		for ( ContactExtraFields contactExtraFields : list ) {
			items.add(new ContactExtraFieldsListItem( contactExtraFields ) );
		}
		return items;
	}
	
	@RequestMapping( value="/contactExtraFields",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ContactExtraFields> findAll() {
		return contactExtraFieldsService.findAll();
	}

	@RequestMapping( value="/contactExtraFields/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ContactExtraFields findOne(@PathVariable("id") Integer id) {
		return contactExtraFieldsService.findById(id);
	}
	
	@RequestMapping( value="/contactExtraFields",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ContactExtraFields create(@RequestBody ContactExtraFields contactExtraFields) {
		return contactExtraFieldsService.create(contactExtraFields);
	}

	@RequestMapping( value="/contactExtraFields/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ContactExtraFields update(@PathVariable("id") Integer id, @RequestBody ContactExtraFields contactExtraFields) {
		return contactExtraFieldsService.update(contactExtraFields);
	}

	@RequestMapping( value="/contactExtraFields/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		contactExtraFieldsService.delete(id);
	}
	
}
