/*
 * Created on 24 �ub 2016 ( Time 15:56:51 )
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
import org.demo.bean.StockUnit;
import org.demo.business.service.StockUnitService;
import org.demo.web.listitem.StockUnitListItem;

/**
 * Spring MVC controller for 'StockUnit' management.
 */
@Controller
public class StockUnitRestController {

	@Resource
	private StockUnitService stockUnitService;
	
	@RequestMapping( value="/items/stockUnit",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockUnitListItem> findAllAsListItems() {
		List<StockUnit> list = stockUnitService.findAll();
		List<StockUnitListItem> items = new LinkedList<StockUnitListItem>();
		for ( StockUnit stockUnit : list ) {
			items.add(new StockUnitListItem( stockUnit ) );
		}
		return items;
	}
	
	@RequestMapping( value="/stockUnit",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockUnit> findAll() {
		return stockUnitService.findAll();
	}

	@RequestMapping( value="/stockUnit/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockUnit findOne(@PathVariable("id") Integer id) {
		return stockUnitService.findById(id);
	}
	
	@RequestMapping( value="/stockUnit",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockUnit create(@RequestBody StockUnit stockUnit) {
		return stockUnitService.create(stockUnit);
	}

	@RequestMapping( value="/stockUnit/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockUnit update(@PathVariable("id") Integer id, @RequestBody StockUnit stockUnit) {
		return stockUnitService.update(stockUnit);
	}

	@RequestMapping( value="/stockUnit/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		stockUnitService.delete(id);
	}
	
}
