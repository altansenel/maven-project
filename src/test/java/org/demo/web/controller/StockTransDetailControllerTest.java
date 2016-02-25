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
import org.demo.bean.StockTransDetail;
import org.demo.bean.StockTrans;
import org.demo.bean.StockTransSource;
import org.demo.bean.StockDepot;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.SaleSeller;
import org.demo.bean.Stock;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.Contact;
import org.demo.test.StockTransDetailFactoryForTest;
import org.demo.test.StockTransFactoryForTest;
import org.demo.test.StockTransSourceFactoryForTest;
import org.demo.test.StockDepotFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.SaleSellerFactoryForTest;
import org.demo.test.StockFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;
import org.demo.test.ContactFactoryForTest;

//--- Services 
import org.demo.business.service.StockTransDetailService;
import org.demo.business.service.StockTransService;
import org.demo.business.service.StockTransSourceService;
import org.demo.business.service.StockDepotService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.SaleSellerService;
import org.demo.business.service.StockService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.ContactService;

//--- List Items 
import org.demo.web.listitem.StockTransListItem;
import org.demo.web.listitem.StockTransSourceListItem;
import org.demo.web.listitem.StockDepotListItem;
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.SaleSellerListItem;
import org.demo.web.listitem.StockListItem;
import org.demo.web.listitem.GlobalTransPointListItem;
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
public class StockTransDetailControllerTest {
	
	@InjectMocks
	private StockTransDetailController stockTransDetailController;
	@Mock
	private StockTransDetailService stockTransDetailService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockTransService stockTransService; // Injected by Spring
	@Mock
	private StockTransSourceService stockTransSourceService; // Injected by Spring
	@Mock
	private StockDepotService stockDepotService; // Injected by Spring
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private SaleSellerService saleSellerService; // Injected by Spring
	@Mock
	private StockService stockService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring
	@Mock
	private ContactService contactService; // Injected by Spring

	private StockTransDetailFactoryForTest stockTransDetailFactoryForTest = new StockTransDetailFactoryForTest();
	private StockTransFactoryForTest stockTransFactoryForTest = new StockTransFactoryForTest();
	private StockTransSourceFactoryForTest stockTransSourceFactoryForTest = new StockTransSourceFactoryForTest();
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private SaleSellerFactoryForTest saleSellerFactoryForTest = new SaleSellerFactoryForTest();
	private StockFactoryForTest stockFactoryForTest = new StockFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();

	List<StockTrans> stockTranss = new ArrayList<StockTrans>();
	List<StockTransSource> stockTransSources = new ArrayList<StockTransSource>();
	List<StockDepot> stockDepots = new ArrayList<StockDepot>();
	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
	List<Stock> stocks = new ArrayList<Stock>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
	List<Contact> contacts = new ArrayList<Contact>();

	private void givenPopulateModel() {
		StockTrans stockTrans1 = stockTransFactoryForTest.newStockTrans();
		StockTrans stockTrans2 = stockTransFactoryForTest.newStockTrans();
		List<StockTrans> stockTranss = new ArrayList<StockTrans>();
		stockTranss.add(stockTrans1);
		stockTranss.add(stockTrans2);
		when(stockTransService.findAll()).thenReturn(stockTranss);

		StockTransSource stockTransSource1 = stockTransSourceFactoryForTest.newStockTransSource();
		StockTransSource stockTransSource2 = stockTransSourceFactoryForTest.newStockTransSource();
		List<StockTransSource> stockTransSources = new ArrayList<StockTransSource>();
		stockTransSources.add(stockTransSource1);
		stockTransSources.add(stockTransSource2);
		when(stockTransSourceService.findAll()).thenReturn(stockTransSources);

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

		SaleSeller saleSeller1 = saleSellerFactoryForTest.newSaleSeller();
		SaleSeller saleSeller2 = saleSellerFactoryForTest.newSaleSeller();
		List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
		saleSellers.add(saleSeller1);
		saleSellers.add(saleSeller2);
		when(saleSellerService.findAll()).thenReturn(saleSellers);

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
		
		List<StockTransDetail> list = new ArrayList<StockTransDetail>();
		when(stockTransDetailService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockTransDetailController.list(model);
		
		// Then
		assertEquals("stockTransDetail/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockTransDetailController.formForCreate(model);
		
		// Then
		assertEquals("stockTransDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockTransDetail)modelMap.get("stockTransDetail")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockTransSourceListItem> stockTransSourceListItems = (List<StockTransSourceListItem>) modelMap.get("listOfStockTransSourceItems");
		assertEquals(2, stockTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransDetail stockTransDetail = stockTransDetailFactoryForTest.newStockTransDetail();
		Integer id = stockTransDetail.getId();
		when(stockTransDetailService.findById(id)).thenReturn(stockTransDetail);
		
		// When
		String viewName = stockTransDetailController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockTransDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransDetail, (StockTransDetail) modelMap.get("stockTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransDetail/update", modelMap.get("saveAction"));
		
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		List<StockTransSourceListItem> stockTransSourceListItems = (List<StockTransSourceListItem>) modelMap.get("listOfStockTransSourceItems");
		assertEquals(2, stockTransSourceListItems.size());
		
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTransDetail stockTransDetail = stockTransDetailFactoryForTest.newStockTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTransDetail stockTransDetailCreated = new StockTransDetail();
		when(stockTransDetailService.create(stockTransDetail)).thenReturn(stockTransDetailCreated); 
		
		// When
		String viewName = stockTransDetailController.create(stockTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTransDetail/form/"+stockTransDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransDetailCreated, (StockTransDetail) modelMap.get("stockTransDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransDetail stockTransDetail = stockTransDetailFactoryForTest.newStockTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransDetailController.create(stockTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransDetail, (StockTransDetail) modelMap.get("stockTransDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockTransSourceListItem> stockTransSourceListItems = (List<StockTransSourceListItem>) modelMap.get("listOfStockTransSourceItems");
		assertEquals(2, stockTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
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

		StockTransDetail stockTransDetail = stockTransDetailFactoryForTest.newStockTransDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransDetailService.create(stockTransDetail)).thenThrow(exception);
		
		// When
		String viewName = stockTransDetailController.create(stockTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransDetail, (StockTransDetail) modelMap.get("stockTransDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTransDetail/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTransDetail.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockTransSourceListItem> stockTransSourceListItems = (List<StockTransSourceListItem>) modelMap.get("listOfStockTransSourceItems");
		assertEquals(2, stockTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTransDetail stockTransDetail = stockTransDetailFactoryForTest.newStockTransDetail();
		Integer id = stockTransDetail.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTransDetail stockTransDetailSaved = new StockTransDetail();
		stockTransDetailSaved.setId(id);
		when(stockTransDetailService.update(stockTransDetail)).thenReturn(stockTransDetailSaved); 
		
		// When
		String viewName = stockTransDetailController.update(stockTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTransDetail/form/"+stockTransDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransDetailSaved, (StockTransDetail) modelMap.get("stockTransDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTransDetail stockTransDetail = stockTransDetailFactoryForTest.newStockTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransDetailController.update(stockTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransDetail, (StockTransDetail) modelMap.get("stockTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransDetail/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
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
		List<StockTransSourceListItem> stockTransSourceListItems = (List<StockTransSourceListItem>) modelMap.get("listOfStockTransSourceItems");
		assertEquals(2, stockTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
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

		StockTransDetail stockTransDetail = stockTransDetailFactoryForTest.newStockTransDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransDetailService.update(stockTransDetail)).thenThrow(exception);
		
		// When
		String viewName = stockTransDetailController.update(stockTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransDetail, (StockTransDetail) modelMap.get("stockTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTransDetail/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTransDetail.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockTransListItem> stockTransListItems = (List<StockTransListItem>) modelMap.get("listOfStockTransItems");
		assertEquals(2, stockTransListItems.size());
		
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
		List<StockTransSourceListItem> stockTransSourceListItems = (List<StockTransSourceListItem>) modelMap.get("listOfStockTransSourceItems");
		assertEquals(2, stockTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTransDetail stockTransDetail = stockTransDetailFactoryForTest.newStockTransDetail();
		Integer id = stockTransDetail.getId();
		
		// When
		String viewName = stockTransDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransDetailService).delete(id);
		assertEquals("redirect:/stockTransDetail", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTransDetail stockTransDetail = stockTransDetailFactoryForTest.newStockTransDetail();
		Integer id = stockTransDetail.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockTransDetailService).delete(id);
		
		// When
		String viewName = stockTransDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransDetailService).delete(id);
		assertEquals("redirect:/stockTransDetail", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockTransDetail.error.delete", exception);
	}
	
	
}
