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
import org.demo.bean.StockExtraFields;
import org.demo.test.StockExtraFieldsFactoryForTest;

//--- Services 
import org.demo.business.service.StockExtraFieldsService;


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
public class StockExtraFieldsControllerTest {
	
	@InjectMocks
	private StockExtraFieldsController stockExtraFieldsController;
	@Mock
	private StockExtraFieldsService stockExtraFieldsService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private StockExtraFieldsFactoryForTest stockExtraFieldsFactoryForTest = new StockExtraFieldsFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockExtraFields> list = new ArrayList<StockExtraFields>();
		when(stockExtraFieldsService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockExtraFieldsController.list(model);
		
		// Then
		assertEquals("stockExtraFields/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockExtraFieldsController.formForCreate(model);
		
		// Then
		assertEquals("stockExtraFields/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockExtraFields)modelMap.get("stockExtraFields")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockExtraFields/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockExtraFields stockExtraFields = stockExtraFieldsFactoryForTest.newStockExtraFields();
		Integer id = stockExtraFields.getId();
		when(stockExtraFieldsService.findById(id)).thenReturn(stockExtraFields);
		
		// When
		String viewName = stockExtraFieldsController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockExtraFields/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockExtraFields, (StockExtraFields) modelMap.get("stockExtraFields"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockExtraFields/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockExtraFields stockExtraFields = stockExtraFieldsFactoryForTest.newStockExtraFields();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockExtraFields stockExtraFieldsCreated = new StockExtraFields();
		when(stockExtraFieldsService.create(stockExtraFields)).thenReturn(stockExtraFieldsCreated); 
		
		// When
		String viewName = stockExtraFieldsController.create(stockExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockExtraFields/form/"+stockExtraFields.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockExtraFieldsCreated, (StockExtraFields) modelMap.get("stockExtraFields"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockExtraFields stockExtraFields = stockExtraFieldsFactoryForTest.newStockExtraFields();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockExtraFieldsController.create(stockExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockExtraFields, (StockExtraFields) modelMap.get("stockExtraFields"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockExtraFields/create", modelMap.get("saveAction"));
		
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

		StockExtraFields stockExtraFields = stockExtraFieldsFactoryForTest.newStockExtraFields();
		
		Exception exception = new RuntimeException("test exception");
		when(stockExtraFieldsService.create(stockExtraFields)).thenThrow(exception);
		
		// When
		String viewName = stockExtraFieldsController.create(stockExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockExtraFields, (StockExtraFields) modelMap.get("stockExtraFields"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockExtraFields/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockExtraFields.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockExtraFields stockExtraFields = stockExtraFieldsFactoryForTest.newStockExtraFields();
		Integer id = stockExtraFields.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockExtraFields stockExtraFieldsSaved = new StockExtraFields();
		stockExtraFieldsSaved.setId(id);
		when(stockExtraFieldsService.update(stockExtraFields)).thenReturn(stockExtraFieldsSaved); 
		
		// When
		String viewName = stockExtraFieldsController.update(stockExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockExtraFields/form/"+stockExtraFields.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockExtraFieldsSaved, (StockExtraFields) modelMap.get("stockExtraFields"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockExtraFields stockExtraFields = stockExtraFieldsFactoryForTest.newStockExtraFields();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockExtraFieldsController.update(stockExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockExtraFields, (StockExtraFields) modelMap.get("stockExtraFields"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockExtraFields/update", modelMap.get("saveAction"));
		
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

		StockExtraFields stockExtraFields = stockExtraFieldsFactoryForTest.newStockExtraFields();
		
		Exception exception = new RuntimeException("test exception");
		when(stockExtraFieldsService.update(stockExtraFields)).thenThrow(exception);
		
		// When
		String viewName = stockExtraFieldsController.update(stockExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockExtraFields, (StockExtraFields) modelMap.get("stockExtraFields"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockExtraFields/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockExtraFields.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockExtraFields stockExtraFields = stockExtraFieldsFactoryForTest.newStockExtraFields();
		Integer id = stockExtraFields.getId();
		
		// When
		String viewName = stockExtraFieldsController.delete(redirectAttributes, id);
		
		// Then
		verify(stockExtraFieldsService).delete(id);
		assertEquals("redirect:/stockExtraFields", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockExtraFields stockExtraFields = stockExtraFieldsFactoryForTest.newStockExtraFields();
		Integer id = stockExtraFields.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockExtraFieldsService).delete(id);
		
		// When
		String viewName = stockExtraFieldsController.delete(redirectAttributes, id);
		
		// Then
		verify(stockExtraFieldsService).delete(id);
		assertEquals("redirect:/stockExtraFields", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockExtraFields.error.delete", exception);
	}
	
	
}
