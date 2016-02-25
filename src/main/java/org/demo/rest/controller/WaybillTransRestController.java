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
import org.demo.bean.WaybillTrans;
import org.demo.business.service.WaybillTransService;
import org.demo.web.listitem.WaybillTransListItem;

/**
 * Spring MVC controller for 'WaybillTrans' management.
 */
@Controller
public class WaybillTransRestController {

	@Resource
	private WaybillTransService waybillTransService;
	
	@RequestMapping( value="/items/waybillTrans",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<WaybillTransListItem> findAllAsListItems() {
		List<WaybillTrans> list = waybillTransService.findAll();
		List<WaybillTransListItem> items = new LinkedList<WaybillTransListItem>();
		for ( WaybillTrans waybillTrans : list ) {
			items.add(new WaybillTransListItem( waybillTrans ) );
		}
		return items;
	}
	
	@RequestMapping( value="/waybillTrans",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<WaybillTrans> findAll() {
		return waybillTransService.findAll();
	}

	@RequestMapping( value="/waybillTrans/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public WaybillTrans findOne(@PathVariable("id") Integer id) {
		return waybillTransService.findById(id);
	}
	
	@RequestMapping( value="/waybillTrans",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public WaybillTrans create(@RequestBody WaybillTrans waybillTrans) {
		return waybillTransService.create(waybillTrans);
	}

	@RequestMapping( value="/waybillTrans/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public WaybillTrans update(@PathVariable("id") Integer id, @RequestBody WaybillTrans waybillTrans) {
		return waybillTransService.update(waybillTrans);
	}

	@RequestMapping( value="/waybillTrans/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		waybillTransService.delete(id);
	}
	
}
