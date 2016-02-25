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
import org.demo.bean.AdminUserRole;
import org.demo.test.AdminUserRoleFactoryForTest;

//--- Services 
import org.demo.business.service.AdminUserRoleService;


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
public class AdminUserRoleControllerTest {
	
	@InjectMocks
	private AdminUserRoleController adminUserRoleController;
	@Mock
	private AdminUserRoleService adminUserRoleService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private AdminUserRoleFactoryForTest adminUserRoleFactoryForTest = new AdminUserRoleFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminUserRole> list = new ArrayList<AdminUserRole>();
		when(adminUserRoleService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminUserRoleController.list(model);
		
		// Then
		assertEquals("adminUserRole/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminUserRoleController.formForCreate(model);
		
		// Then
		assertEquals("adminUserRole/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminUserRole)modelMap.get("adminUserRole")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserRole/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserRole adminUserRole = adminUserRoleFactoryForTest.newAdminUserRole();
		Integer id = adminUserRole.getId();
		when(adminUserRoleService.findById(id)).thenReturn(adminUserRole);
		
		// When
		String viewName = adminUserRoleController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminUserRole/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRole, (AdminUserRole) modelMap.get("adminUserRole"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserRole/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUserRole adminUserRole = adminUserRoleFactoryForTest.newAdminUserRole();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUserRole adminUserRoleCreated = new AdminUserRole();
		when(adminUserRoleService.create(adminUserRole)).thenReturn(adminUserRoleCreated); 
		
		// When
		String viewName = adminUserRoleController.create(adminUserRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUserRole/form/"+adminUserRole.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRoleCreated, (AdminUserRole) modelMap.get("adminUserRole"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserRole adminUserRole = adminUserRoleFactoryForTest.newAdminUserRole();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserRoleController.create(adminUserRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRole, (AdminUserRole) modelMap.get("adminUserRole"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserRole/create", modelMap.get("saveAction"));
		
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

		AdminUserRole adminUserRole = adminUserRoleFactoryForTest.newAdminUserRole();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserRoleService.create(adminUserRole)).thenThrow(exception);
		
		// When
		String viewName = adminUserRoleController.create(adminUserRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRole, (AdminUserRole) modelMap.get("adminUserRole"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserRole/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUserRole.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUserRole adminUserRole = adminUserRoleFactoryForTest.newAdminUserRole();
		Integer id = adminUserRole.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUserRole adminUserRoleSaved = new AdminUserRole();
		adminUserRoleSaved.setId(id);
		when(adminUserRoleService.update(adminUserRole)).thenReturn(adminUserRoleSaved); 
		
		// When
		String viewName = adminUserRoleController.update(adminUserRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUserRole/form/"+adminUserRole.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRoleSaved, (AdminUserRole) modelMap.get("adminUserRole"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserRole adminUserRole = adminUserRoleFactoryForTest.newAdminUserRole();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserRoleController.update(adminUserRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRole, (AdminUserRole) modelMap.get("adminUserRole"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserRole/update", modelMap.get("saveAction"));
		
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

		AdminUserRole adminUserRole = adminUserRoleFactoryForTest.newAdminUserRole();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserRoleService.update(adminUserRole)).thenThrow(exception);
		
		// When
		String viewName = adminUserRoleController.update(adminUserRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRole, (AdminUserRole) modelMap.get("adminUserRole"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserRole/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUserRole.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUserRole adminUserRole = adminUserRoleFactoryForTest.newAdminUserRole();
		Integer id = adminUserRole.getId();
		
		// When
		String viewName = adminUserRoleController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserRoleService).delete(id);
		assertEquals("redirect:/adminUserRole", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUserRole adminUserRole = adminUserRoleFactoryForTest.newAdminUserRole();
		Integer id = adminUserRole.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminUserRoleService).delete(id);
		
		// When
		String viewName = adminUserRoleController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserRoleService).delete(id);
		assertEquals("redirect:/adminUserRole", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminUserRole.error.delete", exception);
	}
	
	
}
