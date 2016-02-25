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
import org.demo.bean.OrderTransFactor;
import org.demo.bean.StockCostFactor;
import org.demo.bean.OrderTrans;
import org.demo.test.OrderTransFactorFactoryForTest;
import org.demo.test.StockCostFactorFactoryForTest;
import org.demo.test.OrderTransFactoryForTest;

//--- Services 
import org.demo.business.service.OrderTransFactorService;
import org.demo.business.service.StockCostFactorService;
import org.demo.business.service.OrderTransService;

//--- List Items 
import org.demo.web.listitem.StockCostFactorListItem;
import org.demo.web.listitem.OrderTransListItem;

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
public class OrderTransFactorControllerTest {
	
	@InjectMocks
	private OrderTransFactorController orderTransFactorController;
	@Mock
	private OrderTransFactorService orderTransFactorService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockCostFactorService stockCostFactorService; // Injected by Spring
	@Mock
	private OrderTransService orderTransService; // Injected by Spring

	private OrderTransFactorFactoryForTest orderTransFactorFactoryForTest = new OrderTransFactorFactoryForTest();
	private StockCostFactorFactoryForTest stockCostFactorFactoryForTest = new StockCostFactorFactoryForTest();
	private OrderTransFactoryForTest orderTransFactoryForTest = new OrderTransFactoryForTest();

	List<StockCostFactor> stockCostFactors = new ArrayList<StockCostFactor>();
	List<OrderTrans> orderTranss = new ArrayList<OrderTrans>();

	private void givenPopulateModel() {
		StockCostFactor stockCostFactor1 = stockCostFactorFactoryForTest.newStockCostFactor();
		StockCostFactor stockCostFactor2 = stockCostFactorFactoryForTest.newStockCostFactor();
		List<StockCostFactor> stockCostFactors = new ArrayList<StockCostFactor>();
		stockCostFactors.add(stockCostFactor1);
		stockCostFactors.add(stockCostFactor2);
		when(stockCostFactorService.findAll()).thenReturn(stockCostFactors);

		OrderTrans orderTrans1 = orderTransFactoryForTest.newOrderTrans();
		OrderTrans orderTrans2 = orderTransFactoryForTest.newOrderTrans();
		List<OrderTrans> orderTranss = new ArrayList<OrderTrans>();
		orderTranss.add(orderTrans1);
		orderTranss.add(orderTrans2);
		when(orderTransService.findAll()).thenReturn(orderTranss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<OrderTransFactor> list = new ArrayList<OrderTransFactor>();
		when(orderTransFactorService.findAll()).thenReturn(list);
		
		// When
		String viewName = orderTransFactorController.list(model);
		
		// Then
		assertEquals("orderTransFactor/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = orderTransFactorController.formForCreate(model);
		
		// Then
		assertEquals("orderTransFactor/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((OrderTransFactor)modelMap.get("orderTransFactor")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransFactor/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransFactor orderTransFactor = orderTransFactorFactoryForTest.newOrderTransFactor();
		Integer id = orderTransFactor.getId();
		when(orderTransFactorService.findById(id)).thenReturn(orderTransFactor);
		
		// When
		String viewName = orderTransFactorController.formForUpdate(model, id);
		
		// Then
		assertEquals("orderTransFactor/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransFactor, (OrderTransFactor) modelMap.get("orderTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransFactor/update", modelMap.get("saveAction"));
		
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTransFactor orderTransFactor = orderTransFactorFactoryForTest.newOrderTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTransFactor orderTransFactorCreated = new OrderTransFactor();
		when(orderTransFactorService.create(orderTransFactor)).thenReturn(orderTransFactorCreated); 
		
		// When
		String viewName = orderTransFactorController.create(orderTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTransFactor/form/"+orderTransFactor.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransFactorCreated, (OrderTransFactor) modelMap.get("orderTransFactor"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransFactor orderTransFactor = orderTransFactorFactoryForTest.newOrderTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransFactorController.create(orderTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransFactor, (OrderTransFactor) modelMap.get("orderTransFactor"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransFactor/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
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

		OrderTransFactor orderTransFactor = orderTransFactorFactoryForTest.newOrderTransFactor();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransFactorService.create(orderTransFactor)).thenThrow(exception);
		
		// When
		String viewName = orderTransFactorController.create(orderTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransFactor, (OrderTransFactor) modelMap.get("orderTransFactor"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransFactor/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTransFactor.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTransFactor orderTransFactor = orderTransFactorFactoryForTest.newOrderTransFactor();
		Integer id = orderTransFactor.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTransFactor orderTransFactorSaved = new OrderTransFactor();
		orderTransFactorSaved.setId(id);
		when(orderTransFactorService.update(orderTransFactor)).thenReturn(orderTransFactorSaved); 
		
		// When
		String viewName = orderTransFactorController.update(orderTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTransFactor/form/"+orderTransFactor.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransFactorSaved, (OrderTransFactor) modelMap.get("orderTransFactor"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransFactor orderTransFactor = orderTransFactorFactoryForTest.newOrderTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransFactorController.update(orderTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransFactor, (OrderTransFactor) modelMap.get("orderTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransFactor/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
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

		OrderTransFactor orderTransFactor = orderTransFactorFactoryForTest.newOrderTransFactor();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransFactorService.update(orderTransFactor)).thenThrow(exception);
		
		// When
		String viewName = orderTransFactorController.update(orderTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransFactor, (OrderTransFactor) modelMap.get("orderTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransFactor/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTransFactor.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTransFactor orderTransFactor = orderTransFactorFactoryForTest.newOrderTransFactor();
		Integer id = orderTransFactor.getId();
		
		// When
		String viewName = orderTransFactorController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransFactorService).delete(id);
		assertEquals("redirect:/orderTransFactor", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTransFactor orderTransFactor = orderTransFactorFactoryForTest.newOrderTransFactor();
		Integer id = orderTransFactor.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(orderTransFactorService).delete(id);
		
		// When
		String viewName = orderTransFactorController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransFactorService).delete(id);
		assertEquals("redirect:/orderTransFactor", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "orderTransFactor.error.delete", exception);
	}
	
	
}
