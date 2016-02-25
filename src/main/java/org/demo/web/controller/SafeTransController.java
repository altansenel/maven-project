/*
 * Created on 24 �ub 2016 ( Time 15:56:50 )
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
import org.demo.bean.SafeTrans;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.SafeExpense;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.Safe;
import org.demo.bean.SafeTransSource;

//--- Services 
import org.demo.business.service.SafeTransService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.SafeExpenseService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.SafeService;
import org.demo.business.service.SafeTransSourceService;

//--- List Items 
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.SafeExpenseListItem;
import org.demo.web.listitem.GlobalTransPointListItem;
import org.demo.web.listitem.SafeListItem;
import org.demo.web.listitem.SafeTransSourceListItem;

/**
 * Spring MVC controller for 'SafeTrans' management.
 */
@Controller
@RequestMapping("/safeTrans")
public class SafeTransController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "safeTrans";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "safeTrans/form";
	private static final String JSP_LIST   = "safeTrans/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/safeTrans/create";
	private static final String SAVE_ACTION_UPDATE   = "/safeTrans/update";

	//--- Main entity service
	@Resource
    private SafeTransService safeTransService; // Injected by Spring
	//--- Other service(s)
	@Resource
    private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Resource
    private SafeExpenseService safeExpenseService; // Injected by Spring
	@Resource
    private GlobalTransPointService globalTransPointService; // Injected by Spring
	@Resource
    private SafeService safeService; // Injected by Spring
	@Resource
    private SafeTransSourceService safeTransSourceService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public SafeTransController() {
		super(SafeTransController.class, MAIN_ENTITY_NAME );
		log("SafeTransController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------
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
	 * Populates the combo-box "items" for the referenced entity "SafeExpense"
	 * @param model
	 */
	private void populateListOfSafeExpenseItems(Model model) {
		List<SafeExpense> list = safeExpenseService.findAll();
		List<SafeExpenseListItem> items = new LinkedList<SafeExpenseListItem>();
		for ( SafeExpense safeExpense : list ) {
			items.add(new SafeExpenseListItem( safeExpense ) );
		}
		model.addAttribute("listOfSafeExpenseItems", items ) ;
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
	 * Populates the combo-box "items" for the referenced entity "Safe"
	 * @param model
	 */
	private void populateListOfSafeItems(Model model) {
		List<Safe> list = safeService.findAll();
		List<SafeListItem> items = new LinkedList<SafeListItem>();
		for ( Safe safe : list ) {
			items.add(new SafeListItem( safe ) );
		}
		model.addAttribute("listOfSafeItems", items ) ;
	}

	/**
	 * Populates the combo-box "items" for the referenced entity "SafeTransSource"
	 * @param model
	 */
	private void populateListOfSafeTransSourceItems(Model model) {
		List<SafeTransSource> list = safeTransSourceService.findAll();
		List<SafeTransSourceListItem> items = new LinkedList<SafeTransSourceListItem>();
		for ( SafeTransSource safeTransSource : list ) {
			items.add(new SafeTransSourceListItem( safeTransSource ) );
		}
		model.addAttribute("listOfSafeTransSourceItems", items ) ;
	}


	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param safeTrans
	 */
	private void populateModel(Model model, SafeTrans safeTrans, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, safeTrans);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
			populateListOfGlobalPrivateCodeItems(model);
			populateListOfSafeExpenseItems(model);
			populateListOfGlobalTransPointItems(model);
			populateListOfSafeItems(model);
			populateListOfSafeTransSourceItems(model);
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
			populateListOfSafeTransSourceItems(model);
			populateListOfGlobalTransPointItems(model);
			populateListOfGlobalPrivateCodeItems(model);
			populateListOfSafeItems(model);
			populateListOfSafeExpenseItems(model);
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of SafeTrans found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<SafeTrans> list = safeTransService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new SafeTrans
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		SafeTrans safeTrans = new SafeTrans();	
		populateModel( model, safeTrans, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing SafeTrans
	 * @param model Spring MVC model
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{id}")
	public String formForUpdate(Model model, @PathVariable("id") Integer id ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		SafeTrans safeTrans = safeTransService.findById(id);
		populateModel( model, safeTrans, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param safeTrans  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid SafeTrans safeTrans, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				SafeTrans safeTransCreated = safeTransService.create(safeTrans); 
				model.addAttribute(MAIN_ENTITY_NAME, safeTransCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, safeTrans.getId() );
			} else {
				populateModel( model, safeTrans, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "safeTrans.error.create", e);
			populateModel( model, safeTrans, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param safeTrans  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid SafeTrans safeTrans, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				SafeTrans safeTransSaved = safeTransService.update(safeTrans);
				model.addAttribute(MAIN_ENTITY_NAME, safeTransSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, safeTrans.getId());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, safeTrans, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "safeTrans.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, safeTrans, FormMode.UPDATE);
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
			safeTransService.delete( id );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "safeTrans.error.delete", e);
		}
		return redirectToList();
	}

}
