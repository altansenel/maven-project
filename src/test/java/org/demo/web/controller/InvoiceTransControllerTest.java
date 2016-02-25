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
import org.demo.bean.InvoiceTrans;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.SaleSeller;
import org.demo.bean.Contact;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.StockDepot;
import org.demo.bean.InvoiceTransStatus;
import org.demo.bean.InvoiceTransSource;
import org.demo.test.InvoiceTransFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;
import org.demo.test.SaleSellerFactoryForTest;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.StockDepotFactoryForTest;
import org.demo.test.InvoiceTransStatusFactoryForTest;
import org.demo.test.InvoiceTransSourceFactoryForTest;

//--- Services 
import org.demo.business.service.InvoiceTransService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.SaleSellerService;
import org.demo.business.service.ContactService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.StockDepotService;
import org.demo.business.service.InvoiceTransStatusService;
import org.demo.business.service.InvoiceTransSourceService;

//--- List Items 
import org.demo.web.listitem.GlobalTransPointListItem;
import org.demo.web.listitem.SaleSellerListItem;
import org.demo.web.listitem.ContactListItem;
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.StockDepotListItem;
import org.demo.web.listitem.InvoiceTransStatusListItem;
import org.demo.web.listitem.InvoiceTransSourceListItem;

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
public class InvoiceTransControllerTest {
	
	@InjectMocks
	private InvoiceTransController invoiceTransController;
	@Mock
	private InvoiceTransService invoiceTransService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
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
	@Mock
	private InvoiceTransStatusService invoiceTransStatusService; // Injected by Spring
	@Mock
	private InvoiceTransSourceService invoiceTransSourceService; // Injected by Spring

	private InvoiceTransFactoryForTest invoiceTransFactoryForTest = new InvoiceTransFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();
	private SaleSellerFactoryForTest saleSellerFactoryForTest = new SaleSellerFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();
	private InvoiceTransStatusFactoryForTest invoiceTransStatusFactoryForTest = new InvoiceTransStatusFactoryForTest();
	private InvoiceTransSourceFactoryForTest invoiceTransSourceFactoryForTest = new InvoiceTransSourceFactoryForTest();

	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
	List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
	List<Contact> contacts = new ArrayList<Contact>();
	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<StockDepot> stockDepots = new ArrayList<StockDepot>();
	List<InvoiceTransStatus> invoiceTransStatuss = new ArrayList<InvoiceTransStatus>();
	List<InvoiceTransSource> invoiceTransSources = new ArrayList<InvoiceTransSource>();

	private void givenPopulateModel() {
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

		InvoiceTransStatus invoiceTransStatus1 = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		InvoiceTransStatus invoiceTransStatus2 = invoiceTransStatusFactoryForTest.newInvoiceTransStatus();
		List<InvoiceTransStatus> invoiceTransStatuss = new ArrayList<InvoiceTransStatus>();
		invoiceTransStatuss.add(invoiceTransStatus1);
		invoiceTransStatuss.add(invoiceTransStatus2);
		when(invoiceTransStatusService.findAll()).thenReturn(invoiceTransStatuss);

		InvoiceTransSource invoiceTransSource1 = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		InvoiceTransSource invoiceTransSource2 = invoiceTransSourceFactoryForTest.newInvoiceTransSource();
		List<InvoiceTransSource> invoiceTransSources = new ArrayList<InvoiceTransSource>();
		invoiceTransSources.add(invoiceTransSource1);
		invoiceTransSources.add(invoiceTransSource2);
		when(invoiceTransSourceService.findAll()).thenReturn(invoiceTransSources);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<InvoiceTrans> list = new ArrayList<InvoiceTrans>();
		when(invoiceTransService.findAll()).thenReturn(list);
		
		// When
		String viewName = invoiceTransController.list(model);
		
		// Then
		assertEquals("invoiceTrans/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = invoiceTransController.formForCreate(model);
		
		// Then
		assertEquals("invoiceTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((InvoiceTrans)modelMap.get("invoiceTrans")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTrans/create", modelMap.get("saveAction"));
		
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
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransSourceListItem> invoiceTransSourceListItems = (List<InvoiceTransSourceListItem>) modelMap.get("listOfInvoiceTransSourceItems");
		assertEquals(2, invoiceTransSourceListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();
		Integer id = invoiceTrans.getId();
		when(invoiceTransService.findById(id)).thenReturn(invoiceTrans);
		
		// When
		String viewName = invoiceTransController.formForUpdate(model, id);
		
		// Then
		assertEquals("invoiceTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTrans, (InvoiceTrans) modelMap.get("invoiceTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTrans/update", modelMap.get("saveAction"));
		
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
		
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTrans invoiceTransCreated = new InvoiceTrans();
		when(invoiceTransService.create(invoiceTrans)).thenReturn(invoiceTransCreated); 
		
		// When
		String viewName = invoiceTransController.create(invoiceTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTrans/form/"+invoiceTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransCreated, (InvoiceTrans) modelMap.get("invoiceTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransController.create(invoiceTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTrans, (InvoiceTrans) modelMap.get("invoiceTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTrans/create", modelMap.get("saveAction"));
		
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
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransSourceListItem> invoiceTransSourceListItems = (List<InvoiceTransSourceListItem>) modelMap.get("listOfInvoiceTransSourceItems");
		assertEquals(2, invoiceTransSourceListItems.size());
		
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

		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransService.create(invoiceTrans)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransController.create(invoiceTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTrans, (InvoiceTrans) modelMap.get("invoiceTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTrans/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTrans.error.create", exception);
		
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
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransSourceListItem> invoiceTransSourceListItems = (List<InvoiceTransSourceListItem>) modelMap.get("listOfInvoiceTransSourceItems");
		assertEquals(2, invoiceTransSourceListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();
		Integer id = invoiceTrans.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTrans invoiceTransSaved = new InvoiceTrans();
		invoiceTransSaved.setId(id);
		when(invoiceTransService.update(invoiceTrans)).thenReturn(invoiceTransSaved); 
		
		// When
		String viewName = invoiceTransController.update(invoiceTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTrans/form/"+invoiceTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransSaved, (InvoiceTrans) modelMap.get("invoiceTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransController.update(invoiceTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTrans, (InvoiceTrans) modelMap.get("invoiceTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTrans/update", modelMap.get("saveAction"));
		
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
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
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

		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransService.update(invoiceTrans)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransController.update(invoiceTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTrans, (InvoiceTrans) modelMap.get("invoiceTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTrans/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTrans.error.update", exception);
		
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
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransStatusListItem> invoiceTransStatusListItems = (List<InvoiceTransStatusListItem>) modelMap.get("listOfInvoiceTransStatusItems");
		assertEquals(2, invoiceTransStatusListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();
		Integer id = invoiceTrans.getId();
		
		// When
		String viewName = invoiceTransController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransService).delete(id);
		assertEquals("redirect:/invoiceTrans", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTrans invoiceTrans = invoiceTransFactoryForTest.newInvoiceTrans();
		Integer id = invoiceTrans.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(invoiceTransService).delete(id);
		
		// When
		String viewName = invoiceTransController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransService).delete(id);
		assertEquals("redirect:/invoiceTrans", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "invoiceTrans.error.delete", exception);
	}
	
	
}
