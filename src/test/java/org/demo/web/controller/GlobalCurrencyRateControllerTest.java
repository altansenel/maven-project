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
import org.demo.bean.GlobalCurrencyRate;
import org.demo.test.GlobalCurrencyRateFactoryForTest;

//--- Services 
import org.demo.business.service.GlobalCurrencyRateService;


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
public class GlobalCurrencyRateControllerTest {
	
	@InjectMocks
	private GlobalCurrencyRateController globalCurrencyRateController;
	@Mock
	private GlobalCurrencyRateService globalCurrencyRateService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private GlobalCurrencyRateFactoryForTest globalCurrencyRateFactoryForTest = new GlobalCurrencyRateFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<GlobalCurrencyRate> list = new ArrayList<GlobalCurrencyRate>();
		when(globalCurrencyRateService.findAll()).thenReturn(list);
		
		// When
		String viewName = globalCurrencyRateController.list(model);
		
		// Then
		assertEquals("globalCurrencyRate/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = globalCurrencyRateController.formForCreate(model);
		
		// Then
		assertEquals("globalCurrencyRate/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((GlobalCurrencyRate)modelMap.get("globalCurrencyRate")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalCurrencyRate/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalCurrencyRate globalCurrencyRate = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		Integer id = globalCurrencyRate.getId();
		when(globalCurrencyRateService.findById(id)).thenReturn(globalCurrencyRate);
		
		// When
		String viewName = globalCurrencyRateController.formForUpdate(model, id);
		
		// Then
		assertEquals("globalCurrencyRate/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRate, (GlobalCurrencyRate) modelMap.get("globalCurrencyRate"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalCurrencyRate/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalCurrencyRate globalCurrencyRate = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalCurrencyRate globalCurrencyRateCreated = new GlobalCurrencyRate();
		when(globalCurrencyRateService.create(globalCurrencyRate)).thenReturn(globalCurrencyRateCreated); 
		
		// When
		String viewName = globalCurrencyRateController.create(globalCurrencyRate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalCurrencyRate/form/"+globalCurrencyRate.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRateCreated, (GlobalCurrencyRate) modelMap.get("globalCurrencyRate"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalCurrencyRate globalCurrencyRate = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalCurrencyRateController.create(globalCurrencyRate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrencyRate/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRate, (GlobalCurrencyRate) modelMap.get("globalCurrencyRate"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalCurrencyRate/create", modelMap.get("saveAction"));
		
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

		GlobalCurrencyRate globalCurrencyRate = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		
		Exception exception = new RuntimeException("test exception");
		when(globalCurrencyRateService.create(globalCurrencyRate)).thenThrow(exception);
		
		// When
		String viewName = globalCurrencyRateController.create(globalCurrencyRate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrencyRate/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRate, (GlobalCurrencyRate) modelMap.get("globalCurrencyRate"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalCurrencyRate/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalCurrencyRate.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalCurrencyRate globalCurrencyRate = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		Integer id = globalCurrencyRate.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalCurrencyRate globalCurrencyRateSaved = new GlobalCurrencyRate();
		globalCurrencyRateSaved.setId(id);
		when(globalCurrencyRateService.update(globalCurrencyRate)).thenReturn(globalCurrencyRateSaved); 
		
		// When
		String viewName = globalCurrencyRateController.update(globalCurrencyRate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalCurrencyRate/form/"+globalCurrencyRate.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRateSaved, (GlobalCurrencyRate) modelMap.get("globalCurrencyRate"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalCurrencyRate globalCurrencyRate = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalCurrencyRateController.update(globalCurrencyRate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrencyRate/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRate, (GlobalCurrencyRate) modelMap.get("globalCurrencyRate"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalCurrencyRate/update", modelMap.get("saveAction"));
		
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

		GlobalCurrencyRate globalCurrencyRate = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		
		Exception exception = new RuntimeException("test exception");
		when(globalCurrencyRateService.update(globalCurrencyRate)).thenThrow(exception);
		
		// When
		String viewName = globalCurrencyRateController.update(globalCurrencyRate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrencyRate/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRate, (GlobalCurrencyRate) modelMap.get("globalCurrencyRate"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalCurrencyRate/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalCurrencyRate.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalCurrencyRate globalCurrencyRate = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		Integer id = globalCurrencyRate.getId();
		
		// When
		String viewName = globalCurrencyRateController.delete(redirectAttributes, id);
		
		// Then
		verify(globalCurrencyRateService).delete(id);
		assertEquals("redirect:/globalCurrencyRate", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalCurrencyRate globalCurrencyRate = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		Integer id = globalCurrencyRate.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(globalCurrencyRateService).delete(id);
		
		// When
		String viewName = globalCurrencyRateController.delete(redirectAttributes, id);
		
		// Then
		verify(globalCurrencyRateService).delete(id);
		assertEquals("redirect:/globalCurrencyRate", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "globalCurrencyRate.error.delete", exception);
	}
	
	
}
