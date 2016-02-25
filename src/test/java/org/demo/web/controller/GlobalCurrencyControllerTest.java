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
import org.demo.bean.GlobalCurrency;
import org.demo.test.GlobalCurrencyFactoryForTest;

//--- Services 
import org.demo.business.service.GlobalCurrencyService;


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
public class GlobalCurrencyControllerTest {
	
	@InjectMocks
	private GlobalCurrencyController globalCurrencyController;
	@Mock
	private GlobalCurrencyService globalCurrencyService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private GlobalCurrencyFactoryForTest globalCurrencyFactoryForTest = new GlobalCurrencyFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<GlobalCurrency> list = new ArrayList<GlobalCurrency>();
		when(globalCurrencyService.findAll()).thenReturn(list);
		
		// When
		String viewName = globalCurrencyController.list(model);
		
		// Then
		assertEquals("globalCurrency/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = globalCurrencyController.formForCreate(model);
		
		// Then
		assertEquals("globalCurrency/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((GlobalCurrency)modelMap.get("globalCurrency")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalCurrency/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalCurrency globalCurrency = globalCurrencyFactoryForTest.newGlobalCurrency();
		Integer id = globalCurrency.getId();
		when(globalCurrencyService.findById(id)).thenReturn(globalCurrency);
		
		// When
		String viewName = globalCurrencyController.formForUpdate(model, id);
		
		// Then
		assertEquals("globalCurrency/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrency, (GlobalCurrency) modelMap.get("globalCurrency"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalCurrency/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalCurrency globalCurrency = globalCurrencyFactoryForTest.newGlobalCurrency();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalCurrency globalCurrencyCreated = new GlobalCurrency();
		when(globalCurrencyService.create(globalCurrency)).thenReturn(globalCurrencyCreated); 
		
		// When
		String viewName = globalCurrencyController.create(globalCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalCurrency/form/"+globalCurrency.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyCreated, (GlobalCurrency) modelMap.get("globalCurrency"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalCurrency globalCurrency = globalCurrencyFactoryForTest.newGlobalCurrency();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalCurrencyController.create(globalCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrency, (GlobalCurrency) modelMap.get("globalCurrency"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalCurrency/create", modelMap.get("saveAction"));
		
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

		GlobalCurrency globalCurrency = globalCurrencyFactoryForTest.newGlobalCurrency();
		
		Exception exception = new RuntimeException("test exception");
		when(globalCurrencyService.create(globalCurrency)).thenThrow(exception);
		
		// When
		String viewName = globalCurrencyController.create(globalCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrency, (GlobalCurrency) modelMap.get("globalCurrency"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalCurrency/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalCurrency.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalCurrency globalCurrency = globalCurrencyFactoryForTest.newGlobalCurrency();
		Integer id = globalCurrency.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalCurrency globalCurrencySaved = new GlobalCurrency();
		globalCurrencySaved.setId(id);
		when(globalCurrencyService.update(globalCurrency)).thenReturn(globalCurrencySaved); 
		
		// When
		String viewName = globalCurrencyController.update(globalCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalCurrency/form/"+globalCurrency.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencySaved, (GlobalCurrency) modelMap.get("globalCurrency"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalCurrency globalCurrency = globalCurrencyFactoryForTest.newGlobalCurrency();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalCurrencyController.update(globalCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrency, (GlobalCurrency) modelMap.get("globalCurrency"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalCurrency/update", modelMap.get("saveAction"));
		
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

		GlobalCurrency globalCurrency = globalCurrencyFactoryForTest.newGlobalCurrency();
		
		Exception exception = new RuntimeException("test exception");
		when(globalCurrencyService.update(globalCurrency)).thenThrow(exception);
		
		// When
		String viewName = globalCurrencyController.update(globalCurrency, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrency/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrency, (GlobalCurrency) modelMap.get("globalCurrency"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalCurrency/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalCurrency.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalCurrency globalCurrency = globalCurrencyFactoryForTest.newGlobalCurrency();
		Integer id = globalCurrency.getId();
		
		// When
		String viewName = globalCurrencyController.delete(redirectAttributes, id);
		
		// Then
		verify(globalCurrencyService).delete(id);
		assertEquals("redirect:/globalCurrency", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalCurrency globalCurrency = globalCurrencyFactoryForTest.newGlobalCurrency();
		Integer id = globalCurrency.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(globalCurrencyService).delete(id);
		
		// When
		String viewName = globalCurrencyController.delete(redirectAttributes, id);
		
		// Then
		verify(globalCurrencyService).delete(id);
		assertEquals("redirect:/globalCurrency", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "globalCurrency.error.delete", exception);
	}
	
	
}
