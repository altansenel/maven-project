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
import org.demo.bean.StockCostFactor;
import org.demo.test.StockCostFactorFactoryForTest;

//--- Services 
import org.demo.business.service.StockCostFactorService;


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
public class StockCostFactorControllerTest {
	
	@InjectMocks
	private StockCostFactorController stockCostFactorController;
	@Mock
	private StockCostFactorService stockCostFactorService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private StockCostFactorFactoryForTest stockCostFactorFactoryForTest = new StockCostFactorFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockCostFactor> list = new ArrayList<StockCostFactor>();
		when(stockCostFactorService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockCostFactorController.list(model);
		
		// Then
		assertEquals("stockCostFactor/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockCostFactorController.formForCreate(model);
		
		// Then
		assertEquals("stockCostFactor/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockCostFactor)modelMap.get("stockCostFactor")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCostFactor/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCostFactor stockCostFactor = stockCostFactorFactoryForTest.newStockCostFactor();
		Integer id = stockCostFactor.getId();
		when(stockCostFactorService.findById(id)).thenReturn(stockCostFactor);
		
		// When
		String viewName = stockCostFactorController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockCostFactor/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostFactor, (StockCostFactor) modelMap.get("stockCostFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCostFactor/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockCostFactor stockCostFactor = stockCostFactorFactoryForTest.newStockCostFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockCostFactor stockCostFactorCreated = new StockCostFactor();
		when(stockCostFactorService.create(stockCostFactor)).thenReturn(stockCostFactorCreated); 
		
		// When
		String viewName = stockCostFactorController.create(stockCostFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockCostFactor/form/"+stockCostFactor.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostFactorCreated, (StockCostFactor) modelMap.get("stockCostFactor"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCostFactor stockCostFactor = stockCostFactorFactoryForTest.newStockCostFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockCostFactorController.create(stockCostFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostFactor, (StockCostFactor) modelMap.get("stockCostFactor"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCostFactor/create", modelMap.get("saveAction"));
		
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

		StockCostFactor stockCostFactor = stockCostFactorFactoryForTest.newStockCostFactor();
		
		Exception exception = new RuntimeException("test exception");
		when(stockCostFactorService.create(stockCostFactor)).thenThrow(exception);
		
		// When
		String viewName = stockCostFactorController.create(stockCostFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostFactor, (StockCostFactor) modelMap.get("stockCostFactor"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCostFactor/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockCostFactor.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockCostFactor stockCostFactor = stockCostFactorFactoryForTest.newStockCostFactor();
		Integer id = stockCostFactor.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockCostFactor stockCostFactorSaved = new StockCostFactor();
		stockCostFactorSaved.setId(id);
		when(stockCostFactorService.update(stockCostFactor)).thenReturn(stockCostFactorSaved); 
		
		// When
		String viewName = stockCostFactorController.update(stockCostFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockCostFactor/form/"+stockCostFactor.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostFactorSaved, (StockCostFactor) modelMap.get("stockCostFactor"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCostFactor stockCostFactor = stockCostFactorFactoryForTest.newStockCostFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockCostFactorController.update(stockCostFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostFactor, (StockCostFactor) modelMap.get("stockCostFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCostFactor/update", modelMap.get("saveAction"));
		
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

		StockCostFactor stockCostFactor = stockCostFactorFactoryForTest.newStockCostFactor();
		
		Exception exception = new RuntimeException("test exception");
		when(stockCostFactorService.update(stockCostFactor)).thenThrow(exception);
		
		// When
		String viewName = stockCostFactorController.update(stockCostFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostFactor, (StockCostFactor) modelMap.get("stockCostFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCostFactor/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockCostFactor.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockCostFactor stockCostFactor = stockCostFactorFactoryForTest.newStockCostFactor();
		Integer id = stockCostFactor.getId();
		
		// When
		String viewName = stockCostFactorController.delete(redirectAttributes, id);
		
		// Then
		verify(stockCostFactorService).delete(id);
		assertEquals("redirect:/stockCostFactor", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockCostFactor stockCostFactor = stockCostFactorFactoryForTest.newStockCostFactor();
		Integer id = stockCostFactor.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockCostFactorService).delete(id);
		
		// When
		String viewName = stockCostFactorController.delete(redirectAttributes, id);
		
		// Then
		verify(stockCostFactorService).delete(id);
		assertEquals("redirect:/stockCostFactor", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockCostFactor.error.delete", exception);
	}
	
	
}
