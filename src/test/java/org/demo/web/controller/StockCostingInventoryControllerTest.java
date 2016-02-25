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
import org.demo.bean.StockCostingInventory;
import org.demo.bean.Stock;
import org.demo.bean.StockCosting;
import org.demo.bean.StockDepot;
import org.demo.test.StockCostingInventoryFactoryForTest;
import org.demo.test.StockFactoryForTest;
import org.demo.test.StockCostingFactoryForTest;
import org.demo.test.StockDepotFactoryForTest;

//--- Services 
import org.demo.business.service.StockCostingInventoryService;
import org.demo.business.service.StockService;
import org.demo.business.service.StockCostingService;
import org.demo.business.service.StockDepotService;

//--- List Items 
import org.demo.web.listitem.StockListItem;
import org.demo.web.listitem.StockCostingListItem;
import org.demo.web.listitem.StockDepotListItem;

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
public class StockCostingInventoryControllerTest {
	
	@InjectMocks
	private StockCostingInventoryController stockCostingInventoryController;
	@Mock
	private StockCostingInventoryService stockCostingInventoryService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockService stockService; // Injected by Spring
	@Mock
	private StockCostingService stockCostingService; // Injected by Spring
	@Mock
	private StockDepotService stockDepotService; // Injected by Spring

	private StockCostingInventoryFactoryForTest stockCostingInventoryFactoryForTest = new StockCostingInventoryFactoryForTest();
	private StockFactoryForTest stockFactoryForTest = new StockFactoryForTest();
	private StockCostingFactoryForTest stockCostingFactoryForTest = new StockCostingFactoryForTest();
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();

	List<Stock> stocks = new ArrayList<Stock>();
	List<StockCosting> stockCostings = new ArrayList<StockCosting>();
	List<StockDepot> stockDepots = new ArrayList<StockDepot>();

	private void givenPopulateModel() {
		Stock stock1 = stockFactoryForTest.newStock();
		Stock stock2 = stockFactoryForTest.newStock();
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(stock1);
		stocks.add(stock2);
		when(stockService.findAll()).thenReturn(stocks);

		StockCosting stockCosting1 = stockCostingFactoryForTest.newStockCosting();
		StockCosting stockCosting2 = stockCostingFactoryForTest.newStockCosting();
		List<StockCosting> stockCostings = new ArrayList<StockCosting>();
		stockCostings.add(stockCosting1);
		stockCostings.add(stockCosting2);
		when(stockCostingService.findAll()).thenReturn(stockCostings);

		StockDepot stockDepot1 = stockDepotFactoryForTest.newStockDepot();
		StockDepot stockDepot2 = stockDepotFactoryForTest.newStockDepot();
		List<StockDepot> stockDepots = new ArrayList<StockDepot>();
		stockDepots.add(stockDepot1);
		stockDepots.add(stockDepot2);
		when(stockDepotService.findAll()).thenReturn(stockDepots);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockCostingInventory> list = new ArrayList<StockCostingInventory>();
		when(stockCostingInventoryService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockCostingInventoryController.list(model);
		
		// Then
		assertEquals("stockCostingInventory/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockCostingInventoryController.formForCreate(model);
		
		// Then
		assertEquals("stockCostingInventory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockCostingInventory)modelMap.get("stockCostingInventory")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCostingInventory/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCostingInventory stockCostingInventory = stockCostingInventoryFactoryForTest.newStockCostingInventory();
		Integer id = stockCostingInventory.getId();
		when(stockCostingInventoryService.findById(id)).thenReturn(stockCostingInventory);
		
		// When
		String viewName = stockCostingInventoryController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockCostingInventory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingInventory, (StockCostingInventory) modelMap.get("stockCostingInventory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCostingInventory/update", modelMap.get("saveAction"));
		
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockCostingInventory stockCostingInventory = stockCostingInventoryFactoryForTest.newStockCostingInventory();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockCostingInventory stockCostingInventoryCreated = new StockCostingInventory();
		when(stockCostingInventoryService.create(stockCostingInventory)).thenReturn(stockCostingInventoryCreated); 
		
		// When
		String viewName = stockCostingInventoryController.create(stockCostingInventory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockCostingInventory/form/"+stockCostingInventory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingInventoryCreated, (StockCostingInventory) modelMap.get("stockCostingInventory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCostingInventory stockCostingInventory = stockCostingInventoryFactoryForTest.newStockCostingInventory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockCostingInventoryController.create(stockCostingInventory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostingInventory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingInventory, (StockCostingInventory) modelMap.get("stockCostingInventory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCostingInventory/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
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

		StockCostingInventory stockCostingInventory = stockCostingInventoryFactoryForTest.newStockCostingInventory();
		
		Exception exception = new RuntimeException("test exception");
		when(stockCostingInventoryService.create(stockCostingInventory)).thenThrow(exception);
		
		// When
		String viewName = stockCostingInventoryController.create(stockCostingInventory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostingInventory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingInventory, (StockCostingInventory) modelMap.get("stockCostingInventory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCostingInventory/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockCostingInventory.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockCostingInventory stockCostingInventory = stockCostingInventoryFactoryForTest.newStockCostingInventory();
		Integer id = stockCostingInventory.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockCostingInventory stockCostingInventorySaved = new StockCostingInventory();
		stockCostingInventorySaved.setId(id);
		when(stockCostingInventoryService.update(stockCostingInventory)).thenReturn(stockCostingInventorySaved); 
		
		// When
		String viewName = stockCostingInventoryController.update(stockCostingInventory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockCostingInventory/form/"+stockCostingInventory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingInventorySaved, (StockCostingInventory) modelMap.get("stockCostingInventory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCostingInventory stockCostingInventory = stockCostingInventoryFactoryForTest.newStockCostingInventory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockCostingInventoryController.update(stockCostingInventory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostingInventory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingInventory, (StockCostingInventory) modelMap.get("stockCostingInventory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCostingInventory/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
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

		StockCostingInventory stockCostingInventory = stockCostingInventoryFactoryForTest.newStockCostingInventory();
		
		Exception exception = new RuntimeException("test exception");
		when(stockCostingInventoryService.update(stockCostingInventory)).thenThrow(exception);
		
		// When
		String viewName = stockCostingInventoryController.update(stockCostingInventory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostingInventory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingInventory, (StockCostingInventory) modelMap.get("stockCostingInventory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCostingInventory/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockCostingInventory.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockCostingInventory stockCostingInventory = stockCostingInventoryFactoryForTest.newStockCostingInventory();
		Integer id = stockCostingInventory.getId();
		
		// When
		String viewName = stockCostingInventoryController.delete(redirectAttributes, id);
		
		// Then
		verify(stockCostingInventoryService).delete(id);
		assertEquals("redirect:/stockCostingInventory", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockCostingInventory stockCostingInventory = stockCostingInventoryFactoryForTest.newStockCostingInventory();
		Integer id = stockCostingInventory.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockCostingInventoryService).delete(id);
		
		// When
		String viewName = stockCostingInventoryController.delete(redirectAttributes, id);
		
		// Then
		verify(stockCostingInventoryService).delete(id);
		assertEquals("redirect:/stockCostingInventory", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockCostingInventory.error.delete", exception);
	}
	
	
}
