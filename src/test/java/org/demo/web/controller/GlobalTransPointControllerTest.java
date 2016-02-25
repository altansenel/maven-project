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
import org.demo.bean.GlobalTransPoint;
import org.demo.test.GlobalTransPointFactoryForTest;

//--- Services 
import org.demo.business.service.GlobalTransPointService;


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
public class GlobalTransPointControllerTest {
	
	@InjectMocks
	private GlobalTransPointController globalTransPointController;
	@Mock
	private GlobalTransPointService globalTransPointService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<GlobalTransPoint> list = new ArrayList<GlobalTransPoint>();
		when(globalTransPointService.findAll()).thenReturn(list);
		
		// When
		String viewName = globalTransPointController.list(model);
		
		// Then
		assertEquals("globalTransPoint/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = globalTransPointController.formForCreate(model);
		
		// Then
		assertEquals("globalTransPoint/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((GlobalTransPoint)modelMap.get("globalTransPoint")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalTransPoint/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalTransPoint globalTransPoint = globalTransPointFactoryForTest.newGlobalTransPoint();
		Integer id = globalTransPoint.getId();
		when(globalTransPointService.findById(id)).thenReturn(globalTransPoint);
		
		// When
		String viewName = globalTransPointController.formForUpdate(model, id);
		
		// Then
		assertEquals("globalTransPoint/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalTransPoint, (GlobalTransPoint) modelMap.get("globalTransPoint"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalTransPoint/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalTransPoint globalTransPoint = globalTransPointFactoryForTest.newGlobalTransPoint();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalTransPoint globalTransPointCreated = new GlobalTransPoint();
		when(globalTransPointService.create(globalTransPoint)).thenReturn(globalTransPointCreated); 
		
		// When
		String viewName = globalTransPointController.create(globalTransPoint, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalTransPoint/form/"+globalTransPoint.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalTransPointCreated, (GlobalTransPoint) modelMap.get("globalTransPoint"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalTransPoint globalTransPoint = globalTransPointFactoryForTest.newGlobalTransPoint();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalTransPointController.create(globalTransPoint, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalTransPoint/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalTransPoint, (GlobalTransPoint) modelMap.get("globalTransPoint"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalTransPoint/create", modelMap.get("saveAction"));
		
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

		GlobalTransPoint globalTransPoint = globalTransPointFactoryForTest.newGlobalTransPoint();
		
		Exception exception = new RuntimeException("test exception");
		when(globalTransPointService.create(globalTransPoint)).thenThrow(exception);
		
		// When
		String viewName = globalTransPointController.create(globalTransPoint, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalTransPoint/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalTransPoint, (GlobalTransPoint) modelMap.get("globalTransPoint"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalTransPoint/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalTransPoint.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalTransPoint globalTransPoint = globalTransPointFactoryForTest.newGlobalTransPoint();
		Integer id = globalTransPoint.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalTransPoint globalTransPointSaved = new GlobalTransPoint();
		globalTransPointSaved.setId(id);
		when(globalTransPointService.update(globalTransPoint)).thenReturn(globalTransPointSaved); 
		
		// When
		String viewName = globalTransPointController.update(globalTransPoint, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalTransPoint/form/"+globalTransPoint.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalTransPointSaved, (GlobalTransPoint) modelMap.get("globalTransPoint"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalTransPoint globalTransPoint = globalTransPointFactoryForTest.newGlobalTransPoint();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalTransPointController.update(globalTransPoint, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalTransPoint/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalTransPoint, (GlobalTransPoint) modelMap.get("globalTransPoint"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalTransPoint/update", modelMap.get("saveAction"));
		
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

		GlobalTransPoint globalTransPoint = globalTransPointFactoryForTest.newGlobalTransPoint();
		
		Exception exception = new RuntimeException("test exception");
		when(globalTransPointService.update(globalTransPoint)).thenThrow(exception);
		
		// When
		String viewName = globalTransPointController.update(globalTransPoint, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalTransPoint/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalTransPoint, (GlobalTransPoint) modelMap.get("globalTransPoint"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalTransPoint/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalTransPoint.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalTransPoint globalTransPoint = globalTransPointFactoryForTest.newGlobalTransPoint();
		Integer id = globalTransPoint.getId();
		
		// When
		String viewName = globalTransPointController.delete(redirectAttributes, id);
		
		// Then
		verify(globalTransPointService).delete(id);
		assertEquals("redirect:/globalTransPoint", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalTransPoint globalTransPoint = globalTransPointFactoryForTest.newGlobalTransPoint();
		Integer id = globalTransPoint.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(globalTransPointService).delete(id);
		
		// When
		String viewName = globalTransPointController.delete(redirectAttributes, id);
		
		// Then
		verify(globalTransPointService).delete(id);
		assertEquals("redirect:/globalTransPoint", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "globalTransPoint.error.delete", exception);
	}
	
	
}
