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
import org.demo.bean.ChqbllDetailPartial;
import org.demo.bean.Safe;
import org.demo.bean.SafeTrans;
import org.demo.bean.ChqbllPayrollDetail;

//--- Services 
import org.demo.business.service.ChqbllDetailPartialService;
import org.demo.business.service.SafeService;
import org.demo.business.service.SafeTransService;
import org.demo.business.service.ChqbllPayrollDetailService;

//--- List Items 
import org.demo.web.listitem.SafeListItem;
import org.demo.web.listitem.SafeTransListItem;
import org.demo.web.listitem.ChqbllPayrollDetailListItem;

/**
 * Spring MVC controller for 'ChqbllDetailPartial' management.
 */
@Controller
@RequestMapping("/chqbllDetailPartial")
public class ChqbllDetailPartialController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "chqbllDetailPartial";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "chqbllDetailPartial/form";
	private static final String JSP_LIST   = "chqbllDetailPartial/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/chqbllDetailPartial/create";
	private static final String SAVE_ACTION_UPDATE   = "/chqbllDetailPartial/update";

	//--- Main entity service
	@Resource
    private ChqbllDetailPartialService chqbllDetailPartialService; // Injected by Spring
	//--- Other service(s)
	@Resource
    private SafeService safeService; // Injected by Spring
	@Resource
    private SafeTransService safeTransService; // Injected by Spring
	@Resource
    private ChqbllPayrollDetailService chqbllPayrollDetailService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public ChqbllDetailPartialController() {
		super(ChqbllDetailPartialController.class, MAIN_ENTITY_NAME );
		log("ChqbllDetailPartialController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------
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
	 * Populates the combo-box "items" for the referenced entity "SafeTrans"
	 * @param model
	 */
	private void populateListOfSafeTransItems(Model model) {
		List<SafeTrans> list = safeTransService.findAll();
		List<SafeTransListItem> items = new LinkedList<SafeTransListItem>();
		for ( SafeTrans safeTrans : list ) {
			items.add(new SafeTransListItem( safeTrans ) );
		}
		model.addAttribute("listOfSafeTransItems", items ) ;
	}

	/**
	 * Populates the combo-box "items" for the referenced entity "ChqbllPayrollDetail"
	 * @param model
	 */
	private void populateListOfChqbllPayrollDetailItems(Model model) {
		List<ChqbllPayrollDetail> list = chqbllPayrollDetailService.findAll();
		List<ChqbllPayrollDetailListItem> items = new LinkedList<ChqbllPayrollDetailListItem>();
		for ( ChqbllPayrollDetail chqbllPayrollDetail : list ) {
			items.add(new ChqbllPayrollDetailListItem( chqbllPayrollDetail ) );
		}
		model.addAttribute("listOfChqbllPayrollDetailItems", items ) ;
	}


	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param chqbllDetailPartial
	 */
	private void populateModel(Model model, ChqbllDetailPartial chqbllDetailPartial, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, chqbllDetailPartial);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
			populateListOfSafeItems(model);
			populateListOfSafeTransItems(model);
			populateListOfChqbllPayrollDetailItems(model);
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
			populateListOfChqbllPayrollDetailItems(model);
			populateListOfSafeItems(model);
			populateListOfSafeTransItems(model);
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of ChqbllDetailPartial found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<ChqbllDetailPartial> list = chqbllDetailPartialService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new ChqbllDetailPartial
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		ChqbllDetailPartial chqbllDetailPartial = new ChqbllDetailPartial();	
		populateModel( model, chqbllDetailPartial, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing ChqbllDetailPartial
	 * @param model Spring MVC model
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{id}")
	public String formForUpdate(Model model, @PathVariable("id") Integer id ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialService.findById(id);
		populateModel( model, chqbllDetailPartial, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param chqbllDetailPartial  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid ChqbllDetailPartial chqbllDetailPartial, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				ChqbllDetailPartial chqbllDetailPartialCreated = chqbllDetailPartialService.create(chqbllDetailPartial); 
				model.addAttribute(MAIN_ENTITY_NAME, chqbllDetailPartialCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, chqbllDetailPartial.getId() );
			} else {
				populateModel( model, chqbllDetailPartial, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "chqbllDetailPartial.error.create", e);
			populateModel( model, chqbllDetailPartial, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param chqbllDetailPartial  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid ChqbllDetailPartial chqbllDetailPartial, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				ChqbllDetailPartial chqbllDetailPartialSaved = chqbllDetailPartialService.update(chqbllDetailPartial);
				model.addAttribute(MAIN_ENTITY_NAME, chqbllDetailPartialSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, chqbllDetailPartial.getId());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, chqbllDetailPartial, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "chqbllDetailPartial.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, chqbllDetailPartial, FormMode.UPDATE);
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
			chqbllDetailPartialService.delete( id );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "chqbllDetailPartial.error.delete", e);
		}
		return redirectToList();
	}

}
