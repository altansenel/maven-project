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
import org.demo.bean.StockCosting;
import org.demo.business.service.StockCostingService;
import org.demo.web.listitem.StockCostingListItem;

/**
 * Spring MVC controller for 'StockCosting' management.
 */
@Controller
public class StockCostingRestController {

	@Resource
	private StockCostingService stockCostingService;
	
	@RequestMapping( value="/items/stockCosting",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockCostingListItem> findAllAsListItems() {
		List<StockCosting> list = stockCostingService.findAll();
		List<StockCostingListItem> items = new LinkedList<StockCostingListItem>();
		for ( StockCosting stockCosting : list ) {
			items.add(new StockCostingListItem( stockCosting ) );
		}
		return items;
	}
	
	@RequestMapping( value="/stockCosting",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockCosting> findAll() {
		return stockCostingService.findAll();
	}

	@RequestMapping( value="/stockCosting/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockCosting findOne(@PathVariable("id") Integer id) {
		return stockCostingService.findById(id);
	}
	
	@RequestMapping( value="/stockCosting",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockCosting create(@RequestBody StockCosting stockCosting) {
		return stockCostingService.create(stockCosting);
	}

	@RequestMapping( value="/stockCosting/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockCosting update(@PathVariable("id") Integer id, @RequestBody StockCosting stockCosting) {
		return stockCostingService.update(stockCosting);
	}

	@RequestMapping( value="/stockCosting/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		stockCostingService.delete(id);
	}
	
}
