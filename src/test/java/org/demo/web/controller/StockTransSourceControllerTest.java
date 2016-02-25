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
import org.demo.bean.StockTransSource;
import org.demo.test.StockTransSourceFactoryForTest;

//--- Services 
import org.demo.business.service.StockTransSourceService;


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
public class StockTransSourceControllerTest {
	
	@InjectMocks
	private StockTransSourceController stockTransSourceController;
	@Mock
	private StockTransSourceService stockTransSourceService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private StockTransSourceFactoryForTest stockTransSourceFactoryForTest = new StockTransSourceFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockTransSource> list = new ArrayList<StockTransSource>();
		when(stockTransSourceService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockTransSourceController.list(model);
		
		// Then
		assertEquals("stockTransSource/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockTransSourceController.formForCreate(model);
		
		// Then
		assertEquals("stockTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockTransSource)modelMap.get("stockTransSource")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransSource/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransSource stockTransSource = stockTransSourceFactoryForTest.newStockTransSource();
		Integer id = stockTransSource.getId();
		when(stockTransSourceService.findById(id)).thenReturn(stockTransSource);
		
		// When
		String viewName = stockTransSourceController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransSource, (StockTransSource) modelMap.get("stockTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransSource/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTransSource stockTransSource = stockTransSourceFactoryForTest.newStockTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTransSource stockTransSourceCreated = new StockTransSource();
		when(stockTransSourceService.create(stockTransSource)).thenReturn(stockTransSourceCreated); 
		
		// When
		String viewName = stockTransSourceController.create(stockTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTransSource/form/"+stockTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransSourceCreated, (StockTransSource) modelMap.get("stockTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransSource stockTransSource = stockTransSourceFactoryForTest.newStockTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransSourceController.create(stockTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransSource, (StockTransSource) modelMap.get("stockTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransSource/create", modelMap.get("saveAction"));
		
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

		StockTransSource stockTransSource = stockTransSourceFactoryForTest.newStockTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransSourceService.create(stockTransSource)).thenThrow(exception);
		
		// When
		String viewName = stockTransSourceController.create(stockTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransSource, (StockTransSource) modelMap.get("stockTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransSource/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTransSource.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTransSource stockTransSource = stockTransSourceFactoryForTest.newStockTransSource();
		Integer id = stockTransSource.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTransSource stockTransSourceSaved = new StockTransSource();
		stockTransSourceSaved.setId(id);
		when(stockTransSourceService.update(stockTransSource)).thenReturn(stockTransSourceSaved); 
		
		// When
		String viewName = stockTransSourceController.update(stockTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTransSource/form/"+stockTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransSourceSaved, (StockTransSource) modelMap.get("stockTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransSource stockTransSource = stockTransSourceFactoryForTest.newStockTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransSourceController.update(stockTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransSource, (StockTransSource) modelMap.get("stockTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransSource/update", modelMap.get("saveAction"));
		
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

		StockTransSource stockTransSource = stockTransSourceFactoryForTest.newStockTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransSourceService.update(stockTransSource)).thenThrow(exception);
		
		// When
		String viewName = stockTransSourceController.update(stockTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransSource, (StockTransSource) modelMap.get("stockTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransSource/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTransSource.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTransSource stockTransSource = stockTransSourceFactoryForTest.newStockTransSource();
		Integer id = stockTransSource.getId();
		
		// When
		String viewName = stockTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransSourceService).delete(id);
		assertEquals("redirect:/stockTransSource", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTransSource stockTransSource = stockTransSourceFactoryForTest.newStockTransSource();
		Integer id = stockTransSource.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockTransSourceService).delete(id);
		
		// When
		String viewName = stockTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransSourceService).delete(id);
		assertEquals("redirect:/stockTransSource", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockTransSource.error.delete", exception);
	}
	
	
}
