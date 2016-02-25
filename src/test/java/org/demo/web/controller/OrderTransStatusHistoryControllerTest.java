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
import org.demo.bean.OrderTransStatusHistory;
import org.demo.test.OrderTransStatusHistoryFactoryForTest;

//--- Services 
import org.demo.business.service.OrderTransStatusHistoryService;


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
public class OrderTransStatusHistoryControllerTest {
	
	@InjectMocks
	private OrderTransStatusHistoryController orderTransStatusHistoryController;
	@Mock
	private OrderTransStatusHistoryService orderTransStatusHistoryService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private OrderTransStatusHistoryFactoryForTest orderTransStatusHistoryFactoryForTest = new OrderTransStatusHistoryFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<OrderTransStatusHistory> list = new ArrayList<OrderTransStatusHistory>();
		when(orderTransStatusHistoryService.findAll()).thenReturn(list);
		
		// When
		String viewName = orderTransStatusHistoryController.list(model);
		
		// Then
		assertEquals("orderTransStatusHistory/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = orderTransStatusHistoryController.formForCreate(model);
		
		// Then
		assertEquals("orderTransStatusHistory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((OrderTransStatusHistory)modelMap.get("orderTransStatusHistory")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransStatusHistory/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransStatusHistory orderTransStatusHistory = orderTransStatusHistoryFactoryForTest.newOrderTransStatusHistory();
		Integer id = orderTransStatusHistory.getId();
		when(orderTransStatusHistoryService.findById(id)).thenReturn(orderTransStatusHistory);
		
		// When
		String viewName = orderTransStatusHistoryController.formForUpdate(model, id);
		
		// Then
		assertEquals("orderTransStatusHistory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatusHistory, (OrderTransStatusHistory) modelMap.get("orderTransStatusHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransStatusHistory/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTransStatusHistory orderTransStatusHistory = orderTransStatusHistoryFactoryForTest.newOrderTransStatusHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTransStatusHistory orderTransStatusHistoryCreated = new OrderTransStatusHistory();
		when(orderTransStatusHistoryService.create(orderTransStatusHistory)).thenReturn(orderTransStatusHistoryCreated); 
		
		// When
		String viewName = orderTransStatusHistoryController.create(orderTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTransStatusHistory/form/"+orderTransStatusHistory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatusHistoryCreated, (OrderTransStatusHistory) modelMap.get("orderTransStatusHistory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransStatusHistory orderTransStatusHistory = orderTransStatusHistoryFactoryForTest.newOrderTransStatusHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransStatusHistoryController.create(orderTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatusHistory, (OrderTransStatusHistory) modelMap.get("orderTransStatusHistory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransStatusHistory/create", modelMap.get("saveAction"));
		
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

		OrderTransStatusHistory orderTransStatusHistory = orderTransStatusHistoryFactoryForTest.newOrderTransStatusHistory();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransStatusHistoryService.create(orderTransStatusHistory)).thenThrow(exception);
		
		// When
		String viewName = orderTransStatusHistoryController.create(orderTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatusHistory, (OrderTransStatusHistory) modelMap.get("orderTransStatusHistory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransStatusHistory/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTransStatusHistory.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTransStatusHistory orderTransStatusHistory = orderTransStatusHistoryFactoryForTest.newOrderTransStatusHistory();
		Integer id = orderTransStatusHistory.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTransStatusHistory orderTransStatusHistorySaved = new OrderTransStatusHistory();
		orderTransStatusHistorySaved.setId(id);
		when(orderTransStatusHistoryService.update(orderTransStatusHistory)).thenReturn(orderTransStatusHistorySaved); 
		
		// When
		String viewName = orderTransStatusHistoryController.update(orderTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTransStatusHistory/form/"+orderTransStatusHistory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatusHistorySaved, (OrderTransStatusHistory) modelMap.get("orderTransStatusHistory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransStatusHistory orderTransStatusHistory = orderTransStatusHistoryFactoryForTest.newOrderTransStatusHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransStatusHistoryController.update(orderTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatusHistory, (OrderTransStatusHistory) modelMap.get("orderTransStatusHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransStatusHistory/update", modelMap.get("saveAction"));
		
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

		OrderTransStatusHistory orderTransStatusHistory = orderTransStatusHistoryFactoryForTest.newOrderTransStatusHistory();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransStatusHistoryService.update(orderTransStatusHistory)).thenThrow(exception);
		
		// When
		String viewName = orderTransStatusHistoryController.update(orderTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatusHistory, (OrderTransStatusHistory) modelMap.get("orderTransStatusHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransStatusHistory/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTransStatusHistory.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTransStatusHistory orderTransStatusHistory = orderTransStatusHistoryFactoryForTest.newOrderTransStatusHistory();
		Integer id = orderTransStatusHistory.getId();
		
		// When
		String viewName = orderTransStatusHistoryController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransStatusHistoryService).delete(id);
		assertEquals("redirect:/orderTransStatusHistory", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTransStatusHistory orderTransStatusHistory = orderTransStatusHistoryFactoryForTest.newOrderTransStatusHistory();
		Integer id = orderTransStatusHistory.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(orderTransStatusHistoryService).delete(id);
		
		// When
		String viewName = orderTransStatusHistoryController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransStatusHistoryService).delete(id);
		assertEquals("redirect:/orderTransStatusHistory", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "orderTransStatusHistory.error.delete", exception);
	}
	
	
}
