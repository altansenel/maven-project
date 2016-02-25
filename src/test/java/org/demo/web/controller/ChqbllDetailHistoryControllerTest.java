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
import org.demo.bean.ChqbllDetailHistory;
import org.demo.bean.Contact;
import org.demo.bean.Safe;
import org.demo.bean.Bank;
import org.demo.bean.ChqbllPayrollDetail;
import org.demo.test.ChqbllDetailHistoryFactoryForTest;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.SafeFactoryForTest;
import org.demo.test.BankFactoryForTest;
import org.demo.test.ChqbllPayrollDetailFactoryForTest;

//--- Services 
import org.demo.business.service.ChqbllDetailHistoryService;
import org.demo.business.service.ContactService;
import org.demo.business.service.SafeService;
import org.demo.business.service.BankService;
import org.demo.business.service.ChqbllPayrollDetailService;

//--- List Items 
import org.demo.web.listitem.ContactListItem;
import org.demo.web.listitem.SafeListItem;
import org.demo.web.listitem.BankListItem;
import org.demo.web.listitem.ChqbllPayrollDetailListItem;

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
public class ChqbllDetailHistoryControllerTest {
	
	@InjectMocks
	private ChqbllDetailHistoryController chqbllDetailHistoryController;
	@Mock
	private ChqbllDetailHistoryService chqbllDetailHistoryService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private ContactService contactService; // Injected by Spring
	@Mock
	private SafeService safeService; // Injected by Spring
	@Mock
	private BankService bankService; // Injected by Spring
	@Mock
	private ChqbllPayrollDetailService chqbllPayrollDetailService; // Injected by Spring

	private ChqbllDetailHistoryFactoryForTest chqbllDetailHistoryFactoryForTest = new ChqbllDetailHistoryFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private SafeFactoryForTest safeFactoryForTest = new SafeFactoryForTest();
	private BankFactoryForTest bankFactoryForTest = new BankFactoryForTest();
	private ChqbllPayrollDetailFactoryForTest chqbllPayrollDetailFactoryForTest = new ChqbllPayrollDetailFactoryForTest();

	List<Contact> contacts = new ArrayList<Contact>();
	List<Safe> safes = new ArrayList<Safe>();
	List<Bank> banks = new ArrayList<Bank>();
	List<ChqbllPayrollDetail> chqbllPayrollDetails = new ArrayList<ChqbllPayrollDetail>();

	private void givenPopulateModel() {
		Contact contact1 = contactFactoryForTest.newContact();
		Contact contact2 = contactFactoryForTest.newContact();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		when(contactService.findAll()).thenReturn(contacts);

		Safe safe1 = safeFactoryForTest.newSafe();
		Safe safe2 = safeFactoryForTest.newSafe();
		List<Safe> safes = new ArrayList<Safe>();
		safes.add(safe1);
		safes.add(safe2);
		when(safeService.findAll()).thenReturn(safes);

		Bank bank1 = bankFactoryForTest.newBank();
		Bank bank2 = bankFactoryForTest.newBank();
		List<Bank> banks = new ArrayList<Bank>();
		banks.add(bank1);
		banks.add(bank2);
		when(bankService.findAll()).thenReturn(banks);

		ChqbllPayrollDetail chqbllPayrollDetail1 = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		ChqbllPayrollDetail chqbllPayrollDetail2 = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		List<ChqbllPayrollDetail> chqbllPayrollDetails = new ArrayList<ChqbllPayrollDetail>();
		chqbllPayrollDetails.add(chqbllPayrollDetail1);
		chqbllPayrollDetails.add(chqbllPayrollDetail2);
		when(chqbllPayrollDetailService.findAll()).thenReturn(chqbllPayrollDetails);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<ChqbllDetailHistory> list = new ArrayList<ChqbllDetailHistory>();
		when(chqbllDetailHistoryService.findAll()).thenReturn(list);
		
		// When
		String viewName = chqbllDetailHistoryController.list(model);
		
		// Then
		assertEquals("chqbllDetailHistory/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = chqbllDetailHistoryController.formForCreate(model);
		
		// Then
		assertEquals("chqbllDetailHistory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ChqbllDetailHistory)modelMap.get("chqbllDetailHistory")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllDetailHistory/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllDetailHistory chqbllDetailHistory = chqbllDetailHistoryFactoryForTest.newChqbllDetailHistory();
		Integer id = chqbllDetailHistory.getId();
		when(chqbllDetailHistoryService.findById(id)).thenReturn(chqbllDetailHistory);
		
		// When
		String viewName = chqbllDetailHistoryController.formForUpdate(model, id);
		
		// Then
		assertEquals("chqbllDetailHistory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailHistory, (ChqbllDetailHistory) modelMap.get("chqbllDetailHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllDetailHistory/update", modelMap.get("saveAction"));
		
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
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
		
		ChqbllDetailHistory chqbllDetailHistory = chqbllDetailHistoryFactoryForTest.newChqbllDetailHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllDetailHistory chqbllDetailHistoryCreated = new ChqbllDetailHistory();
		when(chqbllDetailHistoryService.create(chqbllDetailHistory)).thenReturn(chqbllDetailHistoryCreated); 
		
		// When
		String viewName = chqbllDetailHistoryController.create(chqbllDetailHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllDetailHistory/form/"+chqbllDetailHistory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailHistoryCreated, (ChqbllDetailHistory) modelMap.get("chqbllDetailHistory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllDetailHistory chqbllDetailHistory = chqbllDetailHistoryFactoryForTest.newChqbllDetailHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllDetailHistoryController.create(chqbllDetailHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllDetailHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailHistory, (ChqbllDetailHistory) modelMap.get("chqbllDetailHistory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllDetailHistory/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
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

		ChqbllDetailHistory chqbllDetailHistory = chqbllDetailHistoryFactoryForTest.newChqbllDetailHistory();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllDetailHistoryService.create(chqbllDetailHistory)).thenThrow(exception);
		
		// When
		String viewName = chqbllDetailHistoryController.create(chqbllDetailHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllDetailHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailHistory, (ChqbllDetailHistory) modelMap.get("chqbllDetailHistory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllDetailHistory/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllDetailHistory.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<BankListItem> bankListItems = (List<BankListItem>) modelMap.get("listOfBankItems");
		assertEquals(2, bankListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllDetailHistory chqbllDetailHistory = chqbllDetailHistoryFactoryForTest.newChqbllDetailHistory();
		Integer id = chqbllDetailHistory.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllDetailHistory chqbllDetailHistorySaved = new ChqbllDetailHistory();
		chqbllDetailHistorySaved.setId(id);
		when(chqbllDetailHistoryService.update(chqbllDetailHistory)).thenReturn(chqbllDetailHistorySaved); 
		
		// When
		String viewName = chqbllDetailHistoryController.update(chqbllDetailHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllDetailHistory/form/"+chqbllDetailHistory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailHistorySaved, (ChqbllDetailHistory) modelMap.get("chqbllDetailHistory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllDetailHistory chqbllDetailHistory = chqbllDetailHistoryFactoryForTest.newChqbllDetailHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllDetailHistoryController.update(chqbllDetailHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllDetailHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailHistory, (ChqbllDetailHistory) modelMap.get("chqbllDetailHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllDetailHistory/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
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

		ChqbllDetailHistory chqbllDetailHistory = chqbllDetailHistoryFactoryForTest.newChqbllDetailHistory();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllDetailHistoryService.update(chqbllDetailHistory)).thenThrow(exception);
		
		// When
		String viewName = chqbllDetailHistoryController.update(chqbllDetailHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllDetailHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailHistory, (ChqbllDetailHistory) modelMap.get("chqbllDetailHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllDetailHistory/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllDetailHistory.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
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
		
		ChqbllDetailHistory chqbllDetailHistory = chqbllDetailHistoryFactoryForTest.newChqbllDetailHistory();
		Integer id = chqbllDetailHistory.getId();
		
		// When
		String viewName = chqbllDetailHistoryController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllDetailHistoryService).delete(id);
		assertEquals("redirect:/chqbllDetailHistory", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllDetailHistory chqbllDetailHistory = chqbllDetailHistoryFactoryForTest.newChqbllDetailHistory();
		Integer id = chqbllDetailHistory.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(chqbllDetailHistoryService).delete(id);
		
		// When
		String viewName = chqbllDetailHistoryController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllDetailHistoryService).delete(id);
		assertEquals("redirect:/chqbllDetailHistory", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "chqbllDetailHistory.error.delete", exception);
	}
	
	
}
