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
import org.demo.bean.StockPriceList;
import org.demo.bean.StockExtraFields;
import org.demo.bean.StockCategory;

//--- Services 
import org.demo.business.service.StockPriceListService;
import org.demo.business.service.StockExtraFieldsService;
import org.demo.business.service.StockCategoryService;

//--- List Items 
import org.demo.web.listitem.StockExtraFieldsListItem;
import org.demo.web.listitem.StockCategoryListItem;

/**
 * Spring MVC controller for 'StockPriceList' management.
 */
@Controller
@RequestMapping("/stockPriceList")
public class StockPriceListController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "stockPriceList";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "stockPriceList/form";
	private static final String JSP_LIST   = "stockPriceList/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/stockPriceList/create";
	private static final String SAVE_ACTION_UPDATE   = "/stockPriceList/update";

	//--- Main entity service
	@Resource
    private StockPriceListService stockPriceListService; // Injected by Spring
	//--- Other service(s)
	@Resource
    private StockExtraFieldsService stockExtraFieldsService; // Injected by Spring
	@Resource
    private StockCategoryService stockCategoryService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public StockPriceListController() {
		super(StockPriceListController.class, MAIN_ENTITY_NAME );
		log("StockPriceListController created.");
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
	 * @param stockPriceList
	 */
	private void populateModel(Model model, StockPriceList stockPriceList, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, stockPriceList);
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
	 * Shows a list with all the occurrences of StockPriceList found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<StockPriceList> list = stockPriceListService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new StockPriceList
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		StockPriceList stockPriceList = new StockPriceList();	
		populateModel( model, stockPriceList, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing StockPriceList
	 * @param model Spring MVC model
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{id}")
	public String formForUpdate(Model model, @PathVariable("id") Integer id ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		StockPriceList stockPriceList = stockPriceListService.findById(id);
		populateModel( model, stockPriceList, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param stockPriceList  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid StockPriceList stockPriceList, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				StockPriceList stockPriceListCreated = stockPriceListService.create(stockPriceList); 
				model.addAttribute(MAIN_ENTITY_NAME, stockPriceListCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, stockPriceList.getId() );
			} else {
				populateModel( model, stockPriceList, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "stockPriceList.error.create", e);
			populateModel( model, stockPriceList, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param stockPriceList  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid StockPriceList stockPriceList, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				StockPriceList stockPriceListSaved = stockPriceListService.update(stockPriceList);
				model.addAttribute(MAIN_ENTITY_NAME, stockPriceListSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, stockPriceList.getId());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, stockPriceList, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "stockPriceList.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, stockPriceList, FormMode.UPDATE);
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
			stockPriceListService.delete( id );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "stockPriceList.error.delete", e);
		}
		return redirectToList();
	}

}