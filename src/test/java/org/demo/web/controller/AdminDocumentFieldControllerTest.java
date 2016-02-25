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
import org.demo.bean.AdminDocumentField;
import org.demo.bean.AdminDocument;
import org.demo.test.AdminDocumentFieldFactoryForTest;
import org.demo.test.AdminDocumentFactoryForTest;

//--- Services 
import org.demo.business.service.AdminDocumentFieldService;
import org.demo.business.service.AdminDocumentService;

//--- List Items 
import org.demo.web.listitem.AdminDocumentListItem;

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
public class AdminDocumentFieldControllerTest {
	
	@InjectMocks
	private AdminDocumentFieldController adminDocumentFieldController;
	@Mock
	private AdminDocumentFieldService adminDocumentFieldService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private AdminDocumentService adminDocumentService; // Injected by Spring

	private AdminDocumentFieldFactoryForTest adminDocumentFieldFactoryForTest = new AdminDocumentFieldFactoryForTest();
	private AdminDocumentFactoryForTest adminDocumentFactoryForTest = new AdminDocumentFactoryForTest();

	List<AdminDocument> adminDocuments = new ArrayList<AdminDocument>();

	private void givenPopulateModel() {
		AdminDocument adminDocument1 = adminDocumentFactoryForTest.newAdminDocument();
		AdminDocument adminDocument2 = adminDocumentFactoryForTest.newAdminDocument();
		List<AdminDocument> adminDocuments = new ArrayList<AdminDocument>();
		adminDocuments.add(adminDocument1);
		adminDocuments.add(adminDocument2);
		when(adminDocumentService.findAll()).thenReturn(adminDocuments);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminDocumentField> list = new ArrayList<AdminDocumentField>();
		when(adminDocumentFieldService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminDocumentFieldController.list(model);
		
		// Then
		assertEquals("adminDocumentField/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminDocumentFieldController.formForCreate(model);
		
		// Then
		assertEquals("adminDocumentField/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminDocumentField)modelMap.get("adminDocumentField")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminDocumentField/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminDocumentListItem> adminDocumentListItems = (List<AdminDocumentListItem>) modelMap.get("listOfAdminDocumentItems");
		assertEquals(2, adminDocumentListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		Integer id = adminDocumentField.getId();
		when(adminDocumentFieldService.findById(id)).thenReturn(adminDocumentField);
		
		// When
		String viewName = adminDocumentFieldController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminDocumentField/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentField, (AdminDocumentField) modelMap.get("adminDocumentField"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminDocumentField/update", modelMap.get("saveAction"));
		
		List<AdminDocumentListItem> adminDocumentListItems = (List<AdminDocumentListItem>) modelMap.get("listOfAdminDocumentItems");
		assertEquals(2, adminDocumentListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminDocumentField adminDocumentFieldCreated = new AdminDocumentField();
		when(adminDocumentFieldService.create(adminDocumentField)).thenReturn(adminDocumentFieldCreated); 
		
		// When
		String viewName = adminDocumentFieldController.create(adminDocumentField, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminDocumentField/form/"+adminDocumentField.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentFieldCreated, (AdminDocumentField) modelMap.get("adminDocumentField"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminDocumentFieldController.create(adminDocumentField, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocumentField/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentField, (AdminDocumentField) modelMap.get("adminDocumentField"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminDocumentField/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminDocumentListItem> adminDocumentListItems = (List<AdminDocumentListItem>) modelMap.get("listOfAdminDocumentItems");
		assertEquals(2, adminDocumentListItems.size());
		
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

		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		
		Exception exception = new RuntimeException("test exception");
		when(adminDocumentFieldService.create(adminDocumentField)).thenThrow(exception);
		
		// When
		String viewName = adminDocumentFieldController.create(adminDocumentField, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocumentField/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentField, (AdminDocumentField) modelMap.get("adminDocumentField"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminDocumentField/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminDocumentField.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<AdminDocumentListItem> adminDocumentListItems = (List<AdminDocumentListItem>) modelMap.get("listOfAdminDocumentItems");
		assertEquals(2, adminDocumentListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		Integer id = adminDocumentField.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminDocumentField adminDocumentFieldSaved = new AdminDocumentField();
		adminDocumentFieldSaved.setId(id);
		when(adminDocumentFieldService.update(adminDocumentField)).thenReturn(adminDocumentFieldSaved); 
		
		// When
		String viewName = adminDocumentFieldController.update(adminDocumentField, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminDocumentField/form/"+adminDocumentField.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentFieldSaved, (AdminDocumentField) modelMap.get("adminDocumentField"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminDocumentFieldController.update(adminDocumentField, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocumentField/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentField, (AdminDocumentField) modelMap.get("adminDocumentField"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminDocumentField/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminDocumentListItem> adminDocumentListItems = (List<AdminDocumentListItem>) modelMap.get("listOfAdminDocumentItems");
		assertEquals(2, adminDocumentListItems.size());
		
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

		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		
		Exception exception = new RuntimeException("test exception");
		when(adminDocumentFieldService.update(adminDocumentField)).thenThrow(exception);
		
		// When
		String viewName = adminDocumentFieldController.update(adminDocumentField, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocumentField/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentField, (AdminDocumentField) modelMap.get("adminDocumentField"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminDocumentField/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminDocumentField.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<AdminDocumentListItem> adminDocumentListItems = (List<AdminDocumentListItem>) modelMap.get("listOfAdminDocumentItems");
		assertEquals(2, adminDocumentListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		Integer id = adminDocumentField.getId();
		
		// When
		String viewName = adminDocumentFieldController.delete(redirectAttributes, id);
		
		// Then
		verify(adminDocumentFieldService).delete(id);
		assertEquals("redirect:/adminDocumentField", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminDocumentField adminDocumentField = adminDocumentFieldFactoryForTest.newAdminDocumentField();
		Integer id = adminDocumentField.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminDocumentFieldService).delete(id);
		
		// When
		String viewName = adminDocumentFieldController.delete(redirectAttributes, id);
		
		// Then
		verify(adminDocumentFieldService).delete(id);
		assertEquals("redirect:/adminDocumentField", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminDocumentField.error.delete", exception);
	}
	
	
}
