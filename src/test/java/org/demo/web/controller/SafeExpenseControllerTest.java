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
import org.demo.bean.SafeExpense;
import org.demo.test.SafeExpenseFactoryForTest;

//--- Services 
import org.demo.business.service.SafeExpenseService;


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
public class SafeExpenseControllerTest {
	
	@InjectMocks
	private SafeExpenseController safeExpenseController;
	@Mock
	private SafeExpenseService safeExpenseService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private SafeExpenseFactoryForTest safeExpenseFactoryForTest = new SafeExpenseFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<SafeExpense> list = new ArrayList<SafeExpense>();
		when(safeExpenseService.findAll()).thenReturn(list);
		
		// When
		String viewName = safeExpenseController.list(model);
		
		// Then
		assertEquals("safeExpense/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = safeExpenseController.formForCreate(model);
		
		// Then
		assertEquals("safeExpense/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((SafeExpense)modelMap.get("safeExpense")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safeExpense/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SafeExpense safeExpense = safeExpenseFactoryForTest.newSafeExpense();
		Integer id = safeExpense.getId();
		when(safeExpenseService.findById(id)).thenReturn(safeExpense);
		
		// When
		String viewName = safeExpenseController.formForUpdate(model, id);
		
		// Then
		assertEquals("safeExpense/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeExpense, (SafeExpense) modelMap.get("safeExpense"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safeExpense/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		SafeExpense safeExpense = safeExpenseFactoryForTest.newSafeExpense();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		SafeExpense safeExpenseCreated = new SafeExpense();
		when(safeExpenseService.create(safeExpense)).thenReturn(safeExpenseCreated); 
		
		// When
		String viewName = safeExpenseController.create(safeExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/safeExpense/form/"+safeExpense.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeExpenseCreated, (SafeExpense) modelMap.get("safeExpense"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SafeExpense safeExpense = safeExpenseFactoryForTest.newSafeExpense();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = safeExpenseController.create(safeExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeExpense/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeExpense, (SafeExpense) modelMap.get("safeExpense"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safeExpense/create", modelMap.get("saveAction"));
		
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

		SafeExpense safeExpense = safeExpenseFactoryForTest.newSafeExpense();
		
		Exception exception = new RuntimeException("test exception");
		when(safeExpenseService.create(safeExpense)).thenThrow(exception);
		
		// When
		String viewName = safeExpenseController.create(safeExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeExpense/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeExpense, (SafeExpense) modelMap.get("safeExpense"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safeExpense/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "safeExpense.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		SafeExpense safeExpense = safeExpenseFactoryForTest.newSafeExpense();
		Integer id = safeExpense.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		SafeExpense safeExpenseSaved = new SafeExpense();
		safeExpenseSaved.setId(id);
		when(safeExpenseService.update(safeExpense)).thenReturn(safeExpenseSaved); 
		
		// When
		String viewName = safeExpenseController.update(safeExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/safeExpense/form/"+safeExpense.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeExpenseSaved, (SafeExpense) modelMap.get("safeExpense"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SafeExpense safeExpense = safeExpenseFactoryForTest.newSafeExpense();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = safeExpenseController.update(safeExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeExpense/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeExpense, (SafeExpense) modelMap.get("safeExpense"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safeExpense/update", modelMap.get("saveAction"));
		
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

		SafeExpense safeExpense = safeExpenseFactoryForTest.newSafeExpense();
		
		Exception exception = new RuntimeException("test exception");
		when(safeExpenseService.update(safeExpense)).thenThrow(exception);
		
		// When
		String viewName = safeExpenseController.update(safeExpense, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeExpense/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeExpense, (SafeExpense) modelMap.get("safeExpense"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safeExpense/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "safeExpense.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		SafeExpense safeExpense = safeExpenseFactoryForTest.newSafeExpense();
		Integer id = safeExpense.getId();
		
		// When
		String viewName = safeExpenseController.delete(redirectAttributes, id);
		
		// Then
		verify(safeExpenseService).delete(id);
		assertEquals("redirect:/safeExpense", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		SafeExpense safeExpense = safeExpenseFactoryForTest.newSafeExpense();
		Integer id = safeExpense.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(safeExpenseService).delete(id);
		
		// When
		String viewName = safeExpenseController.delete(redirectAttributes, id);
		
		// Then
		verify(safeExpenseService).delete(id);
		assertEquals("redirect:/safeExpense", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "safeExpense.error.delete", exception);
	}
	
	
}
