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
import org.demo.bean.InvoiceTransTax;
import org.demo.bean.InvoiceTrans;
import org.demo.test.InvoiceTransTaxFactoryForTest;
import org.demo.test.InvoiceTransFactoryForTest;

//--- Services 
import org.demo.business.service.InvoiceTransTaxService;
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
public class InvoiceTransTaxControllerTest {
	
	@InjectMocks
	private InvoiceTransTaxController invoiceTransTaxController;
	@Mock
	private InvoiceTransTaxService invoiceTransTaxService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private InvoiceTransService invoiceTransService; // Injected by Spring

	private InvoiceTransTaxFactoryForTest invoiceTransTaxFactoryForTest = new InvoiceTransTaxFactoryForTest();
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
		
		List<InvoiceTransTax> list = new ArrayList<InvoiceTransTax>();
		when(invoiceTransTaxService.findAll()).thenReturn(list);
		
		// When
		String viewName = invoiceTransTaxController.list(model);
		
		// Then
		assertEquals("invoiceTransTax/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = invoiceTransTaxController.formForCreate(model);
		
		// Then
		assertEquals("invoiceTransTax/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((InvoiceTransTax)modelMap.get("invoiceTransTax")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransTax/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		Integer id = invoiceTransTax.getId();
		when(invoiceTransTaxService.findById(id)).thenReturn(invoiceTransTax);
		
		// When
		String viewName = invoiceTransTaxController.formForUpdate(model, id);
		
		// Then
		assertEquals("invoiceTransTax/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransTax, (InvoiceTransTax) modelMap.get("invoiceTransTax"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransTax/update", modelMap.get("saveAction"));
		
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransTax invoiceTransTaxCreated = new InvoiceTransTax();
		when(invoiceTransTaxService.create(invoiceTransTax)).thenReturn(invoiceTransTaxCreated); 
		
		// When
		String viewName = invoiceTransTaxController.create(invoiceTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransTax/form/"+invoiceTransTax.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransTaxCreated, (InvoiceTransTax) modelMap.get("invoiceTransTax"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransTaxController.create(invoiceTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransTax/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransTax, (InvoiceTransTax) modelMap.get("invoiceTransTax"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransTax/create", modelMap.get("saveAction"));
		
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

		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransTaxService.create(invoiceTransTax)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransTaxController.create(invoiceTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransTax/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransTax, (InvoiceTransTax) modelMap.get("invoiceTransTax"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransTax/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransTax.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		Integer id = invoiceTransTax.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransTax invoiceTransTaxSaved = new InvoiceTransTax();
		invoiceTransTaxSaved.setId(id);
		when(invoiceTransTaxService.update(invoiceTransTax)).thenReturn(invoiceTransTaxSaved); 
		
		// When
		String viewName = invoiceTransTaxController.update(invoiceTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransTax/form/"+invoiceTransTax.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransTaxSaved, (InvoiceTransTax) modelMap.get("invoiceTransTax"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransTaxController.update(invoiceTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransTax/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransTax, (InvoiceTransTax) modelMap.get("invoiceTransTax"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransTax/update", modelMap.get("saveAction"));
		
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

		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransTaxService.update(invoiceTransTax)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransTaxController.update(invoiceTransTax, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransTax/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransTax, (InvoiceTransTax) modelMap.get("invoiceTransTax"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransTax/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransTax.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		Integer id = invoiceTransTax.getId();
		
		// When
		String viewName = invoiceTransTaxController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransTaxService).delete(id);
		assertEquals("redirect:/invoiceTransTax", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransTax invoiceTransTax = invoiceTransTaxFactoryForTest.newInvoiceTransTax();
		Integer id = invoiceTransTax.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(invoiceTransTaxService).delete(id);
		
		// When
		String viewName = invoiceTransTaxController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransTaxService).delete(id);
		assertEquals("redirect:/invoiceTransTax", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "invoiceTransTax.error.delete", exception);
	}
	
	
}
