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
import org.demo.bean.SafeTrans;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.SafeExpense;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.Safe;
import org.demo.bean.SafeTransSource;
import org.demo.test.SafeTransFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.SafeExpenseFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;
import org.demo.test.SafeFactoryForTest;
import org.demo.test.SafeTransSourceFactoryForTest;

//--- Services 
import org.demo.business.service.SafeTransService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.SafeExpenseService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.SafeService;
import org.demo.business.service.SafeTransSourceService;

//--- List Items 
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.SafeExpenseListItem;
import org.demo.web.listitem.GlobalTransPointListItem;
import org.demo.web.listitem.SafeListItem;
import org.demo.web.listitem.SafeTransSourceListItem;

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
public class SafeTransControllerTest {
	
	@InjectMocks
	private SafeTransController safeTransController;
	@Mock
	private SafeTransService safeTransService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private SafeExpenseService safeExpenseService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring
	@Mock
	private SafeService safeService; // Injected by Spring
	@Mock
	private SafeTransSourceService safeTransSourceService; // Injected by Spring

	private SafeTransFactoryForTest safeTransFactoryForTest = new SafeTransFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private SafeExpenseFactoryForTest safeExpenseFactoryForTest = new SafeExpenseFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();
	private SafeFactoryForTest safeFactoryForTest = new SafeFactoryForTest();
	private SafeTransSourceFactoryForTest safeTransSourceFactoryForTest = new SafeTransSourceFactoryForTest();

	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<SafeExpense> safeExpenses = new ArrayList<SafeExpense>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
	List<Safe> safes = new ArrayList<Safe>();
	List<SafeTransSource> safeTransSources = new ArrayList<SafeTransSource>();

	private void givenPopulateModel() {
		GlobalPrivateCode globalPrivateCode1 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		GlobalPrivateCode globalPrivateCode2 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
		globalPrivateCodes.add(globalPrivateCode1);
		globalPrivateCodes.add(globalPrivateCode2);
		when(globalPrivateCodeService.findAll()).thenReturn(globalPrivateCodes);

		SafeExpense safeExpense1 = safeExpenseFactoryForTest.newSafeExpense();
		SafeExpense safeExpense2 = safeExpenseFactoryForTest.newSafeExpense();
		List<SafeExpense> safeExpenses = new ArrayList<SafeExpense>();
		safeExpenses.add(safeExpense1);
		safeExpenses.add(safeExpense2);
		when(safeExpenseService.findAll()).thenReturn(safeExpenses);

		GlobalTransPoint globalTransPoint1 = globalTransPointFactoryForTest.newGlobalTransPoint();
		GlobalTransPoint globalTransPoint2 = globalTransPointFactoryForTest.newGlobalTransPoint();
		List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
		globalTransPoints.add(globalTransPoint1);
		globalTransPoints.add(globalTransPoint2);
		when(globalTransPointService.findAll()).thenReturn(globalTransPoints);

		Safe safe1 = safeFactoryForTest.newSafe();
		Safe safe2 = safeFactoryForTest.newSafe();
		List<Safe> safes = new ArrayList<Safe>();
		safes.add(safe1);
		safes.add(safe2);
		when(safeService.findAll()).thenReturn(safes);

		SafeTransSource safeTransSource1 = safeTransSourceFactoryForTest.newSafeTransSource();
		SafeTransSource safeTransSource2 = safeTransSourceFactoryForTest.newSafeTransSource();
		List<SafeTransSource> safeTransSources = new ArrayList<SafeTransSource>();
		safeTransSources.add(safeTransSource1);
		safeTransSources.add(safeTransSource2);
		when(safeTransSourceService.findAll()).thenReturn(safeTransSources);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<SafeTrans> list = new ArrayList<SafeTrans>();
		when(safeTransService.findAll()).thenReturn(list);
		
		// When
		String viewName = safeTransController.list(model);
		
		// Then
		assertEquals("safeTrans/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = safeTransController.formForCreate(model);
		
		// Then
		assertEquals("safeTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((SafeTrans)modelMap.get("safeTrans")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safeTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeExpenseListItem> safeExpenseListItems = (List<SafeExpenseListItem>) modelMap.get("listOfSafeExpenseItems");
		assertEquals(2, safeExpenseListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeTransSourceListItem> safeTransSourceListItems = (List<SafeTransSourceListItem>) modelMap.get("listOfSafeTransSourceItems");
		assertEquals(2, safeTransSourceListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SafeTrans safeTrans = safeTransFactoryForTest.newSafeTrans();
		Integer id = safeTrans.getId();
		when(safeTransService.findById(id)).thenReturn(safeTrans);
		
		// When
		String viewName = safeTransController.formForUpdate(model, id);
		
		// Then
		assertEquals("safeTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTrans, (SafeTrans) modelMap.get("safeTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safeTrans/update", modelMap.get("saveAction"));
		
		List<SafeTransSourceListItem> safeTransSourceListItems = (List<SafeTransSourceListItem>) modelMap.get("listOfSafeTransSourceItems");
		assertEquals(2, safeTransSourceListItems.size());
		
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		List<SafeExpenseListItem> safeExpenseListItems = (List<SafeExpenseListItem>) modelMap.get("listOfSafeExpenseItems");
		assertEquals(2, safeExpenseListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		SafeTrans safeTrans = safeTransFactoryForTest.newSafeTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		SafeTrans safeTransCreated = new SafeTrans();
		when(safeTransService.create(safeTrans)).thenReturn(safeTransCreated); 
		
		// When
		String viewName = safeTransController.create(safeTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/safeTrans/form/"+safeTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTransCreated, (SafeTrans) modelMap.get("safeTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SafeTrans safeTrans = safeTransFactoryForTest.newSafeTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = safeTransController.create(safeTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTrans, (SafeTrans) modelMap.get("safeTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safeTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeExpenseListItem> safeExpenseListItems = (List<SafeExpenseListItem>) modelMap.get("listOfSafeExpenseItems");
		assertEquals(2, safeExpenseListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeTransSourceListItem> safeTransSourceListItems = (List<SafeTransSourceListItem>) modelMap.get("listOfSafeTransSourceItems");
		assertEquals(2, safeTransSourceListItems.size());
		
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

		SafeTrans safeTrans = safeTransFactoryForTest.newSafeTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(safeTransService.create(safeTrans)).thenThrow(exception);
		
		// When
		String viewName = safeTransController.create(safeTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTrans, (SafeTrans) modelMap.get("safeTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/safeTrans/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "safeTrans.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeExpenseListItem> safeExpenseListItems = (List<SafeExpenseListItem>) modelMap.get("listOfSafeExpenseItems");
		assertEquals(2, safeExpenseListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeTransSourceListItem> safeTransSourceListItems = (List<SafeTransSourceListItem>) modelMap.get("listOfSafeTransSourceItems");
		assertEquals(2, safeTransSourceListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		SafeTrans safeTrans = safeTransFactoryForTest.newSafeTrans();
		Integer id = safeTrans.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		SafeTrans safeTransSaved = new SafeTrans();
		safeTransSaved.setId(id);
		when(safeTransService.update(safeTrans)).thenReturn(safeTransSaved); 
		
		// When
		String viewName = safeTransController.update(safeTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/safeTrans/form/"+safeTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTransSaved, (SafeTrans) modelMap.get("safeTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SafeTrans safeTrans = safeTransFactoryForTest.newSafeTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = safeTransController.update(safeTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTrans, (SafeTrans) modelMap.get("safeTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safeTrans/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<SafeTransSourceListItem> safeTransSourceListItems = (List<SafeTransSourceListItem>) modelMap.get("listOfSafeTransSourceItems");
		assertEquals(2, safeTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeExpenseListItem> safeExpenseListItems = (List<SafeExpenseListItem>) modelMap.get("listOfSafeExpenseItems");
		assertEquals(2, safeExpenseListItems.size());
		
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

		SafeTrans safeTrans = safeTransFactoryForTest.newSafeTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(safeTransService.update(safeTrans)).thenThrow(exception);
		
		// When
		String viewName = safeTransController.update(safeTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("safeTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(safeTrans, (SafeTrans) modelMap.get("safeTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/safeTrans/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "safeTrans.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<SafeTransSourceListItem> safeTransSourceListItems = (List<SafeTransSourceListItem>) modelMap.get("listOfSafeTransSourceItems");
		assertEquals(2, safeTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeExpenseListItem> safeExpenseListItems = (List<SafeExpenseListItem>) modelMap.get("listOfSafeExpenseItems");
		assertEquals(2, safeExpenseListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		SafeTrans safeTrans = safeTransFactoryForTest.newSafeTrans();
		Integer id = safeTrans.getId();
		
		// When
		String viewName = safeTransController.delete(redirectAttributes, id);
		
		// Then
		verify(safeTransService).delete(id);
		assertEquals("redirect:/safeTrans", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		SafeTrans safeTrans = safeTransFactoryForTest.newSafeTrans();
		Integer id = safeTrans.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(safeTransService).delete(id);
		
		// When
		String viewName = safeTransController.delete(redirectAttributes, id);
		
		// Then
		verify(safeTransService).delete(id);
		assertEquals("redirect:/safeTrans", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "safeTrans.error.delete", exception);
	}
	
	
}
