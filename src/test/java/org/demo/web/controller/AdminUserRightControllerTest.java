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
import org.demo.bean.AdminUserRight;
import org.demo.bean.AdminUserRole;
import org.demo.test.AdminUserRightFactoryForTest;
import org.demo.test.AdminUserRoleFactoryForTest;

//--- Services 
import org.demo.business.service.AdminUserRightService;
import org.demo.business.service.AdminUserRoleService;

//--- List Items 
import org.demo.web.listitem.AdminUserRoleListItem;

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
public class AdminUserRightControllerTest {
	
	@InjectMocks
	private AdminUserRightController adminUserRightController;
	@Mock
	private AdminUserRightService adminUserRightService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private AdminUserRoleService adminUserRoleService; // Injected by Spring

	private AdminUserRightFactoryForTest adminUserRightFactoryForTest = new AdminUserRightFactoryForTest();
	private AdminUserRoleFactoryForTest adminUserRoleFactoryForTest = new AdminUserRoleFactoryForTest();

	List<AdminUserRole> adminUserRoles = new ArrayList<AdminUserRole>();

	private void givenPopulateModel() {
		AdminUserRole adminUserRole1 = adminUserRoleFactoryForTest.newAdminUserRole();
		AdminUserRole adminUserRole2 = adminUserRoleFactoryForTest.newAdminUserRole();
		List<AdminUserRole> adminUserRoles = new ArrayList<AdminUserRole>();
		adminUserRoles.add(adminUserRole1);
		adminUserRoles.add(adminUserRole2);
		when(adminUserRoleService.findAll()).thenReturn(adminUserRoles);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminUserRight> list = new ArrayList<AdminUserRight>();
		when(adminUserRightService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminUserRightController.list(model);
		
		// Then
		assertEquals("adminUserRight/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminUserRightController.formForCreate(model);
		
		// Then
		assertEquals("adminUserRight/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminUserRight)modelMap.get("adminUserRight")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserRight/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserRight adminUserRight = adminUserRightFactoryForTest.newAdminUserRight();
		Integer id = adminUserRight.getId();
		when(adminUserRightService.findById(id)).thenReturn(adminUserRight);
		
		// When
		String viewName = adminUserRightController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminUserRight/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRight, (AdminUserRight) modelMap.get("adminUserRight"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserRight/update", modelMap.get("saveAction"));
		
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUserRight adminUserRight = adminUserRightFactoryForTest.newAdminUserRight();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUserRight adminUserRightCreated = new AdminUserRight();
		when(adminUserRightService.create(adminUserRight)).thenReturn(adminUserRightCreated); 
		
		// When
		String viewName = adminUserRightController.create(adminUserRight, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUserRight/form/"+adminUserRight.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRightCreated, (AdminUserRight) modelMap.get("adminUserRight"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserRight adminUserRight = adminUserRightFactoryForTest.newAdminUserRight();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserRightController.create(adminUserRight, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserRight/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRight, (AdminUserRight) modelMap.get("adminUserRight"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserRight/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
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

		AdminUserRight adminUserRight = adminUserRightFactoryForTest.newAdminUserRight();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserRightService.create(adminUserRight)).thenThrow(exception);
		
		// When
		String viewName = adminUserRightController.create(adminUserRight, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserRight/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRight, (AdminUserRight) modelMap.get("adminUserRight"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserRight/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUserRight.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUserRight adminUserRight = adminUserRightFactoryForTest.newAdminUserRight();
		Integer id = adminUserRight.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUserRight adminUserRightSaved = new AdminUserRight();
		adminUserRightSaved.setId(id);
		when(adminUserRightService.update(adminUserRight)).thenReturn(adminUserRightSaved); 
		
		// When
		String viewName = adminUserRightController.update(adminUserRight, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUserRight/form/"+adminUserRight.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRightSaved, (AdminUserRight) modelMap.get("adminUserRight"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserRight adminUserRight = adminUserRightFactoryForTest.newAdminUserRight();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserRightController.update(adminUserRight, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserRight/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRight, (AdminUserRight) modelMap.get("adminUserRight"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserRight/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
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

		AdminUserRight adminUserRight = adminUserRightFactoryForTest.newAdminUserRight();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserRightService.update(adminUserRight)).thenThrow(exception);
		
		// When
		String viewName = adminUserRightController.update(adminUserRight, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserRight/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserRight, (AdminUserRight) modelMap.get("adminUserRight"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserRight/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUserRight.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUserRight adminUserRight = adminUserRightFactoryForTest.newAdminUserRight();
		Integer id = adminUserRight.getId();
		
		// When
		String viewName = adminUserRightController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserRightService).delete(id);
		assertEquals("redirect:/adminUserRight", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUserRight adminUserRight = adminUserRightFactoryForTest.newAdminUserRight();
		Integer id = adminUserRight.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminUserRightService).delete(id);
		
		// When
		String viewName = adminUserRightController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserRightService).delete(id);
		assertEquals("redirect:/adminUserRight", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminUserRight.error.delete", exception);
	}
	
	
}
