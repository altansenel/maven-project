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
import org.demo.bean.ChqbllPayroll;
import org.demo.bean.ChqbllPayrollSource;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.Contact;
import org.demo.bean.GlobalTransPoint;
import org.demo.test.ChqbllPayrollFactoryForTest;
import org.demo.test.ChqbllPayrollSourceFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;

//--- Services 
import org.demo.business.service.ChqbllPayrollService;
import org.demo.business.service.ChqbllPayrollSourceService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.ContactService;
import org.demo.business.service.GlobalTransPointService;

//--- List Items 
import org.demo.web.listitem.ChqbllPayrollSourceListItem;
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.ContactListItem;
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
public class ChqbllPayrollControllerTest {
	
	@InjectMocks
	private ChqbllPayrollController chqbllPayrollController;
	@Mock
	private ChqbllPayrollService chqbllPayrollService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private ChqbllPayrollSourceService chqbllPayrollSourceService; // Injected by Spring
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private ContactService contactService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring

	private ChqbllPayrollFactoryForTest chqbllPayrollFactoryForTest = new ChqbllPayrollFactoryForTest();
	private ChqbllPayrollSourceFactoryForTest chqbllPayrollSourceFactoryForTest = new ChqbllPayrollSourceFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();

	List<ChqbllPayrollSource> chqbllPayrollSources = new ArrayList<ChqbllPayrollSource>();
	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<Contact> contacts = new ArrayList<Contact>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();

	private void givenPopulateModel() {
		ChqbllPayrollSource chqbllPayrollSource1 = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		ChqbllPayrollSource chqbllPayrollSource2 = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		List<ChqbllPayrollSource> chqbllPayrollSources = new ArrayList<ChqbllPayrollSource>();
		chqbllPayrollSources.add(chqbllPayrollSource1);
		chqbllPayrollSources.add(chqbllPayrollSource2);
		when(chqbllPayrollSourceService.findAll()).thenReturn(chqbllPayrollSources);

		GlobalPrivateCode globalPrivateCode1 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		GlobalPrivateCode globalPrivateCode2 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
		globalPrivateCodes.add(globalPrivateCode1);
		globalPrivateCodes.add(globalPrivateCode2);
		when(globalPrivateCodeService.findAll()).thenReturn(globalPrivateCodes);

		Contact contact1 = contactFactoryForTest.newContact();
		Contact contact2 = contactFactoryForTest.newContact();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		when(contactService.findAll()).thenReturn(contacts);

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
		
		List<ChqbllPayroll> list = new ArrayList<ChqbllPayroll>();
		when(chqbllPayrollService.findAll()).thenReturn(list);
		
		// When
		String viewName = chqbllPayrollController.list(model);
		
		// Then
		assertEquals("chqbllPayroll/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = chqbllPayrollController.formForCreate(model);
		
		// Then
		assertEquals("chqbllPayroll/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ChqbllPayroll)modelMap.get("chqbllPayroll")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllPayroll/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllPayroll chqbllPayroll = chqbllPayrollFactoryForTest.newChqbllPayroll();
		Integer id = chqbllPayroll.getId();
		when(chqbllPayrollService.findById(id)).thenReturn(chqbllPayroll);
		
		// When
		String viewName = chqbllPayrollController.formForUpdate(model, id);
		
		// Then
		assertEquals("chqbllPayroll/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayroll, (ChqbllPayroll) modelMap.get("chqbllPayroll"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllPayroll/update", modelMap.get("saveAction"));
		
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllPayroll chqbllPayroll = chqbllPayrollFactoryForTest.newChqbllPayroll();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllPayroll chqbllPayrollCreated = new ChqbllPayroll();
		when(chqbllPayrollService.create(chqbllPayroll)).thenReturn(chqbllPayrollCreated); 
		
		// When
		String viewName = chqbllPayrollController.create(chqbllPayroll, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllPayroll/form/"+chqbllPayroll.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollCreated, (ChqbllPayroll) modelMap.get("chqbllPayroll"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllPayroll chqbllPayroll = chqbllPayrollFactoryForTest.newChqbllPayroll();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllPayrollController.create(chqbllPayroll, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayroll/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayroll, (ChqbllPayroll) modelMap.get("chqbllPayroll"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllPayroll/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
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

		ChqbllPayroll chqbllPayroll = chqbllPayrollFactoryForTest.newChqbllPayroll();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllPayrollService.create(chqbllPayroll)).thenThrow(exception);
		
		// When
		String viewName = chqbllPayrollController.create(chqbllPayroll, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayroll/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayroll, (ChqbllPayroll) modelMap.get("chqbllPayroll"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllPayroll/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllPayroll.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllPayroll chqbllPayroll = chqbllPayrollFactoryForTest.newChqbllPayroll();
		Integer id = chqbllPayroll.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllPayroll chqbllPayrollSaved = new ChqbllPayroll();
		chqbllPayrollSaved.setId(id);
		when(chqbllPayrollService.update(chqbllPayroll)).thenReturn(chqbllPayrollSaved); 
		
		// When
		String viewName = chqbllPayrollController.update(chqbllPayroll, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllPayroll/form/"+chqbllPayroll.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollSaved, (ChqbllPayroll) modelMap.get("chqbllPayroll"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllPayroll chqbllPayroll = chqbllPayrollFactoryForTest.newChqbllPayroll();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllPayrollController.update(chqbllPayroll, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayroll/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayroll, (ChqbllPayroll) modelMap.get("chqbllPayroll"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllPayroll/update", modelMap.get("saveAction"));
		
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

		ChqbllPayroll chqbllPayroll = chqbllPayrollFactoryForTest.newChqbllPayroll();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllPayrollService.update(chqbllPayroll)).thenThrow(exception);
		
		// When
		String viewName = chqbllPayrollController.update(chqbllPayroll, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayroll/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayroll, (ChqbllPayroll) modelMap.get("chqbllPayroll"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllPayroll/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllPayroll.error.update", exception);
		
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
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllPayroll chqbllPayroll = chqbllPayrollFactoryForTest.newChqbllPayroll();
		Integer id = chqbllPayroll.getId();
		
		// When
		String viewName = chqbllPayrollController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllPayrollService).delete(id);
		assertEquals("redirect:/chqbllPayroll", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllPayroll chqbllPayroll = chqbllPayrollFactoryForTest.newChqbllPayroll();
		Integer id = chqbllPayroll.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(chqbllPayrollService).delete(id);
		
		// When
		String viewName = chqbllPayrollController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllPayrollService).delete(id);
		assertEquals("redirect:/chqbllPayroll", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "chqbllPayroll.error.delete", exception);
	}
	
	
}
