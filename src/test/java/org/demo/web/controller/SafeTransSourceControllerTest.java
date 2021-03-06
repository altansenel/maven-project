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
import org.demo.bean.SafeTransSource;
import org.demo.test.SafeTransSourceFactoryForTest;

//--- Services 
import org.demo.business.service.SafeTransSourceService;


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
public class SafeTransSourceControllerTest {
	
	@InjectMocks
	private SafeTransSourceController safeTransSourceController;
	@Mock
	private SafeTransSourceService safeTransSourceService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private SafeTransSourceFactoryForTest safeTransSourceFactoryForTest = new SafeTransSourceFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<SafeTransSource> list = new ArrayList<SafeTransSource>();
		when(safeTransSourceService.findAll()).thenReturn(list);
		
		// When
		String viewName = safeTransSourceController.list(model);
		
		// Then
		assertEquals("safeTransSource/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = safeTransSourceController.formForCreate(model);
		
		// Then
		assertEquals("safeTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((SafeTransSource)modelMap.get("safeTransSource")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safeTransSource/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SafeTransSource safeTransSource = safeTransSourceFactoryForTest.newSafeTransSource();
		Integer id = safeTransSource.getId();
		when(safeTransSourceService.findById(id)).thenReturn(safeTransSource);
		
		// When
		String viewName = safeTransSourceController.formForUpdate(model, id);
		
		// Then
		assertEquals("safeTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTransSource, (SafeTransSource) modelMap.get("safeTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safeTransSource/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		SafeTransSource safeTransSource = safeTransSourceFactoryForTest.newSafeTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		SafeTransSource safeTransSourceCreated = new SafeTransSource();
		when(safeTransSourceService.create(safeTransSource)).thenReturn(safeTransSourceCreated); 
		
		// When
		String viewName = safeTransSourceController.create(safeTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/safeTransSource/form/"+safeTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTransSourceCreated, (SafeTransSource) modelMap.get("safeTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SafeTransSource safeTransSource = safeTransSourceFactoryForTest.newSafeTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = safeTransSourceController.create(safeTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTransSource, (SafeTransSource) modelMap.get("safeTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safeTransSource/create", modelMap.get("saveAction"));
		
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

		SafeTransSource safeTransSource = safeTransSourceFactoryForTest.newSafeTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(safeTransSourceService.create(safeTransSource)).thenThrow(exception);
		
		// When
		String viewName = safeTransSourceController.create(safeTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTransSource, (SafeTransSource) modelMap.get("safeTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safeTransSource/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "safeTransSource.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		SafeTransSource safeTransSource = safeTransSourceFactoryForTest.newSafeTransSource();
		Integer id = safeTransSource.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		SafeTransSource safeTransSourceSaved = new SafeTransSource();
		safeTransSourceSaved.setId(id);
		when(safeTransSourceService.update(safeTransSource)).thenReturn(safeTransSourceSaved); 
		
		// When
		String viewName = safeTransSourceController.update(safeTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/safeTransSource/form/"+safeTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTransSourceSaved, (SafeTransSource) modelMap.get("safeTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SafeTransSource safeTransSource = safeTransSourceFactoryForTest.newSafeTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = safeTransSourceController.update(safeTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTransSource, (SafeTransSource) modelMap.get("safeTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safeTransSource/update", modelMap.get("saveAction"));
		
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

		SafeTransSource safeTransSource = safeTransSourceFactoryForTest.newSafeTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(safeTransSourceService.update(safeTransSource)).thenThrow(exception);
		
		// When
		String viewName = safeTransSourceController.update(safeTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTransSource, (SafeTransSource) modelMap.get("safeTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safeTransSource/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "safeTransSource.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		SafeTransSource safeTransSource = safeTransSourceFactoryForTest.newSafeTransSource();
		Integer id = safeTransSource.getId();
		
		// When
		String viewName = safeTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(safeTransSourceService).delete(id);
		assertEquals("redirect:/safeTransSource", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		SafeTransSource safeTransSource = safeTransSourceFactoryForTest.newSafeTransSource();
		Integer id = safeTransSource.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(safeTransSourceService).delete(id);
		
		// When
		String viewName = safeTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(safeTransSourceService).delete(id);
		assertEquals("redirect:/safeTransSource", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "safeTransSource.error.delete", exception);
	}
	
	
}
