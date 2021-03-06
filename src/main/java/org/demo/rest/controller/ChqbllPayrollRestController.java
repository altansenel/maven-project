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
import org.demo.bean.ChqbllPayroll;
import org.demo.business.service.ChqbllPayrollService;
import org.demo.web.listitem.ChqbllPayrollListItem;

/**
 * Spring MVC controller for 'ChqbllPayroll' management.
 */
@Controller
public class ChqbllPayrollRestController {

	@Resource
	private ChqbllPayrollService chqbllPayrollService;
	
	@RequestMapping( value="/items/chqbllPayroll",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ChqbllPayrollListItem> findAllAsListItems() {
		List<ChqbllPayroll> list = chqbllPayrollService.findAll();
		List<ChqbllPayrollListItem> items = new LinkedList<ChqbllPayrollListItem>();
		for ( ChqbllPayroll chqbllPayroll : list ) {
			items.add(new ChqbllPayrollListItem( chqbllPayroll ) );
		}
		return items;
	}
	
	@RequestMapping( value="/chqbllPayroll",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ChqbllPayroll> findAll() {
		return chqbllPayrollService.findAll();
	}

	@RequestMapping( value="/chqbllPayroll/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ChqbllPayroll findOne(@PathVariable("id") Integer id) {
		return chqbllPayrollService.findById(id);
	}
	
	@RequestMapping( value="/chqbllPayroll",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ChqbllPayroll create(@RequestBody ChqbllPayroll chqbllPayroll) {
		return chqbllPayrollService.create(chqbllPayroll);
	}

	@RequestMapping( value="/chqbllPayroll/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ChqbllPayroll update(@PathVariable("id") Integer id, @RequestBody ChqbllPayroll chqbllPayroll) {
		return chqbllPayrollService.update(chqbllPayroll);
	}

	@RequestMapping( value="/chqbllPayroll/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		chqbllPayrollService.delete(id);
	}
	
}
