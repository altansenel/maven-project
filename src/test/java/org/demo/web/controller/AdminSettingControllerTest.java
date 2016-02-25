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
import org.demo.bean.AdminSetting;
import org.demo.test.AdminSettingFactoryForTest;

//--- Services 
import org.demo.business.service.AdminSettingService;


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
public class AdminSettingControllerTest {
	
	@InjectMocks
	private AdminSettingController adminSettingController;
	@Mock
	private AdminSettingService adminSettingService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private AdminSettingFactoryForTest adminSettingFactoryForTest = new AdminSettingFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminSetting> list = new ArrayList<AdminSetting>();
		when(adminSettingService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminSettingController.list(model);
		
		// Then
		assertEquals("adminSetting/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminSettingController.formForCreate(model);
		
		// Then
		assertEquals("adminSetting/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminSetting)modelMap.get("adminSetting")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminSetting/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();
		Integer id = adminSetting.getId();
		when(adminSettingService.findById(id)).thenReturn(adminSetting);
		
		// When
		String viewName = adminSettingController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminSetting/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminSetting, (AdminSetting) modelMap.get("adminSetting"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminSetting/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminSetting adminSettingCreated = new AdminSetting();
		when(adminSettingService.create(adminSetting)).thenReturn(adminSettingCreated); 
		
		// When
		String viewName = adminSettingController.create(adminSetting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminSetting/form/"+adminSetting.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminSettingCreated, (AdminSetting) modelMap.get("adminSetting"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminSettingController.create(adminSetting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminSetting/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminSetting, (AdminSetting) modelMap.get("adminSetting"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminSetting/create", modelMap.get("saveAction"));
		
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

		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();
		
		Exception exception = new RuntimeException("test exception");
		when(adminSettingService.create(adminSetting)).thenThrow(exception);
		
		// When
		String viewName = adminSettingController.create(adminSetting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminSetting/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminSetting, (AdminSetting) modelMap.get("adminSetting"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminSetting/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminSetting.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();
		Integer id = adminSetting.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminSetting adminSettingSaved = new AdminSetting();
		adminSettingSaved.setId(id);
		when(adminSettingService.update(adminSetting)).thenReturn(adminSettingSaved); 
		
		// When
		String viewName = adminSettingController.update(adminSetting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminSetting/form/"+adminSetting.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminSettingSaved, (AdminSetting) modelMap.get("adminSetting"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminSettingController.update(adminSetting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminSetting/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminSetting, (AdminSetting) modelMap.get("adminSetting"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminSetting/update", modelMap.get("saveAction"));
		
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

		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();
		
		Exception exception = new RuntimeException("test exception");
		when(adminSettingService.update(adminSetting)).thenThrow(exception);
		
		// When
		String viewName = adminSettingController.update(adminSetting, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminSetting/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminSetting, (AdminSetting) modelMap.get("adminSetting"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminSetting/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminSetting.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();
		Integer id = adminSetting.getId();
		
		// When
		String viewName = adminSettingController.delete(redirectAttributes, id);
		
		// Then
		verify(adminSettingService).delete(id);
		assertEquals("redirect:/adminSetting", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminSetting adminSetting = adminSettingFactoryForTest.newAdminSetting();
		Integer id = adminSetting.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminSettingService).delete(id);
		
		// When
		String viewName = adminSettingController.delete(redirectAttributes, id);
		
		// Then
		verify(adminSettingService).delete(id);
		assertEquals("redirect:/adminSetting", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminSetting.error.delete", exception);
	}
	
	
}
