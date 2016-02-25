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
import org.demo.bean.StockTrans;
import org.demo.bean.GlobalPrivateCode;
import org.demo.bean.StockDepot;
import org.demo.bean.StockTransSource;
import org.demo.bean.GlobalTransPoint;
import org.demo.bean.Contact;
import org.demo.bean.SaleSeller;
import org.demo.test.StockTransFactoryForTest;
import org.demo.test.GlobalPrivateCodeFactoryForTest;
import org.demo.test.StockDepotFactoryForTest;
import org.demo.test.StockTransSourceFactoryForTest;
import org.demo.test.GlobalTransPointFactoryForTest;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.SaleSellerFactoryForTest;

//--- Services 
import org.demo.business.service.StockTransService;
import org.demo.business.service.GlobalPrivateCodeService;
import org.demo.business.service.StockDepotService;
import org.demo.business.service.StockTransSourceService;
import org.demo.business.service.GlobalTransPointService;
import org.demo.business.service.ContactService;
import org.demo.business.service.SaleSellerService;

//--- List Items 
import org.demo.web.listitem.GlobalPrivateCodeListItem;
import org.demo.web.listitem.StockDepotListItem;
import org.demo.web.listitem.StockTransSourceListItem;
import org.demo.web.listitem.GlobalTransPointListItem;
import org.demo.web.listitem.ContactListItem;
import org.demo.web.listitem.SaleSellerListItem;

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
public class StockTransControllerTest {
	
	@InjectMocks
	private StockTransController stockTransController;
	@Mock
	private StockTransService stockTransService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private GlobalPrivateCodeService globalPrivateCodeService; // Injected by Spring
	@Mock
	private StockDepotService stockDepotService; // Injected by Spring
	@Mock
	private StockTransSourceService stockTransSourceService; // Injected by Spring
	@Mock
	private GlobalTransPointService globalTransPointService; // Injected by Spring
	@Mock
	private ContactService contactService; // Injected by Spring
	@Mock
	private SaleSellerService saleSellerService; // Injected by Spring

	private StockTransFactoryForTest stockTransFactoryForTest = new StockTransFactoryForTest();
	private GlobalPrivateCodeFactoryForTest globalPrivateCodeFactoryForTest = new GlobalPrivateCodeFactoryForTest();
	private StockDepotFactoryForTest stockDepotFactoryForTest = new StockDepotFactoryForTest();
	private StockTransSourceFactoryForTest stockTransSourceFactoryForTest = new StockTransSourceFactoryForTest();
	private GlobalTransPointFactoryForTest globalTransPointFactoryForTest = new GlobalTransPointFactoryForTest();
	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private SaleSellerFactoryForTest saleSellerFactoryForTest = new SaleSellerFactoryForTest();

	List<GlobalPrivateCode> globalPrivateCodes = new ArrayList<GlobalPrivateCode>();
	List<StockDepot> stockDepots = new ArrayList<StockDepot>();
	List<StockTransSource> stockTransSources = new ArrayList<StockTransSource>();
	List<GlobalTransPoint> globalTransPoints = new ArrayList<GlobalTransPoint>();
	List<Contact> contacts = new ArrayList<Contact>();
	List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();

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

		StockTransSource stockTransSource1 = stockTransSourceFactoryForTest.newStockTransSource();
		StockTransSource stockTransSource2 = stockTransSourceFactoryForTest.newStockTransSource();
		List<StockTransSource> stockTransSources = new ArrayList<StockTransSource>();
		stockTransSources.add(stockTransSource1);
		stockTransSources.add(stockTransSource2);
		when(stockTransSourceService.findAll()).thenReturn(stockTransSources);

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

		SaleSeller saleSeller1 = saleSellerFactoryForTest.newSaleSeller();
		SaleSeller saleSeller2 = saleSellerFactoryForTest.newSaleSeller();
		List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
		saleSellers.add(saleSeller1);
		saleSellers.add(saleSeller2);
		when(saleSellerService.findAll()).thenReturn(saleSellers);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockTrans> list = new ArrayList<StockTrans>();
		when(stockTransService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockTransController.list(model);
		
		// Then
		assertEquals("stockTrans/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockTransController.formForCreate(model);
		
		// Then
		assertEquals("stockTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockTrans)modelMap.get("stockTrans")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockTransSourceListItem> stockTransSourceListItems = (List<StockTransSourceListItem>) modelMap.get("listOfStockTransSourceItems");
		assertEquals(2, stockTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTrans stockTrans = stockTransFactoryForTest.newStockTrans();
		Integer id = stockTrans.getId();
		when(stockTransService.findById(id)).thenReturn(stockTrans);
		
		// When
		String viewName = stockTransController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockTrans/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTrans, (StockTrans) modelMap.get("stockTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTrans/update", modelMap.get("saveAction"));
		
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
		
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTrans stockTrans = stockTransFactoryForTest.newStockTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTrans stockTransCreated = new StockTrans();
		when(stockTransService.create(stockTrans)).thenReturn(stockTransCreated); 
		
		// When
		String viewName = stockTransController.create(stockTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTrans/form/"+stockTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransCreated, (StockTrans) modelMap.get("stockTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTrans stockTrans = stockTransFactoryForTest.newStockTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransController.create(stockTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTrans, (StockTrans) modelMap.get("stockTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTrans/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockTransSourceListItem> stockTransSourceListItems = (List<StockTransSourceListItem>) modelMap.get("listOfStockTransSourceItems");
		assertEquals(2, stockTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
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

		StockTrans stockTrans = stockTransFactoryForTest.newStockTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransService.create(stockTrans)).thenThrow(exception);
		
		// When
		String viewName = stockTransController.create(stockTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTrans, (StockTrans) modelMap.get("stockTrans"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockTrans/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTrans.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<GlobalPrivateCodeListItem> globalPrivateCodeListItems = (List<GlobalPrivateCodeListItem>) modelMap.get("listOfGlobalPrivateCodeItems");
		assertEquals(2, globalPrivateCodeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockTransSourceListItem> stockTransSourceListItems = (List<StockTransSourceListItem>) modelMap.get("listOfStockTransSourceItems");
		assertEquals(2, stockTransSourceListItems.size());
		
		@SuppressWarnings("unchecked")
		List<GlobalTransPointListItem> globalTransPointListItems = (List<GlobalTransPointListItem>) modelMap.get("listOfGlobalTransPointItems");
		assertEquals(2, globalTransPointListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactListItem> contactListItems = (List<ContactListItem>) modelMap.get("listOfContactItems");
		assertEquals(2, contactListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockTrans stockTrans = stockTransFactoryForTest.newStockTrans();
		Integer id = stockTrans.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockTrans stockTransSaved = new StockTrans();
		stockTransSaved.setId(id);
		when(stockTransService.update(stockTrans)).thenReturn(stockTransSaved); 
		
		// When
		String viewName = stockTransController.update(stockTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockTrans/form/"+stockTrans.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTransSaved, (StockTrans) modelMap.get("stockTrans"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockTrans stockTrans = stockTransFactoryForTest.newStockTrans();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockTransController.update(stockTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTrans, (StockTrans) modelMap.get("stockTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTrans/update", modelMap.get("saveAction"));
		
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
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
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

		StockTrans stockTrans = stockTransFactoryForTest.newStockTrans();
		
		Exception exception = new RuntimeException("test exception");
		when(stockTransService.update(stockTrans)).thenThrow(exception);
		
		// When
		String viewName = stockTransController.update(stockTrans, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockTrans/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockTrans, (StockTrans) modelMap.get("stockTrans"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockTrans/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockTrans.error.update", exception);
		
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
		
		@SuppressWarnings("unchecked")
		List<StockDepotListItem> stockDepotListItems = (List<StockDepotListItem>) modelMap.get("listOfStockDepotItems");
		assertEquals(2, stockDepotListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTrans stockTrans = stockTransFactoryForTest.newStockTrans();
		Integer id = stockTrans.getId();
		
		// When
		String viewName = stockTransController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransService).delete(id);
		assertEquals("redirect:/stockTrans", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockTrans stockTrans = stockTransFactoryForTest.newStockTrans();
		Integer id = stockTrans.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockTransService).delete(id);
		
		// When
		String viewName = stockTransController.delete(redirectAttributes, id);
		
		// Then
		verify(stockTransService).delete(id);
		assertEquals("redirect:/stockTrans", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockTrans.error.delete", exception);
	}
	
	
}
