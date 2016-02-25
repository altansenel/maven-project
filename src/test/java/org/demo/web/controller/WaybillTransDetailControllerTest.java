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
import org.demo.bean.WaybillTransDetail;
import org.demo.bean.WaybillTransStatus;
import org.demo.bean.SaleSeller;
import org.demo.bean.WaybillTrans;
import org.demo.bean.WaybillTransSource;
import org.demo.bean.Stock;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.StockDepot;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.Contact;
import org.demo.test.WaybillTransDetailFactoryForTest;
import org.demo.test.WaybillTransStatusFactoryForTest;
import org.demo.test.SaleSellerFactoryForTest;
import org.demo.test.WaybillTransFactoryForTest;
import org.demo.test.WaybillTransSourceFactoryForTest;
import org.demo.test.StockFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;
import org.demo.test.StockDepotFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.ContactFactoryForTest;

//--- Services 
import org.demo.business.service.WaybillTransDetailService;
import org.demo.business.service.WaybillTransStatusService;
import org.demo.business.service.SaleSellerService;
import org.demo.business.service.WaybillTransService;
import org.demo.business.service.WaybillTransSourceService;
import org.demo.business.service.StockService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.StockDepotService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.ContactService;

//--- List Items 
import org.demo.web.listitem.WaybillTransStatusListItem;
import org.demo.web.listitem.SaleSellerListItem;
import org.demo.web.listitem.WaybillTransListItem;
import org.demo.web.listitem.WaybillTransSourceListItem;
import org.demo.web.listitem.StockListItem;
import org.demo.web.listitem.GlobalTransPointListItem;
import org.demo.web.listitem.StockDepotListItem;
import org.demo.web.listitem.GlobalPrivateCodeListItem;
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
public class WaybillTransDetailControllerTest {
	
	@InjectMocks
	private WaybillTransDetailController waybillTransDetailController;
	@Mock
	private WaybillTransDetailService waybillTransDetailService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private WaybillTransStatusService waybillTransStatusService; // Injected by Spring
	@Mock
	private SaleSellerService saleSellerService; // Injected by Spring
	@Mock
	private WaybillTransService waybillTransService; // Injected by Spring
	@Mock
	private WaybillTransSourceService waybillTransSourceService; // Injected by Spring
	@Mock
	private StockService stockService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring
	@Mock
	private StockDepotService stockDepotService; // Injected by Spring
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private ContactService contactService; // Injected by Spring

	private WaybillTransDetailFactoryForTest waybillTransDetailFactoryForTest = new WaybillTransDetailFactoryForTest();
	private WaybillTransStatusFactoryForTest waybillTransStatusFactoryForTest = new WaybillTransStatusFactoryForTest();
	private SaleSellerFactoryForTest saleSellerFactoryForTest = new SaleSellerFactoryForTest();
	private WaybillTransFactoryForTest waybillTransFactoryForTest = new WaybillTransFactoryForTest();
	private WaybillTransSourceFactoryForTest waybillTransSourceFactoryForTest = new WaybillTransSourceFactoryForTest();
	private StockFactoryForTest stockFactoryForTest = new StockFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();

	List<WaybillTransStatus> waybillTransStatuss = new ArrayList<WaybillTransStatus>();
	List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
	List<WaybillTrans> waybillTranss = new ArrayList<WaybillTrans>();
	List<WaybillTransSource> waybillTransSources = new ArrayList<WaybillTransSource>();
	List<Stock> stocks = new ArrayList<Stock>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
	List<StockDepot> stockDepots = new ArrayList<StockDepot>();
	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<Contact> contacts = new ArrayList<Contact>();

	private void givenPopulateModel() {
		WaybillTransStatus waybillTransStatus1 = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		WaybillTransStatus waybillTransStatus2 = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		List<WaybillTransStatus> waybillTransStatuss = new ArrayList<WaybillTransStatus>();
		waybillTransStatuss.add(waybillTransStatus1);
		waybillTransStatuss.add(waybillTransStatus2);
		when(waybillTransStatusService.findAll()).thenReturn(waybillTransStatuss);

		SaleSeller saleSeller1 = saleSellerFactoryForTest.newSaleSeller();
		SaleSeller saleSeller2 = saleSellerFactoryForTest.newSaleSeller();
		List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
		saleSellers.add(saleSeller1);
		saleSellers.add(saleSeller2);
		when(saleSellerService.findAll()).thenReturn(saleSellers);

		WaybillTrans waybillTrans1 = waybillTransFactoryForTest.newWaybillTrans();
		WaybillTrans waybillTrans2 = waybillTransFactoryForTest.newWaybillTrans();
		List<WaybillTrans> waybillTranss = new ArrayList<WaybillTrans>();
		waybillTranss.add(waybillTrans1);
		waybillTranss.add(waybillTrans2);
		when(waybillTransService.findAll()).thenReturn(waybillTranss);

		WaybillTransSource waybillTransSource1 = waybillTransSourceFactoryForTest.newWaybillTransSource();
		WaybillTransSource waybillTransSource2 = waybillTransSourceFactoryForTest.newWaybillTransSource();
		List<WaybillTransSource> waybillTransSources = new ArrayList<WaybillTransSource>();
		waybillTransSources.add(waybillTransSource1);
		waybillTransSources.add(waybillTransSource2);
		when(waybillTransSourceService.findAll()).thenReturn(waybillTransSources);

		Stock stock1 = stockFactoryForTest.newStock();
		Stock stock2 = stockFactoryForTest.newStock();
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(stock1);
		stocks.add(stock2);
		when(stockService.findAll()).thenReturn(stocks);

		GlobalTransPoint globalTransPoint1 = globalTransPointFactoryForTest.newGlobalTransPoint();
		GlobalTransPoint globalTransPoint2 = globalTransPointFactoryForTest.newGlobalTransPoint();
		List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
		globalTransPoints.add(globalTransPoint1);
		globalTransPoints.add(globalTransPoint2);
		when(globalTransPointService.findAll()).thenReturn(globalTransPoints);

		StockDepot stockDepot1 = stockDepotFactoryForTest.newStockDepot();
		StockDepot stockDepot2 = stockDepotFactoryForTest.newStockDepot();
		List<StockDepot> stockDepots = new ArrayList<StockDepot>();
		stockDepots.add(stockDepot1);
		stockDepots.add(stockDepot2);
		when(stockDepotService.findAll()).thenReturn(stockDepots);

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

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<WaybillTransDetail> list = new ArrayList<WaybillTransDetail>();
		when(waybillTransDetailService.findAll()).thenReturn(list);
		
		// When
		String viewName = waybillTransDetailController.list(model);
		
		// Then
		assertEquals("waybillTransDetail/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = waybillTransDetailController.formForCreate(model);
		
		// Then
		assertEquals("waybillTransDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((WaybillTransDetail)modelMap.get("waybillTransDetail")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransSourceListItem> waybillTransSourceListItems = (List<WaybillTransSourceListItem>) modelMap.get("listOfWaybillTransSourceItems");
		assertEquals(2, waybillTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransDetail waybillTransDetail = waybillTransDetailFactoryForTest.newWaybillTransDetail();
		Integer id = waybillTransDetail.getId();
		when(waybillTransDetailService.findById(id)).thenReturn(waybillTransDetail);
		
		// When
		String viewName = waybillTransDetailController.formForUpdate(model, id);
		
		// Then
		assertEquals("waybillTransDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransDetail, (WaybillTransDetail) modelMap.get("waybillTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransDetail/update", modelMap.get("saveAction"));
		
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
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
		
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransDetail waybillTransDetail = waybillTransDetailFactoryForTest.newWaybillTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransDetail waybillTransDetailCreated = new WaybillTransDetail();
		when(waybillTransDetailService.create(waybillTransDetail)).thenReturn(waybillTransDetailCreated); 
		
		// When
		String viewName = waybillTransDetailController.create(waybillTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransDetail/form/"+waybillTransDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransDetailCreated, (WaybillTransDetail) modelMap.get("waybillTransDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransDetail waybillTransDetail = waybillTransDetailFactoryForTest.newWaybillTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransDetailController.create(waybillTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransDetail, (WaybillTransDetail) modelMap.get("waybillTransDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransSourceListItem> waybillTransSourceListItems = (List<WaybillTransSourceListItem>) modelMap.get("listOfWaybillTransSourceItems");
		assertEquals(2, waybillTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
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

		WaybillTransDetail waybillTransDetail = waybillTransDetailFactoryForTest.newWaybillTransDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransDetailService.create(waybillTransDetail)).thenThrow(exception);
		
		// When
		String viewName = waybillTransDetailController.create(waybillTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransDetail, (WaybillTransDetail) modelMap.get("waybillTransDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransDetail/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransDetail.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransSourceListItem> waybillTransSourceListItems = (List<WaybillTransSourceListItem>) modelMap.get("listOfWaybillTransSourceItems");
		assertEquals(2, waybillTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransDetail waybillTransDetail = waybillTransDetailFactoryForTest.newWaybillTransDetail();
		Integer id = waybillTransDetail.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransDetail waybillTransDetailSaved = new WaybillTransDetail();
		waybillTransDetailSaved.setId(id);
		when(waybillTransDetailService.update(waybillTransDetail)).thenReturn(waybillTransDetailSaved); 
		
		// When
		String viewName = waybillTransDetailController.update(waybillTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransDetail/form/"+waybillTransDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransDetailSaved, (WaybillTransDetail) modelMap.get("waybillTransDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransDetail waybillTransDetail = waybillTransDetailFactoryForTest.newWaybillTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransDetailController.update(waybillTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransDetail, (WaybillTransDetail) modelMap.get("waybillTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransDetail/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
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

		WaybillTransDetail waybillTransDetail = waybillTransDetailFactoryForTest.newWaybillTransDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransDetailService.update(waybillTransDetail)).thenThrow(exception);
		
		// When
		String viewName = waybillTransDetailController.update(waybillTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransDetail, (WaybillTransDetail) modelMap.get("waybillTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransDetail/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransDetail.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
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
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransDetail waybillTransDetail = waybillTransDetailFactoryForTest.newWaybillTransDetail();
		Integer id = waybillTransDetail.getId();
		
		// When
		String viewName = waybillTransDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransDetailService).delete(id);
		assertEquals("redirect:/waybillTransDetail", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransDetail waybillTransDetail = waybillTransDetailFactoryForTest.newWaybillTransDetail();
		Integer id = waybillTransDetail.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(waybillTransDetailService).delete(id);
		
		// When
		String viewName = waybillTransDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransDetailService).delete(id);
		assertEquals("redirect:/waybillTransDetail", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "waybillTransDetail.error.delete", exception);
	}
	
	
}
