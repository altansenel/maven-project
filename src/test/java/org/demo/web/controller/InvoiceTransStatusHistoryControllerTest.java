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
import org.demo.bean.InvoiceTransStatusHistory;
import org.demo.test.InvoiceTransStatusHistoryFactoryForTest;

//--- Services 
import org.demo.business.service.InvoiceTransStatusHistoryService;


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
public class InvoiceTransStatusHistoryControllerTest {
	
	@InjectMocks
	private InvoiceTransStatusHistoryController invoiceTransStatusHistoryController;
	@Mock
	private InvoiceTransStatusHistoryService invoiceTransStatusHistoryService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private InvoiceTransStatusHistoryFactoryForTest invoiceTransStatusHistoryFactoryForTest = new InvoiceTransStatusHistoryFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<InvoiceTransStatusHistory> list = new ArrayList<InvoiceTransStatusHistory>();
		when(invoiceTransStatusHistoryService.findAll()).thenReturn(list);
		
		// When
		String viewName = invoiceTransStatusHistoryController.list(model);
		
		// Then
		assertEquals("invoiceTransStatusHistory/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = invoiceTransStatusHistoryController.formForCreate(model);
		
		// Then
		assertEquals("invoiceTransStatusHistory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((InvoiceTransStatusHistory)modelMap.get("invoiceTransStatusHistory")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransStatusHistory/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransStatusHistory invoiceTransStatusHistory = invoiceTransStatusHistoryFactoryForTest.newInvoiceTransStatusHistory();
		Integer id = invoiceTransStatusHistory.getId();
		when(invoiceTransStatusHistoryService.findById(id)).thenReturn(invoiceTransStatusHistory);
		
		// When
		String viewName = invoiceTransStatusHistoryController.formForUpdate(model, id);
		
		// Then
		assertEquals("invoiceTransStatusHistory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatusHistory, (InvoiceTransStatusHistory) modelMap.get("invoiceTransStatusHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransStatusHistory/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransStatusHistory invoiceTransStatusHistory = invoiceTransStatusHistoryFactoryForTest.newInvoiceTransStatusHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransStatusHistory invoiceTransStatusHistoryCreated = new InvoiceTransStatusHistory();
		when(invoiceTransStatusHistoryService.create(invoiceTransStatusHistory)).thenReturn(invoiceTransStatusHistoryCreated); 
		
		// When
		String viewName = invoiceTransStatusHistoryController.create(invoiceTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransStatusHistory/form/"+invoiceTransStatusHistory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatusHistoryCreated, (InvoiceTransStatusHistory) modelMap.get("invoiceTransStatusHistory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransStatusHistory invoiceTransStatusHistory = invoiceTransStatusHistoryFactoryForTest.newInvoiceTransStatusHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransStatusHistoryController.create(invoiceTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatusHistory, (InvoiceTransStatusHistory) modelMap.get("invoiceTransStatusHistory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransStatusHistory/create", modelMap.get("saveAction"));
		
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

		InvoiceTransStatusHistory invoiceTransStatusHistory = invoiceTransStatusHistoryFactoryForTest.newInvoiceTransStatusHistory();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransStatusHistoryService.create(invoiceTransStatusHistory)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransStatusHistoryController.create(invoiceTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatusHistory, (InvoiceTransStatusHistory) modelMap.get("invoiceTransStatusHistory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransStatusHistory/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransStatusHistory.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransStatusHistory invoiceTransStatusHistory = invoiceTransStatusHistoryFactoryForTest.newInvoiceTransStatusHistory();
		Integer id = invoiceTransStatusHistory.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransStatusHistory invoiceTransStatusHistorySaved = new InvoiceTransStatusHistory();
		invoiceTransStatusHistorySaved.setId(id);
		when(invoiceTransStatusHistoryService.update(invoiceTransStatusHistory)).thenReturn(invoiceTransStatusHistorySaved); 
		
		// When
		String viewName = invoiceTransStatusHistoryController.update(invoiceTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransStatusHistory/form/"+invoiceTransStatusHistory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatusHistorySaved, (InvoiceTransStatusHistory) modelMap.get("invoiceTransStatusHistory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransStatusHistory invoiceTransStatusHistory = invoiceTransStatusHistoryFactoryForTest.newInvoiceTransStatusHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransStatusHistoryController.update(invoiceTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatusHistory, (InvoiceTransStatusHistory) modelMap.get("invoiceTransStatusHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransStatusHistory/update", modelMap.get("saveAction"));
		
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

		InvoiceTransStatusHistory invoiceTransStatusHistory = invoiceTransStatusHistoryFactoryForTest.newInvoiceTransStatusHistory();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransStatusHistoryService.update(invoiceTransStatusHistory)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransStatusHistoryController.update(invoiceTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatusHistory, (InvoiceTransStatusHistory) modelMap.get("invoiceTransStatusHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransStatusHistory/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransStatusHistory.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransStatusHistory invoiceTransStatusHistory = invoiceTransStatusHistoryFactoryForTest.newInvoiceTransStatusHistory();
		Integer id = invoiceTransStatusHistory.getId();
		
		// When
		String viewName = invoiceTransStatusHistoryController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransStatusHistoryService).delete(id);
		assertEquals("redirect:/invoiceTransStatusHistory", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransStatusHistory invoiceTransStatusHistory = invoiceTransStatusHistoryFactoryForTest.newInvoiceTransStatusHistory();
		Integer id = invoiceTransStatusHistory.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(invoiceTransStatusHistoryService).delete(id);
		
		// When
		String viewName = invoiceTransStatusHistoryController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransStatusHistoryService).delete(id);
		assertEquals("redirect:/invoiceTransStatusHistory", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "invoiceTransStatusHistory.error.delete", exception);
	}
	
	
}
