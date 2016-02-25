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
import org.demo.bean.InvoiceTransStatus;
//--- Services 
import org.demo.business.service.InvoiceTransStatusService;
import org.demo.test.InvoiceTransStatusFactoryForTest;
import org.demo.web.common.Message;
import org.demo.web.common.MessageHelper;
import org.demo.web.common.MessageType;
//--- List Items 
import org.demo.web.listitem.InvoiceTransStatusListItem;
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
public class InvoiceTransStatusControllerTest {
	
	@InjectMocks
	private InvoiceTransStatusController invoiceTransStatusController;
	@Mock
	private InvoiceTransStatusService invoiceTransStatusService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private InvoiceTransStatusFactoryForTest invoiceTransStatusFactoryForTest = new InvoiceTransStatusFactoryForTest();

	List<InvoiceTransStatus> invoiceTransStatuss = new ArrayList<InvoiceTransStatus>();

	private void givenPopulateModel() {
		InvoiceTransStatus invoiceTransStatus1 = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		InvoiceTransStatus invoiceTransStatus2 = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		List<InvoiceTransStatus> invoiceTransStatuss = new ArrayList<InvoiceTransStatus>();
		invoiceTransStatuss.add(invoiceTransStatus1);
		invoiceTransStatuss.add(invoiceTransStatus2);
		when(invoiceTransStatusService.findAll()).thenReturn(invoiceTransStatuss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<InvoiceTransStatus> list = new ArrayList<InvoiceTransStatus>();
		when(invoiceTransStatusService.findAll()).thenReturn(list);
		
		// When
		String viewName = invoiceTransStatusController.list(model);
		
		// Then
		assertEquals("invoiceTransStatus/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = invoiceTransStatusController.formForCreate(model);
		
		// Then
		assertEquals("invoiceTransStatus/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((InvoiceTransStatus)modelMap.get("invoiceTransStatus")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransStatus/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransStatus invoiceTransStatus = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		Integer id = invoiceTransStatus.getId();
		when(invoiceTransStatusService.findById(id)).thenReturn(invoiceTransStatus);
		
		// When
		String viewName = invoiceTransStatusController.formForUpdate(model, id);
		
		// Then
		assertEquals("invoiceTransStatus/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatus, (InvoiceTransStatus) modelMap.get("invoiceTransStatus"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransStatus/update", modelMap.get("saveAction"));
		
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransStatus invoiceTransStatus = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransStatus invoiceTransStatusCreated = new InvoiceTransStatus();
		when(invoiceTransStatusService.create(invoiceTransStatus)).thenReturn(invoiceTransStatusCreated); 
		
		// When
		String viewName = invoiceTransStatusController.create(invoiceTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransStatus/form/"+invoiceTransStatus.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatusCreated, (InvoiceTransStatus) modelMap.get("invoiceTransStatus"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransStatus invoiceTransStatus = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransStatusController.create(invoiceTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatus, (InvoiceTransStatus) modelMap.get("invoiceTransStatus"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransStatus/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
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

		InvoiceTransStatus invoiceTransStatus = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransStatusService.create(invoiceTransStatus)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransStatusController.create(invoiceTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatus, (InvoiceTransStatus) modelMap.get("invoiceTransStatus"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransStatus/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransStatus.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransStatus invoiceTransStatus = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		Integer id = invoiceTransStatus.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransStatus invoiceTransStatusSaved = new InvoiceTransStatus();
		invoiceTransStatusSaved.setId(id);
		when(invoiceTransStatusService.update(invoiceTransStatus)).thenReturn(invoiceTransStatusSaved); 
		
		// When
		String viewName = invoiceTransStatusController.update(invoiceTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransStatus/form/"+invoiceTransStatus.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatusSaved, (InvoiceTransStatus) modelMap.get("invoiceTransStatus"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransStatus invoiceTransStatus = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransStatusController.update(invoiceTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatus, (InvoiceTransStatus) modelMap.get("invoiceTransStatus"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransStatus/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
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

		InvoiceTransStatus invoiceTransStatus = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransStatusService.update(invoiceTransStatus)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransStatusController.update(invoiceTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransStatus, (InvoiceTransStatus) modelMap.get("invoiceTransStatus"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransStatus/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransStatus.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransStatus invoiceTransStatus = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		Integer id = invoiceTransStatus.getId();
		
		// When
		String viewName = invoiceTransStatusController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransStatusService).delete(id);
		assertEquals("redirect:/invoiceTransStatus", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransStatus invoiceTransStatus = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		Integer id = invoiceTransStatus.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(invoiceTransStatusService).delete(id);
		
		// When
		String viewName = invoiceTransStatusController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransStatusService).delete(id);
		assertEquals("redirect:/invoiceTransStatus", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "invoiceTransStatus.error.delete", exception);
	}
	
	
}
