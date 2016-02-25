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
import org.demo.bean.BankExpense;
import org.demo.test.BankExpenseFactoryForTest;

//--- Services 
import org.demo.business.service.BankExpenseService;


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
public class BankExpenseControllerTest {
	
	@InjectMocks
	private BankExpenseController bankExpenseController;
	@Mock
	private BankExpenseService bankExpenseService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private BankExpenseFactoryForTest bankExpenseFactoryForTest = new BankExpenseFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<BankExpense> list = new ArrayList<BankExpense>();
		when(bankExpenseService.findAll()).thenReturn(list);
		
		// When
		String viewName = bankExpenseController.list(model);
		
		// Then
		assertEquals("bankExpense/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = bankExpenseController.formForCreate(model);
		
		// Then
		assertEquals("bankExpense/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((BankExpense)modelMap.get("bankExpense")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bankExpense/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		BankExpense bankExpense = bankExpenseFactoryForTest.newBankExpense();
		Integer id = bankExpense.getId();
		when(bankExpenseService.findById(id)).thenReturn(bankExpense);
		
		// When
		String viewName = bankExpenseController.formForUpdate(model, id);
		
		// Then
		assertEquals("bankExpense/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankExpense, (BankExpense) modelMap.get("bankExpense"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bankExpense/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		BankExpense bankExpense = bankExpenseFactoryForTest.newBankExpense();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		BankExpense bankExpenseCreated = new BankExpense();
		when(bankExpenseService.create(bankExpense)).thenReturn(bankExpenseCreated); 
		
		// When
		String viewName = bankExpenseController.create(bankExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/bankExpense/form/"+bankExpense.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankExpenseCreated, (BankExpense) modelMap.get("bankExpense"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		BankExpense bankExpense = bankExpenseFactoryForTest.newBankExpense();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = bankExpenseController.create(bankExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankExpense/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankExpense, (BankExpense) modelMap.get("bankExpense"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bankExpense/create", modelMap.get("saveAction"));
		
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

		BankExpense bankExpense = bankExpenseFactoryForTest.newBankExpense();
		
		Exception exception = new RuntimeException("test exception");
		when(bankExpenseService.create(bankExpense)).thenThrow(exception);
		
		// When
		String viewName = bankExpenseController.create(bankExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankExpense/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankExpense, (BankExpense) modelMap.get("bankExpense"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bankExpense/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "bankExpense.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		BankExpense bankExpense = bankExpenseFactoryForTest.newBankExpense();
		Integer id = bankExpense.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		BankExpense bankExpenseSaved = new BankExpense();
		bankExpenseSaved.setId(id);
		when(bankExpenseService.update(bankExpense)).thenReturn(bankExpenseSaved); 
		
		// When
		String viewName = bankExpenseController.update(bankExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/bankExpense/form/"+bankExpense.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankExpenseSaved, (BankExpense) modelMap.get("bankExpense"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		BankExpense bankExpense = bankExpenseFactoryForTest.newBankExpense();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = bankExpenseController.update(bankExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankExpense/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankExpense, (BankExpense) modelMap.get("bankExpense"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bankExpense/update", modelMap.get("saveAction"));
		
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

		BankExpense bankExpense = bankExpenseFactoryForTest.newBankExpense();
		
		Exception exception = new RuntimeException("test exception");
		when(bankExpenseService.update(bankExpense)).thenThrow(exception);
		
		// When
		String viewName = bankExpenseController.update(bankExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankExpense/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankExpense, (BankExpense) modelMap.get("bankExpense"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bankExpense/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "bankExpense.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		BankExpense bankExpense = bankExpenseFactoryForTest.newBankExpense();
		Integer id = bankExpense.getId();
		
		// When
		String viewName = bankExpenseController.delete(redirectAttributes, id);
		
		// Then
		verify(bankExpenseService).delete(id);
		assertEquals("redirect:/bankExpense", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		BankExpense bankExpense = bankExpenseFactoryForTest.newBankExpense();
		Integer id = bankExpense.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(bankExpenseService).delete(id);
		
		// When
		String viewName = bankExpenseController.delete(redirectAttributes, id);
		
		// Then
		verify(bankExpenseService).delete(id);
		assertEquals("redirect:/bankExpense", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "bankExpense.error.delete", exception);
	}
	
	
}
