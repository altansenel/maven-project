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
import org.demo.bean.StockDepot;
import org.demo.test.StockDepotFactoryForTest;

//--- Services 
import org.demo.business.service.StockDepotService;


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
public class StockDepotControllerTest {
	
	@InjectMocks
	private StockDepotController stockDepotController;
	@Mock
	private StockDepotService stockDepotService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockDepot> list = new ArrayList<StockDepot>();
		when(stockDepotService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockDepotController.list(model);
		
		// Then
		assertEquals("stockDepot/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockDepotController.formForCreate(model);
		
		// Then
		assertEquals("stockDepot/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockDepot)modelMap.get("stockDepot")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockDepot/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();
		Integer id = stockDepot.getId();
		when(stockDepotService.findById(id)).thenReturn(stockDepot);
		
		// When
		String viewName = stockDepotController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockDepot/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockDepot, (StockDepot) modelMap.get("stockDepot"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockDepot/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockDepot stockDepotCreated = new StockDepot();
		when(stockDepotService.create(stockDepot)).thenReturn(stockDepotCreated); 
		
		// When
		String viewName = stockDepotController.create(stockDepot, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockDepot/form/"+stockDepot.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockDepotCreated, (StockDepot) modelMap.get("stockDepot"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockDepotController.create(stockDepot, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockDepot/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockDepot, (StockDepot) modelMap.get("stockDepot"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockDepot/create", modelMap.get("saveAction"));
		
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

		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();
		
		Exception exception = new RuntimeException("test exception");
		when(stockDepotService.create(stockDepot)).thenThrow(exception);
		
		// When
		String viewName = stockDepotController.create(stockDepot, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockDepot/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockDepot, (StockDepot) modelMap.get("stockDepot"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockDepot/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockDepot.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();
		Integer id = stockDepot.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockDepot stockDepotSaved = new StockDepot();
		stockDepotSaved.setId(id);
		when(stockDepotService.update(stockDepot)).thenReturn(stockDepotSaved); 
		
		// When
		String viewName = stockDepotController.update(stockDepot, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockDepot/form/"+stockDepot.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockDepotSaved, (StockDepot) modelMap.get("stockDepot"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockDepotController.update(stockDepot, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockDepot/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockDepot, (StockDepot) modelMap.get("stockDepot"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockDepot/update", modelMap.get("saveAction"));
		
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

		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();
		
		Exception exception = new RuntimeException("test exception");
		when(stockDepotService.update(stockDepot)).thenThrow(exception);
		
		// When
		String viewName = stockDepotController.update(stockDepot, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockDepot/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockDepot, (StockDepot) modelMap.get("stockDepot"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockDepot/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockDepot.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();
		Integer id = stockDepot.getId();
		
		// When
		String viewName = stockDepotController.delete(redirectAttributes, id);
		
		// Then
		verify(stockDepotService).delete(id);
		assertEquals("redirect:/stockDepot", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockDepot stockDepot = stockDepotFactoryForTest.newStockDepot();
		Integer id = stockDepot.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockDepotService).delete(id);
		
		// When
		String viewName = stockDepotController.delete(redirectAttributes, id);
		
		// Then
		verify(stockDepotService).delete(id);
		assertEquals("redirect:/stockDepot", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockDepot.error.delete", exception);
	}
	
	
}
