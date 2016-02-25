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
import org.demo.bean.StockTransTax;
import org.demo.bean.StockTrans;
import org.demo.test.StockTransTaxFactoryForTest;
import org.demo.test.StockTransFactoryForTest;

//--- Services 
import org.demo.business.service.StockTransTaxService;
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
public class StockTransTaxControllerTest {
	
	@InjectMocks
	private StockTransTaxController stockTransTaxController;
	@Mock
	private StockTransTaxService stockTransTaxService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockTransService stockTransService; // Injected by Spring

	private StockTransTaxFactoryForTest stockTransTaxFactoryForTest = new StockTransTaxFactoryForTest();
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
		
		List<StockTransTax> list = new ArrayList<StockTransTax>();
		when(stockTransTaxService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockTransTaxController.list(model);
		
		// Then
		assertEquals("stockTransTax/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockTransTaxController.formForCreate(model);
		
		// Then
		assertEquals("stockTransTax/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockTransTax)modelMap.get("stockTransTax")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransTax/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();
		Integer id = stockTransTax.getId();
		when(stockTransTaxService.findById(id)).thenReturn(stockTransTax);
		
		// When
		String viewName = stockTransTaxController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockTransTax/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransTax, (StockTransTax) modelMap.get("stockTransTax"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransTax/update", modelMap.get("saveAction"));
		
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTransTax stockTransTaxCreated = new StockTransTax();
		when(stockTransTaxService.create(stockTransTax)).thenReturn(stockTransTaxCreated); 
		
		// When
		String viewName = stockTransTaxController.create(stockTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTransTax/form/"+stockTransTax.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransTaxCreated, (StockTransTax) modelMap.get("stockTransTax"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransTaxController.create(stockTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransTax/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransTax, (StockTransTax) modelMap.get("stockTransTax"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransTax/create", modelMap.get("saveAction"));
		
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

		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransTaxService.create(stockTransTax)).thenThrow(exception);
		
		// When
		String viewName = stockTransTaxController.create(stockTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransTax/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransTax, (StockTransTax) modelMap.get("stockTransTax"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransTax/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTransTax.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();
		Integer id = stockTransTax.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTransTax stockTransTaxSaved = new StockTransTax();
		stockTransTaxSaved.setId(id);
		when(stockTransTaxService.update(stockTransTax)).thenReturn(stockTransTaxSaved); 
		
		// When
		String viewName = stockTransTaxController.update(stockTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTransTax/form/"+stockTransTax.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransTaxSaved, (StockTransTax) modelMap.get("stockTransTax"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransTaxController.update(stockTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransTax/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransTax, (StockTransTax) modelMap.get("stockTransTax"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransTax/update", modelMap.get("saveAction"));
		
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

		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransTaxService.update(stockTransTax)).thenThrow(exception);
		
		// When
		String viewName = stockTransTaxController.update(stockTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransTax/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransTax, (StockTransTax) modelMap.get("stockTransTax"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransTax/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTransTax.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();
		Integer id = stockTransTax.getId();
		
		// When
		String viewName = stockTransTaxController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransTaxService).delete(id);
		assertEquals("redirect:/stockTransTax", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTransTax stockTransTax = stockTransTaxFactoryForTest.newStockTransTax();
		Integer id = stockTransTax.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockTransTaxService).delete(id);
		
		// When
		String viewName = stockTransTaxController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransTaxService).delete(id);
		assertEquals("redirect:/stockTransTax", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockTransTax.error.delete", exception);
	}
	
	
}
