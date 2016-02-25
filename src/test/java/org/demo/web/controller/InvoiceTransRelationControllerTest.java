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
import org.demo.bean.InvoiceTransRelation;
import org.demo.bean.InvoiceTrans;
import org.demo.test.InvoiceTransRelationFactoryForTest;
import org.demo.test.InvoiceTransFactoryForTest;

//--- Services 
import org.demo.business.service.InvoiceTransRelationService;
import org.demo.business.service.InvoiceTransService;

//--- List Items 
import org.demo.web.listitem.InvoiceTransListItem;

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
public class InvoiceTransRelationControllerTest {
	
	@InjectMocks
	private InvoiceTransRelationController invoiceTransRelationController;
	@Mock
	private InvoiceTransRelationService invoiceTransRelationService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private InvoiceTransService invoiceTransService; // Injected by Spring

	private InvoiceTransRelationFactoryForTest invoiceTransRelationFactoryForTest = new InvoiceTransRelationFactoryForTest();
	private InvoiceTransFactoryForTest invoiceTransFactoryForTest = new InvoiceTransFactoryForTest();

	List<InvoiceTrans> invoiceTranss = new ArrayList<InvoiceTrans>();

	private void givenPopulateModel() {
		InvoiceTrans invoiceTrans1 = invoiceTransFactoryForTest.newInvoiceTrans();
		InvoiceTrans invoiceTrans2 = invoiceTransFactoryForTest.newInvoiceTrans();
		List<InvoiceTrans> invoiceTranss = new ArrayList<InvoiceTrans>();
		invoiceTranss.add(invoiceTrans1);
		invoiceTranss.add(invoiceTrans2);
		when(invoiceTransService.findAll()).thenReturn(invoiceTranss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<InvoiceTransRelation> list = new ArrayList<InvoiceTransRelation>();
		when(invoiceTransRelationService.findAll()).thenReturn(list);
		
		// When
		String viewName = invoiceTransRelationController.list(model);
		
		// Then
		assertEquals("invoiceTransRelation/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = invoiceTransRelationController.formForCreate(model);
		
		// Then
		assertEquals("invoiceTransRelation/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((InvoiceTransRelation)modelMap.get("invoiceTransRelation")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransRelation/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransRelation invoiceTransRelation = invoiceTransRelationFactoryForTest.newInvoiceTransRelation();
		Integer id = invoiceTransRelation.getId();
		when(invoiceTransRelationService.findById(id)).thenReturn(invoiceTransRelation);
		
		// When
		String viewName = invoiceTransRelationController.formForUpdate(model, id);
		
		// Then
		assertEquals("invoiceTransRelation/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransRelation, (InvoiceTransRelation) modelMap.get("invoiceTransRelation"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransRelation/update", modelMap.get("saveAction"));
		
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransRelation invoiceTransRelation = invoiceTransRelationFactoryForTest.newInvoiceTransRelation();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransRelation invoiceTransRelationCreated = new InvoiceTransRelation();
		when(invoiceTransRelationService.create(invoiceTransRelation)).thenReturn(invoiceTransRelationCreated); 
		
		// When
		String viewName = invoiceTransRelationController.create(invoiceTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransRelation/form/"+invoiceTransRelation.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransRelationCreated, (InvoiceTransRelation) modelMap.get("invoiceTransRelation"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransRelation invoiceTransRelation = invoiceTransRelationFactoryForTest.newInvoiceTransRelation();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransRelationController.create(invoiceTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransRelation/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransRelation, (InvoiceTransRelation) modelMap.get("invoiceTransRelation"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransRelation/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
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

		InvoiceTransRelation invoiceTransRelation = invoiceTransRelationFactoryForTest.newInvoiceTransRelation();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransRelationService.create(invoiceTransRelation)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransRelationController.create(invoiceTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransRelation/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransRelation, (InvoiceTransRelation) modelMap.get("invoiceTransRelation"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransRelation/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransRelation.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransRelation invoiceTransRelation = invoiceTransRelationFactoryForTest.newInvoiceTransRelation();
		Integer id = invoiceTransRelation.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransRelation invoiceTransRelationSaved = new InvoiceTransRelation();
		invoiceTransRelationSaved.setId(id);
		when(invoiceTransRelationService.update(invoiceTransRelation)).thenReturn(invoiceTransRelationSaved); 
		
		// When
		String viewName = invoiceTransRelationController.update(invoiceTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransRelation/form/"+invoiceTransRelation.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransRelationSaved, (InvoiceTransRelation) modelMap.get("invoiceTransRelation"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransRelation invoiceTransRelation = invoiceTransRelationFactoryForTest.newInvoiceTransRelation();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransRelationController.update(invoiceTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransRelation/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransRelation, (InvoiceTransRelation) modelMap.get("invoiceTransRelation"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransRelation/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
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

		InvoiceTransRelation invoiceTransRelation = invoiceTransRelationFactoryForTest.newInvoiceTransRelation();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransRelationService.update(invoiceTransRelation)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransRelationController.update(invoiceTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransRelation/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransRelation, (InvoiceTransRelation) modelMap.get("invoiceTransRelation"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransRelation/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransRelation.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransRelation invoiceTransRelation = invoiceTransRelationFactoryForTest.newInvoiceTransRelation();
		Integer id = invoiceTransRelation.getId();
		
		// When
		String viewName = invoiceTransRelationController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransRelationService).delete(id);
		assertEquals("redirect:/invoiceTransRelation", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransRelation invoiceTransRelation = invoiceTransRelationFactoryForTest.newInvoiceTransRelation();
		Integer id = invoiceTransRelation.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(invoiceTransRelationService).delete(id);
		
		// When
		String viewName = invoiceTransRelationController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransRelationService).delete(id);
		assertEquals("redirect:/invoiceTransRelation", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "invoiceTransRelation.error.delete", exception);
	}
	
	
}
