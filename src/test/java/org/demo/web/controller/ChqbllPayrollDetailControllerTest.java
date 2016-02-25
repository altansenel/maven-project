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
import org.demo.bean.ChqbllPayrollDetail;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.ChqbllPayroll;
import org.demo.bean.Contact;
import org.demo.bean.ChqbllPayrollSource;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.ChqbllType;
import org.demo.test.ChqbllPayrollDetailFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.ChqbllPayrollFactoryForTest;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.ChqbllPayrollSourceFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;
import org.demo.test.ChqbllTypeFactoryForTest;

//--- Services 
import org.demo.business.service.ChqbllPayrollDetailService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.ChqbllPayrollService;
import org.demo.business.service.ContactService;
import org.demo.business.service.ChqbllPayrollSourceService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.ChqbllTypeService;

//--- List Items 
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.ChqbllPayrollListItem;
import org.demo.web.listitem.ContactListItem;
import org.demo.web.listitem.ChqbllPayrollSourceListItem;
import org.demo.web.listitem.GlobalTransPointListItem;
import org.demo.web.listitem.ChqbllTypeListItem;

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
public class ChqbllPayrollDetailControllerTest {
	
	@InjectMocks
	private ChqbllPayrollDetailController chqbllPayrollDetailController;
	@Mock
	private ChqbllPayrollDetailService chqbllPayrollDetailService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private ChqbllPayrollService chqbllPayrollService; // Injected by Spring
	@Mock
	private ContactService contactService; // Injected by Spring
	@Mock
	private ChqbllPayrollSourceService chqbllPayrollSourceService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring
	@Mock
	private ChqbllTypeService chqbllTypeService; // Injected by Spring

	private ChqbllPayrollDetailFactoryForTest chqbllPayrollDetailFactoryForTest = new ChqbllPayrollDetailFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private ChqbllPayrollFactoryForTest chqbllPayrollFactoryForTest = new ChqbllPayrollFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private ChqbllPayrollSourceFactoryForTest chqbllPayrollSourceFactoryForTest = new ChqbllPayrollSourceFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();
	private ChqbllTypeFactoryForTest chqbllTypeFactoryForTest = new ChqbllTypeFactoryForTest();

	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<ChqbllPayroll> chqbllPayrolls = new ArrayList<ChqbllPayroll>();
	List<Contact> contacts = new ArrayList<Contact>();
	List<ChqbllPayrollSource> chqbllPayrollSources = new ArrayList<ChqbllPayrollSource>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
	List<ChqbllType> chqbllTypes = new ArrayList<ChqbllType>();

	private void givenPopulateModel() {
		GlobalPrivateCode globalPrivateCode1 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		GlobalPrivateCode globalPrivateCode2 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
		globalPrivateCodes.add(globalPrivateCode1);
		globalPrivateCodes.add(globalPrivateCode2);
		when(globalPrivateCodeService.findAll()).thenReturn(globalPrivateCodes);

		ChqbllPayroll chqbllPayroll1 = chqbllPayrollFactoryForTest.newChqbllPayroll();
		ChqbllPayroll chqbllPayroll2 = chqbllPayrollFactoryForTest.newChqbllPayroll();
		List<ChqbllPayroll> chqbllPayrolls = new ArrayList<ChqbllPayroll>();
		chqbllPayrolls.add(chqbllPayroll1);
		chqbllPayrolls.add(chqbllPayroll2);
		when(chqbllPayrollService.findAll()).thenReturn(chqbllPayrolls);

		Contact contact1 = contactFactoryForTest.newContact();
		Contact contact2 = contactFactoryForTest.newContact();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		when(contactService.findAll()).thenReturn(contacts);

		ChqbllPayrollSource chqbllPayrollSource1 = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		ChqbllPayrollSource chqbllPayrollSource2 = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		List<ChqbllPayrollSource> chqbllPayrollSources = new ArrayList<ChqbllPayrollSource>();
		chqbllPayrollSources.add(chqbllPayrollSource1);
		chqbllPayrollSources.add(chqbllPayrollSource2);
		when(chqbllPayrollSourceService.findAll()).thenReturn(chqbllPayrollSources);

		GlobalTransPoint globalTransPoint1 = globalTransPointFactoryForTest.newGlobalTransPoint();
		GlobalTransPoint globalTransPoint2 = globalTransPointFactoryForTest.newGlobalTransPoint();
		List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
		globalTransPoints.add(globalTransPoint1);
		globalTransPoints.add(globalTransPoint2);
		when(globalTransPointService.findAll()).thenReturn(globalTransPoints);

		ChqbllType chqbllType1 = chqbllTypeFactoryForTest.newChqbllType();
		ChqbllType chqbllType2 = chqbllTypeFactoryForTest.newChqbllType();
		List<ChqbllType> chqbllTypes = new ArrayList<ChqbllType>();
		chqbllTypes.add(chqbllType1);
		chqbllTypes.add(chqbllType2);
		when(chqbllTypeService.findAll()).thenReturn(chqbllTypes);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<ChqbllPayrollDetail> list = new ArrayList<ChqbllPayrollDetail>();
		when(chqbllPayrollDetailService.findAll()).thenReturn(list);
		
		// When
		String viewName = chqbllPayrollDetailController.list(model);
		
		// Then
		assertEquals("chqbllPayrollDetail/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = chqbllPayrollDetailController.formForCreate(model);
		
		// Then
		assertEquals("chqbllPayrollDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ChqbllPayrollDetail)modelMap.get("chqbllPayrollDetail")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllPayrollDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollListItem> chqbllPayrollListItems = (List<ChqbllPayrollListItem>) modelMap.get("listOfChqbllPayrollItems");
		assertEquals(2, chqbllPayrollListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllTypeListItem> chqbllTypeListItems = (List<ChqbllTypeListItem>) modelMap.get("listOfChqbllTypeItems");
		assertEquals(2, chqbllTypeListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllPayrollDetail chqbllPayrollDetail = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		Integer id = chqbllPayrollDetail.getId();
		when(chqbllPayrollDetailService.findById(id)).thenReturn(chqbllPayrollDetail);
		
		// When
		String viewName = chqbllPayrollDetailController.formForUpdate(model, id);
		
		// Then
		assertEquals("chqbllPayrollDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollDetail, (ChqbllPayrollDetail) modelMap.get("chqbllPayrollDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllPayrollDetail/update", modelMap.get("saveAction"));
		
		List<ChqbllTypeListItem> chqbllTypeListItems = (List<ChqbllTypeListItem>) modelMap.get("listOfChqbllTypeItems");
		assertEquals(2, chqbllTypeListItems.size());
		
		List<ChqbllPayrollListItem> chqbllPayrollListItems = (List<ChqbllPayrollListItem>) modelMap.get("listOfChqbllPayrollItems");
		assertEquals(2, chqbllPayrollListItems.size());
		
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
		
		ChqbllPayrollDetail chqbllPayrollDetail = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllPayrollDetail chqbllPayrollDetailCreated = new ChqbllPayrollDetail();
		when(chqbllPayrollDetailService.create(chqbllPayrollDetail)).thenReturn(chqbllPayrollDetailCreated); 
		
		// When
		String viewName = chqbllPayrollDetailController.create(chqbllPayrollDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllPayrollDetail/form/"+chqbllPayrollDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollDetailCreated, (ChqbllPayrollDetail) modelMap.get("chqbllPayrollDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllPayrollDetail chqbllPayrollDetail = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllPayrollDetailController.create(chqbllPayrollDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayrollDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollDetail, (ChqbllPayrollDetail) modelMap.get("chqbllPayrollDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllPayrollDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollListItem> chqbllPayrollListItems = (List<ChqbllPayrollListItem>) modelMap.get("listOfChqbllPayrollItems");
		assertEquals(2, chqbllPayrollListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllTypeListItem> chqbllTypeListItems = (List<ChqbllTypeListItem>) modelMap.get("listOfChqbllTypeItems");
		assertEquals(2, chqbllTypeListItems.size());
		
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

		ChqbllPayrollDetail chqbllPayrollDetail = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllPayrollDetailService.create(chqbllPayrollDetail)).thenThrow(exception);
		
		// When
		String viewName = chqbllPayrollDetailController.create(chqbllPayrollDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayrollDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollDetail, (ChqbllPayrollDetail) modelMap.get("chqbllPayrollDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllPayrollDetail/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllPayrollDetail.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollListItem> chqbllPayrollListItems = (List<ChqbllPayrollListItem>) modelMap.get("listOfChqbllPayrollItems");
		assertEquals(2, chqbllPayrollListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollSourceListItem> chqbllPayrollSourceListItems = (List<ChqbllPayrollSourceListItem>) modelMap.get("listOfChqbllPayrollSourceItems");
		assertEquals(2, chqbllPayrollSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllTypeListItem> chqbllTypeListItems = (List<ChqbllTypeListItem>) modelMap.get("listOfChqbllTypeItems");
		assertEquals(2, chqbllTypeListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllPayrollDetail chqbllPayrollDetail = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		Integer id = chqbllPayrollDetail.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllPayrollDetail chqbllPayrollDetailSaved = new ChqbllPayrollDetail();
		chqbllPayrollDetailSaved.setId(id);
		when(chqbllPayrollDetailService.update(chqbllPayrollDetail)).thenReturn(chqbllPayrollDetailSaved); 
		
		// When
		String viewName = chqbllPayrollDetailController.update(chqbllPayrollDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllPayrollDetail/form/"+chqbllPayrollDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollDetailSaved, (ChqbllPayrollDetail) modelMap.get("chqbllPayrollDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllPayrollDetail chqbllPayrollDetail = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllPayrollDetailController.update(chqbllPayrollDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayrollDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollDetail, (ChqbllPayrollDetail) modelMap.get("chqbllPayrollDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllPayrollDetail/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ChqbllTypeListItem> chqbllTypeListItems = (List<ChqbllTypeListItem>) modelMap.get("listOfChqbllTypeItems");
		assertEquals(2, chqbllTypeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollListItem> chqbllPayrollListItems = (List<ChqbllPayrollListItem>) modelMap.get("listOfChqbllPayrollItems");
		assertEquals(2, chqbllPayrollListItems.size());
		
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

		ChqbllPayrollDetail chqbllPayrollDetail = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllPayrollDetailService.update(chqbllPayrollDetail)).thenThrow(exception);
		
		// When
		String viewName = chqbllPayrollDetailController.update(chqbllPayrollDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayrollDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollDetail, (ChqbllPayrollDetail) modelMap.get("chqbllPayrollDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllPayrollDetail/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllPayrollDetail.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<ChqbllTypeListItem> chqbllTypeListItems = (List<ChqbllTypeListItem>) modelMap.get("listOfChqbllTypeItems");
		assertEquals(2, chqbllTypeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollListItem> chqbllPayrollListItems = (List<ChqbllPayrollListItem>) modelMap.get("listOfChqbllPayrollItems");
		assertEquals(2, chqbllPayrollListItems.size());
		
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
		
		ChqbllPayrollDetail chqbllPayrollDetail = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		Integer id = chqbllPayrollDetail.getId();
		
		// When
		String viewName = chqbllPayrollDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllPayrollDetailService).delete(id);
		assertEquals("redirect:/chqbllPayrollDetail", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllPayrollDetail chqbllPayrollDetail = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		Integer id = chqbllPayrollDetail.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(chqbllPayrollDetailService).delete(id);
		
		// When
		String viewName = chqbllPayrollDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllPayrollDetailService).delete(id);
		assertEquals("redirect:/chqbllPayrollDetail", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "chqbllPayrollDetail.error.delete", exception);
	}
	
	
}
