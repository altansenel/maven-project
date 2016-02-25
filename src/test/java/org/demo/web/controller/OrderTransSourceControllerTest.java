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
import org.demo.bean.OrderTransSource;
import org.demo.test.OrderTransSourceFactoryForTest;

//--- Services 
import org.demo.business.service.OrderTransSourceService;


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
public class OrderTransSourceControllerTest {
	
	@InjectMocks
	private OrderTransSourceController orderTransSourceController;
	@Mock
	private OrderTransSourceService orderTransSourceService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private OrderTransSourceFactoryForTest orderTransSourceFactoryForTest = new OrderTransSourceFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<OrderTransSource> list = new ArrayList<OrderTransSource>();
		when(orderTransSourceService.findAll()).thenReturn(list);
		
		// When
		String viewName = orderTransSourceController.list(model);
		
		// Then
		assertEquals("orderTransSource/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = orderTransSourceController.formForCreate(model);
		
		// Then
		assertEquals("orderTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((OrderTransSource)modelMap.get("orderTransSource")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransSource/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransSource orderTransSource = orderTransSourceFactoryForTest.newOrderTransSource();
		Integer id = orderTransSource.getId();
		when(orderTransSourceService.findById(id)).thenReturn(orderTransSource);
		
		// When
		String viewName = orderTransSourceController.formForUpdate(model, id);
		
		// Then
		assertEquals("orderTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransSource, (OrderTransSource) modelMap.get("orderTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransSource/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTransSource orderTransSource = orderTransSourceFactoryForTest.newOrderTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTransSource orderTransSourceCreated = new OrderTransSource();
		when(orderTransSourceService.create(orderTransSource)).thenReturn(orderTransSourceCreated); 
		
		// When
		String viewName = orderTransSourceController.create(orderTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTransSource/form/"+orderTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransSourceCreated, (OrderTransSource) modelMap.get("orderTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransSource orderTransSource = orderTransSourceFactoryForTest.newOrderTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransSourceController.create(orderTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransSource, (OrderTransSource) modelMap.get("orderTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransSource/create", modelMap.get("saveAction"));
		
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

		OrderTransSource orderTransSource = orderTransSourceFactoryForTest.newOrderTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransSourceService.create(orderTransSource)).thenThrow(exception);
		
		// When
		String viewName = orderTransSourceController.create(orderTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransSource, (OrderTransSource) modelMap.get("orderTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransSource/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTransSource.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTransSource orderTransSource = orderTransSourceFactoryForTest.newOrderTransSource();
		Integer id = orderTransSource.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTransSource orderTransSourceSaved = new OrderTransSource();
		orderTransSourceSaved.setId(id);
		when(orderTransSourceService.update(orderTransSource)).thenReturn(orderTransSourceSaved); 
		
		// When
		String viewName = orderTransSourceController.update(orderTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTransSource/form/"+orderTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransSourceSaved, (OrderTransSource) modelMap.get("orderTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransSource orderTransSource = orderTransSourceFactoryForTest.newOrderTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransSourceController.update(orderTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransSource, (OrderTransSource) modelMap.get("orderTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransSource/update", modelMap.get("saveAction"));
		
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

		OrderTransSource orderTransSource = orderTransSourceFactoryForTest.newOrderTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransSourceService.update(orderTransSource)).thenThrow(exception);
		
		// When
		String viewName = orderTransSourceController.update(orderTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransSource, (OrderTransSource) modelMap.get("orderTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransSource/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTransSource.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTransSource orderTransSource = orderTransSourceFactoryForTest.newOrderTransSource();
		Integer id = orderTransSource.getId();
		
		// When
		String viewName = orderTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransSourceService).delete(id);
		assertEquals("redirect:/orderTransSource", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTransSource orderTransSource = orderTransSourceFactoryForTest.newOrderTransSource();
		Integer id = orderTransSource.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(orderTransSourceService).delete(id);
		
		// When
		String viewName = orderTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransSourceService).delete(id);
		assertEquals("redirect:/orderTransSource", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "orderTransSource.error.delete", exception);
	}
	
	
}
