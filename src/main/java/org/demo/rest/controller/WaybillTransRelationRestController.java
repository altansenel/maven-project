/*
 * Created on 24 �ub 2016 ( Time 15:56:52 )
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
import org.demo.bean.WaybillTransRelation;
import org.demo.business.service.WaybillTransRelationService;
import org.demo.web.listitem.WaybillTransRelationListItem;

/**
 * Spring MVC controller for 'WaybillTransRelation' management.
 */
@Controller
public class WaybillTransRelationRestController {

	@Resource
	private WaybillTransRelationService waybillTransRelationService;
	
	@RequestMapping( value="/items/waybillTransRelation",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<WaybillTransRelationListItem> findAllAsListItems() {
		List<WaybillTransRelation> list = waybillTransRelationService.findAll();
		List<WaybillTransRelationListItem> items = new LinkedList<WaybillTransRelationListItem>();
		for ( WaybillTransRelation waybillTransRelation : list ) {
			items.add(new WaybillTransRelationListItem( waybillTransRelation ) );
		}
		return items;
	}
	
	@RequestMapping( value="/waybillTransRelation",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<WaybillTransRelation> findAll() {
		return waybillTransRelationService.findAll();
	}

	@RequestMapping( value="/waybillTransRelation/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public WaybillTransRelation findOne(@PathVariable("id") Integer id) {
		return waybillTransRelationService.findById(id);
	}
	
	@RequestMapping( value="/waybillTransRelation",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public WaybillTransRelation create(@RequestBody WaybillTransRelation waybillTransRelation) {
		return waybillTransRelationService.create(waybillTransRelation);
	}

	@RequestMapping( value="/waybillTransRelation/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public WaybillTransRelation update(@PathVariable("id") Integer id, @RequestBody WaybillTransRelation waybillTransRelation) {
		return waybillTransRelationService.update(waybillTransRelation);
	}

	@RequestMapping( value="/waybillTransRelation/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		waybillTransRelationService.delete(id);
	}
	
}
