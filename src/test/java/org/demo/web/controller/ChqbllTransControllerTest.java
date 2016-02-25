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
import org.demo.bean.ChqbllTrans;
import org.demo.bean.Bank;
import org.demo.bean.ChqbllPayrollSource;
import org.demo.bean.Contact;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.Safe;
import org.demo.bean.GlobalTransPoint;
import org.demo.test.ChqbllTransFactoryForTest;
import org.demo.test.BankFactoryForTest;
import org.demo.test.ChqbllPayrollSourceFactoryForTest;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.SafeFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;

//--- Services 
import org.demo.business.service.ChqbllTransService;
import org.demo.business.service.BankService;
import org.demo.business.service.ChqbllPayrollSourceService;
import org.demo.business.service.ContactService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.SafeService;
import org.demo.business.service.GlobalTransPointService;

//--- List Items 
import org.demo.web.listitem.BankListItem;
import org.demo.web.listitem.ChqbllPayrollSourceListItem;
import org.demo.web.listitem.ContactListItem;
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.SafeListItem;
import org.demo.web.listitem.GlobalTransPointListItem;

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
public class ChqbllTransControllerTest {
	
	@InjectMocks
	private ChqbllTransController chqbllTransController;
	@Mock
	private ChqbllTransService chqbllTransService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private BankService bankService; // Injected by Spring
	@Mock
	private ChqbllPayrollSourceService chqbllPayrollSourceService; // Injected by Spring
	@Mock
	private ContactService contactService; // Injected by Spring
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private SafeService safeService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring

	private ChqbllTransFactoryForTest chqbllTransFactoryForTest = new ChqbllTransFactoryForTest();
	private BankFactoryForTest bankFactoryForTest = new BankFactoryForTest();
	private ChqbllPayrollSourceFactoryForTest chqbllPayrollSourceFactoryForTest = new ChqbllPayrollSourceFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private SafeFactoryForTest safeFactoryForTest = new SafeFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();

	List<Bank> banks = new ArrayList<Bank>();
	List<ChqbllPayrollSource> chqbllPayrollSources = new ArrayList<ChqbllPayrollSource>();
	List<Contact> contacts = new ArrayList<Contact>();
	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<Safe> safes = new ArrayList<Safe>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();

	private void givenPopulateModel() {
		Bank bank1 = bankFactoryForTest.newBank();
		Bank bank2 = bankFactoryForTest.newBank();
		List<Bank> banks = new ArrayList<Bank>();
		banks.add(bank1);
		banks.add(bank2);
		when(bankService.findAll()).thenReturn(banks);

		ChqbllPayrollSource chqbllPayrollSource1 = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		ChqbllPayrollSource chqbllPayrollSource2 = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		List<ChqbllPayrollSource> chqbllPayrollSources = new ArrayList<ChqbllPayrollSource>();
		chqbllPayrollSources.add(chqbllPayrollSource1);
		chqbllPayrollSources.add(chqbllPayrollSource2);
		when(chqbllPayrollSourceService.findAll()).thenReturn(chqbllPayrollSources);

		Contact contact1 = contactFactoryForTest.newContact();
		Contact contact2 = contactFactoryForTest.newContact();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		when(contactService.findAll()).thenReturn(contacts);

		GlobalPrivateCode globalPrivateCode1 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		GlobalPrivateCode globalPrivateCode2 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
		globalPrivateCodes.add(globalPrivateCode1);
		globalPrivateCodes.add(globalPrivateCode2);
		when(globalPrivateCodeService.findAll()).thenReturn(globalPrivateCodes);

		Safe safe1 = safeFactoryForTest.newSafe();
		Safe safe2 = safeFactoryForTest.newSafe();
		List<Safe> safes = new ArrayList<Safe>();
		safes.add(safe1);
		safes.add(safe2);
		when(safeService.findAll()).thenReturn(safes);

		GlobalTransPoint globalTransPoint1 = globalTransPointFactoryForTest.newGlobalTransPoint();
		GlobalTransPoint globalTransPoint2 = globalTransPointFactoryForTest.newGlobalTransPoint();
		List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
		globalTransPoints.add(globalTransPoint1);
		globalTransPoints.add(globalTransPoint2);
		when(globalTransPointService.findAll()).thenReturn(globalTransPoints);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<ChqbllTrans> list = new ArrayList<ChqbllTrans>();
		when(chqbllTransService.findAll()).thenReturn(list);
		
		// When
		String viewName = chqbllTransController.list(model);
		
		// Then
		assertEquals("chqbllTrans/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = chqbllTransController.formForCreate(model);
		
		// Then
		assertEquals("chqbllTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ChqbllTrans)modelMap.get("chqbllTrans")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();
		Integer id = chqbllTrans.getId();
		when(chqbllTransService.findById(id)).thenReturn(chqbllTrans);
		
		// When
		String viewName = chqbllTransController.formForUpdate(model, id);
		
		// Then
		assertEquals("chqbllTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTrans, (ChqbllTrans) modelMap.get("chqbllTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllTrans/update", modelMap.get("saveAction"));
		
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllTrans chqbllTransCreated = new ChqbllTrans();
		when(chqbllTransService.create(chqbllTrans)).thenReturn(chqbllTransCreated); 
		
		// When
		String viewName = chqbllTransController.create(chqbllTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllTrans/form/"+chqbllTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTransCreated, (ChqbllTrans) modelMap.get("chqbllTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllTransController.create(chqbllTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTrans, (ChqbllTrans) modelMap.get("chqbllTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
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

		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllTransService.create(chqbllTrans)).thenThrow(exception);
		
		// When
		String viewName = chqbllTransController.create(chqbllTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTrans, (ChqbllTrans) modelMap.get("chqbllTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllTrans/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllTrans.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();
		Integer id = chqbllTrans.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllTrans chqbllTransSaved = new ChqbllTrans();
		chqbllTransSaved.setId(id);
		when(chqbllTransService.update(chqbllTrans)).thenReturn(chqbllTransSaved); 
		
		// When
		String viewName = chqbllTransController.update(chqbllTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllTrans/form/"+chqbllTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTransSaved, (ChqbllTrans) modelMap.get("chqbllTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllTransController.update(chqbllTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTrans, (ChqbllTrans) modelMap.get("chqbllTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllTrans/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
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

		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllTransService.update(chqbllTrans)).thenThrow(exception);
		
		// When
		String viewName = chqbllTransController.update(chqbllTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTrans, (ChqbllTrans) modelMap.get("chqbllTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllTrans/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllTrans.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();
		Integer id = chqbllTrans.getId();
		
		// When
		String viewName = chqbllTransController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllTransService).delete(id);
		assertEquals("redirect:/chqbllTrans", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllTrans chqbllTrans = chqbllTransFactoryForTest.newChqbllTrans();
		Integer id = chqbllTrans.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(chqbllTransService).delete(id);
		
		// When
		String viewName = chqbllTransController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllTransService).delete(id);
		assertEquals("redirect:/chqbllTrans", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "chqbllTrans.error.delete", exception);
	}
	
	
}
