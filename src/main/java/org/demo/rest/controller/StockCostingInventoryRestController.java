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
import org.demo.bean.StockCostingInventory;
import org.demo.business.service.StockCostingInventoryService;
import org.demo.web.listitem.StockCostingInventoryListItem;

/**
 * Spring MVC controller for 'StockCostingInventory' management.
 */
@Controller
public class StockCostingInventoryRestController {

	@Resource
	private StockCostingInventoryService stockCostingInventoryService;
	
	@RequestMapping( value="/items/stockCostingInventory",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockCostingInventoryListItem> findAllAsListItems() {
		List<StockCostingInventory> list = stockCostingInventoryService.findAll();
		List<StockCostingInventoryListItem> items = new LinkedList<StockCostingInventoryListItem>();
		for ( StockCostingInventory stockCostingInventory : list ) {
			items.add(new StockCostingInventoryListItem( stockCostingInventory ) );
		}
		return items;
	}
	
	@RequestMapping( value="/stockCostingInventory",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockCostingInventory> findAll() {
		return stockCostingInventoryService.findAll();
	}

	@RequestMapping( value="/stockCostingInventory/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockCostingInventory findOne(@PathVariable("id") Integer id) {
		return stockCostingInventoryService.findById(id);
	}
	
	@RequestMapping( value="/stockCostingInventory",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockCostingInventory create(@RequestBody StockCostingInventory stockCostingInventory) {
		return stockCostingInventoryService.create(stockCostingInventory);
	}

	@RequestMapping( value="/stockCostingInventory/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockCostingInventory update(@PathVariable("id") Integer id, @RequestBody StockCostingInventory stockCostingInventory) {
		return stockCostingInventoryService.update(stockCostingInventory);
	}

	@RequestMapping( value="/stockCostingInventory/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		stockCostingInventoryService.delete(id);
	}
	
}
