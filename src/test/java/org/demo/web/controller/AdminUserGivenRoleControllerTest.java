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
import org.demo.bean.AdminUserGivenRole;
import org.demo.bean.AdminUserGroup;
import org.demo.bean.AdminUserRole;
import org.demo.bean.AdminWorkspace;
import org.demo.test.AdminUserGivenRoleFactoryForTest;
import org.demo.test.AdminUserGroupFactoryForTest;
import org.demo.test.AdminUserRoleFactoryForTest;
import org.demo.test.AdminWorkspaceFactoryForTest;

//--- Services 
import org.demo.business.service.AdminUserGivenRoleService;
import org.demo.business.service.AdminUserGroupService;
import org.demo.business.service.AdminUserRoleService;
import org.demo.business.service.AdminWorkspaceService;

//--- List Items 
import org.demo.web.listitem.AdminUserGroupListItem;
import org.demo.web.listitem.AdminUserRoleListItem;
import org.demo.web.listitem.AdminWorkspaceListItem;

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
public class AdminUserGivenRoleControllerTest {
	
	@InjectMocks
	private AdminUserGivenRoleController adminUserGivenRoleController;
	@Mock
	private AdminUserGivenRoleService adminUserGivenRoleService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private AdminUserGroupService adminUserGroupService; // Injected by Spring
	@Mock
	private AdminUserRoleService adminUserRoleService; // Injected by Spring
	@Mock
	private AdminWorkspaceService adminWorkspaceService; // Injected by Spring

	private AdminUserGivenRoleFactoryForTest adminUserGivenRoleFactoryForTest = new AdminUserGivenRoleFactoryForTest();
	private AdminUserGroupFactoryForTest adminUserGroupFactoryForTest = new AdminUserGroupFactoryForTest();
	private AdminUserRoleFactoryForTest adminUserRoleFactoryForTest = new AdminUserRoleFactoryForTest();
	private AdminWorkspaceFactoryForTest adminWorkspaceFactoryForTest = new AdminWorkspaceFactoryForTest();

	List<AdminUserGroup> adminUserGroups = new ArrayList<AdminUserGroup>();
	List<AdminUserRole> adminUserRoles = new ArrayList<AdminUserRole>();
	List<AdminWorkspace> adminWorkspaces = new ArrayList<AdminWorkspace>();

	private void givenPopulateModel() {
		AdminUserGroup adminUserGroup1 = adminUserGroupFactoryForTest.newAdminUserGroup();
		AdminUserGroup adminUserGroup2 = adminUserGroupFactoryForTest.newAdminUserGroup();
		List<AdminUserGroup> adminUserGroups = new ArrayList<AdminUserGroup>();
		adminUserGroups.add(adminUserGroup1);
		adminUserGroups.add(adminUserGroup2);
		when(adminUserGroupService.findAll()).thenReturn(adminUserGroups);

		AdminUserRole adminUserRole1 = adminUserRoleFactoryForTest.newAdminUserRole();
		AdminUserRole adminUserRole2 = adminUserRoleFactoryForTest.newAdminUserRole();
		List<AdminUserRole> adminUserRoles = new ArrayList<AdminUserRole>();
		adminUserRoles.add(adminUserRole1);
		adminUserRoles.add(adminUserRole2);
		when(adminUserRoleService.findAll()).thenReturn(adminUserRoles);

		AdminWorkspace adminWorkspace1 = adminWorkspaceFactoryForTest.newAdminWorkspace();
		AdminWorkspace adminWorkspace2 = adminWorkspaceFactoryForTest.newAdminWorkspace();
		List<AdminWorkspace> adminWorkspaces = new ArrayList<AdminWorkspace>();
		adminWorkspaces.add(adminWorkspace1);
		adminWorkspaces.add(adminWorkspace2);
		when(adminWorkspaceService.findAll()).thenReturn(adminWorkspaces);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminUserGivenRole> list = new ArrayList<AdminUserGivenRole>();
		when(adminUserGivenRoleService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminUserGivenRoleController.list(model);
		
		// Then
		assertEquals("adminUserGivenRole/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminUserGivenRoleController.formForCreate(model);
		
		// Then
		assertEquals("adminUserGivenRole/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminUserGivenRole)modelMap.get("adminUserGivenRole")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserGivenRole/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AdminWorkspaceListItem> adminWorkspaceListItems = (List<AdminWorkspaceListItem>) modelMap.get("listOfAdminWorkspaceItems");
		assertEquals(2, adminWorkspaceListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		Integer id = adminUserGivenRole.getId();
		when(adminUserGivenRoleService.findById(id)).thenReturn(adminUserGivenRole);
		
		// When
		String viewName = adminUserGivenRoleController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminUserGivenRole/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGivenRole, (AdminUserGivenRole) modelMap.get("adminUserGivenRole"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserGivenRole/update", modelMap.get("saveAction"));
		
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
		List<AdminWorkspaceListItem> adminWorkspaceListItems = (List<AdminWorkspaceListItem>) modelMap.get("listOfAdminWorkspaceItems");
		assertEquals(2, adminWorkspaceListItems.size());
		
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUserGivenRole adminUserGivenRoleCreated = new AdminUserGivenRole();
		when(adminUserGivenRoleService.create(adminUserGivenRole)).thenReturn(adminUserGivenRoleCreated); 
		
		// When
		String viewName = adminUserGivenRoleController.create(adminUserGivenRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUserGivenRole/form/"+adminUserGivenRole.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGivenRoleCreated, (AdminUserGivenRole) modelMap.get("adminUserGivenRole"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserGivenRoleController.create(adminUserGivenRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserGivenRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGivenRole, (AdminUserGivenRole) modelMap.get("adminUserGivenRole"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserGivenRole/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AdminWorkspaceListItem> adminWorkspaceListItems = (List<AdminWorkspaceListItem>) modelMap.get("listOfAdminWorkspaceItems");
		assertEquals(2, adminWorkspaceListItems.size());
		
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

		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserGivenRoleService.create(adminUserGivenRole)).thenThrow(exception);
		
		// When
		String viewName = adminUserGivenRoleController.create(adminUserGivenRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserGivenRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGivenRole, (AdminUserGivenRole) modelMap.get("adminUserGivenRole"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserGivenRole/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUserGivenRole.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AdminWorkspaceListItem> adminWorkspaceListItems = (List<AdminWorkspaceListItem>) modelMap.get("listOfAdminWorkspaceItems");
		assertEquals(2, adminWorkspaceListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		Integer id = adminUserGivenRole.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUserGivenRole adminUserGivenRoleSaved = new AdminUserGivenRole();
		adminUserGivenRoleSaved.setId(id);
		when(adminUserGivenRoleService.update(adminUserGivenRole)).thenReturn(adminUserGivenRoleSaved); 
		
		// When
		String viewName = adminUserGivenRoleController.update(adminUserGivenRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUserGivenRole/form/"+adminUserGivenRole.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGivenRoleSaved, (AdminUserGivenRole) modelMap.get("adminUserGivenRole"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserGivenRoleController.update(adminUserGivenRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserGivenRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGivenRole, (AdminUserGivenRole) modelMap.get("adminUserGivenRole"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserGivenRole/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AdminWorkspaceListItem> adminWorkspaceListItems = (List<AdminWorkspaceListItem>) modelMap.get("listOfAdminWorkspaceItems");
		assertEquals(2, adminWorkspaceListItems.size());
		
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

		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserGivenRoleService.update(adminUserGivenRole)).thenThrow(exception);
		
		// When
		String viewName = adminUserGivenRoleController.update(adminUserGivenRole, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserGivenRole/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGivenRole, (AdminUserGivenRole) modelMap.get("adminUserGivenRole"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserGivenRole/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUserGivenRole.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AdminWorkspaceListItem> adminWorkspaceListItems = (List<AdminWorkspaceListItem>) modelMap.get("listOfAdminWorkspaceItems");
		assertEquals(2, adminWorkspaceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<AdminUserRoleListItem> adminUserRoleListItems = (List<AdminUserRoleListItem>) modelMap.get("listOfAdminUserRoleItems");
		assertEquals(2, adminUserRoleListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		Integer id = adminUserGivenRole.getId();
		
		// When
		String viewName = adminUserGivenRoleController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserGivenRoleService).delete(id);
		assertEquals("redirect:/adminUserGivenRole", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUserGivenRole adminUserGivenRole = adminUserGivenRoleFactoryForTest.newAdminUserGivenRole();
		Integer id = adminUserGivenRole.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminUserGivenRoleService).delete(id);
		
		// When
		String viewName = adminUserGivenRoleController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserGivenRoleService).delete(id);
		assertEquals("redirect:/adminUserGivenRole", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminUserGivenRole.error.delete", exception);
	}
	
	
}
