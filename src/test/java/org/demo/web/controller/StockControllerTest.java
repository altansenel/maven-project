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
import org.demo.bean.Stock;
import org.demo.bean.StockCategory;
import org.demo.bean.StockExtraFields;
import org.demo.test.StockFactoryForTest;
import org.demo.test.StockCategoryFactoryForTest;
import org.demo.test.StockExtraFieldsFactoryForTest;

//--- Services 
import org.demo.business.service.StockService;
import org.demo.business.service.StockCategoryService;
import org.demo.business.service.StockExtraFieldsService;

//--- List Items 
import org.demo.web.listitem.StockCategoryListItem;
import org.demo.web.listitem.StockExtraFieldsListItem;

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
public class StockControllerTest {
	
	@InjectMocks
	private StockController stockController;
	@Mock
	private StockService stockService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockCategoryService stockCategoryService; // Injected by Spring
	@Mock
	private StockExtraFieldsService stockExtraFieldsService; // Injected by Spring

	private StockFactoryForTest stockFactoryForTest = new StockFactoryForTest();
	private StockCategoryFactoryForTest stockCategoryFactoryForTest = new StockCategoryFactoryForTest();
	private StockExtraFieldsFactoryForTest stockExtraFieldsFactoryForTest = new StockExtraFieldsFactoryForTest();

	List<StockCategory> stockCategorys = new ArrayList<StockCategory>();
	List<StockExtraFields> stockExtraFieldss = new ArrayList<StockExtraFields>();

	private void givenPopulateModel() {
		StockCategory stockCategory1 = stockCategoryFactoryForTest.newStockCategory();
		StockCategory stockCategory2 = stockCategoryFactoryForTest.newStockCategory();
		List<StockCategory> stockCategorys = new ArrayList<StockCategory>();
		stockCategorys.add(stockCategory1);
		stockCategorys.add(stockCategory2);
		when(stockCategoryService.findAll()).thenReturn(stockCategorys);

		StockExtraFields stockExtraFields1 = stockExtraFieldsFactoryForTest.newStockExtraFields();
		StockExtraFields stockExtraFields2 = stockExtraFieldsFactoryForTest.newStockExtraFields();
		List<StockExtraFields> stockExtraFieldss = new ArrayList<StockExtraFields>();
		stockExtraFieldss.add(stockExtraFields1);
		stockExtraFieldss.add(stockExtraFields2);
		when(stockExtraFieldsService.findAll()).thenReturn(stockExtraFieldss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<Stock> list = new ArrayList<Stock>();
		when(stockService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockController.list(model);
		
		// Then
		assertEquals("stock/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockController.formForCreate(model);
		
		// Then
		assertEquals("stock/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((Stock)modelMap.get("stock")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stock/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Stock stock = stockFactoryForTest.newStock();
		Integer id = stock.getId();
		when(stockService.findById(id)).thenReturn(stock);
		
		// When
		String viewName = stockController.formForUpdate(model, id);
		
		// Then
		assertEquals("stock/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stock, (Stock) modelMap.get("stock"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stock/update", modelMap.get("saveAction"));
		
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Stock stock = stockFactoryForTest.newStock();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Stock stockCreated = new Stock();
		when(stockService.create(stock)).thenReturn(stockCreated); 
		
		// When
		String viewName = stockController.create(stock, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stock/form/"+stock.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCreated, (Stock) modelMap.get("stock"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Stock stock = stockFactoryForTest.newStock();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockController.create(stock, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stock/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stock, (Stock) modelMap.get("stock"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stock/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
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

		Stock stock = stockFactoryForTest.newStock();
		
		Exception exception = new RuntimeException("test exception");
		when(stockService.create(stock)).thenThrow(exception);
		
		// When
		String viewName = stockController.create(stock, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stock/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stock, (Stock) modelMap.get("stock"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stock/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stock.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Stock stock = stockFactoryForTest.newStock();
		Integer id = stock.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Stock stockSaved = new Stock();
		stockSaved.setId(id);
		when(stockService.update(stock)).thenReturn(stockSaved); 
		
		// When
		String viewName = stockController.update(stock, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stock/form/"+stock.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockSaved, (Stock) modelMap.get("stock"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Stock stock = stockFactoryForTest.newStock();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockController.update(stock, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stock/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stock, (Stock) modelMap.get("stock"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stock/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
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

		Stock stock = stockFactoryForTest.newStock();
		
		Exception exception = new RuntimeException("test exception");
		when(stockService.update(stock)).thenThrow(exception);
		
		// When
		String viewName = stockController.update(stock, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stock/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stock, (Stock) modelMap.get("stock"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stock/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stock.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Stock stock = stockFactoryForTest.newStock();
		Integer id = stock.getId();
		
		// When
		String viewName = stockController.delete(redirectAttributes, id);
		
		// Then
		verify(stockService).delete(id);
		assertEquals("redirect:/stock", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Stock stock = stockFactoryForTest.newStock();
		Integer id = stock.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockService).delete(id);
		
		// When
		String viewName = stockController.delete(redirectAttributes, id);
		
		// Then
		verify(stockService).delete(id);
		assertEquals("redirect:/stock", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stock.error.delete", exception);
	}
	
	
}
