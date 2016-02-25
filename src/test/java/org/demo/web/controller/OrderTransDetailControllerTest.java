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
import org.demo.bean.OrderTransDetail;
import org.demo.bean.StockDepot;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.Contact;
import org.demo.bean.OrderTransStatus;
import org.demo.bean.SaleSeller;
import org.demo.bean.OrderTrans;
import org.demo.bean.OrderTransSource;
import org.demo.bean.Stock;
import org.demo.bean.GlobalTransPoint;
import org.demo.test.OrderTransDetailFactoryForTest;
import org.demo.test.StockDepotFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.OrderTransStatusFactoryForTest;
import org.demo.test.SaleSellerFactoryForTest;
import org.demo.test.OrderTransFactoryForTest;
import org.demo.test.OrderTransSourceFactoryForTest;
import org.demo.test.StockFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;

//--- Services 
import org.demo.business.service.OrderTransDetailService;
import org.demo.business.service.StockDepotService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.ContactService;
import org.demo.business.service.OrderTransStatusService;
import org.demo.business.service.SaleSellerService;
import org.demo.business.service.OrderTransService;
import org.demo.business.service.OrderTransSourceService;
import org.demo.business.service.StockService;
import org.demo.business.service.GlobalTransPointService;

//--- List Items 
import org.demo.web.listitem.StockDepotListItem;
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.ContactListItem;
import org.demo.web.listitem.OrderTransStatusListItem;
import org.demo.web.listitem.SaleSellerListItem;
import org.demo.web.listitem.OrderTransListItem;
import org.demo.web.listitem.OrderTransSourceListItem;
import org.demo.web.listitem.StockListItem;
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
public class OrderTransDetailControllerTest {
	
	@InjectMocks
	private OrderTransDetailController orderTransDetailController;
	@Mock
	private OrderTransDetailService orderTransDetailService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockDepotService stockDepotService; // Injected by Spring
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private ContactService contactService; // Injected by Spring
	@Mock
	private OrderTransStatusService orderTransStatusService; // Injected by Spring
	@Mock
	private SaleSellerService saleSellerService; // Injected by Spring
	@Mock
	private OrderTransService orderTransService; // Injected by Spring
	@Mock
	private OrderTransSourceService orderTransSourceService; // Injected by Spring
	@Mock
	private StockService stockService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring

	private OrderTransDetailFactoryForTest orderTransDetailFactoryForTest = new OrderTransDetailFactoryForTest();
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private OrderTransStatusFactoryForTest orderTransStatusFactoryForTest = new OrderTransStatusFactoryForTest();
	private SaleSellerFactoryForTest saleSellerFactoryForTest = new SaleSellerFactoryForTest();
	private OrderTransFactoryForTest orderTransFactoryForTest = new OrderTransFactoryForTest();
	private OrderTransSourceFactoryForTest orderTransSourceFactoryForTest = new OrderTransSourceFactoryForTest();
	private StockFactoryForTest stockFactoryForTest = new StockFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();

	List<StockDepot> stockDepots = new ArrayList<StockDepot>();
	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<Contact> contacts = new ArrayList<Contact>();
	List<OrderTransStatus> orderTransStatuss = new ArrayList<OrderTransStatus>();
	List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
	List<OrderTrans> orderTranss = new ArrayList<OrderTrans>();
	List<OrderTransSource> orderTransSources = new ArrayList<OrderTransSource>();
	List<Stock> stocks = new ArrayList<Stock>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();

	private void givenPopulateModel() {
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

		OrderTransStatus orderTransStatus1 = orderTransStatusFactoryForTest.newOrderTransStatus();
		OrderTransStatus orderTransStatus2 = orderTransStatusFactoryForTest.newOrderTransStatus();
		List<OrderTransStatus> orderTransStatuss = new ArrayList<OrderTransStatus>();
		orderTransStatuss.add(orderTransStatus1);
		orderTransStatuss.add(orderTransStatus2);
		when(orderTransStatusService.findAll()).thenReturn(orderTransStatuss);

		SaleSeller saleSeller1 = saleSellerFactoryForTest.newSaleSeller();
		SaleSeller saleSeller2 = saleSellerFactoryForTest.newSaleSeller();
		List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
		saleSellers.add(saleSeller1);
		saleSellers.add(saleSeller2);
		when(saleSellerService.findAll()).thenReturn(saleSellers);

		OrderTrans orderTrans1 = orderTransFactoryForTest.newOrderTrans();
		OrderTrans orderTrans2 = orderTransFactoryForTest.newOrderTrans();
		List<OrderTrans> orderTranss = new ArrayList<OrderTrans>();
		orderTranss.add(orderTrans1);
		orderTranss.add(orderTrans2);
		when(orderTransService.findAll()).thenReturn(orderTranss);

		OrderTransSource orderTransSource1 = orderTransSourceFactoryForTest.newOrderTransSource();
		OrderTransSource orderTransSource2 = orderTransSourceFactoryForTest.newOrderTransSource();
		List<OrderTransSource> orderTransSources = new ArrayList<OrderTransSource>();
		orderTransSources.add(orderTransSource1);
		orderTransSources.add(orderTransSource2);
		when(orderTransSourceService.findAll()).thenReturn(orderTransSources);

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

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<OrderTransDetail> list = new ArrayList<OrderTransDetail>();
		when(orderTransDetailService.findAll()).thenReturn(list);
		
		// When
		String viewName = orderTransDetailController.list(model);
		
		// Then
		assertEquals("orderTransDetail/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = orderTransDetailController.formForCreate(model);
		
		// Then
		assertEquals("orderTransDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((OrderTransDetail)modelMap.get("orderTransDetail")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransSourceListItem> orderTransSourceListItems = (List<OrderTransSourceListItem>) modelMap.get("listOfOrderTransSourceItems");
		assertEquals(2, orderTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();
		Integer id = orderTransDetail.getId();
		when(orderTransDetailService.findById(id)).thenReturn(orderTransDetail);
		
		// When
		String viewName = orderTransDetailController.formForUpdate(model, id);
		
		// Then
		assertEquals("orderTransDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransDetail, (OrderTransDetail) modelMap.get("orderTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransDetail/update", modelMap.get("saveAction"));
		
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		List<OrderTransSourceListItem> orderTransSourceListItems = (List<OrderTransSourceListItem>) modelMap.get("listOfOrderTransSourceItems");
		assertEquals(2, orderTransSourceListItems.size());
		
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTransDetail orderTransDetailCreated = new OrderTransDetail();
		when(orderTransDetailService.create(orderTransDetail)).thenReturn(orderTransDetailCreated); 
		
		// When
		String viewName = orderTransDetailController.create(orderTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTransDetail/form/"+orderTransDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransDetailCreated, (OrderTransDetail) modelMap.get("orderTransDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransDetailController.create(orderTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransDetail, (OrderTransDetail) modelMap.get("orderTransDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransSourceListItem> orderTransSourceListItems = (List<OrderTransSourceListItem>) modelMap.get("listOfOrderTransSourceItems");
		assertEquals(2, orderTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
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

		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransDetailService.create(orderTransDetail)).thenThrow(exception);
		
		// When
		String viewName = orderTransDetailController.create(orderTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransDetail, (OrderTransDetail) modelMap.get("orderTransDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTransDetail/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTransDetail.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransSourceListItem> orderTransSourceListItems = (List<OrderTransSourceListItem>) modelMap.get("listOfOrderTransSourceItems");
		assertEquals(2, orderTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();
		Integer id = orderTransDetail.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTransDetail orderTransDetailSaved = new OrderTransDetail();
		orderTransDetailSaved.setId(id);
		when(orderTransDetailService.update(orderTransDetail)).thenReturn(orderTransDetailSaved); 
		
		// When
		String viewName = orderTransDetailController.update(orderTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTransDetail/form/"+orderTransDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransDetailSaved, (OrderTransDetail) modelMap.get("orderTransDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransDetailController.update(orderTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransDetail, (OrderTransDetail) modelMap.get("orderTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransDetail/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
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
		List<OrderTransSourceListItem> orderTransSourceListItems = (List<OrderTransSourceListItem>) modelMap.get("listOfOrderTransSourceItems");
		assertEquals(2, orderTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
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

		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransDetailService.update(orderTransDetail)).thenThrow(exception);
		
		// When
		String viewName = orderTransDetailController.update(orderTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransDetail, (OrderTransDetail) modelMap.get("orderTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTransDetail/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTransDetail.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransListItem> orderTransListItems = (List<OrderTransListItem>) modelMap.get("listOfOrderTransItems");
		assertEquals(2, orderTransListItems.size());
		
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
		List<OrderTransSourceListItem> orderTransSourceListItems = (List<OrderTransSourceListItem>) modelMap.get("listOfOrderTransSourceItems");
		assertEquals(2, orderTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();
		Integer id = orderTransDetail.getId();
		
		// When
		String viewName = orderTransDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransDetailService).delete(id);
		assertEquals("redirect:/orderTransDetail", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTransDetail orderTransDetail = orderTransDetailFactoryForTest.newOrderTransDetail();
		Integer id = orderTransDetail.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(orderTransDetailService).delete(id);
		
		// When
		String viewName = orderTransDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransDetailService).delete(id);
		assertEquals("redirect:/orderTransDetail", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "orderTransDetail.error.delete", exception);
	}
	
	
}
