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
import org.demo.bean.Bank;
import org.demo.test.BankFactoryForTest;

//--- Services 
import org.demo.business.service.BankService;


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
public class BankControllerTest {
	
	@InjectMocks
	private BankController bankController;
	@Mock
	private BankService bankService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private BankFactoryForTest bankFactoryForTest = new BankFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<Bank> list = new ArrayList<Bank>();
		when(bankService.findAll()).thenReturn(list);
		
		// When
		String viewName = bankController.list(model);
		
		// Then
		assertEquals("bank/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = bankController.formForCreate(model);
		
		// Then
		assertEquals("bank/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((Bank)modelMap.get("bank")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bank/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Bank bank = bankFactoryForTest.newBank();
		Integer id = bank.getId();
		when(bankService.findById(id)).thenReturn(bank);
		
		// When
		String viewName = bankController.formForUpdate(model, id);
		
		// Then
		assertEquals("bank/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bank, (Bank) modelMap.get("bank"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bank/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Bank bank = bankFactoryForTest.newBank();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Bank bankCreated = new Bank();
		when(bankService.create(bank)).thenReturn(bankCreated); 
		
		// When
		String viewName = bankController.create(bank, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/bank/form/"+bank.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankCreated, (Bank) modelMap.get("bank"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Bank bank = bankFactoryForTest.newBank();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = bankController.create(bank, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bank/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bank, (Bank) modelMap.get("bank"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bank/create", modelMap.get("saveAction"));
		
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

		Bank bank = bankFactoryForTest.newBank();
		
		Exception exception = new RuntimeException("test exception");
		when(bankService.create(bank)).thenThrow(exception);
		
		// When
		String viewName = bankController.create(bank, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bank/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bank, (Bank) modelMap.get("bank"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bank/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "bank.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Bank bank = bankFactoryForTest.newBank();
		Integer id = bank.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Bank bankSaved = new Bank();
		bankSaved.setId(id);
		when(bankService.update(bank)).thenReturn(bankSaved); 
		
		// When
		String viewName = bankController.update(bank, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/bank/form/"+bank.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankSaved, (Bank) modelMap.get("bank"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Bank bank = bankFactoryForTest.newBank();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = bankController.update(bank, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bank/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bank, (Bank) modelMap.get("bank"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bank/update", modelMap.get("saveAction"));
		
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

		Bank bank = bankFactoryForTest.newBank();
		
		Exception exception = new RuntimeException("test exception");
		when(bankService.update(bank)).thenThrow(exception);
		
		// When
		String viewName = bankController.update(bank, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bank/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bank, (Bank) modelMap.get("bank"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bank/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "bank.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Bank bank = bankFactoryForTest.newBank();
		Integer id = bank.getId();
		
		// When
		String viewName = bankController.delete(redirectAttributes, id);
		
		// Then
		verify(bankService).delete(id);
		assertEquals("redirect:/bank", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Bank bank = bankFactoryForTest.newBank();
		Integer id = bank.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(bankService).delete(id);
		
		// When
		String viewName = bankController.delete(redirectAttributes, id);
		
		// Then
		verify(bankService).delete(id);
		assertEquals("redirect:/bank", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "bank.error.delete", exception);
	}
	
	
}
