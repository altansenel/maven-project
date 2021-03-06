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
import org.demo.bean.StockPriceUpdateDetail;
import org.demo.business.service.StockPriceUpdateDetailService;
import org.demo.web.listitem.StockPriceUpdateDetailListItem;

/**
 * Spring MVC controller for 'StockPriceUpdateDetail' management.
 */
@Controller
public class StockPriceUpdateDetailRestController {

	@Resource
	private StockPriceUpdateDetailService stockPriceUpdateDetailService;
	
	@RequestMapping( value="/items/stockPriceUpdateDetail",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockPriceUpdateDetailListItem> findAllAsListItems() {
		List<StockPriceUpdateDetail> list = stockPriceUpdateDetailService.findAll();
		List<StockPriceUpdateDetailListItem> items = new LinkedList<StockPriceUpdateDetailListItem>();
		for ( StockPriceUpdateDetail stockPriceUpdateDetail : list ) {
			items.add(new StockPriceUpdateDetailListItem( stockPriceUpdateDetail ) );
		}
		return items;
	}
	
	@RequestMapping( value="/stockPriceUpdateDetail",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<StockPriceUpdateDetail> findAll() {
		return stockPriceUpdateDetailService.findAll();
	}

	@RequestMapping( value="/stockPriceUpdateDetail/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockPriceUpdateDetail findOne(@PathVariable("id") Integer id) {
		return stockPriceUpdateDetailService.findById(id);
	}
	
	@RequestMapping( value="/stockPriceUpdateDetail",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockPriceUpdateDetail create(@RequestBody StockPriceUpdateDetail stockPriceUpdateDetail) {
		return stockPriceUpdateDetailService.create(stockPriceUpdateDetail);
	}

	@RequestMapping( value="/stockPriceUpdateDetail/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StockPriceUpdateDetail update(@PathVariable("id") Integer id, @RequestBody StockPriceUpdateDetail stockPriceUpdateDetail) {
		return stockPriceUpdateDetailService.update(stockPriceUpdateDetail);
	}

	@RequestMapping( value="/stockPriceUpdateDetail/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		stockPriceUpdateDetailService.delete(id);
	}
	
}
