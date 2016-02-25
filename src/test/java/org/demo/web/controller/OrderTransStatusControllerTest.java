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
import org.demo.bean.OrderTransStatus;
//--- Services 
import org.demo.business.service.OrderTransStatusService;
import org.demo.test.OrderTransStatusFactoryForTest;
import org.demo.web.common.Message;
import org.demo.web.common.MessageHelper;
import org.demo.web.common.MessageType;
//--- List Items 
import org.demo.web.listitem.OrderTransStatusListItem;
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
public class OrderTransStatusControllerTest {
	
	@InjectMocks
	private OrderTransStatusController orderTransStatusController;
	@Mock
	private OrderTransStatusService orderTransStatusService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private OrderTransStatusFactoryForTest orderTransStatusFactoryForTest = new OrderTransStatusFactoryForTest();

	List<OrderTransStatus> orderTransStatuss = new ArrayList<OrderTransStatus>();

	private void givenPopulateModel() {
		OrderTransStatus orderTransStatus1 = orderTransStatusFactoryForTest.newOrderTransStatus();
		OrderTransStatus orderTransStatus2 = orderTransStatusFactoryForTest.newOrderTransStatus();
		List<OrderTransStatus> orderTransStatuss = new ArrayList<OrderTransStatus>();
		orderTransStatuss.add(orderTransStatus1);
		orderTransStatuss.add(orderTransStatus2);
		when(orderTransStatusService.findAll()).thenReturn(orderTransStatuss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<OrderTransStatus> list = new ArrayList<OrderTransStatus>();
		when(orderTransStatusService.findAll()).thenReturn(list);
		
		// When
		String viewName = orderTransStatusController.list(model);
		
		// Then
		assertEquals("orderTransStatus/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = orderTransStatusController.formForCreate(model);
		
		// Then
		assertEquals("orderTransStatus/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((OrderTransStatus)modelMap.get("orderTransStatus")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransStatus/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();
		Integer id = orderTransStatus.getId();
		when(orderTransStatusService.findById(id)).thenReturn(orderTransStatus);
		
		// When
		String viewName = orderTransStatusController.formForUpdate(model, id);
		
		// Then
		assertEquals("orderTransStatus/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatus, (OrderTransStatus) modelMap.get("orderTransStatus"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransStatus/update", modelMap.get("saveAction"));
		
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTransStatus orderTransStatusCreated = new OrderTransStatus();
		when(orderTransStatusService.create(orderTransStatus)).thenReturn(orderTransStatusCreated); 
		
		// When
		String viewName = orderTransStatusController.create(orderTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTransStatus/form/"+orderTransStatus.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatusCreated, (OrderTransStatus) modelMap.get("orderTransStatus"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransStatusController.create(orderTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatus, (OrderTransStatus) modelMap.get("orderTransStatus"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransStatus/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
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

		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransStatusService.create(orderTransStatus)).thenThrow(exception);
		
		// When
		String viewName = orderTransStatusController.create(orderTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatus, (OrderTransStatus) modelMap.get("orderTransStatus"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransStatus/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTransStatus.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();
		Integer id = orderTransStatus.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTransStatus orderTransStatusSaved = new OrderTransStatus();
		orderTransStatusSaved.setId(id);
		when(orderTransStatusService.update(orderTransStatus)).thenReturn(orderTransStatusSaved); 
		
		// When
		String viewName = orderTransStatusController.update(orderTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTransStatus/form/"+orderTransStatus.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatusSaved, (OrderTransStatus) modelMap.get("orderTransStatus"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransStatusController.update(orderTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatus, (OrderTransStatus) modelMap.get("orderTransStatus"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransStatus/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
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

		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransStatusService.update(orderTransStatus)).thenThrow(exception);
		
		// When
		String viewName = orderTransStatusController.update(orderTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransStatus, (OrderTransStatus) modelMap.get("orderTransStatus"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransStatus/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTransStatus.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();
		Integer id = orderTransStatus.getId();
		
		// When
		String viewName = orderTransStatusController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransStatusService).delete(id);
		assertEquals("redirect:/orderTransStatus", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTransStatus orderTransStatus = orderTransStatusFactoryForTest.newOrderTransStatus();
		Integer id = orderTransStatus.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(orderTransStatusService).delete(id);
		
		// When
		String viewName = orderTransStatusController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransStatusService).delete(id);
		assertEquals("redirect:/orderTransStatus", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "orderTransStatus.error.delete", exception);
	}
	
	
}
