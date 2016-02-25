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
import org.demo.bean.StockTransFactor;
import org.demo.bean.StockCostFactor;
import org.demo.bean.StockTrans;
import org.demo.test.StockTransFactorFactoryForTest;
import org.demo.test.StockCostFactorFactoryForTest;
import org.demo.test.StockTransFactoryForTest;

//--- Services 
import org.demo.business.service.StockTransFactorService;
import org.demo.business.service.StockCostFactorService;
import org.demo.business.service.StockTransService;

//--- List Items 
import org.demo.web.listitem.StockCostFactorListItem;
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
public class StockTransFactorControllerTest {
	
	@InjectMocks
	private StockTransFactorController stockTransFactorController;
	@Mock
	private StockTransFactorService stockTransFactorService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockCostFactorService stockCostFactorService; // Injected by Spring
	@Mock
	private StockTransService stockTransService; // Injected by Spring

	private StockTransFactorFactoryForTest stockTransFactorFactoryForTest = new StockTransFactorFactoryForTest();
	private StockCostFactorFactoryForTest stockCostFactorFactoryForTest = new StockCostFactorFactoryForTest();
	private StockTransFactoryForTest stockTransFactoryForTest = new StockTransFactoryForTest();

	List<StockCostFactor> stockCostFactors = new ArrayList<StockCostFactor>();
	List<StockTrans> stockTranss = new ArrayList<StockTrans>();

	private void givenPopulateModel() {
		StockCostFactor stockCostFactor1 = stockCostFactorFactoryForTest.newStockCostFactor();
		StockCostFactor stockCostFactor2 = stockCostFactorFactoryForTest.newStockCostFactor();
		List<StockCostFactor> stockCostFactors = new ArrayList<StockCostFactor>();
		stockCostFactors.add(stockCostFactor1);
		stockCostFactors.add(stockCostFactor2);
		when(stockCostFactorService.findAll()).thenReturn(stockCostFactors);

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
		
		List<StockTransFactor> list = new ArrayList<StockTransFactor>();
		when(stockTransFactorService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockTransFactorController.list(model);
		
		// Then
		assertEquals("stockTransFactor/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockTransFactorController.formForCreate(model);
		
		// Then
		assertEquals("stockTransFactor/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockTransFactor)modelMap.get("stockTransFactor")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransFactor/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransFactor stockTransFactor = stockTransFactorFactoryForTest.newStockTransFactor();
		Integer id = stockTransFactor.getId();
		when(stockTransFactorService.findById(id)).thenReturn(stockTransFactor);
		
		// When
		String viewName = stockTransFactorController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockTransFactor/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransFactor, (StockTransFactor) modelMap.get("stockTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransFactor/update", modelMap.get("saveAction"));
		
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTransFactor stockTransFactor = stockTransFactorFactoryForTest.newStockTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTransFactor stockTransFactorCreated = new StockTransFactor();
		when(stockTransFactorService.create(stockTransFactor)).thenReturn(stockTransFactorCreated); 
		
		// When
		String viewName = stockTransFactorController.create(stockTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTransFactor/form/"+stockTransFactor.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransFactorCreated, (StockTransFactor) modelMap.get("stockTransFactor"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransFactor stockTransFactor = stockTransFactorFactoryForTest.newStockTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransFactorController.create(stockTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransFactor, (StockTransFactor) modelMap.get("stockTransFactor"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransFactor/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
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

		StockTransFactor stockTransFactor = stockTransFactorFactoryForTest.newStockTransFactor();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransFactorService.create(stockTransFactor)).thenThrow(exception);
		
		// When
		String viewName = stockTransFactorController.create(stockTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransFactor, (StockTransFactor) modelMap.get("stockTransFactor"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransFactor/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTransFactor.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTransFactor stockTransFactor = stockTransFactorFactoryForTest.newStockTransFactor();
		Integer id = stockTransFactor.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTransFactor stockTransFactorSaved = new StockTransFactor();
		stockTransFactorSaved.setId(id);
		when(stockTransFactorService.update(stockTransFactor)).thenReturn(stockTransFactorSaved); 
		
		// When
		String viewName = stockTransFactorController.update(stockTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTransFactor/form/"+stockTransFactor.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransFactorSaved, (StockTransFactor) modelMap.get("stockTransFactor"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransFactor stockTransFactor = stockTransFactorFactoryForTest.newStockTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransFactorController.update(stockTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransFactor, (StockTransFactor) modelMap.get("stockTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransFactor/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
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

		StockTransFactor stockTransFactor = stockTransFactorFactoryForTest.newStockTransFactor();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransFactorService.update(stockTransFactor)).thenThrow(exception);
		
		// When
		String viewName = stockTransFactorController.update(stockTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransFactor, (StockTransFactor) modelMap.get("stockTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransFactor/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTransFactor.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTransFactor stockTransFactor = stockTransFactorFactoryForTest.newStockTransFactor();
		Integer id = stockTransFactor.getId();
		
		// When
		String viewName = stockTransFactorController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransFactorService).delete(id);
		assertEquals("redirect:/stockTransFactor", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTransFactor stockTransFactor = stockTransFactorFactoryForTest.newStockTransFactor();
		Integer id = stockTransFactor.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockTransFactorService).delete(id);
		
		// When
		String viewName = stockTransFactorController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransFactorService).delete(id);
		assertEquals("redirect:/stockTransFactor", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockTransFactor.error.delete", exception);
	}
	
	
}
