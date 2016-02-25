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
import org.demo.bean.GlobalProfile;
import org.demo.test.GlobalProfileFactoryForTest;

//--- Services 
import org.demo.business.service.GlobalProfileService;


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
public class GlobalProfileControllerTest {
	
	@InjectMocks
	private GlobalProfileController globalProfileController;
	@Mock
	private GlobalProfileService globalProfileService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private GlobalProfileFactoryForTest globalProfileFactoryForTest = new GlobalProfileFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<GlobalProfile> list = new ArrayList<GlobalProfile>();
		when(globalProfileService.findAll()).thenReturn(list);
		
		// When
		String viewName = globalProfileController.list(model);
		
		// Then
		assertEquals("globalProfile/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = globalProfileController.formForCreate(model);
		
		// Then
		assertEquals("globalProfile/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((GlobalProfile)modelMap.get("globalProfile")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalProfile/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalProfile globalProfile = globalProfileFactoryForTest.newGlobalProfile();
		Integer id = globalProfile.getId();
		when(globalProfileService.findById(id)).thenReturn(globalProfile);
		
		// When
		String viewName = globalProfileController.formForUpdate(model, id);
		
		// Then
		assertEquals("globalProfile/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalProfile, (GlobalProfile) modelMap.get("globalProfile"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalProfile/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalProfile globalProfile = globalProfileFactoryForTest.newGlobalProfile();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalProfile globalProfileCreated = new GlobalProfile();
		when(globalProfileService.create(globalProfile)).thenReturn(globalProfileCreated); 
		
		// When
		String viewName = globalProfileController.create(globalProfile, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalProfile/form/"+globalProfile.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalProfileCreated, (GlobalProfile) modelMap.get("globalProfile"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalProfile globalProfile = globalProfileFactoryForTest.newGlobalProfile();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalProfileController.create(globalProfile, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalProfile/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalProfile, (GlobalProfile) modelMap.get("globalProfile"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalProfile/create", modelMap.get("saveAction"));
		
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

		GlobalProfile globalProfile = globalProfileFactoryForTest.newGlobalProfile();
		
		Exception exception = new RuntimeException("test exception");
		when(globalProfileService.create(globalProfile)).thenThrow(exception);
		
		// When
		String viewName = globalProfileController.create(globalProfile, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalProfile/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalProfile, (GlobalProfile) modelMap.get("globalProfile"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalProfile/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalProfile.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalProfile globalProfile = globalProfileFactoryForTest.newGlobalProfile();
		Integer id = globalProfile.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalProfile globalProfileSaved = new GlobalProfile();
		globalProfileSaved.setId(id);
		when(globalProfileService.update(globalProfile)).thenReturn(globalProfileSaved); 
		
		// When
		String viewName = globalProfileController.update(globalProfile, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalProfile/form/"+globalProfile.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalProfileSaved, (GlobalProfile) modelMap.get("globalProfile"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalProfile globalProfile = globalProfileFactoryForTest.newGlobalProfile();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalProfileController.update(globalProfile, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalProfile/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalProfile, (GlobalProfile) modelMap.get("globalProfile"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalProfile/update", modelMap.get("saveAction"));
		
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

		GlobalProfile globalProfile = globalProfileFactoryForTest.newGlobalProfile();
		
		Exception exception = new RuntimeException("test exception");
		when(globalProfileService.update(globalProfile)).thenThrow(exception);
		
		// When
		String viewName = globalProfileController.update(globalProfile, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalProfile/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalProfile, (GlobalProfile) modelMap.get("globalProfile"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalProfile/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalProfile.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalProfile globalProfile = globalProfileFactoryForTest.newGlobalProfile();
		Integer id = globalProfile.getId();
		
		// When
		String viewName = globalProfileController.delete(redirectAttributes, id);
		
		// Then
		verify(globalProfileService).delete(id);
		assertEquals("redirect:/globalProfile", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalProfile globalProfile = globalProfileFactoryForTest.newGlobalProfile();
		Integer id = globalProfile.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(globalProfileService).delete(id);
		
		// When
		String viewName = globalProfileController.delete(redirectAttributes, id);
		
		// Then
		verify(globalProfileService).delete(id);
		assertEquals("redirect:/globalProfile", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "globalProfile.error.delete", exception);
	}
	
	
}
