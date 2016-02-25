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
import org.demo.bean.StockCosting;
import org.demo.bean.StockExtraFields;
import org.demo.bean.StockCategory;
import org.demo.bean.Stock;
import org.demo.bean.StockDepot;
import org.demo.bean.GlobalTransPoint;

//--- Services 
import org.demo.business.service.StockCostingService;
import org.demo.business.service.StockExtraFieldsService;
import org.demo.business.service.StockCategoryService;
import org.demo.business.service.StockService;
import org.demo.business.service.StockDepotService;
import org.demo.business.service.GlobalTransPointService;

//--- List Items 
import org.demo.web.listitem.StockExtraFieldsListItem;
import org.demo.web.listitem.StockCategoryListItem;
import org.demo.web.listitem.StockListItem;
import org.demo.web.listitem.StockDepotListItem;
import org.demo.web.listitem.GlobalTransPointListItem;

/**
 * Spring MVC controller for 'StockCosting' management.
 */
@Controller
@RequestMapping("/stockCosting")
public class StockCostingController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "stockCosting";
	private static final String MAIN_LIST_NAME   = "list";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "stockCosting/form";
	private static final String JSP_LIST   = "stockCosting/list";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/stockCosting/create";
	private static final String SAVE_ACTION_UPDATE   = "/stockCosting/update";

	//--- Main entity service
	@Resource
    private StockCostingService stockCostingService; // Injected by Spring
	//--- Other service(s)
	@Resource
    private StockExtraFieldsService stockExtraFieldsService; // Injected by Spring
	@Resource
    private StockCategoryService stockCategoryService; // Injected by Spring
	@Resource
    private StockService stockService; // Injected by Spring
	@Resource
    private StockDepotService stockDepotService; // Injected by Spring
	@Resource
    private GlobalTransPointService globalTransPointService; // Injected by Spring

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public StockCostingController() {
		super(StockCostingController.class, MAIN_ENTITY_NAME );
		log("StockCostingController created.");
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
	 * Populates the combo-box "items" for the referenced entity "Stock"
	 * @param model
	 */
	private void populateListOfStockItems(Model model) {
		List<Stock> list = stockService.findAll();
		List<StockListItem> items = new LinkedList<StockListItem>();
		for ( Stock stock : list ) {
			items.add(new StockListItem( stock ) );
		}
		model.addAttribute("listOfStockItems", items ) ;
	}

	/**
	 * Populates the combo-box "items" for the referenced entity "StockDepot"
	 * @param model
	 */
	private void populateListOfStockDepotItems(Model model) {
		List<StockDepot> list = stockDepotService.findAll();
		List<StockDepotListItem> items = new LinkedList<StockDepotListItem>();
		for ( StockDepot stockDepot : list ) {
			items.add(new StockDepotListItem( stockDepot ) );
		}
		model.addAttribute("listOfStockDepotItems", items ) ;
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
	 * @param stockCosting
	 */
	private void populateModel(Model model, StockCosting stockCosting, FormMode formMode) {
		//--- Main entity
		model.addAttribute(MAIN_ENTITY_NAME, stockCosting);
		if ( formMode == FormMode.CREATE ) {
			model.addAttribute(MODE, MODE_CREATE); // The form is in "create" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_CREATE); 			
			//--- Other data useful in this screen in "create" mode (all fields)
			populateListOfStockExtraFieldsItems(model);
			populateListOfStockCategoryItems(model);
			populateListOfStockItems(model);
			populateListOfStockDepotItems(model);
			populateListOfGlobalTransPointItems(model);
		}
		else if ( formMode == FormMode.UPDATE ) {
			model.addAttribute(MODE, MODE_UPDATE); // The form is in "update" mode
			model.addAttribute(SAVE_ACTION, SAVE_ACTION_UPDATE); 			
			//--- Other data useful in this screen in "update" mode (only non-pk fields)
			populateListOfGlobalTransPointItems(model);
			populateListOfStockCategoryItems(model);
			populateListOfStockDepotItems(model);
			populateListOfStockItems(model);
			populateListOfStockExtraFieldsItems(model);
		}
	}

	//--------------------------------------------------------------------------------------
	// Request mapping
	//--------------------------------------------------------------------------------------
	/**
	 * Shows a list with all the occurrences of StockCosting found in the database
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping()
	public String list(Model model) {
		log("Action 'list'");
		List<StockCosting> list = stockCostingService.findAll();
		model.addAttribute(MAIN_LIST_NAME, list);		
		return JSP_LIST;
	}

	/**
	 * Shows a form page in order to create a new StockCosting
	 * @param model Spring MVC model
	 * @return
	 */
	@RequestMapping("/form")
	public String formForCreate(Model model) {
		log("Action 'formForCreate'");
		//--- Populates the model with a new instance
		StockCosting stockCosting = new StockCosting();	
		populateModel( model, stockCosting, FormMode.CREATE);
		return JSP_FORM;
	}

	/**
	 * Shows a form page in order to update an existing StockCosting
	 * @param model Spring MVC model
	 * @param id  primary key element
	 * @return
	 */
	@RequestMapping(value = "/form/{id}")
	public String formForUpdate(Model model, @PathVariable("id") Integer id ) {
		log("Action 'formForUpdate'");
		//--- Search the entity by its primary key and stores it in the model 
		StockCosting stockCosting = stockCostingService.findById(id);
		populateModel( model, stockCosting, FormMode.UPDATE);		
		return JSP_FORM;
	}

	/**
	 * 'CREATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param stockCosting  entity to be created
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/create" ) // GET or POST
	public String create(@Valid StockCosting stockCosting, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'create'");
		try {
			if (!bindingResult.hasErrors()) {
				StockCosting stockCostingCreated = stockCostingService.create(stockCosting); 
				model.addAttribute(MAIN_ENTITY_NAME, stockCostingCreated);

				//---
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				return redirectToForm(httpServletRequest, stockCosting.getId() );
			} else {
				populateModel( model, stockCosting, FormMode.CREATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			log("Action 'create' : Exception - " + e.getMessage() );
			messageHelper.addException(model, "stockCosting.error.create", e);
			populateModel( model, stockCosting, FormMode.CREATE);
			return JSP_FORM;
		}
	}

	/**
	 * 'UPDATE' action processing. <br>
	 * This action is based on the 'Post/Redirect/Get (PRG)' pattern, so it ends by 'http redirect'<br>
	 * @param stockCosting  entity to be updated
	 * @param bindingResult Spring MVC binding result
	 * @param model Spring MVC model
	 * @param redirectAttributes Spring MVC redirect attributes
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/update" ) // GET or POST
	public String update(@Valid StockCosting stockCosting, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {
		log("Action 'update'");
		try {
			if (!bindingResult.hasErrors()) {
				//--- Perform database operations
				StockCosting stockCostingSaved = stockCostingService.update(stockCosting);
				model.addAttribute(MAIN_ENTITY_NAME, stockCostingSaved);
				//--- Set the result message
				messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
				log("Action 'update' : update done - redirect");
				return redirectToForm(httpServletRequest, stockCosting.getId());
			} else {
				log("Action 'update' : binding errors");
				populateModel( model, stockCosting, FormMode.UPDATE);
				return JSP_FORM;
			}
		} catch(Exception e) {
			messageHelper.addException(model, "stockCosting.error.update", e);
			log("Action 'update' : Exception - " + e.getMessage() );
			populateModel( model, stockCosting, FormMode.UPDATE);
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
			stockCostingService.delete( id );
			//--- Set the result message
			messageHelper.addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));	
		} catch(Exception e) {
			messageHelper.addException(redirectAttributes, "stockCosting.error.delete", e);
		}
		return redirectToList();
	}

}