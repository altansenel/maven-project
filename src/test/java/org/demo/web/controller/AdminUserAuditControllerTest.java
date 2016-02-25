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
import org.demo.bean.AdminUserAudit;
import org.demo.test.AdminUserAuditFactoryForTest;

//--- Services 
import org.demo.business.service.AdminUserAuditService;


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
public class AdminUserAuditControllerTest {
	
	@InjectMocks
	private AdminUserAuditController adminUserAuditController;
	@Mock
	private AdminUserAuditService adminUserAuditService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private AdminUserAuditFactoryForTest adminUserAuditFactoryForTest = new AdminUserAuditFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminUserAudit> list = new ArrayList<AdminUserAudit>();
		when(adminUserAuditService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminUserAuditController.list(model);
		
		// Then
		assertEquals("adminUserAudit/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminUserAuditController.formForCreate(model);
		
		// Then
		assertEquals("adminUserAudit/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminUserAudit)modelMap.get("adminUserAudit")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserAudit/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserAudit adminUserAudit = adminUserAuditFactoryForTest.newAdminUserAudit();
		Integer id = adminUserAudit.getId();
		when(adminUserAuditService.findById(id)).thenReturn(adminUserAudit);
		
		// When
		String viewName = adminUserAuditController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminUserAudit/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserAudit, (AdminUserAudit) modelMap.get("adminUserAudit"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserAudit/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUserAudit adminUserAudit = adminUserAuditFactoryForTest.newAdminUserAudit();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUserAudit adminUserAuditCreated = new AdminUserAudit();
		when(adminUserAuditService.create(adminUserAudit)).thenReturn(adminUserAuditCreated); 
		
		// When
		String viewName = adminUserAuditController.create(adminUserAudit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUserAudit/form/"+adminUserAudit.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserAuditCreated, (AdminUserAudit) modelMap.get("adminUserAudit"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserAudit adminUserAudit = adminUserAuditFactoryForTest.newAdminUserAudit();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserAuditController.create(adminUserAudit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserAudit/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserAudit, (AdminUserAudit) modelMap.get("adminUserAudit"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserAudit/create", modelMap.get("saveAction"));
		
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

		AdminUserAudit adminUserAudit = adminUserAuditFactoryForTest.newAdminUserAudit();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserAuditService.create(adminUserAudit)).thenThrow(exception);
		
		// When
		String viewName = adminUserAuditController.create(adminUserAudit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserAudit/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserAudit, (AdminUserAudit) modelMap.get("adminUserAudit"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserAudit/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUserAudit.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUserAudit adminUserAudit = adminUserAuditFactoryForTest.newAdminUserAudit();
		Integer id = adminUserAudit.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUserAudit adminUserAuditSaved = new AdminUserAudit();
		adminUserAuditSaved.setId(id);
		when(adminUserAuditService.update(adminUserAudit)).thenReturn(adminUserAuditSaved); 
		
		// When
		String viewName = adminUserAuditController.update(adminUserAudit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUserAudit/form/"+adminUserAudit.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserAuditSaved, (AdminUserAudit) modelMap.get("adminUserAudit"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserAudit adminUserAudit = adminUserAuditFactoryForTest.newAdminUserAudit();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserAuditController.update(adminUserAudit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserAudit/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserAudit, (AdminUserAudit) modelMap.get("adminUserAudit"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserAudit/update", modelMap.get("saveAction"));
		
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

		AdminUserAudit adminUserAudit = adminUserAuditFactoryForTest.newAdminUserAudit();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserAuditService.update(adminUserAudit)).thenThrow(exception);
		
		// When
		String viewName = adminUserAuditController.update(adminUserAudit, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserAudit/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserAudit, (AdminUserAudit) modelMap.get("adminUserAudit"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserAudit/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUserAudit.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUserAudit adminUserAudit = adminUserAuditFactoryForTest.newAdminUserAudit();
		Integer id = adminUserAudit.getId();
		
		// When
		String viewName = adminUserAuditController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserAuditService).delete(id);
		assertEquals("redirect:/adminUserAudit", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUserAudit adminUserAudit = adminUserAuditFactoryForTest.newAdminUserAudit();
		Integer id = adminUserAudit.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminUserAuditService).delete(id);
		
		// When
		String viewName = adminUserAuditController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserAuditService).delete(id);
		assertEquals("redirect:/adminUserAudit", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminUserAudit.error.delete", exception);
	}
	
	
}
