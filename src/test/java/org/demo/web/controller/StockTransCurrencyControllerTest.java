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
import org.demo.bean.StockTransCurrency;
import org.demo.bean.StockTrans;
import org.demo.test.StockTransCurrencyFactoryForTest;
import org.demo.test.StockTransFactoryForTest;

//--- Services 
import org.demo.business.service.StockTransCurrencyService;
import org.demo.business.service.StockTransService;

//--- List Items 
import org.demo.web.listitem.StockTransListItem;

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
public class StockTransCurrencyControllerTest {
	
	@InjectMocks
	private StockTransCurrencyController stockTransCurrencyController;
	@Mock
	private StockTransCurrencyService stockTransCurrencyService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockTransService stockTransService; // Injected by Spring

	private StockTransCurrencyFactoryForTest stockTransCurrencyFactoryForTest = new StockTransCurrencyFactoryForTest();
	private StockTransFactoryForTest stockTransFactoryForTest = new StockTransFactoryForTest();

	List<StockTrans> stockTranss = new ArrayList<StockTrans>();

	private void givenPopulateModel() {
		StockTrans stockTrans1 = stockTransFactoryForTest.newStockTrans();
		StockTrans stockTrans2 = stockTransFactoryForTest.newStockTrans();
		List<StockTrans> stockTranss = new ArrayList<StockTrans>();
		stockTranss.add(stockTrans1);
		stockTranss.add(stockTrans2);
		when(stockTransService.findAll()).thenReturn(stockTranss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockTransCurrency> list = new ArrayList<StockTransCurrency>();
		when(stockTransCurrencyService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockTransCurrencyController.list(model);
		
		// Then
		assertEquals("stockTransCurrency/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockTransCurrencyController.formForCreate(model);
		
		// Then
		assertEquals("stockTransCurrency/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockTransCurrency)modelMap.get("stockTransCurrency")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransCurrency/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransCurrency stockTransCurrency = stockTransCurrencyFactoryForTest.newStockTransCurrency();
		Integer id = stockTransCurrency.getId();
		when(stockTransCurrencyService.findById(id)).thenReturn(stockTransCurrency);
		
		// When
		String viewName = stockTransCurrencyController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockTransCurrency/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransCurrency, (StockTransCurrency) modelMap.get("stockTransCurrency"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransCurrency/update", modelMap.get("saveAction"));
		
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTransCurrency stockTransCurrency = stockTransCurrencyFactoryForTest.newStockTransCurrency();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTransCurrency stockTransCurrencyCreated = new StockTransCurrency();
		when(stockTransCurrencyService.create(stockTransCurrency)).thenReturn(stockTransCurrencyCreated); 
		
		// When
		String viewName = stockTransCurrencyController.create(stockTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTransCurrency/form/"+stockTransCurrency.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransCurrencyCreated, (StockTransCurrency) modelMap.get("stockTransCurrency"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransCurrency stockTransCurrency = stockTransCurrencyFactoryForTest.newStockTransCurrency();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransCurrencyController.create(stockTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransCurrency, (StockTransCurrency) modelMap.get("stockTransCurrency"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransCurrency/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
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

		StockTransCurrency stockTransCurrency = stockTransCurrencyFactoryForTest.newStockTransCurrency();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransCurrencyService.create(stockTransCurrency)).thenThrow(exception);
		
		// When
		String viewName = stockTransCurrencyController.create(stockTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransCurrency, (StockTransCurrency) modelMap.get("stockTransCurrency"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransCurrency/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTransCurrency.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTransCurrency stockTransCurrency = stockTransCurrencyFactoryForTest.newStockTransCurrency();
		Integer id = stockTransCurrency.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTransCurrency stockTransCurrencySaved = new StockTransCurrency();
		stockTransCurrencySaved.setId(id);
		when(stockTransCurrencyService.update(stockTransCurrency)).thenReturn(stockTransCurrencySaved); 
		
		// When
		String viewName = stockTransCurrencyController.update(stockTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTransCurrency/form/"+stockTransCurrency.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransCurrencySaved, (StockTransCurrency) modelMap.get("stockTransCurrency"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransCurrency stockTransCurrency = stockTransCurrencyFactoryForTest.newStockTransCurrency();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransCurrencyController.update(stockTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransCurrency, (StockTransCurrency) modelMap.get("stockTransCurrency"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransCurrency/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
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

		StockTransCurrency stockTransCurrency = stockTransCurrencyFactoryForTest.newStockTransCurrency();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransCurrencyService.update(stockTransCurrency)).thenThrow(exception);
		
		// When
		String viewName = stockTransCurrencyController.update(stockTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransCurrency, (StockTransCurrency) modelMap.get("stockTransCurrency"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransCurrency/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTransCurrency.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTransCurrency stockTransCurrency = stockTransCurrencyFactoryForTest.newStockTransCurrency();
		Integer id = stockTransCurrency.getId();
		
		// When
		String viewName = stockTransCurrencyController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransCurrencyService).delete(id);
		assertEquals("redirect:/stockTransCurrency", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTransCurrency stockTransCurrency = stockTransCurrencyFactoryForTest.newStockTransCurrency();
		Integer id = stockTransCurrency.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockTransCurrencyService).delete(id);
		
		// When
		String viewName = stockTransCurrencyController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransCurrencyService).delete(id);
		assertEquals("redirect:/stockTransCurrency", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockTransCurrency.error.delete", exception);
	}
	
	
}
