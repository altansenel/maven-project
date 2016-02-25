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
import org.demo.bean.Safe;
import org.demo.test.SafeFactoryForTest;

//--- Services 
import org.demo.business.service.SafeService;


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
public class SafeControllerTest {
	
	@InjectMocks
	private SafeController safeController;
	@Mock
	private SafeService safeService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private SafeFactoryForTest safeFactoryForTest = new SafeFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<Safe> list = new ArrayList<Safe>();
		when(safeService.findAll()).thenReturn(list);
		
		// When
		String viewName = safeController.list(model);
		
		// Then
		assertEquals("safe/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = safeController.formForCreate(model);
		
		// Then
		assertEquals("safe/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((Safe)modelMap.get("safe")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safe/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Safe safe = safeFactoryForTest.newSafe();
		Integer id = safe.getId();
		when(safeService.findById(id)).thenReturn(safe);
		
		// When
		String viewName = safeController.formForUpdate(model, id);
		
		// Then
		assertEquals("safe/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safe, (Safe) modelMap.get("safe"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safe/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Safe safe = safeFactoryForTest.newSafe();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Safe safeCreated = new Safe();
		when(safeService.create(safe)).thenReturn(safeCreated); 
		
		// When
		String viewName = safeController.create(safe, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/safe/form/"+safe.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeCreated, (Safe) modelMap.get("safe"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Safe safe = safeFactoryForTest.newSafe();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = safeController.create(safe, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safe/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safe, (Safe) modelMap.get("safe"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safe/create", modelMap.get("saveAction"));
		
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

		Safe safe = safeFactoryForTest.newSafe();
		
		Exception exception = new RuntimeException("test exception");
		when(safeService.create(safe)).thenThrow(exception);
		
		// When
		String viewName = safeController.create(safe, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safe/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safe, (Safe) modelMap.get("safe"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safe/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "safe.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Safe safe = safeFactoryForTest.newSafe();
		Integer id = safe.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Safe safeSaved = new Safe();
		safeSaved.setId(id);
		when(safeService.update(safe)).thenReturn(safeSaved); 
		
		// When
		String viewName = safeController.update(safe, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/safe/form/"+safe.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeSaved, (Safe) modelMap.get("safe"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Safe safe = safeFactoryForTest.newSafe();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = safeController.update(safe, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safe/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safe, (Safe) modelMap.get("safe"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safe/update", modelMap.get("saveAction"));
		
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

		Safe safe = safeFactoryForTest.newSafe();
		
		Exception exception = new RuntimeException("test exception");
		when(safeService.update(safe)).thenThrow(exception);
		
		// When
		String viewName = safeController.update(safe, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safe/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safe, (Safe) modelMap.get("safe"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safe/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "safe.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Safe safe = safeFactoryForTest.newSafe();
		Integer id = safe.getId();
		
		// When
		String viewName = safeController.delete(redirectAttributes, id);
		
		// Then
		verify(safeService).delete(id);
		assertEquals("redirect:/safe", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Safe safe = safeFactoryForTest.newSafe();
		Integer id = safe.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(safeService).delete(id);
		
		// When
		String viewName = safeController.delete(redirectAttributes, id);
		
		// Then
		verify(safeService).delete(id);
		assertEquals("redirect:/safe", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "safe.error.delete", exception);
	}
	
	
}
