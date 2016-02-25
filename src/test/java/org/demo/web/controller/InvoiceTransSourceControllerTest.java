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
import org.demo.bean.InvoiceTransSource;
import org.demo.test.InvoiceTransSourceFactoryForTest;

//--- Services 
import org.demo.business.service.InvoiceTransSourceService;


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
public class InvoiceTransSourceControllerTest {
	
	@InjectMocks
	private InvoiceTransSourceController invoiceTransSourceController;
	@Mock
	private InvoiceTransSourceService invoiceTransSourceService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private InvoiceTransSourceFactoryForTest invoiceTransSourceFactoryForTest = new InvoiceTransSourceFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<InvoiceTransSource> list = new ArrayList<InvoiceTransSource>();
		when(invoiceTransSourceService.findAll()).thenReturn(list);
		
		// When
		String viewName = invoiceTransSourceController.list(model);
		
		// Then
		assertEquals("invoiceTransSource/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = invoiceTransSourceController.formForCreate(model);
		
		// Then
		assertEquals("invoiceTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((InvoiceTransSource)modelMap.get("invoiceTransSource")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransSource/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransSource invoiceTransSource = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		Integer id = invoiceTransSource.getId();
		when(invoiceTransSourceService.findById(id)).thenReturn(invoiceTransSource);
		
		// When
		String viewName = invoiceTransSourceController.formForUpdate(model, id);
		
		// Then
		assertEquals("invoiceTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransSource, (InvoiceTransSource) modelMap.get("invoiceTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransSource/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransSource invoiceTransSource = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransSource invoiceTransSourceCreated = new InvoiceTransSource();
		when(invoiceTransSourceService.create(invoiceTransSource)).thenReturn(invoiceTransSourceCreated); 
		
		// When
		String viewName = invoiceTransSourceController.create(invoiceTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransSource/form/"+invoiceTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransSourceCreated, (InvoiceTransSource) modelMap.get("invoiceTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransSource invoiceTransSource = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransSourceController.create(invoiceTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransSource, (InvoiceTransSource) modelMap.get("invoiceTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransSource/create", modelMap.get("saveAction"));
		
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

		InvoiceTransSource invoiceTransSource = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransSourceService.create(invoiceTransSource)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransSourceController.create(invoiceTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransSource, (InvoiceTransSource) modelMap.get("invoiceTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransSource/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransSource.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransSource invoiceTransSource = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		Integer id = invoiceTransSource.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransSource invoiceTransSourceSaved = new InvoiceTransSource();
		invoiceTransSourceSaved.setId(id);
		when(invoiceTransSourceService.update(invoiceTransSource)).thenReturn(invoiceTransSourceSaved); 
		
		// When
		String viewName = invoiceTransSourceController.update(invoiceTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransSource/form/"+invoiceTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransSourceSaved, (InvoiceTransSource) modelMap.get("invoiceTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransSource invoiceTransSource = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransSourceController.update(invoiceTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransSource, (InvoiceTransSource) modelMap.get("invoiceTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransSource/update", modelMap.get("saveAction"));
		
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

		InvoiceTransSource invoiceTransSource = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransSourceService.update(invoiceTransSource)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransSourceController.update(invoiceTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransSource, (InvoiceTransSource) modelMap.get("invoiceTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransSource/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransSource.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransSource invoiceTransSource = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		Integer id = invoiceTransSource.getId();
		
		// When
		String viewName = invoiceTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransSourceService).delete(id);
		assertEquals("redirect:/invoiceTransSource", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransSource invoiceTransSource = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		Integer id = invoiceTransSource.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(invoiceTransSourceService).delete(id);
		
		// When
		String viewName = invoiceTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransSourceService).delete(id);
		assertEquals("redirect:/invoiceTransSource", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "invoiceTransSource.error.delete", exception);
	}
	
	
}
