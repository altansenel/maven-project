/*
 * Created on 24 �ub 2016 ( Time 15:56:51 )
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
import org.demo.bean.StockPriceUpdate;
import org.demo.bean.StockExtraFields;
import org.demo.bean.StockCategory;

//--- Services 
import org.demo.business.service.StockPriceUpdateService;
import org.demo.business.service.StockExtraFieldsService;
import org.demo.business.service.StockCategoryService;

//--- List Items 
import org.demo.web.listitem.StockExtraFieldsListItem;
import org.demo.web.listitem.StockCategoryListItem;

/**
 * Spring MVC controller for 'StockPriceUpdate' management.
 */
@Controller
@RequestMapping("/stockPriceUpdate")
public class StockPriceUpdateController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "stockPriceUpdate";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "stockPriceUpdate/form";
	private static final String JSP_LIST   = "stockPriceUpdate/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/stockPriceUpdate/create";
	private static final String SAVE_ACTION_UPDATE   = "/stockPriceUpdate/update";

	//--- Main entity service
	@Resource
    private StockPriceUpdateService stockPriceUpdateService; // Injected by Spring
	//--- Other service(s)
	@Resource
    private StockExtraFieldsService stockExtraFieldsService; // Injected by Spring
	@Resource
    private StockCategoryService stockCategoryService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public StockPriceUpdateController() {
		super(StockPriceUpdateController.class, MAIN_ENTITY_NAME );
		log("StockPriceUpdateController created.");
	}

	//--------------------------------------------------------------------------------------
	// Spring MVC model management
	//--------------------------------------------------------------------------------------
	/**
	 * Populates the combo-box "items" for the referenced entity "StockExtraFields"
	 * @param model
	 */
	private void populateListOfStockExtraFieldsItems(Model model) {
		List<StockExtraFields> list = stockExtraFieldsService.findAll();
		List<StockExtraFieldsListItem> items = new LinkedList<StockExtraFieldsListItem>();
		for ( StockExtraFields stockExtraFields : list ) {
			items.add(new StockExtraFieldsListItem( stockExtraFields ) );
		}
		model.addAttribute("listOfStockExtraFieldsItems", items ) ;
	}

	/**
	 * Populates the combo-box "items" for the referenced entity "StockCategory"
	 * @param model
	 */
	private void populateListOfStockCategoryItems(Model model) {
		List<StockCategory> list = stockCategoryService.findAll();
		List<StockCategoryListItem> items = new LinkedList<StockCategoryListItem>();
		for ( StockCategory stockCategory : list ) {
			items.add(new StockCategoryListItem( stockCategory ) );
		}
		model.addAttribute("listOfStockCategoryItems", items ) ;
	}


	/**
	 * Populates the Spring MVC model with the given entity and eventually other useful data
	 * @param model
	 * @param stockPriceUpdate
	 */
	private void populateModel(Model model, StockPriceUpdate stockPriceUpdate, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, stockPriceUpdate);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
			populateListOfStockExtraFieldsItems(model);
			populateListOfStockCategoryItems(model);
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
			populateListOfStockCategoryItems(model);
			populateListOfStockExtraFieldsItems(model);
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of StockPriceUpdate found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<StockPriceUpdate> list = stockPriceUpdateService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new StockPriceUpdate
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		StockPriceUpdate stockPriceUpdate = new StockPriceUpdate();	
		populateModel( model, stockPriceUpdate, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing StockPriceUpdate
	 * @param model Spring MVC model
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{id}")
	public String formForUpdate(Model model, @PathVariable("id") Integer id ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateService.findById(id);
		populateModel( model, stockPriceUpdate, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param stockPriceUpdate  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid StockPriceUpdate stockPriceUpdate, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				StockPriceUpdate stockPriceUpdateCreated = stockPriceUpdateService.create(stockPriceUpdate); 
				model.addAttribute(MAIN_ENTITY_NAME, stockPriceUpdateCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, stockPriceUpdate.getId() );
			} else {
				populateModel( model, stockPriceUpdate, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "stockPriceUpdate.error.create", e);
			populateModel( model, stockPriceUpdate, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param stockPriceUpdate  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid StockPriceUpdate stockPriceUpdate, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				StockPriceUpdate stockPriceUpdateSaved = stockPriceUpdateService.update(stockPriceUpdate);
				model.addAttribute(MAIN_ENTITY_NAME, stockPriceUpdateSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, stockPriceUpdate.getId());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, stockPriceUpdate, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "stockPriceUpdate.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, stockPriceUpdate, FormMode.UPDATE);
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
			stockPriceUpdateService.delete( id );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "stockPriceUpdate.error.delete", e);
		}
		return redirectToList();
	}

}