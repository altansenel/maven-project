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
import org.demo.bean.AdminWorkspace;
import org.demo.test.AdminWorkspaceFactoryForTest;

//--- Services 
import org.demo.business.service.AdminWorkspaceService;


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
public class AdminWorkspaceControllerTest {
	
	@InjectMocks
	private AdminWorkspaceController adminWorkspaceController;
	@Mock
	private AdminWorkspaceService adminWorkspaceService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private AdminWorkspaceFactoryForTest adminWorkspaceFactoryForTest = new AdminWorkspaceFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminWorkspace> list = new ArrayList<AdminWorkspace>();
		when(adminWorkspaceService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminWorkspaceController.list(model);
		
		// Then
		assertEquals("adminWorkspace/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminWorkspaceController.formForCreate(model);
		
		// Then
		assertEquals("adminWorkspace/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminWorkspace)modelMap.get("adminWorkspace")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminWorkspace/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminWorkspace adminWorkspace = adminWorkspaceFactoryForTest.newAdminWorkspace();
		Integer id = adminWorkspace.getId();
		when(adminWorkspaceService.findById(id)).thenReturn(adminWorkspace);
		
		// When
		String viewName = adminWorkspaceController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminWorkspace/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminWorkspace, (AdminWorkspace) modelMap.get("adminWorkspace"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminWorkspace/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminWorkspace adminWorkspace = adminWorkspaceFactoryForTest.newAdminWorkspace();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminWorkspace adminWorkspaceCreated = new AdminWorkspace();
		when(adminWorkspaceService.create(adminWorkspace)).thenReturn(adminWorkspaceCreated); 
		
		// When
		String viewName = adminWorkspaceController.create(adminWorkspace, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminWorkspace/form/"+adminWorkspace.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminWorkspaceCreated, (AdminWorkspace) modelMap.get("adminWorkspace"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminWorkspace adminWorkspace = adminWorkspaceFactoryForTest.newAdminWorkspace();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminWorkspaceController.create(adminWorkspace, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminWorkspace/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminWorkspace, (AdminWorkspace) modelMap.get("adminWorkspace"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminWorkspace/create", modelMap.get("saveAction"));
		
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

		AdminWorkspace adminWorkspace = adminWorkspaceFactoryForTest.newAdminWorkspace();
		
		Exception exception = new RuntimeException("test exception");
		when(adminWorkspaceService.create(adminWorkspace)).thenThrow(exception);
		
		// When
		String viewName = adminWorkspaceController.create(adminWorkspace, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminWorkspace/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminWorkspace, (AdminWorkspace) modelMap.get("adminWorkspace"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminWorkspace/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminWorkspace.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminWorkspace adminWorkspace = adminWorkspaceFactoryForTest.newAdminWorkspace();
		Integer id = adminWorkspace.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminWorkspace adminWorkspaceSaved = new AdminWorkspace();
		adminWorkspaceSaved.setId(id);
		when(adminWorkspaceService.update(adminWorkspace)).thenReturn(adminWorkspaceSaved); 
		
		// When
		String viewName = adminWorkspaceController.update(adminWorkspace, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminWorkspace/form/"+adminWorkspace.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminWorkspaceSaved, (AdminWorkspace) modelMap.get("adminWorkspace"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminWorkspace adminWorkspace = adminWorkspaceFactoryForTest.newAdminWorkspace();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminWorkspaceController.update(adminWorkspace, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminWorkspace/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminWorkspace, (AdminWorkspace) modelMap.get("adminWorkspace"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminWorkspace/update", modelMap.get("saveAction"));
		
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

		AdminWorkspace adminWorkspace = adminWorkspaceFactoryForTest.newAdminWorkspace();
		
		Exception exception = new RuntimeException("test exception");
		when(adminWorkspaceService.update(adminWorkspace)).thenThrow(exception);
		
		// When
		String viewName = adminWorkspaceController.update(adminWorkspace, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminWorkspace/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminWorkspace, (AdminWorkspace) modelMap.get("adminWorkspace"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminWorkspace/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminWorkspace.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminWorkspace adminWorkspace = adminWorkspaceFactoryForTest.newAdminWorkspace();
		Integer id = adminWorkspace.getId();
		
		// When
		String viewName = adminWorkspaceController.delete(redirectAttributes, id);
		
		// Then
		verify(adminWorkspaceService).delete(id);
		assertEquals("redirect:/adminWorkspace", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminWorkspace adminWorkspace = adminWorkspaceFactoryForTest.newAdminWorkspace();
		Integer id = adminWorkspace.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminWorkspaceService).delete(id);
		
		// When
		String viewName = adminWorkspaceController.delete(redirectAttributes, id);
		
		// Then
		verify(adminWorkspaceService).delete(id);
		assertEquals("redirect:/adminWorkspace", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminWorkspace.error.delete", exception);
	}
	
	
}
