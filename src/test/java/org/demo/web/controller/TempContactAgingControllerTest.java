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
import org.demo.bean.TempContactAging;
import org.demo.test.TempContactAgingFactoryForTest;

//--- Services 
import org.demo.business.service.TempContactAgingService;


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
public class TempContactAgingControllerTest {
	
	@InjectMocks
	private TempContactAgingController tempContactAgingController;
	@Mock
	private TempContactAgingService tempContactAgingService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private TempContactAgingFactoryForTest tempContactAgingFactoryForTest = new TempContactAgingFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<TempContactAging> list = new ArrayList<TempContactAging>();
		when(tempContactAgingService.findAll()).thenReturn(list);
		
		// When
		String viewName = tempContactAgingController.list(model);
		
		// Then
		assertEquals("tempContactAging/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = tempContactAgingController.formForCreate(model);
		
		// Then
		assertEquals("tempContactAging/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((TempContactAging)modelMap.get("tempContactAging")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/tempContactAging/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		TempContactAging tempContactAging = tempContactAgingFactoryForTest.newTempContactAging();
		Integer id = tempContactAging.getId();
		when(tempContactAgingService.findById(id)).thenReturn(tempContactAging);
		
		// When
		String viewName = tempContactAgingController.formForUpdate(model, id);
		
		// Then
		assertEquals("tempContactAging/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(tempContactAging, (TempContactAging) modelMap.get("tempContactAging"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/tempContactAging/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		TempContactAging tempContactAging = tempContactAgingFactoryForTest.newTempContactAging();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		TempContactAging tempContactAgingCreated = new TempContactAging();
		when(tempContactAgingService.create(tempContactAging)).thenReturn(tempContactAgingCreated); 
		
		// When
		String viewName = tempContactAgingController.create(tempContactAging, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/tempContactAging/form/"+tempContactAging.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(tempContactAgingCreated, (TempContactAging) modelMap.get("tempContactAging"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		TempContactAging tempContactAging = tempContactAgingFactoryForTest.newTempContactAging();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = tempContactAgingController.create(tempContactAging, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("tempContactAging/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(tempContactAging, (TempContactAging) modelMap.get("tempContactAging"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/tempContactAging/create", modelMap.get("saveAction"));
		
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

		TempContactAging tempContactAging = tempContactAgingFactoryForTest.newTempContactAging();
		
		Exception exception = new RuntimeException("test exception");
		when(tempContactAgingService.create(tempContactAging)).thenThrow(exception);
		
		// When
		String viewName = tempContactAgingController.create(tempContactAging, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("tempContactAging/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(tempContactAging, (TempContactAging) modelMap.get("tempContactAging"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/tempContactAging/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "tempContactAging.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		TempContactAging tempContactAging = tempContactAgingFactoryForTest.newTempContactAging();
		Integer id = tempContactAging.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		TempContactAging tempContactAgingSaved = new TempContactAging();
		tempContactAgingSaved.setId(id);
		when(tempContactAgingService.update(tempContactAging)).thenReturn(tempContactAgingSaved); 
		
		// When
		String viewName = tempContactAgingController.update(tempContactAging, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/tempContactAging/form/"+tempContactAging.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(tempContactAgingSaved, (TempContactAging) modelMap.get("tempContactAging"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		TempContactAging tempContactAging = tempContactAgingFactoryForTest.newTempContactAging();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = tempContactAgingController.update(tempContactAging, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("tempContactAging/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(tempContactAging, (TempContactAging) modelMap.get("tempContactAging"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/tempContactAging/update", modelMap.get("saveAction"));
		
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

		TempContactAging tempContactAging = tempContactAgingFactoryForTest.newTempContactAging();
		
		Exception exception = new RuntimeException("test exception");
		when(tempContactAgingService.update(tempContactAging)).thenThrow(exception);
		
		// When
		String viewName = tempContactAgingController.update(tempContactAging, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("tempContactAging/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(tempContactAging, (TempContactAging) modelMap.get("tempContactAging"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/tempContactAging/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "tempContactAging.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		TempContactAging tempContactAging = tempContactAgingFactoryForTest.newTempContactAging();
		Integer id = tempContactAging.getId();
		
		// When
		String viewName = tempContactAgingController.delete(redirectAttributes, id);
		
		// Then
		verify(tempContactAgingService).delete(id);
		assertEquals("redirect:/tempContactAging", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		TempContactAging tempContactAging = tempContactAgingFactoryForTest.newTempContactAging();
		Integer id = tempContactAging.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(tempContactAgingService).delete(id);
		
		// When
		String viewName = tempContactAgingController.delete(redirectAttributes, id);
		
		// Then
		verify(tempContactAgingService).delete(id);
		assertEquals("redirect:/tempContactAging", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "tempContactAging.error.delete", exception);
	}
	
	
}
