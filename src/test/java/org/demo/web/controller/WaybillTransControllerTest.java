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
import org.demo.bean.WaybillTrans;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.StockDepot;
import org.demo.bean.WaybillTransStatus;
import org.demo.bean.WaybillTransSource;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.SaleSeller;
import org.demo.bean.Contact;
import org.demo.test.WaybillTransFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.StockDepotFactoryForTest;
import org.demo.test.WaybillTransStatusFactoryForTest;
import org.demo.test.WaybillTransSourceFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;
import org.demo.test.SaleSellerFactoryForTest;
import org.demo.test.ContactFactoryForTest;

//--- Services 
import org.demo.business.service.WaybillTransService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.StockDepotService;
import org.demo.business.service.WaybillTransStatusService;
import org.demo.business.service.WaybillTransSourceService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.SaleSellerService;
import org.demo.business.service.ContactService;

//--- List Items 
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.StockDepotListItem;
import org.demo.web.listitem.WaybillTransStatusListItem;
import org.demo.web.listitem.WaybillTransSourceListItem;
import org.demo.web.listitem.GlobalTransPointListItem;
import org.demo.web.listitem.SaleSellerListItem;
import org.demo.web.listitem.ContactListItem;

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
public class WaybillTransControllerTest {
	
	@InjectMocks
	private WaybillTransController waybillTransController;
	@Mock
	private WaybillTransService waybillTransService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private StockDepotService stockDepotService; // Injected by Spring
	@Mock
	private WaybillTransStatusService waybillTransStatusService; // Injected by Spring
	@Mock
	private WaybillTransSourceService waybillTransSourceService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring
	@Mock
	private SaleSellerService saleSellerService; // Injected by Spring
	@Mock
	private ContactService contactService; // Injected by Spring

	private WaybillTransFactoryForTest waybillTransFactoryForTest = new WaybillTransFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();
	private WaybillTransStatusFactoryForTest waybillTransStatusFactoryForTest = new WaybillTransStatusFactoryForTest();
	private WaybillTransSourceFactoryForTest waybillTransSourceFactoryForTest = new WaybillTransSourceFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();
	private SaleSellerFactoryForTest saleSellerFactoryForTest = new SaleSellerFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();

	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<StockDepot> stockDepots = new ArrayList<StockDepot>();
	List<WaybillTransStatus> waybillTransStatuss = new ArrayList<WaybillTransStatus>();
	List<WaybillTransSource> waybillTransSources = new ArrayList<WaybillTransSource>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
	List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
	List<Contact> contacts = new ArrayList<Contact>();

	private void givenPopulateModel() {
		GlobalPrivateCode globalPrivateCode1 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		GlobalPrivateCode globalPrivateCode2 = globalPrivateCodeFactoryForTest.newGlobalPrivateCode();
		List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
		globalPrivateCodes.add(globalPrivateCode1);
		globalPrivateCodes.add(globalPrivateCode2);
		when(globalPrivateCodeService.findAll()).thenReturn(globalPrivateCodes);

		StockDepot stockDepot1 = stockDepotFactoryForTest.newStockDepot();
		StockDepot stockDepot2 = stockDepotFactoryForTest.newStockDepot();
		List<StockDepot> stockDepots = new ArrayList<StockDepot>();
		stockDepots.add(stockDepot1);
		stockDepots.add(stockDepot2);
		when(stockDepotService.findAll()).thenReturn(stockDepots);

		WaybillTransStatus waybillTransStatus1 = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		WaybillTransStatus waybillTransStatus2 = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		List<WaybillTransStatus> waybillTransStatuss = new ArrayList<WaybillTransStatus>();
		waybillTransStatuss.add(waybillTransStatus1);
		waybillTransStatuss.add(waybillTransStatus2);
		when(waybillTransStatusService.findAll()).thenReturn(waybillTransStatuss);

		WaybillTransSource waybillTransSource1 = waybillTransSourceFactoryForTest.newWaybillTransSource();
		WaybillTransSource waybillTransSource2 = waybillTransSourceFactoryForTest.newWaybillTransSource();
		List<WaybillTransSource> waybillTransSources = new ArrayList<WaybillTransSource>();
		waybillTransSources.add(waybillTransSource1);
		waybillTransSources.add(waybillTransSource2);
		when(waybillTransSourceService.findAll()).thenReturn(waybillTransSources);

		GlobalTransPoint globalTransPoint1 = globalTransPointFactoryForTest.newGlobalTransPoint();
		GlobalTransPoint globalTransPoint2 = globalTransPointFactoryForTest.newGlobalTransPoint();
		List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
		globalTransPoints.add(globalTransPoint1);
		globalTransPoints.add(globalTransPoint2);
		when(globalTransPointService.findAll()).thenReturn(globalTransPoints);

		SaleSeller saleSeller1 = saleSellerFactoryForTest.newSaleSeller();
		SaleSeller saleSeller2 = saleSellerFactoryForTest.newSaleSeller();
		List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
		saleSellers.add(saleSeller1);
		saleSellers.add(saleSeller2);
		when(saleSellerService.findAll()).thenReturn(saleSellers);

		Contact contact1 = contactFactoryForTest.newContact();
		Contact contact2 = contactFactoryForTest.newContact();
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		when(contactService.findAll()).thenReturn(contacts);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<WaybillTrans> list = new ArrayList<WaybillTrans>();
		when(waybillTransService.findAll()).thenReturn(list);
		
		// When
		String viewName = waybillTransController.list(model);
		
		// Then
		assertEquals("waybillTrans/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = waybillTransController.formForCreate(model);
		
		// Then
		assertEquals("waybillTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((WaybillTrans)modelMap.get("waybillTrans")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransSourceListItem> waybillTransSourceListItems = (List<WaybillTransSourceListItem>) modelMap.get("listOfWaybillTransSourceItems");
		assertEquals(2, waybillTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();
		Integer id = waybillTrans.getId();
		when(waybillTransService.findById(id)).thenReturn(waybillTrans);
		
		// When
		String viewName = waybillTransController.formForUpdate(model, id);
		
		// Then
		assertEquals("waybillTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTrans, (WaybillTrans) modelMap.get("waybillTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTrans/update", modelMap.get("saveAction"));
		
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		List<WaybillTransSourceListItem> waybillTransSourceListItems = (List<WaybillTransSourceListItem>) modelMap.get("listOfWaybillTransSourceItems");
		assertEquals(2, waybillTransSourceListItems.size());
		
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTrans waybillTransCreated = new WaybillTrans();
		when(waybillTransService.create(waybillTrans)).thenReturn(waybillTransCreated); 
		
		// When
		String viewName = waybillTransController.create(waybillTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTrans/form/"+waybillTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransCreated, (WaybillTrans) modelMap.get("waybillTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransController.create(waybillTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTrans, (WaybillTrans) modelMap.get("waybillTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransSourceListItem> waybillTransSourceListItems = (List<WaybillTransSourceListItem>) modelMap.get("listOfWaybillTransSourceItems");
		assertEquals(2, waybillTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
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

		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransService.create(waybillTrans)).thenThrow(exception);
		
		// When
		String viewName = waybillTransController.create(waybillTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTrans, (WaybillTrans) modelMap.get("waybillTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTrans/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTrans.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransSourceListItem> waybillTransSourceListItems = (List<WaybillTransSourceListItem>) modelMap.get("listOfWaybillTransSourceItems");
		assertEquals(2, waybillTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();
		Integer id = waybillTrans.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTrans waybillTransSaved = new WaybillTrans();
		waybillTransSaved.setId(id);
		when(waybillTransService.update(waybillTrans)).thenReturn(waybillTransSaved); 
		
		// When
		String viewName = waybillTransController.update(waybillTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTrans/form/"+waybillTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransSaved, (WaybillTrans) modelMap.get("waybillTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransController.update(waybillTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTrans, (WaybillTrans) modelMap.get("waybillTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTrans/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransSourceListItem> waybillTransSourceListItems = (List<WaybillTransSourceListItem>) modelMap.get("listOfWaybillTransSourceItems");
		assertEquals(2, waybillTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
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

		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransService.update(waybillTrans)).thenThrow(exception);
		
		// When
		String viewName = waybillTransController.update(waybillTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTrans, (WaybillTrans) modelMap.get("waybillTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTrans/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTrans.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransSourceListItem> waybillTransSourceListItems = (List<WaybillTransSourceListItem>) modelMap.get("listOfWaybillTransSourceItems");
		assertEquals(2, waybillTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();
		Integer id = waybillTrans.getId();
		
		// When
		String viewName = waybillTransController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransService).delete(id);
		assertEquals("redirect:/waybillTrans", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTrans waybillTrans = waybillTransFactoryForTest.newWaybillTrans();
		Integer id = waybillTrans.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(waybillTransService).delete(id);
		
		// When
		String viewName = waybillTransController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransService).delete(id);
		assertEquals("redirect:/waybillTrans", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "waybillTrans.error.delete", exception);
	}
	
	
}
