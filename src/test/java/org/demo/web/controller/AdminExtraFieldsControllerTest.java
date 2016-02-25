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
import org.demo.bean.AdminExtraFields;
import org.demo.test.AdminExtraFieldsFactoryForTest;

//--- Services 
import org.demo.business.service.AdminExtraFieldsService;


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
public class AdminExtraFieldsControllerTest {
	
	@InjectMocks
	private AdminExtraFieldsController adminExtraFieldsController;
	@Mock
	private AdminExtraFieldsService adminExtraFieldsService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private AdminExtraFieldsFactoryForTest adminExtraFieldsFactoryForTest = new AdminExtraFieldsFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminExtraFields> list = new ArrayList<AdminExtraFields>();
		when(adminExtraFieldsService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminExtraFieldsController.list(model);
		
		// Then
		assertEquals("adminExtraFields/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminExtraFieldsController.formForCreate(model);
		
		// Then
		assertEquals("adminExtraFields/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminExtraFields)modelMap.get("adminExtraFields")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminExtraFields/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminExtraFields adminExtraFields = adminExtraFieldsFactoryForTest.newAdminExtraFields();
		Integer id = adminExtraFields.getId();
		when(adminExtraFieldsService.findById(id)).thenReturn(adminExtraFields);
		
		// When
		String viewName = adminExtraFieldsController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminExtraFields/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminExtraFields, (AdminExtraFields) modelMap.get("adminExtraFields"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminExtraFields/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminExtraFields adminExtraFields = adminExtraFieldsFactoryForTest.newAdminExtraFields();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminExtraFields adminExtraFieldsCreated = new AdminExtraFields();
		when(adminExtraFieldsService.create(adminExtraFields)).thenReturn(adminExtraFieldsCreated); 
		
		// When
		String viewName = adminExtraFieldsController.create(adminExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminExtraFields/form/"+adminExtraFields.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminExtraFieldsCreated, (AdminExtraFields) modelMap.get("adminExtraFields"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminExtraFields adminExtraFields = adminExtraFieldsFactoryForTest.newAdminExtraFields();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminExtraFieldsController.create(adminExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminExtraFields, (AdminExtraFields) modelMap.get("adminExtraFields"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminExtraFields/create", modelMap.get("saveAction"));
		
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

		AdminExtraFields adminExtraFields = adminExtraFieldsFactoryForTest.newAdminExtraFields();
		
		Exception exception = new RuntimeException("test exception");
		when(adminExtraFieldsService.create(adminExtraFields)).thenThrow(exception);
		
		// When
		String viewName = adminExtraFieldsController.create(adminExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminExtraFields, (AdminExtraFields) modelMap.get("adminExtraFields"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminExtraFields/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminExtraFields.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminExtraFields adminExtraFields = adminExtraFieldsFactoryForTest.newAdminExtraFields();
		Integer id = adminExtraFields.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminExtraFields adminExtraFieldsSaved = new AdminExtraFields();
		adminExtraFieldsSaved.setId(id);
		when(adminExtraFieldsService.update(adminExtraFields)).thenReturn(adminExtraFieldsSaved); 
		
		// When
		String viewName = adminExtraFieldsController.update(adminExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminExtraFields/form/"+adminExtraFields.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminExtraFieldsSaved, (AdminExtraFields) modelMap.get("adminExtraFields"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminExtraFields adminExtraFields = adminExtraFieldsFactoryForTest.newAdminExtraFields();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminExtraFieldsController.update(adminExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminExtraFields, (AdminExtraFields) modelMap.get("adminExtraFields"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminExtraFields/update", modelMap.get("saveAction"));
		
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

		AdminExtraFields adminExtraFields = adminExtraFieldsFactoryForTest.newAdminExtraFields();
		
		Exception exception = new RuntimeException("test exception");
		when(adminExtraFieldsService.update(adminExtraFields)).thenThrow(exception);
		
		// When
		String viewName = adminExtraFieldsController.update(adminExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminExtraFields, (AdminExtraFields) modelMap.get("adminExtraFields"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminExtraFields/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminExtraFields.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminExtraFields adminExtraFields = adminExtraFieldsFactoryForTest.newAdminExtraFields();
		Integer id = adminExtraFields.getId();
		
		// When
		String viewName = adminExtraFieldsController.delete(redirectAttributes, id);
		
		// Then
		verify(adminExtraFieldsService).delete(id);
		assertEquals("redirect:/adminExtraFields", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminExtraFields adminExtraFields = adminExtraFieldsFactoryForTest.newAdminExtraFields();
		Integer id = adminExtraFields.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminExtraFieldsService).delete(id);
		
		// When
		String viewName = adminExtraFieldsController.delete(redirectAttributes, id);
		
		// Then
		verify(adminExtraFieldsService).delete(id);
		assertEquals("redirect:/adminExtraFields", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminExtraFields.error.delete", exception);
	}
	
	
}
