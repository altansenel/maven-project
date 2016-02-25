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
import org.demo.bean.AdminUserGroup;
import org.demo.test.AdminUserGroupFactoryForTest;

//--- Services 
import org.demo.business.service.AdminUserGroupService;


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
public class AdminUserGroupControllerTest {
	
	@InjectMocks
	private AdminUserGroupController adminUserGroupController;
	@Mock
	private AdminUserGroupService adminUserGroupService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private AdminUserGroupFactoryForTest adminUserGroupFactoryForTest = new AdminUserGroupFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminUserGroup> list = new ArrayList<AdminUserGroup>();
		when(adminUserGroupService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminUserGroupController.list(model);
		
		// Then
		assertEquals("adminUserGroup/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminUserGroupController.formForCreate(model);
		
		// Then
		assertEquals("adminUserGroup/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminUserGroup)modelMap.get("adminUserGroup")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserGroup/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserGroup adminUserGroup = adminUserGroupFactoryForTest.newAdminUserGroup();
		Integer id = adminUserGroup.getId();
		when(adminUserGroupService.findById(id)).thenReturn(adminUserGroup);
		
		// When
		String viewName = adminUserGroupController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminUserGroup/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGroup, (AdminUserGroup) modelMap.get("adminUserGroup"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserGroup/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUserGroup adminUserGroup = adminUserGroupFactoryForTest.newAdminUserGroup();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUserGroup adminUserGroupCreated = new AdminUserGroup();
		when(adminUserGroupService.create(adminUserGroup)).thenReturn(adminUserGroupCreated); 
		
		// When
		String viewName = adminUserGroupController.create(adminUserGroup, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUserGroup/form/"+adminUserGroup.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGroupCreated, (AdminUserGroup) modelMap.get("adminUserGroup"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserGroup adminUserGroup = adminUserGroupFactoryForTest.newAdminUserGroup();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserGroupController.create(adminUserGroup, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserGroup/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGroup, (AdminUserGroup) modelMap.get("adminUserGroup"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserGroup/create", modelMap.get("saveAction"));
		
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

		AdminUserGroup adminUserGroup = adminUserGroupFactoryForTest.newAdminUserGroup();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserGroupService.create(adminUserGroup)).thenThrow(exception);
		
		// When
		String viewName = adminUserGroupController.create(adminUserGroup, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserGroup/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGroup, (AdminUserGroup) modelMap.get("adminUserGroup"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminUserGroup/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUserGroup.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminUserGroup adminUserGroup = adminUserGroupFactoryForTest.newAdminUserGroup();
		Integer id = adminUserGroup.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminUserGroup adminUserGroupSaved = new AdminUserGroup();
		adminUserGroupSaved.setId(id);
		when(adminUserGroupService.update(adminUserGroup)).thenReturn(adminUserGroupSaved); 
		
		// When
		String viewName = adminUserGroupController.update(adminUserGroup, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminUserGroup/form/"+adminUserGroup.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGroupSaved, (AdminUserGroup) modelMap.get("adminUserGroup"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminUserGroup adminUserGroup = adminUserGroupFactoryForTest.newAdminUserGroup();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminUserGroupController.update(adminUserGroup, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserGroup/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGroup, (AdminUserGroup) modelMap.get("adminUserGroup"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserGroup/update", modelMap.get("saveAction"));
		
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

		AdminUserGroup adminUserGroup = adminUserGroupFactoryForTest.newAdminUserGroup();
		
		Exception exception = new RuntimeException("test exception");
		when(adminUserGroupService.update(adminUserGroup)).thenThrow(exception);
		
		// When
		String viewName = adminUserGroupController.update(adminUserGroup, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminUserGroup/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminUserGroup, (AdminUserGroup) modelMap.get("adminUserGroup"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminUserGroup/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminUserGroup.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUserGroup adminUserGroup = adminUserGroupFactoryForTest.newAdminUserGroup();
		Integer id = adminUserGroup.getId();
		
		// When
		String viewName = adminUserGroupController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserGroupService).delete(id);
		assertEquals("redirect:/adminUserGroup", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminUserGroup adminUserGroup = adminUserGroupFactoryForTest.newAdminUserGroup();
		Integer id = adminUserGroup.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminUserGroupService).delete(id);
		
		// When
		String viewName = adminUserGroupController.delete(redirectAttributes, id);
		
		// Then
		verify(adminUserGroupService).delete(id);
		assertEquals("redirect:/adminUserGroup", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminUserGroup.error.delete", exception);
	}
	
	
}
