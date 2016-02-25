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
import org.demo.bean.Contact;
import org.demo.bean.ContactCategory;
import org.demo.bean.ContactExtraFields;
import org.demo.bean.SaleSeller;
import org.demo.bean.StockPriceList;
import org.demo.test.ContactFactoryForTest;
import org.demo.test.ContactCategoryFactoryForTest;
import org.demo.test.ContactExtraFieldsFactoryForTest;
import org.demo.test.SaleSellerFactoryForTest;
import org.demo.test.StockPriceListFactoryForTest;

//--- Services 
import org.demo.business.service.ContactService;
import org.demo.business.service.ContactCategoryService;
import org.demo.business.service.ContactExtraFieldsService;
import org.demo.business.service.SaleSellerService;
import org.demo.business.service.StockPriceListService;

//--- List Items 
import org.demo.web.listitem.ContactCategoryListItem;
import org.demo.web.listitem.ContactExtraFieldsListItem;
import org.demo.web.listitem.SaleSellerListItem;
import org.demo.web.listitem.StockPriceListListItem;

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
public class ContactControllerTest {
	
	@InjectMocks
	private ContactController contactController;
	@Mock
	private ContactService contactService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private ContactCategoryService contactCategoryService; // Injected by Spring
	@Mock
	private ContactExtraFieldsService contactExtraFieldsService; // Injected by Spring
	@Mock
	private SaleSellerService saleSellerService; // Injected by Spring
	@Mock
	private StockPriceListService stockPriceListService; // Injected by Spring

	private ContactFactoryForTest contactFactoryForTest = new ContactFactoryForTest();
	private ContactCategoryFactoryForTest contactCategoryFactoryForTest = new ContactCategoryFactoryForTest();
	private ContactExtraFieldsFactoryForTest contactExtraFieldsFactoryForTest = new ContactExtraFieldsFactoryForTest();
	private SaleSellerFactoryForTest saleSellerFactoryForTest = new SaleSellerFactoryForTest();
	private StockPriceListFactoryForTest stockPriceListFactoryForTest = new StockPriceListFactoryForTest();

	List<ContactCategory> contactCategorys = new ArrayList<ContactCategory>();
	List<ContactExtraFields> contactExtraFieldss = new ArrayList<ContactExtraFields>();
	List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
	List<StockPriceList> stockPriceLists = new ArrayList<StockPriceList>();

	private void givenPopulateModel() {
		ContactCategory contactCategory1 = contactCategoryFactoryForTest.newContactCategory();
		ContactCategory contactCategory2 = contactCategoryFactoryForTest.newContactCategory();
		List<ContactCategory> contactCategorys = new ArrayList<ContactCategory>();
		contactCategorys.add(contactCategory1);
		contactCategorys.add(contactCategory2);
		when(contactCategoryService.findAll()).thenReturn(contactCategorys);

		ContactExtraFields contactExtraFields1 = contactExtraFieldsFactoryForTest.newContactExtraFields();
		ContactExtraFields contactExtraFields2 = contactExtraFieldsFactoryForTest.newContactExtraFields();
		List<ContactExtraFields> contactExtraFieldss = new ArrayList<ContactExtraFields>();
		contactExtraFieldss.add(contactExtraFields1);
		contactExtraFieldss.add(contactExtraFields2);
		when(contactExtraFieldsService.findAll()).thenReturn(contactExtraFieldss);

		SaleSeller saleSeller1 = saleSellerFactoryForTest.newSaleSeller();
		SaleSeller saleSeller2 = saleSellerFactoryForTest.newSaleSeller();
		List<SaleSeller> saleSellers = new ArrayList<SaleSeller>();
		saleSellers.add(saleSeller1);
		saleSellers.add(saleSeller2);
		when(saleSellerService.findAll()).thenReturn(saleSellers);

		StockPriceList stockPriceList1 = stockPriceListFactoryForTest.newStockPriceList();
		StockPriceList stockPriceList2 = stockPriceListFactoryForTest.newStockPriceList();
		List<StockPriceList> stockPriceLists = new ArrayList<StockPriceList>();
		stockPriceLists.add(stockPriceList1);
		stockPriceLists.add(stockPriceList2);
		when(stockPriceListService.findAll()).thenReturn(stockPriceLists);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<Contact> list = new ArrayList<Contact>();
		when(contactService.findAll()).thenReturn(list);
		
		// When
		String viewName = contactController.list(model);
		
		// Then
		assertEquals("contact/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = contactController.formForCreate(model);
		
		// Then
		assertEquals("contact/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((Contact)modelMap.get("contact")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contact/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ContactCategoryListItem> contactCategoryListItems = (List<ContactCategoryListItem>) modelMap.get("listOfContactCategoryItems");
		assertEquals(2, contactCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactExtraFieldsListItem> contactExtraFieldsListItems = (List<ContactExtraFieldsListItem>) modelMap.get("listOfContactExtraFieldsItems");
		assertEquals(2, contactExtraFieldsListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockPriceListListItem> stockPriceListListItems = (List<StockPriceListListItem>) modelMap.get("listOfStockPriceListItems");
		assertEquals(2, stockPriceListListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Contact contact = contactFactoryForTest.newContact();
		Integer id = contact.getId();
		when(contactService.findById(id)).thenReturn(contact);
		
		// When
		String viewName = contactController.formForUpdate(model, id);
		
		// Then
		assertEquals("contact/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contact, (Contact) modelMap.get("contact"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contact/update", modelMap.get("saveAction"));
		
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		List<ContactCategoryListItem> contactCategoryListItems = (List<ContactCategoryListItem>) modelMap.get("listOfContactCategoryItems");
		assertEquals(2, contactCategoryListItems.size());
		
		List<StockPriceListListItem> stockPriceListListItems = (List<StockPriceListListItem>) modelMap.get("listOfStockPriceListItems");
		assertEquals(2, stockPriceListListItems.size());
		
		List<ContactExtraFieldsListItem> contactExtraFieldsListItems = (List<ContactExtraFieldsListItem>) modelMap.get("listOfContactExtraFieldsItems");
		assertEquals(2, contactExtraFieldsListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Contact contact = contactFactoryForTest.newContact();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Contact contactCreated = new Contact();
		when(contactService.create(contact)).thenReturn(contactCreated); 
		
		// When
		String viewName = contactController.create(contact, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/contact/form/"+contact.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactCreated, (Contact) modelMap.get("contact"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Contact contact = contactFactoryForTest.newContact();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = contactController.create(contact, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contact/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contact, (Contact) modelMap.get("contact"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contact/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ContactCategoryListItem> contactCategoryListItems = (List<ContactCategoryListItem>) modelMap.get("listOfContactCategoryItems");
		assertEquals(2, contactCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactExtraFieldsListItem> contactExtraFieldsListItems = (List<ContactExtraFieldsListItem>) modelMap.get("listOfContactExtraFieldsItems");
		assertEquals(2, contactExtraFieldsListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockPriceListListItem> stockPriceListListItems = (List<StockPriceListListItem>) modelMap.get("listOfStockPriceListItems");
		assertEquals(2, stockPriceListListItems.size());
		
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

		Contact contact = contactFactoryForTest.newContact();
		
		Exception exception = new RuntimeException("test exception");
		when(contactService.create(contact)).thenThrow(exception);
		
		// When
		String viewName = contactController.create(contact, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contact/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contact, (Contact) modelMap.get("contact"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contact/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "contact.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<ContactCategoryListItem> contactCategoryListItems = (List<ContactCategoryListItem>) modelMap.get("listOfContactCategoryItems");
		assertEquals(2, contactCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactExtraFieldsListItem> contactExtraFieldsListItems = (List<ContactExtraFieldsListItem>) modelMap.get("listOfContactExtraFieldsItems");
		assertEquals(2, contactExtraFieldsListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockPriceListListItem> stockPriceListListItems = (List<StockPriceListListItem>) modelMap.get("listOfStockPriceListItems");
		assertEquals(2, stockPriceListListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		Contact contact = contactFactoryForTest.newContact();
		Integer id = contact.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		Contact contactSaved = new Contact();
		contactSaved.setId(id);
		when(contactService.update(contact)).thenReturn(contactSaved); 
		
		// When
		String viewName = contactController.update(contact, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/contact/form/"+contact.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactSaved, (Contact) modelMap.get("contact"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		Contact contact = contactFactoryForTest.newContact();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = contactController.update(contact, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contact/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contact, (Contact) modelMap.get("contact"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contact/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactCategoryListItem> contactCategoryListItems = (List<ContactCategoryListItem>) modelMap.get("listOfContactCategoryItems");
		assertEquals(2, contactCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockPriceListListItem> stockPriceListListItems = (List<StockPriceListListItem>) modelMap.get("listOfStockPriceListItems");
		assertEquals(2, stockPriceListListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactExtraFieldsListItem> contactExtraFieldsListItems = (List<ContactExtraFieldsListItem>) modelMap.get("listOfContactExtraFieldsItems");
		assertEquals(2, contactExtraFieldsListItems.size());
		
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

		Contact contact = contactFactoryForTest.newContact();
		
		Exception exception = new RuntimeException("test exception");
		when(contactService.update(contact)).thenThrow(exception);
		
		// When
		String viewName = contactController.update(contact, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contact/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contact, (Contact) modelMap.get("contact"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contact/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "contact.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<SaleSellerListItem> saleSellerListItems = (List<SaleSellerListItem>) modelMap.get("listOfSaleSellerItems");
		assertEquals(2, saleSellerListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactCategoryListItem> contactCategoryListItems = (List<ContactCategoryListItem>) modelMap.get("listOfContactCategoryItems");
		assertEquals(2, contactCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockPriceListListItem> stockPriceListListItems = (List<StockPriceListListItem>) modelMap.get("listOfStockPriceListItems");
		assertEquals(2, stockPriceListListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ContactExtraFieldsListItem> contactExtraFieldsListItems = (List<ContactExtraFieldsListItem>) modelMap.get("listOfContactExtraFieldsItems");
		assertEquals(2, contactExtraFieldsListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Contact contact = contactFactoryForTest.newContact();
		Integer id = contact.getId();
		
		// When
		String viewName = contactController.delete(redirectAttributes, id);
		
		// Then
		verify(contactService).delete(id);
		assertEquals("redirect:/contact", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		Contact contact = contactFactoryForTest.newContact();
		Integer id = contact.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(contactService).delete(id);
		
		// When
		String viewName = contactController.delete(redirectAttributes, id);
		
		// Then
		verify(contactService).delete(id);
		assertEquals("redirect:/contact", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "contact.error.delete", exception);
	}
	
	
}
