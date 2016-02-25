package org.demo.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//--- Entities
import org.demo.bean.StockCosting;
import org.demo.bean.StockExtraFields;
import org.demo.bean.StockCategory;
import org.demo.bean.Stock;
import org.demo.bean.StockDepot;
import org.demo.bean.GlobalTransPoint;
import org.demo.test.StockCostingFactoryForTest;
import org.demo.test.StockExtraFieldsFactoryForTest;
import org.demo.test.StockCategoryFactoryForTest;
import org.demo.test.StockFactoryForTest;
import org.demo.test.StockDepotFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;

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

import org.demo.web.common.Message;
import org.demo.web.common.MessageHelper;
import org.demo.web.common.MessageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RunWith(MockitoJUnitRunner.class)
public class StockCostingControllerTest {
	
	@InjectMocks
	private StockCostingController stockCostingController;
	@Mock
	private StockCostingService stockCostingService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockExtraFieldsService stockExtraFieldsService; // Injected by Spring
	@Mock
	private StockCategoryService stockCategoryService; // Injected by Spring
	@Mock
	private StockService stockService; // Injected by Spring
	@Mock
	private StockDepotService stockDepotService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring

	private StockCostingFactoryForTest stockCostingFactoryForTest = new StockCostingFactoryForTest();
	private StockExtraFieldsFactoryForTest stockExtraFieldsFactoryForTest = new StockExtraFieldsFactoryForTest();
	private StockCategoryFactoryForTest stockCategoryFactoryForTest = new StockCategoryFactoryForTest();
	private StockFactoryForTest stockFactoryForTest = new StockFactoryForTest();
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();

	List<StockExtraFields> stockExtraFieldss = new ArrayList<StockExtraFields>();
	List<StockCategory> stockCategorys = new ArrayList<StockCategory>();
	List<Stock> stocks = new ArrayList<Stock>();
	List<StockDepot> stockDepots = new ArrayList<StockDepot>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();

	private void givenPopulateModel() {
		StockExtraFields stockExtraFields1 = stockExtraFieldsFactoryForTest.newStockExtraFields();
		StockExtraFields stockExtraFields2 = stockExtraFieldsFactoryForTest.newStockExtraFields();
		List<StockExtraFields> stockExtraFieldss = new ArrayList<StockExtraFields>();
		stockExtraFieldss.add(stockExtraFields1);
		stockExtraFieldss.add(stockExtraFields2);
		when(stockExtraFieldsService.findAll()).thenReturn(stockExtraFieldss);

		StockCategory stockCategory1 = stockCategoryFactoryForTest.newStockCategory();
		StockCategory stockCategory2 = stockCategoryFactoryForTest.newStockCategory();
		List<StockCategory> stockCategorys = new ArrayList<StockCategory>();
		stockCategorys.add(stockCategory1);
		stockCategorys.add(stockCategory2);
		when(stockCategoryService.findAll()).thenReturn(stockCategorys);

		Stock stock1 = stockFactoryForTest.newStock();
		Stock stock2 = stockFactoryForTest.newStock();
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(stock1);
		stocks.add(stock2);
		when(stockService.findAll()).thenReturn(stocks);

		StockDepot stockDepot1 = stockDepotFactoryForTest.newStockDepot();
		StockDepot stockDepot2 = stockDepotFactoryForTest.newStockDepot();
		List<StockDepot> stockDepots = new ArrayList<StockDepot>();
		stockDepots.add(stockDepot1);
		stockDepots.add(stockDepot2);
		when(stockDepotService.findAll()).thenReturn(stockDepots);

		GlobalTransPoint globalTransPoint1 = globalTransPointFactoryForTest.newGlobalTransPoint();
		GlobalTransPoint globalTransPoint2 = globalTransPointFactoryForTest.newGlobalTransPoint();
		List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
		globalTransPoints.add(globalTransPoint1);
		globalTransPoints.add(globalTransPoint2);
		when(globalTransPointService.findAll()).thenReturn(globalTransPoints);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockCosting> list = new ArrayList<StockCosting>();
		when(stockCostingService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockCostingController.list(model);
		
		// Then
		assertEquals("stockCosting/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockCostingController.formForCreate(model);
		
		// Then
		assertEquals("stockCosting/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockCosting)modelMap.get("stockCosting")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCosting/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCosting stockCosting = stockCostingFactoryForTest.newStockCosting();
		Integer id = stockCosting.getId();
		when(stockCostingService.findById(id)).thenReturn(stockCosting);
		
		// When
		String viewName = stockCostingController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockCosting/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCosting, (StockCosting) modelMap.get("stockCosting"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCosting/update", modelMap.get("saveAction"));
		
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockCosting stockCosting = stockCostingFactoryForTest.newStockCosting();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockCosting stockCostingCreated = new StockCosting();
		when(stockCostingService.create(stockCosting)).thenReturn(stockCostingCreated); 
		
		// When
		String viewName = stockCostingController.create(stockCosting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockCosting/form/"+stockCosting.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingCreated, (StockCosting) modelMap.get("stockCosting"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCosting stockCosting = stockCostingFactoryForTest.newStockCosting();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockCostingController.create(stockCosting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCosting/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCosting, (StockCosting) modelMap.get("stockCosting"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCosting/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
	}

	@Test
	public void createException() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		StockCosting stockCosting = stockCostingFactoryForTest.newStockCosting();
		
		Exception exception = new RuntimeException("test exception");
		when(stockCostingService.create(stockCosting)).thenThrow(exception);
		
		// When
		String viewName = stockCostingController.create(stockCosting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCosting/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCosting, (StockCosting) modelMap.get("stockCosting"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCosting/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockCosting.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockCosting stockCosting = stockCostingFactoryForTest.newStockCosting();
		Integer id = stockCosting.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockCosting stockCostingSaved = new StockCosting();
		stockCostingSaved.setId(id);
		when(stockCostingService.update(stockCosting)).thenReturn(stockCostingSaved); 
		
		// When
		String viewName = stockCostingController.update(stockCosting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockCosting/form/"+stockCosting.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingSaved, (StockCosting) modelMap.get("stockCosting"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCosting stockCosting = stockCostingFactoryForTest.newStockCosting();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockCostingController.update(stockCosting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCosting/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCosting, (StockCosting) modelMap.get("stockCosting"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCosting/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}

	@Test
	public void updateException() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		StockCosting stockCosting = stockCostingFactoryForTest.newStockCosting();
		
		Exception exception = new RuntimeException("test exception");
		when(stockCostingService.update(stockCosting)).thenThrow(exception);
		
		// When
		String viewName = stockCostingController.update(stockCosting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCosting/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCosting, (StockCosting) modelMap.get("stockCosting"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCosting/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockCosting.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockCosting stockCosting = stockCostingFactoryForTest.newStockCosting();
		Integer id = stockCosting.getId();
		
		// When
		String viewName = stockCostingController.delete(redirectAttributes, id);
		
		// Then
		verify(stockCostingService).delete(id);
		assertEquals("redirect:/stockCosting", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockCosting stockCosting = stockCostingFactoryForTest.newStockCosting();
		Integer id = stockCosting.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockCostingService).delete(id);
		
		// When
		String viewName = stockCostingController.delete(redirectAttributes, id);
		
		// Then
		verify(stockCostingService).delete(id);
		assertEquals("redirect:/stockCosting", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockCosting.error.delete", exception);
	}
	
	
}
