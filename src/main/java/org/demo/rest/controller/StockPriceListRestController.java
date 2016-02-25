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
import org.demo.bean.StockPriceList;
import org.demo.business.service.StockPriceListService;
import org.demo.web.listitem.StockPriceListListItem;

/**
 * Spring MVC controller for 'StockPriceList' management.
 */
@Controller
public class StockPriceListRestController {

	@Resource
	private StockPriceListService stockPriceListService;
	
	@RequestMapping( value="/items/stockPriceList",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockPriceListListItem> findAllAsListItems() {
		List<StockPriceList> list = stockPriceListService.findAll();
		List<StockPriceListListItem> items = new LinkedList<StockPriceListListItem>();
		for ( StockPriceList stockPriceList : list ) {
			items.add(new StockPriceListListItem( stockPriceList ) );
		}
		return items;
	}
	
	@RequestMapping( value="/stockPriceList",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockPriceList> findAll() {
		return stockPriceListService.findAll();
	}

	@RequestMapping( value="/stockPriceList/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockPriceList findOne(@PathVariable("id") Integer id) {
		return stockPriceListService.findById(id);
	}
	
	@RequestMapping( value="/stockPriceList",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockPriceList create(@RequestBody StockPriceList stockPriceList) {
		return stockPriceListService.create(stockPriceList);
	}

	@RequestMapping( value="/stockPriceList/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockPriceList update(@PathVariable("id") Integer id, @RequestBody StockPriceList stockPriceList) {
		return stockPriceListService.update(stockPriceList);
	}

	@RequestMapping( value="/stockPriceList/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		stockPriceListService.delete(id);
	}
	
}
