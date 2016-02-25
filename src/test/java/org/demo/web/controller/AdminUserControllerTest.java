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
import org.demo.bean.AdminUser;
import org.demo.bean.AdminUserGroup;
import org.demo.test.AdminUserFactoryForTest;
import org.demo.test.AdminUserGroupFactoryForTest;

//--- Services 
import org.demo.business.service.AdminUserService;
import org.demo.business.service.AdminUserGroupService;

//--- List Items 
import org.demo.web.listitem.AdminUserGroupListItem;

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
public class AdminUserControllerTest {
	
	@InjectMocks
	private AdminUserController adminUserController;
	@Mock
	private AdminUserService adminUserService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private AdminUserGroupService adminUserGroupService; // Injected by Spring

	private AdminUserFactoryForTest adminUserFactoryForTest = new AdminUserFactoryForTest();
	private AdminUserGroupFactoryForTest adminUserGroupFactoryForTest = new AdminUserGroupFactoryForTest();

	List<AdminUserGroup> adminUserGroups = new ArrayList<AdminUserGroup>();

	private void givenPopulateModel() {
		AdminUserGroup adminUserGroup1 = adminUserGroupFactoryForTest.newAdminUserGroup();
		AdminUserGroup adminUserGroup2 = adminUserGroupFactoryForTest.newAdminUserGroup();
		List<AdminUserGroup> adminUserGroups = new ArrayList<AdminUserGroup>();
		adminUserGroups.add(adminUserGroup1);
		adminUserGroups.add(adminUserGroup2);
		when(adminUserGroupService.findAll()).thenReturn(adminUserGroups);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminUser> list = new ArrayList<AdminUser>();
		when(adminUserService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminUserController.list(model);
		
		// Then
		assertEquals("adminUser/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminUserController.formForCreate(model);
		
		// Then
		assertEquals("adminUser/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminUser)modelMap.get("adminUser")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUser/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUser adminUser = adminUserFactoryForTest.newAdminUser();
		Integer id = adminUser.getId();
		when(adminUserService.findById(id)).thenReturn(adminUser);
		
		// When
		String viewName = adminUserController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminUser/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUser, (AdminUser) modelMap.get("adminUser"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUser/update", modelMap.get("saveAction"));
		
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUser adminUser = adminUserFactoryForTest.newAdminUser();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUser adminUserCreated = new AdminUser();
		when(adminUserService.create(adminUser)).thenReturn(adminUserCreated); 
		
		// When
		String viewName = adminUserController.create(adminUser, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUser/form/"+adminUser.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserCreated, (AdminUser) modelMap.get("adminUser"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUser adminUser = adminUserFactoryForTest.newAdminUser();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserController.create(adminUser, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUser/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUser, (AdminUser) modelMap.get("adminUser"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUser/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
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

		AdminUser adminUser = adminUserFactoryForTest.newAdminUser();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserService.create(adminUser)).thenThrow(exception);
		
		// When
		String viewName = adminUserController.create(adminUser, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUser/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUser, (AdminUser) modelMap.get("adminUser"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUser/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUser.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUser adminUser = adminUserFactoryForTest.newAdminUser();
		Integer id = adminUser.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUser adminUserSaved = new AdminUser();
		adminUserSaved.setId(id);
		when(adminUserService.update(adminUser)).thenReturn(adminUserSaved); 
		
		// When
		String viewName = adminUserController.update(adminUser, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUser/form/"+adminUser.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserSaved, (AdminUser) modelMap.get("adminUser"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUser adminUser = adminUserFactoryForTest.newAdminUser();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserController.update(adminUser, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUser/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUser, (AdminUser) modelMap.get("adminUser"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUser/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
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

		AdminUser adminUser = adminUserFactoryForTest.newAdminUser();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserService.update(adminUser)).thenThrow(exception);
		
		// When
		String viewName = adminUserController.update(adminUser, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUser/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUser, (AdminUser) modelMap.get("adminUser"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUser/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUser.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<AdminUserGroupListItem> adminUserGroupListItems = (List<AdminUserGroupListItem>) modelMap.get("listOfAdminUserGroupItems");
		assertEquals(2, adminUserGroupListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUser adminUser = adminUserFactoryForTest.newAdminUser();
		Integer id = adminUser.getId();
		
		// When
		String viewName = adminUserController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserService).delete(id);
		assertEquals("redirect:/adminUser", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUser adminUser = adminUserFactoryForTest.newAdminUser();
		Integer id = adminUser.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminUserService).delete(id);
		
		// When
		String viewName = adminUserController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserService).delete(id);
		assertEquals("redirect:/adminUser", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminUser.error.delete", exception);
	}
	
	
}
