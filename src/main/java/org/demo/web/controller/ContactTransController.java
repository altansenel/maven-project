/*
 * Created on 24 �ub 2016 ( Time 15:56:48 )
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
import org.demo.bean.ContactTrans;
import org.demo.bean.ContactTransSource;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.Contact;
import org.demo.bean.GlobalTransPoint;

//--- Services 
import org.demo.business.service.ContactTransService;
import org.demo.business.service.ContactTransSourceService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.ContactService;
import org.demo.business.service.GlobalTransPointService;

//--- List Items 
import org.demo.web.listitem.ContactTransSourceListItem;
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.ContactListItem;
import org.demo.web.listitem.GlobalTransPointListItem;

/**
 * Spring MVC controller for 'ContactTrans' management.
 */
@Controller
@RequestMapping("/contactTrans")
public class ContactTransController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "contactTrans";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "contactTrans/form";
	private static final String JSP_LIST   = "contactTrans/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/contactTrans/create";
	private static final String SAVE_ACTION_UPDATE   = "/contactTrans/update";

	//--- Main entity service
	@Resource
    private ContactTransService contactTransService; // Injected by Spring
	//--- Other service(s)
	@Resource
    private ContactTransSourceService contactTransSourceService; // Injected by Spring
	@Resource
    private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Resource
    private ContactService contactService; // Injected by Spring
	@Resource
    private GlobalTransPointService globalTransPointService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public ContactTransController() {
		super(ContactTransController.class, MAIN_ENTITY_NAME );
		log("ContactTransController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------
	/**
	 * Populates the combo-box "items" for the referenced entity "ContactTransSource"
	 * @param model
	 */
	private void populateListOfContactTransSourceItems(Model model) {
		List<ContactTransSource> list = contactTransSourceService.findAll();
		List<ContactTransSourceListItem> items = new LinkedList<ContactTransSourceListItem>();
		for ( ContactTransSource contactTransSource : list ) {
			items.add(new ContactTransSourceListItem( contactTransSource ) );
		}
		model.addAttribute("listOfContactTransSourceItems", items ) ;
	}

	/**
	 * Populates the combo-box "items" for the referenced entity "GlobalPrivateCode"
	 * @param model
	 */
	private void populateListOfGlobalPrivateCodeItems(Model model) {
		List<GlobalPrivateCode> list = globalPrivateCodeService.findAll();
		List<GlobalPrivateCodeListItem> items = new LinkedList<GlobalPrivateCodeListItem>();
		for ( GlobalPrivateCode globalPrivateCode : list ) {
			items.add(new GlobalPrivateCodeListItem( globalPrivateCode ) );
		}
		model.addAttribute("listOfGlobalPrivateCodeItems", items ) ;
	}

	/**
	 * Populates the combo-box "items" for the referenced entity "Contact"
	 * @param model
	 */
	private void populateListOfContactItems(Model model) {
		List<Contact> list = contactService.findAll();
		List<ContactListItem> items = new LinkedList<ContactListItem>();
		for ( Contact contact : list ) {
			items.add(new ContactListItem( contact ) );
		}
		model.addAttribute("listOfContactItems", items ) ;
	}

	/**
	 * Populates the combo-box "items" for the referenced entity "GlobalTransPoint"
	 * @param model
	 */
	private void populateListOfGlobalTransPointItems(Model model) {
		List<GlobalTransPoint> list = globalTransPointService.findAll();
		List<GlobalTransPointListItem> items = new LinkedList<GlobalTransPointListItem>();
		for ( GlobalTransPoint globalTransPoint : list ) {
			items.add(new GlobalTransPointListItem( globalTransPoint ) );
		}
		model.addAttribute("listOfGlobalTransPointItems", items ) ;
	}


	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param contactTrans
	 */
	private void populateModel(Model model, ContactTrans contactTrans, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, contactTrans);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
			populateListOfContactTransSourceItems(model);
			populateListOfGlobalPrivateCodeItems(model);
			populateListOfContactItems(model);
			populateListOfGlobalTransPointItems(model);
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
			populateListOfContactTransSourceItems(model);
			populateListOfGlobalTransPointItems(model);
			populateListOfGlobalPrivateCodeItems(model);
			populateListOfContactItems(model);
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of ContactTrans found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<ContactTrans> list = contactTransService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new ContactTrans
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		ContactTrans contactTrans = new ContactTrans();	
		populateModel( model, contactTrans, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing ContactTrans
	 * @param model Spring MVC model
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{id}")
	public String formForUpdate(Model model, @PathVariable("id") Integer id ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		ContactTrans contactTrans = contactTransService.findById(id);
		populateModel( model, contactTrans, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param contactTrans  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid ContactTrans contactTrans, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				ContactTrans contactTransCreated = contactTransService.create(contactTrans); 
				model.addAttribute(MAIN_ENTITY_NAME, contactTransCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, contactTrans.getId() );
			} else {
				populateModel( model, contactTrans, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "contactTrans.error.create", e);
			populateModel( model, contactTrans, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param contactTrans  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid ContactTrans contactTrans, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				ContactTrans contactTransSaved = contactTransService.update(contactTrans);
				model.addAttribute(MAIN_ENTITY_NAME, contactTransSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, contactTrans.getId());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, contactTrans, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "contactTrans.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, contactTrans, FormMode.UPDATE);
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
			contactTransService.delete( id );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "contactTrans.error.delete", e);
		}
		return redirectToList();
	}

}
