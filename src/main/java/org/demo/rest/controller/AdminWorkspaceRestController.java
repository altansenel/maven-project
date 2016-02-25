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
import org.demo.bean.AdminWorkspace;
import org.demo.business.service.AdminWorkspaceService;
import org.demo.web.listitem.AdminWorkspaceListItem;

/**
 * Spring MVC controller for 'AdminWorkspace' management.
 */
@Controller
public class AdminWorkspaceRestController {

	@Resource
	private AdminWorkspaceService adminWorkspaceService;
	
	@RequestMapping( value="/items/adminWorkspace",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AdminWorkspaceListItem> findAllAsListItems() {
		List<AdminWorkspace> list = adminWorkspaceService.findAll();
		List<AdminWorkspaceListItem> items = new LinkedList<AdminWorkspaceListItem>();
		for ( AdminWorkspace adminWorkspace : list ) {
			items.add(new AdminWorkspaceListItem( adminWorkspace ) );
		}
		return items;
	}
	
	@RequestMapping( value="/adminWorkspace",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AdminWorkspace> findAll() {
		return adminWorkspaceService.findAll();
	}

	@RequestMapping( value="/adminWorkspace/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AdminWorkspace findOne(@PathVariable("id") Integer id) {
		return adminWorkspaceService.findById(id);
	}
	
	@RequestMapping( value="/adminWorkspace",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AdminWorkspace create(@RequestBody AdminWorkspace adminWorkspace) {
		return adminWorkspaceService.create(adminWorkspace);
	}

	@RequestMapping( value="/adminWorkspace/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AdminWorkspace update(@PathVariable("id") Integer id, @RequestBody AdminWorkspace adminWorkspace) {
		return adminWorkspaceService.update(adminWorkspace);
	}

	@RequestMapping( value="/adminWorkspace/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Integer id) {
		adminWorkspaceService.delete(id);
	}
	
}
