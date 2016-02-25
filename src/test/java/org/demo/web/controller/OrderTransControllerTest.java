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
import org.demo.bean.OrderTrans;
import org.demo.bean.OrderTransStatus;
import org.demo.bean.OrderTransSource;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.SaleSeller;
import org.demo.bean.Contact;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.StockDepot;
import org.demo.test.OrderTransFactoryForTest;
import org.demo.test.OrderTransStatusFactoryForTest;
import org.demo.test.OrderTransSourceFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;
import org.demo.test.SaleSellerFactoryForTest;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.StockDepotFactoryForTest;

//--- Services 
import org.demo.business.service.OrderTransService;
import org.demo.business.service.OrderTransStatusService;
import org.demo.business.service.OrderTransSourceService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.SaleSellerService;
import org.demo.business.service.ContactService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.StockDepotService;

//--- List Items 
import org.demo.web.listitem.OrderTransStatusListItem;
import org.demo.web.listitem.OrderTransSourceListItem;
import org.demo.web.listitem.GlobalTransPointListItem;
import org.demo.web.listitem.SaleSellerListItem;
import org.demo.web.listitem.ContactListItem;
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.StockDepotListItem;

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
public class OrderTransControllerTest {
	
	@InjectMocks
	private OrderTransController orderTransController;
	@Mock
	private OrderTransService orderTransService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private OrderTransStatusService orderTransStatusService; // Injected by Spring
	@Mock
	private OrderTransSourceService orderTransSourceService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring
	@Mock
	private SaleSellerService saleSellerService; // Injected by Spring
	@Mock
	private ContactService contactService; // Injected by Spring
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private StockDepotService stockDepotService; // Injected by Spring

	private OrderTransFactoryForTest orderTransFactoryForTest = new OrderTransFactoryForTest();
	private OrderTransStatusFactoryForTest orderTransStatusFactoryForTest = new OrderTransStatusFactoryForTest();
	private OrderTransSourceFactoryForTest orderTransSourceFactoryForTest = new OrderTransSourceFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();
	private SaleSellerFactoryForTest saleSellerFactoryForTest = new SaleSellerFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();

	List<OrderTransStatus> orderTransStatuss = new ArrayList<OrderTransStatus>();
	List<OrderTransSource> orderTransSources = new ArrayList<OrderTransSource>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
	List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
	List<Contact> contacts = new ArrayList<Contact>();
	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<StockDepot> stockDepots = new ArrayList<StockDepot>();

	private void givenPopulateModel() {
		OrderTransStatus orderTransStatus1 = orderTransStatusFactoryForTest.newOrderTransStatus();
		OrderTransStatus orderTransStatus2 = orderTransStatusFactoryForTest.newOrderTransStatus();
		List<OrderTransStatus> orderTransStatuss = new ArrayList<OrderTransStatus>();
		orderTransStatuss.add(orderTransStatus1);
		orderTransStatuss.add(orderTransStatus2);
		when(orderTransStatusService.findAll()).thenReturn(orderTransStatuss);

		OrderTransSource orderTransSource1 = orderTransSourceFactoryForTest.newOrderTransSource();
		OrderTransSource orderTransSource2 = orderTransSourceFactoryForTest.newOrderTransSource();
		List<OrderTransSource> orderTransSources = new ArrayList<OrderTransSource>();
		orderTransSources.add(orderTransSource1);
		orderTransSources.add(orderTransSource2);
		when(orderTransSourceService.findAll()).thenReturn(orderTransSources);

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

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<OrderTrans> list = new ArrayList<OrderTrans>();
		when(orderTransService.findAll()).thenReturn(list);
		
		// When
		String viewName = orderTransController.list(model);
		
		// Then
		assertEquals("orderTrans/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = orderTransController.formForCreate(model);
		
		// Then
		assertEquals("orderTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((OrderTrans)modelMap.get("orderTrans")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransSourceListItem> orderTransSourceListItems = (List<OrderTransSourceListItem>) modelMap.get("listOfOrderTransSourceItems");
		assertEquals(2, orderTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();
		Integer id = orderTrans.getId();
		when(orderTransService.findById(id)).thenReturn(orderTrans);
		
		// When
		String viewName = orderTransController.formForUpdate(model, id);
		
		// Then
		assertEquals("orderTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTrans, (OrderTrans) modelMap.get("orderTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTrans/update", modelMap.get("saveAction"));
		
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
		
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTrans orderTransCreated = new OrderTrans();
		when(orderTransService.create(orderTrans)).thenReturn(orderTransCreated); 
		
		// When
		String viewName = orderTransController.create(orderTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTrans/form/"+orderTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransCreated, (OrderTrans) modelMap.get("orderTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransController.create(orderTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTrans, (OrderTrans) modelMap.get("orderTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransSourceListItem> orderTransSourceListItems = (List<OrderTransSourceListItem>) modelMap.get("listOfOrderTransSourceItems");
		assertEquals(2, orderTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
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

		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransService.create(orderTrans)).thenThrow(exception);
		
		// When
		String viewName = orderTransController.create(orderTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTrans, (OrderTrans) modelMap.get("orderTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/orderTrans/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTrans.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransSourceListItem> orderTransSourceListItems = (List<OrderTransSourceListItem>) modelMap.get("listOfOrderTransSourceItems");
		assertEquals(2, orderTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();
		Integer id = orderTrans.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		OrderTrans orderTransSaved = new OrderTrans();
		orderTransSaved.setId(id);
		when(orderTransService.update(orderTrans)).thenReturn(orderTransSaved); 
		
		// When
		String viewName = orderTransController.update(orderTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/orderTrans/form/"+orderTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTransSaved, (OrderTrans) modelMap.get("orderTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = orderTransController.update(orderTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTrans, (OrderTrans) modelMap.get("orderTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTrans/update", modelMap.get("saveAction"));
		
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
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
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

		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(orderTransService.update(orderTrans)).thenThrow(exception);
		
		// When
		String viewName = orderTransController.update(orderTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("orderTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(orderTrans, (OrderTrans) modelMap.get("orderTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/orderTrans/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "orderTrans.error.update", exception);
		
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
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<OrderTransStatusListItem> orderTransStatusListItems = (List<OrderTransStatusListItem>) modelMap.get("listOfOrderTransStatusItems");
		assertEquals(2, orderTransStatusListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();
		Integer id = orderTrans.getId();
		
		// When
		String viewName = orderTransController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransService).delete(id);
		assertEquals("redirect:/orderTrans", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		OrderTrans orderTrans = orderTransFactoryForTest.newOrderTrans();
		Integer id = orderTrans.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(orderTransService).delete(id);
		
		// When
		String viewName = orderTransController.delete(redirectAttributes, id);
		
		// Then
		verify(orderTransService).delete(id);
		assertEquals("redirect:/orderTrans", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "orderTrans.error.delete", exception);
	}
	
	
}
