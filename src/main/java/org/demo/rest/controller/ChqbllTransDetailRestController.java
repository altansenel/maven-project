/*
 * Created on 24 �ub 2016 ( Time 15:56:48 )
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
import org.demo.bean.ChqbllTransDetail;
import org.demo.business.service.ChqbllTransDetailService;
import org.demo.web.listitem.ChqbllTransDetailListItem;

/**
 * Spring MVC controller for 'ChqbllTransDetail' management.
 */
@Controller
public class ChqbllTransDetailRestController {

	@Resource
	private ChqbllTransDetailService chqbllTransDetailService;
	
	@RequestMapping( value="/items/chqbllTransDetail",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ChqbllTransDetailListItem> findAllAsListItems() {
		List<ChqbllTransDetail> list = chqbllTransDetailService.findAll();
		List<ChqbllTransDetailListItem> items = new LinkedList<ChqbllTransDetailListItem>();
		for ( ChqbllTransDetail chqbllTransDetail : list ) {
			items.add(new ChqbllTransDetailListItem( chqbllTransDetail ) );
		}
		return items;
	}
	
	@RequestMapping( value="/chqbllTransDetail",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ChqbllTransDetail> findAll() {
		return chqbllTransDetailService.findAll();
	}

	@RequestMapping( value="/chqbllTransDetail/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ChqbllTransDetail findOne(@PathVariable("id") Integer id) {
		return chqbllTransDetailService.findById(id);
	}
	
	@RequestMapping( value="/chqbllTransDetail",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ChqbllTransDetail create(@RequestBody ChqbllTransDetail chqbllTransDetail) {
		return chqbllTransDetailService.create(chqbllTransDetail);
	}

	@RequestMapping( value="/chqbllTransDetail/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ChqbllTransDetail update(@PathVariable("id") Integer id, @RequestBody ChqbllTransDetail chqbllTransDetail) {
		return chqbllTransDetailService.update(chqbllTransDetail);
	}

	@RequestMapping( value="/chqbllTransDetail/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		chqbllTransDetailService.delete(id);
	}
	
}
