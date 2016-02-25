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
import org.demo.bean.StockUnit;
import org.demo.test.StockUnitFactoryForTest;

//--- Services 
import org.demo.business.service.StockUnitService;


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
public class StockUnitControllerTest {
	
	@InjectMocks
	private StockUnitController stockUnitController;
	@Mock
	private StockUnitService stockUnitService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private StockUnitFactoryForTest stockUnitFactoryForTest = new StockUnitFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockUnit> list = new ArrayList<StockUnit>();
		when(stockUnitService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockUnitController.list(model);
		
		// Then
		assertEquals("stockUnit/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockUnitController.formForCreate(model);
		
		// Then
		assertEquals("stockUnit/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockUnit)modelMap.get("stockUnit")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockUnit/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockUnit stockUnit = stockUnitFactoryForTest.newStockUnit();
		Integer id = stockUnit.getId();
		when(stockUnitService.findById(id)).thenReturn(stockUnit);
		
		// When
		String viewName = stockUnitController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockUnit/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockUnit, (StockUnit) modelMap.get("stockUnit"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockUnit/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockUnit stockUnit = stockUnitFactoryForTest.newStockUnit();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockUnit stockUnitCreated = new StockUnit();
		when(stockUnitService.create(stockUnit)).thenReturn(stockUnitCreated); 
		
		// When
		String viewName = stockUnitController.create(stockUnit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockUnit/form/"+stockUnit.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockUnitCreated, (StockUnit) modelMap.get("stockUnit"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockUnit stockUnit = stockUnitFactoryForTest.newStockUnit();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockUnitController.create(stockUnit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockUnit/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockUnit, (StockUnit) modelMap.get("stockUnit"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockUnit/create", modelMap.get("saveAction"));
		
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

		StockUnit stockUnit = stockUnitFactoryForTest.newStockUnit();
		
		Exception exception = new RuntimeException("test exception");
		when(stockUnitService.create(stockUnit)).thenThrow(exception);
		
		// When
		String viewName = stockUnitController.create(stockUnit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockUnit/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockUnit, (StockUnit) modelMap.get("stockUnit"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockUnit/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockUnit.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockUnit stockUnit = stockUnitFactoryForTest.newStockUnit();
		Integer id = stockUnit.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockUnit stockUnitSaved = new StockUnit();
		stockUnitSaved.setId(id);
		when(stockUnitService.update(stockUnit)).thenReturn(stockUnitSaved); 
		
		// When
		String viewName = stockUnitController.update(stockUnit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockUnit/form/"+stockUnit.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockUnitSaved, (StockUnit) modelMap.get("stockUnit"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockUnit stockUnit = stockUnitFactoryForTest.newStockUnit();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockUnitController.update(stockUnit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockUnit/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockUnit, (StockUnit) modelMap.get("stockUnit"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockUnit/update", modelMap.get("saveAction"));
		
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

		StockUnit stockUnit = stockUnitFactoryForTest.newStockUnit();
		
		Exception exception = new RuntimeException("test exception");
		when(stockUnitService.update(stockUnit)).thenThrow(exception);
		
		// When
		String viewName = stockUnitController.update(stockUnit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockUnit/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockUnit, (StockUnit) modelMap.get("stockUnit"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockUnit/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockUnit.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockUnit stockUnit = stockUnitFactoryForTest.newStockUnit();
		Integer id = stockUnit.getId();
		
		// When
		String viewName = stockUnitController.delete(redirectAttributes, id);
		
		// Then
		verify(stockUnitService).delete(id);
		assertEquals("redirect:/stockUnit", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockUnit stockUnit = stockUnitFactoryForTest.newStockUnit();
		Integer id = stockUnit.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockUnitService).delete(id);
		
		// When
		String viewName = stockUnitController.delete(redirectAttributes, id);
		
		// Then
		verify(stockUnitService).delete(id);
		assertEquals("redirect:/stockUnit", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockUnit.error.delete", exception);
	}
	
	
}
