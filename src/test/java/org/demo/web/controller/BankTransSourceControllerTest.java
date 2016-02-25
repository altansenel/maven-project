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
import org.demo.bean.BankTransSource;
import org.demo.test.BankTransSourceFactoryForTest;

//--- Services 
import org.demo.business.service.BankTransSourceService;


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
public class BankTransSourceControllerTest {
	
	@InjectMocks
	private BankTransSourceController bankTransSourceController;
	@Mock
	private BankTransSourceService bankTransSourceService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private BankTransSourceFactoryForTest bankTransSourceFactoryForTest = new BankTransSourceFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<BankTransSource> list = new ArrayList<BankTransSource>();
		when(bankTransSourceService.findAll()).thenReturn(list);
		
		// When
		String viewName = bankTransSourceController.list(model);
		
		// Then
		assertEquals("bankTransSource/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = bankTransSourceController.formForCreate(model);
		
		// Then
		assertEquals("bankTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((BankTransSource)modelMap.get("bankTransSource")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bankTransSource/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		BankTransSource bankTransSource = bankTransSourceFactoryForTest.newBankTransSource();
		Integer id = bankTransSource.getId();
		when(bankTransSourceService.findById(id)).thenReturn(bankTransSource);
		
		// When
		String viewName = bankTransSourceController.formForUpdate(model, id);
		
		// Then
		assertEquals("bankTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTransSource, (BankTransSource) modelMap.get("bankTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bankTransSource/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		BankTransSource bankTransSource = bankTransSourceFactoryForTest.newBankTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		BankTransSource bankTransSourceCreated = new BankTransSource();
		when(bankTransSourceService.create(bankTransSource)).thenReturn(bankTransSourceCreated); 
		
		// When
		String viewName = bankTransSourceController.create(bankTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/bankTransSource/form/"+bankTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTransSourceCreated, (BankTransSource) modelMap.get("bankTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		BankTransSource bankTransSource = bankTransSourceFactoryForTest.newBankTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = bankTransSourceController.create(bankTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTransSource, (BankTransSource) modelMap.get("bankTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bankTransSource/create", modelMap.get("saveAction"));
		
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

		BankTransSource bankTransSource = bankTransSourceFactoryForTest.newBankTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(bankTransSourceService.create(bankTransSource)).thenThrow(exception);
		
		// When
		String viewName = bankTransSourceController.create(bankTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTransSource, (BankTransSource) modelMap.get("bankTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bankTransSource/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "bankTransSource.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		BankTransSource bankTransSource = bankTransSourceFactoryForTest.newBankTransSource();
		Integer id = bankTransSource.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		BankTransSource bankTransSourceSaved = new BankTransSource();
		bankTransSourceSaved.setId(id);
		when(bankTransSourceService.update(bankTransSource)).thenReturn(bankTransSourceSaved); 
		
		// When
		String viewName = bankTransSourceController.update(bankTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/bankTransSource/form/"+bankTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTransSourceSaved, (BankTransSource) modelMap.get("bankTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		BankTransSource bankTransSource = bankTransSourceFactoryForTest.newBankTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = bankTransSourceController.update(bankTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTransSource, (BankTransSource) modelMap.get("bankTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bankTransSource/update", modelMap.get("saveAction"));
		
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

		BankTransSource bankTransSource = bankTransSourceFactoryForTest.newBankTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(bankTransSourceService.update(bankTransSource)).thenThrow(exception);
		
		// When
		String viewName = bankTransSourceController.update(bankTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTransSource, (BankTransSource) modelMap.get("bankTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bankTransSource/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "bankTransSource.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		BankTransSource bankTransSource = bankTransSourceFactoryForTest.newBankTransSource();
		Integer id = bankTransSource.getId();
		
		// When
		String viewName = bankTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(bankTransSourceService).delete(id);
		assertEquals("redirect:/bankTransSource", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		BankTransSource bankTransSource = bankTransSourceFactoryForTest.newBankTransSource();
		Integer id = bankTransSource.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(bankTransSourceService).delete(id);
		
		// When
		String viewName = bankTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(bankTransSourceService).delete(id);
		assertEquals("redirect:/bankTransSource", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "bankTransSource.error.delete", exception);
	}
	
	
}
