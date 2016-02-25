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
import org.demo.bean.InvoiceTransCurrency;
import org.demo.bean.InvoiceTrans;
import org.demo.test.InvoiceTransCurrencyFactoryForTest;
import org.demo.test.InvoiceTransFactoryForTest;

//--- Services 
import org.demo.business.service.InvoiceTransCurrencyService;
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
public class InvoiceTransCurrencyControllerTest {
	
	@InjectMocks
	private InvoiceTransCurrencyController invoiceTransCurrencyController;
	@Mock
	private InvoiceTransCurrencyService invoiceTransCurrencyService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private InvoiceTransService invoiceTransService; // Injected by Spring

	private InvoiceTransCurrencyFactoryForTest invoiceTransCurrencyFactoryForTest = new InvoiceTransCurrencyFactoryForTest();
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
		
		List<InvoiceTransCurrency> list = new ArrayList<InvoiceTransCurrency>();
		when(invoiceTransCurrencyService.findAll()).thenReturn(list);
		
		// When
		String viewName = invoiceTransCurrencyController.list(model);
		
		// Then
		assertEquals("invoiceTransCurrency/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = invoiceTransCurrencyController.formForCreate(model);
		
		// Then
		assertEquals("invoiceTransCurrency/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((InvoiceTransCurrency)modelMap.get("invoiceTransCurrency")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransCurrency/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransCurrency invoiceTransCurrency = invoiceTransCurrencyFactoryForTest.newInvoiceTransCurrency();
		Integer id = invoiceTransCurrency.getId();
		when(invoiceTransCurrencyService.findById(id)).thenReturn(invoiceTransCurrency);
		
		// When
		String viewName = invoiceTransCurrencyController.formForUpdate(model, id);
		
		// Then
		assertEquals("invoiceTransCurrency/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransCurrency, (InvoiceTransCurrency) modelMap.get("invoiceTransCurrency"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransCurrency/update", modelMap.get("saveAction"));
		
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransCurrency invoiceTransCurrency = invoiceTransCurrencyFactoryForTest.newInvoiceTransCurrency();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransCurrency invoiceTransCurrencyCreated = new InvoiceTransCurrency();
		when(invoiceTransCurrencyService.create(invoiceTransCurrency)).thenReturn(invoiceTransCurrencyCreated); 
		
		// When
		String viewName = invoiceTransCurrencyController.create(invoiceTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransCurrency/form/"+invoiceTransCurrency.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransCurrencyCreated, (InvoiceTransCurrency) modelMap.get("invoiceTransCurrency"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransCurrency invoiceTransCurrency = invoiceTransCurrencyFactoryForTest.newInvoiceTransCurrency();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransCurrencyController.create(invoiceTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransCurrency, (InvoiceTransCurrency) modelMap.get("invoiceTransCurrency"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransCurrency/create", modelMap.get("saveAction"));
		
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

		InvoiceTransCurrency invoiceTransCurrency = invoiceTransCurrencyFactoryForTest.newInvoiceTransCurrency();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransCurrencyService.create(invoiceTransCurrency)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransCurrencyController.create(invoiceTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransCurrency, (InvoiceTransCurrency) modelMap.get("invoiceTransCurrency"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransCurrency/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransCurrency.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransCurrency invoiceTransCurrency = invoiceTransCurrencyFactoryForTest.newInvoiceTransCurrency();
		Integer id = invoiceTransCurrency.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransCurrency invoiceTransCurrencySaved = new InvoiceTransCurrency();
		invoiceTransCurrencySaved.setId(id);
		when(invoiceTransCurrencyService.update(invoiceTransCurrency)).thenReturn(invoiceTransCurrencySaved); 
		
		// When
		String viewName = invoiceTransCurrencyController.update(invoiceTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransCurrency/form/"+invoiceTransCurrency.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransCurrencySaved, (InvoiceTransCurrency) modelMap.get("invoiceTransCurrency"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransCurrency invoiceTransCurrency = invoiceTransCurrencyFactoryForTest.newInvoiceTransCurrency();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransCurrencyController.update(invoiceTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransCurrency, (InvoiceTransCurrency) modelMap.get("invoiceTransCurrency"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransCurrency/update", modelMap.get("saveAction"));
		
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

		InvoiceTransCurrency invoiceTransCurrency = invoiceTransCurrencyFactoryForTest.newInvoiceTransCurrency();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransCurrencyService.update(invoiceTransCurrency)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransCurrencyController.update(invoiceTransCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransCurrency, (InvoiceTransCurrency) modelMap.get("invoiceTransCurrency"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransCurrency/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransCurrency.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransCurrency invoiceTransCurrency = invoiceTransCurrencyFactoryForTest.newInvoiceTransCurrency();
		Integer id = invoiceTransCurrency.getId();
		
		// When
		String viewName = invoiceTransCurrencyController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransCurrencyService).delete(id);
		assertEquals("redirect:/invoiceTransCurrency", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransCurrency invoiceTransCurrency = invoiceTransCurrencyFactoryForTest.newInvoiceTransCurrency();
		Integer id = invoiceTransCurrency.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(invoiceTransCurrencyService).delete(id);
		
		// When
		String viewName = invoiceTransCurrencyController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransCurrencyService).delete(id);
		assertEquals("redirect:/invoiceTransCurrency", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "invoiceTransCurrency.error.delete", exception);
	}
	
	
}
