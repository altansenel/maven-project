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
import org.demo.bean.StockTrans;
import org.demo.business.service.StockTransService;
import org.demo.web.listitem.StockTransListItem;

/**
 * Spring MVC controller for 'StockTrans' management.
 */
@Controller
public class StockTransRestController {

	@Resource
	private StockTransService stockTransService;
	
	@RequestMapping( value="/items/stockTrans",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockTransListItem> findAllAsListItems() {
		List<StockTrans> list = stockTransService.findAll();
		List<StockTransListItem> items = new LinkedList<StockTransListItem>();
		for ( StockTrans stockTrans : list ) {
			items.add(new StockTransListItem( stockTrans ) );
		}
		return items;
	}
	
	@RequestMapping( value="/stockTrans",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockTrans> findAll() {
		return stockTransService.findAll();
	}

	@RequestMapping( value="/stockTrans/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockTrans findOne(@PathVariable("id") Integer id) {
		return stockTransService.findById(id);
	}
	
	@RequestMapping( value="/stockTrans",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockTrans create(@RequestBody StockTrans stockTrans) {
		return stockTransService.create(stockTrans);
	}

	@RequestMapping( value="/stockTrans/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockTrans update(@PathVariable("id") Integer id, @RequestBody StockTrans stockTrans) {
		return stockTransService.update(stockTrans);
	}

	@RequestMapping( value="/stockTrans/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		stockTransService.delete(id);
	}
	
}
