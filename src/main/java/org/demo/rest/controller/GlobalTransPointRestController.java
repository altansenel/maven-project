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
import org.demo.bean.GlobalTransPoint;
import org.demo.business.service.GlobalTransPointService;
import org.demo.web.listitem.GlobalTransPointListItem;

/**
 * Spring MVC controller for 'GlobalTransPoint' management.
 */
@Controller
public class GlobalTransPointRestController {

	@Resource
	private GlobalTransPointService globalTransPointService;
	
	@RequestMapping( value="/items/globalTransPoint",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<GlobalTransPointListItem> findAllAsListItems() {
		List<GlobalTransPoint> list = globalTransPointService.findAll();
		List<GlobalTransPointListItem> items = new LinkedList<GlobalTransPointListItem>();
		for ( GlobalTransPoint globalTransPoint : list ) {
			items.add(new GlobalTransPointListItem( globalTransPoint ) );
		}
		return items;
	}
	
	@RequestMapping( value="/globalTransPoint",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<GlobalTransPoint> findAll() {
		return globalTransPointService.findAll();
	}

	@RequestMapping( value="/globalTransPoint/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public GlobalTransPoint findOne(@PathVariable("id") Integer id) {
		return globalTransPointService.findById(id);
	}
	
	@RequestMapping( value="/globalTransPoint",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public GlobalTransPoint create(@RequestBody GlobalTransPoint globalTransPoint) {
		return globalTransPointService.create(globalTransPoint);
	}

	@RequestMapping( value="/globalTransPoint/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public GlobalTransPoint update(@PathVariable("id") Integer id, @RequestBody GlobalTransPoint globalTransPoint) {
		return globalTransPointService.update(globalTransPoint);
	}

	@RequestMapping( value="/globalTransPoint/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		globalTransPointService.delete(id);
	}
	
}
