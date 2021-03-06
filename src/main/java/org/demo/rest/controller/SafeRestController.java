/*
 * Created on 24 �ub 2016 ( Time 15:56:50 )
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
import org.demo.bean.Safe;
import org.demo.business.service.SafeService;
import org.demo.web.listitem.SafeListItem;

/**
 * Spring MVC controller for 'Safe' management.
 */
@Controller
public class SafeRestController {

	@Resource
	private SafeService safeService;
	
	@RequestMapping( value="/items/safe",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<SafeListItem> findAllAsListItems() {
		List<Safe> list = safeService.findAll();
		List<SafeListItem> items = new LinkedList<SafeListItem>();
		for ( Safe safe : list ) {
			items.add(new SafeListItem( safe ) );
		}
		return items;
	}
	
	@RequestMapping( value="/safe",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Safe> findAll() {
		return safeService.findAll();
	}

	@RequestMapping( value="/safe/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Safe findOne(@PathVariable("id") Integer id) {
		return safeService.findById(id);
	}
	
	@RequestMapping( value="/safe",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Safe create(@RequestBody Safe safe) {
		return safeService.create(safe);
	}

	@RequestMapping( value="/safe/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Safe update(@PathVariable("id") Integer id, @RequestBody Safe safe) {
		return safeService.update(safe);
	}

	@RequestMapping( value="/safe/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		safeService.delete(id);
	}
	
}
