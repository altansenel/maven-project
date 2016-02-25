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
import org.demo.bean.ContactTrans;
import org.demo.bean.ContactTransSource;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.Contact;
import org.demo.bean.GlobalTransPoint;
import org.demo.test.ContactTransFactoryForTest;
import org.demo.test.ContactTransSourceFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;

//--- Services 
import org.demo.business.service.ContactTransService;
import org.demo.business.service.ContactTransSourceService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.ContactService;
import org.demo.business.service.GlobalTransPointService;

//--- List Items 
import org.demo.web.listitem.ContactTransSourceListItem;
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
public class ContactTransControllerTest {
	
	@InjectMocks
	private ContactTransController contactTransController;
	@Mock
	private ContactTransService contactTransService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private ContactTransSourceService contactTransSourceService; // Injected by Spring
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private ContactService contactService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring

	private ContactTransFactoryForTest contactTransFactoryForTest = new ContactTransFactoryForTest();
	private ContactTransSourceFactoryForTest contactTransSourceFactoryForTest = new ContactTransSourceFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();

	List<ContactTransSource> contactTransSources = new ArrayList<ContactTransSource>();
	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<Contact> contacts = new ArrayList<Contact>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();

	private void givenPopulateModel() {
		ContactTransSource contactTransSource1 = contactTransSourceFactoryForTest.newContactTransSource();
		ContactTransSource contactTransSource2 = contactTransSourceFactoryForTest.newContactTransSource();
		List<ContactTransSource> contactTransSources = new ArrayList<ContactTransSource>();
		contactTransSources.add(contactTransSource1);
		contactTransSources.add(contactTransSource2);
		when(contactTransSourceService.findAll()).thenReturn(contactTransSources);

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
		
		List<ContactTrans> list = new ArrayList<ContactTrans>();
		when(contactTransService.findAll()).thenReturn(list);
		
		// When
		String viewName = contactTransController.list(model);
		
		// Then
		assertEquals("contactTrans/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = contactTransController.formForCreate(model);
		
		// Then
		assertEquals("contactTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ContactTrans)modelMap.get("contactTrans")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ContactTransSourceListItem> contactTransSourceListItems = (List<ContactTransSourceListItem>) modelMap.get("listOfContactTransSourceItems");
		assertEquals(2, contactTransSourceListItems.size());
		
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
		
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();
		Integer id = contactTrans.getId();
		when(contactTransService.findById(id)).thenReturn(contactTrans);
		
		// When
		String viewName = contactTransController.formForUpdate(model, id);
		
		// Then
		assertEquals("contactTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTrans, (ContactTrans) modelMap.get("contactTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactTrans/update", modelMap.get("saveAction"));
		
		List<ContactTransSourceListItem> contactTransSourceListItems = (List<ContactTransSourceListItem>) modelMap.get("listOfContactTransSourceItems");
		assertEquals(2, contactTransSourceListItems.size());
		
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
		
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ContactTrans contactTransCreated = new ContactTrans();
		when(contactTransService.create(contactTrans)).thenReturn(contactTransCreated); 
		
		// When
		String viewName = contactTransController.create(contactTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/contactTrans/form/"+contactTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTransCreated, (ContactTrans) modelMap.get("contactTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = contactTransController.create(contactTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTrans, (ContactTrans) modelMap.get("contactTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ContactTransSourceListItem> contactTransSourceListItems = (List<ContactTransSourceListItem>) modelMap.get("listOfContactTransSourceItems");
		assertEquals(2, contactTransSourceListItems.size());
		
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

		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(contactTransService.create(contactTrans)).thenThrow(exception);
		
		// When
		String viewName = contactTransController.create(contactTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTrans, (ContactTrans) modelMap.get("contactTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactTrans/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "contactTrans.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<ContactTransSourceListItem> contactTransSourceListItems = (List<ContactTransSourceListItem>) modelMap.get("listOfContactTransSourceItems");
		assertEquals(2, contactTransSourceListItems.size());
		
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
		
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();
		Integer id = contactTrans.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ContactTrans contactTransSaved = new ContactTrans();
		contactTransSaved.setId(id);
		when(contactTransService.update(contactTrans)).thenReturn(contactTransSaved); 
		
		// When
		String viewName = contactTransController.update(contactTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/contactTrans/form/"+contactTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTransSaved, (ContactTrans) modelMap.get("contactTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = contactTransController.update(contactTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTrans, (ContactTrans) modelMap.get("contactTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactTrans/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ContactTransSourceListItem> contactTransSourceListItems = (List<ContactTransSourceListItem>) modelMap.get("listOfContactTransSourceItems");
		assertEquals(2, contactTransSourceListItems.size());
		
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

		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(contactTransService.update(contactTrans)).thenThrow(exception);
		
		// When
		String viewName = contactTransController.update(contactTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTrans, (ContactTrans) modelMap.get("contactTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactTrans/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "contactTrans.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<ContactTransSourceListItem> contactTransSourceListItems = (List<ContactTransSourceListItem>) modelMap.get("listOfContactTransSourceItems");
		assertEquals(2, contactTransSourceListItems.size());
		
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
		
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();
		Integer id = contactTrans.getId();
		
		// When
		String viewName = contactTransController.delete(redirectAttributes, id);
		
		// Then
		verify(contactTransService).delete(id);
		assertEquals("redirect:/contactTrans", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ContactTrans contactTrans = contactTransFactoryForTest.newContactTrans();
		Integer id = contactTrans.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(contactTransService).delete(id);
		
		// When
		String viewName = contactTransController.delete(redirectAttributes, id);
		
		// Then
		verify(contactTransService).delete(id);
		assertEquals("redirect:/contactTrans", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "contactTrans.error.delete", exception);
	}
	
	
}
