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
import org.demo.bean.WaybillTransSource;
import org.demo.test.WaybillTransSourceFactoryForTest;

//--- Services 
import org.demo.business.service.WaybillTransSourceService;


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
public class WaybillTransSourceControllerTest {
	
	@InjectMocks
	private WaybillTransSourceController waybillTransSourceController;
	@Mock
	private WaybillTransSourceService waybillTransSourceService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private WaybillTransSourceFactoryForTest waybillTransSourceFactoryForTest = new WaybillTransSourceFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<WaybillTransSource> list = new ArrayList<WaybillTransSource>();
		when(waybillTransSourceService.findAll()).thenReturn(list);
		
		// When
		String viewName = waybillTransSourceController.list(model);
		
		// Then
		assertEquals("waybillTransSource/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = waybillTransSourceController.formForCreate(model);
		
		// Then
		assertEquals("waybillTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((WaybillTransSource)modelMap.get("waybillTransSource")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransSource/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransSource waybillTransSource = waybillTransSourceFactoryForTest.newWaybillTransSource();
		Integer id = waybillTransSource.getId();
		when(waybillTransSourceService.findById(id)).thenReturn(waybillTransSource);
		
		// When
		String viewName = waybillTransSourceController.formForUpdate(model, id);
		
		// Then
		assertEquals("waybillTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransSource, (WaybillTransSource) modelMap.get("waybillTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransSource/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransSource waybillTransSource = waybillTransSourceFactoryForTest.newWaybillTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransSource waybillTransSourceCreated = new WaybillTransSource();
		when(waybillTransSourceService.create(waybillTransSource)).thenReturn(waybillTransSourceCreated); 
		
		// When
		String viewName = waybillTransSourceController.create(waybillTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransSource/form/"+waybillTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransSourceCreated, (WaybillTransSource) modelMap.get("waybillTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransSource waybillTransSource = waybillTransSourceFactoryForTest.newWaybillTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransSourceController.create(waybillTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransSource, (WaybillTransSource) modelMap.get("waybillTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransSource/create", modelMap.get("saveAction"));
		
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

		WaybillTransSource waybillTransSource = waybillTransSourceFactoryForTest.newWaybillTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransSourceService.create(waybillTransSource)).thenThrow(exception);
		
		// When
		String viewName = waybillTransSourceController.create(waybillTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransSource, (WaybillTransSource) modelMap.get("waybillTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransSource/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransSource.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransSource waybillTransSource = waybillTransSourceFactoryForTest.newWaybillTransSource();
		Integer id = waybillTransSource.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransSource waybillTransSourceSaved = new WaybillTransSource();
		waybillTransSourceSaved.setId(id);
		when(waybillTransSourceService.update(waybillTransSource)).thenReturn(waybillTransSourceSaved); 
		
		// When
		String viewName = waybillTransSourceController.update(waybillTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransSource/form/"+waybillTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransSourceSaved, (WaybillTransSource) modelMap.get("waybillTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransSource waybillTransSource = waybillTransSourceFactoryForTest.newWaybillTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransSourceController.update(waybillTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransSource, (WaybillTransSource) modelMap.get("waybillTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransSource/update", modelMap.get("saveAction"));
		
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

		WaybillTransSource waybillTransSource = waybillTransSourceFactoryForTest.newWaybillTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransSourceService.update(waybillTransSource)).thenThrow(exception);
		
		// When
		String viewName = waybillTransSourceController.update(waybillTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransSource, (WaybillTransSource) modelMap.get("waybillTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransSource/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransSource.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransSource waybillTransSource = waybillTransSourceFactoryForTest.newWaybillTransSource();
		Integer id = waybillTransSource.getId();
		
		// When
		String viewName = waybillTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransSourceService).delete(id);
		assertEquals("redirect:/waybillTransSource", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransSource waybillTransSource = waybillTransSourceFactoryForTest.newWaybillTransSource();
		Integer id = waybillTransSource.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(waybillTransSourceService).delete(id);
		
		// When
		String viewName = waybillTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransSourceService).delete(id);
		assertEquals("redirect:/waybillTransSource", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "waybillTransSource.error.delete", exception);
	}
	
	
}
