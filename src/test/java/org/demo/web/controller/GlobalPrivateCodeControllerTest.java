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
import org.demo.bean.GlobalPrivateCode;
import org.demo.test.GlobalPrivateCodeFactoryForTest;

//--- Services 
import org.demo.business.service.GlobalPrivateCodeService;


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
public class GlobalPrivateCodeControllerTest {
	
	@InjectMocks
	private GlobalPrivateCodeController globalPrivateCodeController;
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<GlobalPrivateCode> list = new ArrayList<GlobalPrivateCode>();
		when(globalPrivateCodeService.findAll()).thenReturn(list);
		
		// When
		String viewName = globalPrivateCodeController.list(model);
		
		// Then
		assertEquals("globalPrivateCode/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = globalPrivateCodeController.formForCreate(model);
		
		// Then
		assertEquals("globalPrivateCode/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((GlobalPrivateCode)modelMap.get("globalPrivateCode")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalPrivateCode/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalPrivateCode globalPrivateCode = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		Integer id = globalPrivateCode.getId();
		when(globalPrivateCodeService.findById(id)).thenReturn(globalPrivateCode);
		
		// When
		String viewName = globalPrivateCodeController.formForUpdate(model, id);
		
		// Then
		assertEquals("globalPrivateCode/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalPrivateCode, (GlobalPrivateCode) modelMap.get("globalPrivateCode"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalPrivateCode/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalPrivateCode globalPrivateCode = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalPrivateCode globalPrivateCodeCreated = new GlobalPrivateCode();
		when(globalPrivateCodeService.create(globalPrivateCode)).thenReturn(globalPrivateCodeCreated); 
		
		// When
		String viewName = globalPrivateCodeController.create(globalPrivateCode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalPrivateCode/form/"+globalPrivateCode.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalPrivateCodeCreated, (GlobalPrivateCode) modelMap.get("globalPrivateCode"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalPrivateCode globalPrivateCode = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalPrivateCodeController.create(globalPrivateCode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalPrivateCode/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalPrivateCode, (GlobalPrivateCode) modelMap.get("globalPrivateCode"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalPrivateCode/create", modelMap.get("saveAction"));
		
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

		GlobalPrivateCode globalPrivateCode = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		
		Exception exception = new RuntimeException("test exception");
		when(globalPrivateCodeService.create(globalPrivateCode)).thenThrow(exception);
		
		// When
		String viewName = globalPrivateCodeController.create(globalPrivateCode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalPrivateCode/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalPrivateCode, (GlobalPrivateCode) modelMap.get("globalPrivateCode"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalPrivateCode/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalPrivateCode.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalPrivateCode globalPrivateCode = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		Integer id = globalPrivateCode.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalPrivateCode globalPrivateCodeSaved = new GlobalPrivateCode();
		globalPrivateCodeSaved.setId(id);
		when(globalPrivateCodeService.update(globalPrivateCode)).thenReturn(globalPrivateCodeSaved); 
		
		// When
		String viewName = globalPrivateCodeController.update(globalPrivateCode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalPrivateCode/form/"+globalPrivateCode.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalPrivateCodeSaved, (GlobalPrivateCode) modelMap.get("globalPrivateCode"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalPrivateCode globalPrivateCode = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalPrivateCodeController.update(globalPrivateCode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalPrivateCode/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalPrivateCode, (GlobalPrivateCode) modelMap.get("globalPrivateCode"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalPrivateCode/update", modelMap.get("saveAction"));
		
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

		GlobalPrivateCode globalPrivateCode = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		
		Exception exception = new RuntimeException("test exception");
		when(globalPrivateCodeService.update(globalPrivateCode)).thenThrow(exception);
		
		// When
		String viewName = globalPrivateCodeController.update(globalPrivateCode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalPrivateCode/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalPrivateCode, (GlobalPrivateCode) modelMap.get("globalPrivateCode"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalPrivateCode/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalPrivateCode.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalPrivateCode globalPrivateCode = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		Integer id = globalPrivateCode.getId();
		
		// When
		String viewName = globalPrivateCodeController.delete(redirectAttributes, id);
		
		// Then
		verify(globalPrivateCodeService).delete(id);
		assertEquals("redirect:/globalPrivateCode", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalPrivateCode globalPrivateCode = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		Integer id = globalPrivateCode.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(globalPrivateCodeService).delete(id);
		
		// When
		String viewName = globalPrivateCodeController.delete(redirectAttributes, id);
		
		// Then
		verify(globalPrivateCodeService).delete(id);
		assertEquals("redirect:/globalPrivateCode", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "globalPrivateCode.error.delete", exception);
	}
	
	
}
