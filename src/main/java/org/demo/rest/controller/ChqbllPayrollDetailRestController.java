/*
 * Created on 24 �ub 2016 ( Time 15:56:47 )
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
import org.demo.bean.ChqbllPayrollDetail;
import org.demo.business.service.ChqbllPayrollDetailService;
import org.demo.web.listitem.ChqbllPayrollDetailListItem;

/**
 * Spring MVC controller for 'ChqbllPayrollDetail' management.
 */
@Controller
public class ChqbllPayrollDetailRestController {

	@Resource
	private ChqbllPayrollDetailService chqbllPayrollDetailService;
	
	@RequestMapping( value="/items/chqbllPayrollDetail",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ChqbllPayrollDetailListItem> findAllAsListItems() {
		List<ChqbllPayrollDetail> list = chqbllPayrollDetailService.findAll();
		List<ChqbllPayrollDetailListItem> items = new LinkedList<ChqbllPayrollDetailListItem>();
		for ( ChqbllPayrollDetail chqbllPayrollDetail : list ) {
			items.add(new ChqbllPayrollDetailListItem( chqbllPayrollDetail ) );
		}
		return items;
	}
	
	@RequestMapping( value="/chqbllPayrollDetail",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ChqbllPayrollDetail> findAll() {
		return chqbllPayrollDetailService.findAll();
	}

	@RequestMapping( value="/chqbllPayrollDetail/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ChqbllPayrollDetail findOne(@PathVariable("id") Integer id) {
		return chqbllPayrollDetailService.findById(id);
	}
	
	@RequestMapping( value="/chqbllPayrollDetail",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ChqbllPayrollDetail create(@RequestBody ChqbllPayrollDetail chqbllPayrollDetail) {
		return chqbllPayrollDetailService.create(chqbllPayrollDetail);
	}

	@RequestMapping( value="/chqbllPayrollDetail/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ChqbllPayrollDetail update(@PathVariable("id") Integer id, @RequestBody ChqbllPayrollDetail chqbllPayrollDetail) {
		return chqbllPayrollDetailService.update(chqbllPayrollDetail);
	}

	@RequestMapping( value="/chqbllPayrollDetail/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		chqbllPayrollDetailService.delete(id);
	}
	
}