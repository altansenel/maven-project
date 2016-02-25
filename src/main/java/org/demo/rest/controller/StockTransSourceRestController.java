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
import org.demo.bean.StockTransSource;
import org.demo.business.service.StockTransSourceService;
import org.demo.web.listitem.StockTransSourceListItem;

/**
 * Spring MVC controller for 'StockTransSource' management.
 */
@Controller
public class StockTransSourceRestController {

	@Resource
	private StockTransSourceService stockTransSourceService;
	
	@RequestMapping( value="/items/stockTransSource",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockTransSourceListItem> findAllAsListItems() {
		List<StockTransSource> list = stockTransSourceService.findAll();
		List<StockTransSourceListItem> items = new LinkedList<StockTransSourceListItem>();
		for ( StockTransSource stockTransSource : list ) {
			items.add(new StockTransSourceListItem( stockTransSource ) );
		}
		return items;
	}
	
	@RequestMapping( value="/stockTransSource",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockTransSource> findAll() {
		return stockTransSourceService.findAll();
	}

	@RequestMapping( value="/stockTransSource/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockTransSource findOne(@PathVariable("id") Integer id) {
		return stockTransSourceService.findById(id);
	}
	
	@RequestMapping( value="/stockTransSource",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockTransSource create(@RequestBody StockTransSource stockTransSource) {
		return stockTransSourceService.create(stockTransSource);
	}

	@RequestMapping( value="/stockTransSource/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockTransSource update(@PathVariable("id") Integer id, @RequestBody StockTransSource stockTransSource) {
		return stockTransSourceService.update(stockTransSource);
	}

	@RequestMapping( value="/stockTransSource/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		stockTransSourceService.delete(id);
	}
	
}
