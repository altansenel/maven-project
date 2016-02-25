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
import org.demo.bean.BankTrans;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.Bank;
import org.demo.bean.BankTransSource;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.BankExpense;
import org.demo.test.BankTransFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;
import org.demo.test.BankFactoryForTest;
import org.demo.test.BankTransSourceFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.BankExpenseFactoryForTest;

//--- Services 
import org.demo.business.service.BankTransService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.BankService;
import org.demo.business.service.BankTransSourceService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.BankExpenseService;

//--- List Items 
import org.demo.web.listitem.GlobalTransPointListItem;
import org.demo.web.listitem.BankListItem;
import org.demo.web.listitem.BankTransSourceListItem;
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.BankExpenseListItem;

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
public class BankTransControllerTest {
	
	@InjectMocks
	private BankTransController bankTransController;
	@Mock
	private BankTransService bankTransService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring
	@Mock
	private BankService bankService; // Injected by Spring
	@Mock
	private BankTransSourceService bankTransSourceService; // Injected by Spring
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private BankExpenseService bankExpenseService; // Injected by Spring

	private BankTransFactoryForTest bankTransFactoryForTest = new BankTransFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();
	private BankFactoryForTest bankFactoryForTest = new BankFactoryForTest();
	private BankTransSourceFactoryForTest bankTransSourceFactoryForTest = new BankTransSourceFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private BankExpenseFactoryForTest bankExpenseFactoryForTest = new BankExpenseFactoryForTest();

	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
	List<Bank> banks = new ArrayList<Bank>();
	List<BankTransSource> bankTransSources = new ArrayList<BankTransSource>();
	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<BankExpense> bankExpenses = new ArrayList<BankExpense>();

	private void givenPopulateModel() {
		GlobalTransPoint globalTransPoint1 = globalTransPointFactoryForTest.newGlobalTransPoint();
		GlobalTransPoint globalTransPoint2 = globalTransPointFactoryForTest.newGlobalTransPoint();
		List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
		globalTransPoints.add(globalTransPoint1);
		globalTransPoints.add(globalTransPoint2);
		when(globalTransPointService.findAll()).thenReturn(globalTransPoints);

		Bank bank1 = bankFactoryForTest.newBank();
		Bank bank2 = bankFactoryForTest.newBank();
		List<Bank> banks = new ArrayList<Bank>();
		banks.add(bank1);
		banks.add(bank2);
		when(bankService.findAll()).thenReturn(banks);

		BankTransSource bankTransSource1 = bankTransSourceFactoryForTest.newBankTransSource();
		BankTransSource bankTransSource2 = bankTransSourceFactoryForTest.newBankTransSource();
		List<BankTransSource> bankTransSources = new ArrayList<BankTransSource>();
		bankTransSources.add(bankTransSource1);
		bankTransSources.add(bankTransSource2);
		when(bankTransSourceService.findAll()).thenReturn(bankTransSources);

		GlobalPrivateCode globalPrivateCode1 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		GlobalPrivateCode globalPrivateCode2 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
		globalPrivateCodes.add(globalPrivateCode1);
		globalPrivateCodes.add(globalPrivateCode2);
		when(globalPrivateCodeService.findAll()).thenReturn(globalPrivateCodes);

		BankExpense bankExpense1 = bankExpenseFactoryForTest.newBankExpense();
		BankExpense bankExpense2 = bankExpenseFactoryForTest.newBankExpense();
		List<BankExpense> bankExpenses = new ArrayList<BankExpense>();
		bankExpenses.add(bankExpense1);
		bankExpenses.add(bankExpense2);
		when(bankExpenseService.findAll()).thenReturn(bankExpenses);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<BankTrans> list = new ArrayList<BankTrans>();
		when(bankTransService.findAll()).thenReturn(list);
		
		// When
		String viewName = bankTransController.list(model);
		
		// Then
		assertEquals("bankTrans/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = bankTransController.formForCreate(model);
		
		// Then
		assertEquals("bankTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((BankTrans)modelMap.get("bankTrans")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bankTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankTransSourceListItem> bankTransSourceListItems = (List<BankTransSourceListItem>) modelMap.get("listOfBankTransSourceItems");
		assertEquals(2, bankTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankExpenseListItem> bankExpenseListItems = (List<BankExpenseListItem>) modelMap.get("listOfBankExpenseItems");
		assertEquals(2, bankExpenseListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		BankTrans bankTrans = bankTransFactoryForTest.newBankTrans();
		Integer id = bankTrans.getId();
		when(bankTransService.findById(id)).thenReturn(bankTrans);
		
		// When
		String viewName = bankTransController.formForUpdate(model, id);
		
		// Then
		assertEquals("bankTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTrans, (BankTrans) modelMap.get("bankTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bankTrans/update", modelMap.get("saveAction"));
		
		List<BankTransSourceListItem> bankTransSourceListItems = (List<BankTransSourceListItem>) modelMap.get("listOfBankTransSourceItems");
		assertEquals(2, bankTransSourceListItems.size());
		
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		List<BankExpenseListItem> bankExpenseListItems = (List<BankExpenseListItem>) modelMap.get("listOfBankExpenseItems");
		assertEquals(2, bankExpenseListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		BankTrans bankTrans = bankTransFactoryForTest.newBankTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		BankTrans bankTransCreated = new BankTrans();
		when(bankTransService.create(bankTrans)).thenReturn(bankTransCreated); 
		
		// When
		String viewName = bankTransController.create(bankTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/bankTrans/form/"+bankTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTransCreated, (BankTrans) modelMap.get("bankTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		BankTrans bankTrans = bankTransFactoryForTest.newBankTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = bankTransController.create(bankTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTrans, (BankTrans) modelMap.get("bankTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bankTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankTransSourceListItem> bankTransSourceListItems = (List<BankTransSourceListItem>) modelMap.get("listOfBankTransSourceItems");
		assertEquals(2, bankTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankExpenseListItem> bankExpenseListItems = (List<BankExpenseListItem>) modelMap.get("listOfBankExpenseItems");
		assertEquals(2, bankExpenseListItems.size());
		
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

		BankTrans bankTrans = bankTransFactoryForTest.newBankTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(bankTransService.create(bankTrans)).thenThrow(exception);
		
		// When
		String viewName = bankTransController.create(bankTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTrans, (BankTrans) modelMap.get("bankTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/bankTrans/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "bankTrans.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankTransSourceListItem> bankTransSourceListItems = (List<BankTransSourceListItem>) modelMap.get("listOfBankTransSourceItems");
		assertEquals(2, bankTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankExpenseListItem> bankExpenseListItems = (List<BankExpenseListItem>) modelMap.get("listOfBankExpenseItems");
		assertEquals(2, bankExpenseListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		BankTrans bankTrans = bankTransFactoryForTest.newBankTrans();
		Integer id = bankTrans.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		BankTrans bankTransSaved = new BankTrans();
		bankTransSaved.setId(id);
		when(bankTransService.update(bankTrans)).thenReturn(bankTransSaved); 
		
		// When
		String viewName = bankTransController.update(bankTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/bankTrans/form/"+bankTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTransSaved, (BankTrans) modelMap.get("bankTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		BankTrans bankTrans = bankTransFactoryForTest.newBankTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = bankTransController.update(bankTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTrans, (BankTrans) modelMap.get("bankTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bankTrans/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<BankTransSourceListItem> bankTransSourceListItems = (List<BankTransSourceListItem>) modelMap.get("listOfBankTransSourceItems");
		assertEquals(2, bankTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankExpenseListItem> bankExpenseListItems = (List<BankExpenseListItem>) modelMap.get("listOfBankExpenseItems");
		assertEquals(2, bankExpenseListItems.size());
		
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

		BankTrans bankTrans = bankTransFactoryForTest.newBankTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(bankTransService.update(bankTrans)).thenThrow(exception);
		
		// When
		String viewName = bankTransController.update(bankTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("bankTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(bankTrans, (BankTrans) modelMap.get("bankTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/bankTrans/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "bankTrans.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<BankTransSourceListItem> bankTransSourceListItems = (List<BankTransSourceListItem>) modelMap.get("listOfBankTransSourceItems");
		assertEquals(2, bankTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankExpenseListItem> bankExpenseListItems = (List<BankExpenseListItem>) modelMap.get("listOfBankExpenseItems");
		assertEquals(2, bankExpenseListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		BankTrans bankTrans = bankTransFactoryForTest.newBankTrans();
		Integer id = bankTrans.getId();
		
		// When
		String viewName = bankTransController.delete(redirectAttributes, id);
		
		// Then
		verify(bankTransService).delete(id);
		assertEquals("redirect:/bankTrans", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		BankTrans bankTrans = bankTransFactoryForTest.newBankTrans();
		Integer id = bankTrans.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(bankTransService).delete(id);
		
		// When
		String viewName = bankTransController.delete(redirectAttributes, id);
		
		// Then
		verify(bankTransService).delete(id);
		assertEquals("redirect:/bankTrans", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "bankTrans.error.delete", exception);
	}
	
	
}
