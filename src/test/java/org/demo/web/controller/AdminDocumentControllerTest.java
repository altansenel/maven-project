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
import org.demo.bean.AdminDocument;
import org.demo.test.AdminDocumentFactoryForTest;

//--- Services 
import org.demo.business.service.AdminDocumentService;


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
public class AdminDocumentControllerTest {
	
	@InjectMocks
	private AdminDocumentController adminDocumentController;
	@Mock
	private AdminDocumentService adminDocumentService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private AdminDocumentFactoryForTest adminDocumentFactoryForTest = new AdminDocumentFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminDocument> list = new ArrayList<AdminDocument>();
		when(adminDocumentService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminDocumentController.list(model);
		
		// Then
		assertEquals("adminDocument/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminDocumentController.formForCreate(model);
		
		// Then
		assertEquals("adminDocument/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminDocument)modelMap.get("adminDocument")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminDocument/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminDocument adminDocument = adminDocumentFactoryForTest.newAdminDocument();
		Integer id = adminDocument.getId();
		when(adminDocumentService.findById(id)).thenReturn(adminDocument);
		
		// When
		String viewName = adminDocumentController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminDocument/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocument, (AdminDocument) modelMap.get("adminDocument"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminDocument/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminDocument adminDocument = adminDocumentFactoryForTest.newAdminDocument();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminDocument adminDocumentCreated = new AdminDocument();
		when(adminDocumentService.create(adminDocument)).thenReturn(adminDocumentCreated); 
		
		// When
		String viewName = adminDocumentController.create(adminDocument, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminDocument/form/"+adminDocument.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentCreated, (AdminDocument) modelMap.get("adminDocument"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminDocument adminDocument = adminDocumentFactoryForTest.newAdminDocument();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminDocumentController.create(adminDocument, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocument/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocument, (AdminDocument) modelMap.get("adminDocument"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminDocument/create", modelMap.get("saveAction"));
		
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

		AdminDocument adminDocument = adminDocumentFactoryForTest.newAdminDocument();
		
		Exception exception = new RuntimeException("test exception");
		when(adminDocumentService.create(adminDocument)).thenThrow(exception);
		
		// When
		String viewName = adminDocumentController.create(adminDocument, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocument/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocument, (AdminDocument) modelMap.get("adminDocument"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminDocument/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminDocument.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminDocument adminDocument = adminDocumentFactoryForTest.newAdminDocument();
		Integer id = adminDocument.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminDocument adminDocumentSaved = new AdminDocument();
		adminDocumentSaved.setId(id);
		when(adminDocumentService.update(adminDocument)).thenReturn(adminDocumentSaved); 
		
		// When
		String viewName = adminDocumentController.update(adminDocument, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminDocument/form/"+adminDocument.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentSaved, (AdminDocument) modelMap.get("adminDocument"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminDocument adminDocument = adminDocumentFactoryForTest.newAdminDocument();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminDocumentController.update(adminDocument, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocument/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocument, (AdminDocument) modelMap.get("adminDocument"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminDocument/update", modelMap.get("saveAction"));
		
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

		AdminDocument adminDocument = adminDocumentFactoryForTest.newAdminDocument();
		
		Exception exception = new RuntimeException("test exception");
		when(adminDocumentService.update(adminDocument)).thenThrow(exception);
		
		// When
		String viewName = adminDocumentController.update(adminDocument, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocument/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocument, (AdminDocument) modelMap.get("adminDocument"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminDocument/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminDocument.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminDocument adminDocument = adminDocumentFactoryForTest.newAdminDocument();
		Integer id = adminDocument.getId();
		
		// When
		String viewName = adminDocumentController.delete(redirectAttributes, id);
		
		// Then
		verify(adminDocumentService).delete(id);
		assertEquals("redirect:/adminDocument", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminDocument adminDocument = adminDocumentFactoryForTest.newAdminDocument();
		Integer id = adminDocument.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminDocumentService).delete(id);
		
		// When
		String viewName = adminDocumentController.delete(redirectAttributes, id);
		
		// Then
		verify(adminDocumentService).delete(id);
		assertEquals("redirect:/adminDocument", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminDocument.error.delete", exception);
	}
	
	
}
