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
import org.demo.bean.InvoiceTransDetail;
import org.demo.bean.SaleSeller;
import org.demo.bean.InvoiceTrans;
import org.demo.bean.InvoiceTransSource;
import org.demo.bean.Stock;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.StockDepot;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.Contact;
import org.demo.bean.InvoiceTransStatus;
import org.demo.test.InvoiceTransDetailFactoryForTest;
import org.demo.test.SaleSellerFactoryForTest;
import org.demo.test.InvoiceTransFactoryForTest;
import org.demo.test.InvoiceTransSourceFactoryForTest;
import org.demo.test.StockFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;
import org.demo.test.StockDepotFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.InvoiceTransStatusFactoryForTest;

//--- Services 
import org.demo.business.service.InvoiceTransDetailService;
import org.demo.business.service.SaleSellerService;
import org.demo.business.service.InvoiceTransService;
import org.demo.business.service.InvoiceTransSourceService;
import org.demo.business.service.StockService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.StockDepotService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.ContactService;
import org.demo.business.service.InvoiceTransStatusService;

//--- List Items 
import org.demo.web.listitem.SaleSellerListItem;
import org.demo.web.listitem.InvoiceTransListItem;
import org.demo.web.listitem.InvoiceTransSourceListItem;
import org.demo.web.listitem.StockListItem;
import org.demo.web.listitem.GlobalTransPointListItem;
import org.demo.web.listitem.StockDepotListItem;
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.ContactListItem;
import org.demo.web.listitem.InvoiceTransStatusListItem;

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
public class InvoiceTransDetailControllerTest {
	
	@InjectMocks
	private InvoiceTransDetailController invoiceTransDetailController;
	@Mock
	private InvoiceTransDetailService invoiceTransDetailService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private SaleSellerService saleSellerService; // Injected by Spring
	@Mock
	private InvoiceTransService invoiceTransService; // Injected by Spring
	@Mock
	private InvoiceTransSourceService invoiceTransSourceService; // Injected by Spring
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
	@Mock
	private InvoiceTransStatusService invoiceTransStatusService; // Injected by Spring

	private InvoiceTransDetailFactoryForTest invoiceTransDetailFactoryForTest = new InvoiceTransDetailFactoryForTest();
	private SaleSellerFactoryForTest saleSellerFactoryForTest = new SaleSellerFactoryForTest();
	private InvoiceTransFactoryForTest invoiceTransFactoryForTest = new InvoiceTransFactoryForTest();
	private InvoiceTransSourceFactoryForTest invoiceTransSourceFactoryForTest = new InvoiceTransSourceFactoryForTest();
	private StockFactoryForTest stockFactoryForTest = new StockFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private InvoiceTransStatusFactoryForTest invoiceTransStatusFactoryForTest = new InvoiceTransStatusFactoryForTest();

	List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
	List<InvoiceTrans> invoiceTranss = new ArrayList<InvoiceTrans>();
	List<InvoiceTransSource> invoiceTransSources = new ArrayList<InvoiceTransSource>();
	List<Stock> stocks = new ArrayList<Stock>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
	List<StockDepot> stockDepots = new ArrayList<StockDepot>();
	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<Contact> contacts = new ArrayList<Contact>();
	List<InvoiceTransStatus> invoiceTransStatuss = new ArrayList<InvoiceTransStatus>();

	private void givenPopulateModel() {
		SaleSeller saleSeller1 = saleSellerFactoryForTest.newSaleSeller();
		SaleSeller saleSeller2 = saleSellerFactoryForTest.newSaleSeller();
		List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
		saleSellers.add(saleSeller1);
		saleSellers.add(saleSeller2);
		when(saleSellerService.findAll()).thenReturn(saleSellers);

		InvoiceTrans invoiceTrans1 = invoiceTransFactoryForTest.newInvoiceTrans();
		InvoiceTrans invoiceTrans2 = invoiceTransFactoryForTest.newInvoiceTrans();
		List<InvoiceTrans> invoiceTranss = new ArrayList<InvoiceTrans>();
		invoiceTranss.add(invoiceTrans1);
		invoiceTranss.add(invoiceTrans2);
		when(invoiceTransService.findAll()).thenReturn(invoiceTranss);

		InvoiceTransSource invoiceTransSource1 = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		InvoiceTransSource invoiceTransSource2 = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		List<InvoiceTransSource> invoiceTransSources = new ArrayList<InvoiceTransSource>();
		invoiceTransSources.add(invoiceTransSource1);
		invoiceTransSources.add(invoiceTransSource2);
		when(invoiceTransSourceService.findAll()).thenReturn(invoiceTransSources);

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

		InvoiceTransStatus invoiceTransStatus1 = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		InvoiceTransStatus invoiceTransStatus2 = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		List<InvoiceTransStatus> invoiceTransStatuss = new ArrayList<InvoiceTransStatus>();
		invoiceTransStatuss.add(invoiceTransStatus1);
		invoiceTransStatuss.add(invoiceTransStatus2);
		when(invoiceTransStatusService.findAll()).thenReturn(invoiceTransStatuss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<InvoiceTransDetail> list = new ArrayList<InvoiceTransDetail>();
		when(invoiceTransDetailService.findAll()).thenReturn(list);
		
		// When
		String viewName = invoiceTransDetailController.list(model);
		
		// Then
		assertEquals("invoiceTransDetail/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = invoiceTransDetailController.formForCreate(model);
		
		// Then
		assertEquals("invoiceTransDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((InvoiceTransDetail)modelMap.get("invoiceTransDetail")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransSourceListItem> invoiceTransSourceListItems = (List<InvoiceTransSourceListItem>) modelMap.get("listOfInvoiceTransSourceItems");
		assertEquals(2, invoiceTransSourceListItems.size());
		
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
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransDetail invoiceTransDetail = invoiceTransDetailFactoryForTest.newInvoiceTransDetail();
		Integer id = invoiceTransDetail.getId();
		when(invoiceTransDetailService.findById(id)).thenReturn(invoiceTransDetail);
		
		// When
		String viewName = invoiceTransDetailController.formForUpdate(model, id);
		
		// Then
		assertEquals("invoiceTransDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransDetail, (InvoiceTransDetail) modelMap.get("invoiceTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransDetail/update", modelMap.get("saveAction"));
		
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		List<InvoiceTransSourceListItem> invoiceTransSourceListItems = (List<InvoiceTransSourceListItem>) modelMap.get("listOfInvoiceTransSourceItems");
		assertEquals(2, invoiceTransSourceListItems.size());
		
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransDetail invoiceTransDetail = invoiceTransDetailFactoryForTest.newInvoiceTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransDetail invoiceTransDetailCreated = new InvoiceTransDetail();
		when(invoiceTransDetailService.create(invoiceTransDetail)).thenReturn(invoiceTransDetailCreated); 
		
		// When
		String viewName = invoiceTransDetailController.create(invoiceTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransDetail/form/"+invoiceTransDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransDetailCreated, (InvoiceTransDetail) modelMap.get("invoiceTransDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransDetail invoiceTransDetail = invoiceTransDetailFactoryForTest.newInvoiceTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransDetailController.create(invoiceTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransDetail, (InvoiceTransDetail) modelMap.get("invoiceTransDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransSourceListItem> invoiceTransSourceListItems = (List<InvoiceTransSourceListItem>) modelMap.get("listOfInvoiceTransSourceItems");
		assertEquals(2, invoiceTransSourceListItems.size());
		
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
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
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

		InvoiceTransDetail invoiceTransDetail = invoiceTransDetailFactoryForTest.newInvoiceTransDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransDetailService.create(invoiceTransDetail)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransDetailController.create(invoiceTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransDetail, (InvoiceTransDetail) modelMap.get("invoiceTransDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransDetail/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransDetail.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransSourceListItem> invoiceTransSourceListItems = (List<InvoiceTransSourceListItem>) modelMap.get("listOfInvoiceTransSourceItems");
		assertEquals(2, invoiceTransSourceListItems.size());
		
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
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransDetail invoiceTransDetail = invoiceTransDetailFactoryForTest.newInvoiceTransDetail();
		Integer id = invoiceTransDetail.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransDetail invoiceTransDetailSaved = new InvoiceTransDetail();
		invoiceTransDetailSaved.setId(id);
		when(invoiceTransDetailService.update(invoiceTransDetail)).thenReturn(invoiceTransDetailSaved); 
		
		// When
		String viewName = invoiceTransDetailController.update(invoiceTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransDetail/form/"+invoiceTransDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransDetailSaved, (InvoiceTransDetail) modelMap.get("invoiceTransDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransDetail invoiceTransDetail = invoiceTransDetailFactoryForTest.newInvoiceTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransDetailController.update(invoiceTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransDetail, (InvoiceTransDetail) modelMap.get("invoiceTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransDetail/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
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
		List<InvoiceTransSourceListItem> invoiceTransSourceListItems = (List<InvoiceTransSourceListItem>) modelMap.get("listOfInvoiceTransSourceItems");
		assertEquals(2, invoiceTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
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

		InvoiceTransDetail invoiceTransDetail = invoiceTransDetailFactoryForTest.newInvoiceTransDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransDetailService.update(invoiceTransDetail)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransDetailController.update(invoiceTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransDetail, (InvoiceTransDetail) modelMap.get("invoiceTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransDetail/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransDetail.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
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
		List<InvoiceTransSourceListItem> invoiceTransSourceListItems = (List<InvoiceTransSourceListItem>) modelMap.get("listOfInvoiceTransSourceItems");
		assertEquals(2, invoiceTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransDetail invoiceTransDetail = invoiceTransDetailFactoryForTest.newInvoiceTransDetail();
		Integer id = invoiceTransDetail.getId();
		
		// When
		String viewName = invoiceTransDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransDetailService).delete(id);
		assertEquals("redirect:/invoiceTransDetail", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransDetail invoiceTransDetail = invoiceTransDetailFactoryForTest.newInvoiceTransDetail();
		Integer id = invoiceTransDetail.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(invoiceTransDetailService).delete(id);
		
		// When
		String viewName = invoiceTransDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransDetailService).delete(id);
		assertEquals("redirect:/invoiceTransDetail", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "invoiceTransDetail.error.delete", exception);
	}
	
	
}
