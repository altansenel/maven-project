/*
 * Created on 24 �ub 2016 ( Time 15:56:47 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//--- Common classes
import org.demo.web.common.AbstractController;
import org.demo.web.common.FormMode;
import org.demo.web.common.Message;
import org.demo.web.common.MessageType;

//--- Entities
import org.demo.bean.AdminUserRight;
import org.demo.bean.AdminUserRole;

//--- Services 
import org.demo.business.service.AdminUserRightService;
import org.demo.business.service.AdminUserRoleService;

//--- List Items 
import org.demo.web.listitem.AdminUserRoleListItem;

/**
 * Spring MVC controller for 'AdminUserRight' management.
 */
@Controller
@RequestMapping("/adminUserRight")
public class AdminUserRightController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "adminUserRight";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "adminUserRight/form";
	private static final String JSP_LIST   = "adminUserRight/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/adminUserRight/create";
	private static final String SAVE_ACTION_UPDATE   = "/adminUserRight/update";

	//--- Main entity service
	@Resource
    private AdminUserRightService adminUserRightService; // Injected by Spring
	//--- Other service(s)
	@Resource
    private AdminUserRoleService adminUserRoleService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public AdminUserRightController() {
		super(AdminUserRightController.class, MAIN_ENTITY_NAME );
		log("AdminUserRightController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------
	/**
	 * Populates the combo-box "items" for the referenced entity "AdminUserRole"
	 * @param model
	 */
	private void populateListOfAdminUserRoleItems(Model model) {
		List<AdminUserRole> list = adminUserRoleService.findAll();
		List<AdminUserRoleListItem> items = new LinkedList<AdminUserRoleListItem>();
		for ( AdminUserRole adminUserRole : list ) {
			items.add(new AdminUserRoleListItem( adminUserRole ) );
		}
		model.addAttribute("listOfAdminUserRoleItems", items ) ;
	}


	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param adminUserRight
	 */
	private void populateModel(Model model, AdminUserRight adminUserRight, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, adminUserRight);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
			populateListOfAdminUserRoleItems(model);
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
			populateListOfAdminUserRoleItems(model);
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of AdminUserRight found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<AdminUserRight> list = adminUserRightService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new AdminUserRight
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		AdminUserRight adminUserRight = new AdminUserRight();	
		populateModel( model, adminUserRight, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing AdminUserRight
	 * @param model Spring MVC model
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{id}")
	public String formForUpdate(Model model, @PathVariable("id") Integer id ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		AdminUserRight adminUserRight = adminUserRightService.findById(id);
		populateModel( model, adminUserRight, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param adminUserRight  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid AdminUserRight adminUserRight, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				AdminUserRight adminUserRightCreated = adminUserRightService.create(adminUserRight); 
				model.addAttribute(MAIN_ENTITY_NAME, adminUserRightCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, adminUserRight.getId() );
			} else {
				populateModel( model, adminUserRight, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "adminUserRight.error.create", e);
			populateModel( model, adminUserRight, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param adminUserRight  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid AdminUserRight adminUserRight, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				AdminUserRight adminUserRightSaved = adminUserRightService.update(adminUserRight);
				model.addAttribute(MAIN_ENTITY_NAME, adminUserRightSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, adminUserRight.getId());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, adminUserRight, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "adminUserRight.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, adminUserRight, FormMode.UPDATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'DELETE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param redirectAttributes
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}") // GET or POST
	public String delete(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id) {
		log("Action 'delete'" );
		try {
			adminUserRightService.delete( id );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "adminUserRight.error.delete", e);
		}
		return redirectToList();
	}

}
