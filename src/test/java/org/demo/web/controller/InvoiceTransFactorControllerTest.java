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
import org.demo.bean.InvoiceTransFactor;
import org.demo.bean.StockCostFactor;
import org.demo.bean.InvoiceTrans;
import org.demo.test.InvoiceTransFactorFactoryForTest;
import org.demo.test.StockCostFactorFactoryForTest;
import org.demo.test.InvoiceTransFactoryForTest;

//--- Services 
import org.demo.business.service.InvoiceTransFactorService;
import org.demo.business.service.StockCostFactorService;
import org.demo.business.service.InvoiceTransService;

//--- List Items 
import org.demo.web.listitem.StockCostFactorListItem;
import org.demo.web.listitem.InvoiceTransListItem;

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
public class InvoiceTransFactorControllerTest {
	
	@InjectMocks
	private InvoiceTransFactorController invoiceTransFactorController;
	@Mock
	private InvoiceTransFactorService invoiceTransFactorService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockCostFactorService stockCostFactorService; // Injected by Spring
	@Mock
	private InvoiceTransService invoiceTransService; // Injected by Spring

	private InvoiceTransFactorFactoryForTest invoiceTransFactorFactoryForTest = new InvoiceTransFactorFactoryForTest();
	private StockCostFactorFactoryForTest stockCostFactorFactoryForTest = new StockCostFactorFactoryForTest();
	private InvoiceTransFactoryForTest invoiceTransFactoryForTest = new InvoiceTransFactoryForTest();

	List<StockCostFactor> stockCostFactors = new ArrayList<StockCostFactor>();
	List<InvoiceTrans> invoiceTranss = new ArrayList<InvoiceTrans>();

	private void givenPopulateModel() {
		StockCostFactor stockCostFactor1 = stockCostFactorFactoryForTest.newStockCostFactor();
		StockCostFactor stockCostFactor2 = stockCostFactorFactoryForTest.newStockCostFactor();
		List<StockCostFactor> stockCostFactors = new ArrayList<StockCostFactor>();
		stockCostFactors.add(stockCostFactor1);
		stockCostFactors.add(stockCostFactor2);
		when(stockCostFactorService.findAll()).thenReturn(stockCostFactors);

		InvoiceTrans invoiceTrans1 = invoiceTransFactoryForTest.newInvoiceTrans();
		InvoiceTrans invoiceTrans2 = invoiceTransFactoryForTest.newInvoiceTrans();
		List<InvoiceTrans> invoiceTranss = new ArrayList<InvoiceTrans>();
		invoiceTranss.add(invoiceTrans1);
		invoiceTranss.add(invoiceTrans2);
		when(invoiceTransService.findAll()).thenReturn(invoiceTranss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<InvoiceTransFactor> list = new ArrayList<InvoiceTransFactor>();
		when(invoiceTransFactorService.findAll()).thenReturn(list);
		
		// When
		String viewName = invoiceTransFactorController.list(model);
		
		// Then
		assertEquals("invoiceTransFactor/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = invoiceTransFactorController.formForCreate(model);
		
		// Then
		assertEquals("invoiceTransFactor/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((InvoiceTransFactor)modelMap.get("invoiceTransFactor")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransFactor/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		Integer id = invoiceTransFactor.getId();
		when(invoiceTransFactorService.findById(id)).thenReturn(invoiceTransFactor);
		
		// When
		String viewName = invoiceTransFactorController.formForUpdate(model, id);
		
		// Then
		assertEquals("invoiceTransFactor/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransFactor, (InvoiceTransFactor) modelMap.get("invoiceTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransFactor/update", modelMap.get("saveAction"));
		
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransFactor invoiceTransFactorCreated = new InvoiceTransFactor();
		when(invoiceTransFactorService.create(invoiceTransFactor)).thenReturn(invoiceTransFactorCreated); 
		
		// When
		String viewName = invoiceTransFactorController.create(invoiceTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransFactor/form/"+invoiceTransFactor.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransFactorCreated, (InvoiceTransFactor) modelMap.get("invoiceTransFactor"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransFactorController.create(invoiceTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransFactor, (InvoiceTransFactor) modelMap.get("invoiceTransFactor"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransFactor/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
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

		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransFactorService.create(invoiceTransFactor)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransFactorController.create(invoiceTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransFactor, (InvoiceTransFactor) modelMap.get("invoiceTransFactor"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/invoiceTransFactor/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransFactor.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		Integer id = invoiceTransFactor.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		InvoiceTransFactor invoiceTransFactorSaved = new InvoiceTransFactor();
		invoiceTransFactorSaved.setId(id);
		when(invoiceTransFactorService.update(invoiceTransFactor)).thenReturn(invoiceTransFactorSaved); 
		
		// When
		String viewName = invoiceTransFactorController.update(invoiceTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/invoiceTransFactor/form/"+invoiceTransFactor.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransFactorSaved, (InvoiceTransFactor) modelMap.get("invoiceTransFactor"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = invoiceTransFactorController.update(invoiceTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransFactor, (InvoiceTransFactor) modelMap.get("invoiceTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransFactor/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
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

		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		
		Exception exception = new RuntimeException("test exception");
		when(invoiceTransFactorService.update(invoiceTransFactor)).thenThrow(exception);
		
		// When
		String viewName = invoiceTransFactorController.update(invoiceTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("invoiceTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(invoiceTransFactor, (InvoiceTransFactor) modelMap.get("invoiceTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/invoiceTransFactor/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "invoiceTransFactor.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<InvoiceTransListItem> invoiceTransListItems = (List<InvoiceTransListItem>) modelMap.get("listOfInvoiceTransItems");
		assertEquals(2, invoiceTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		Integer id = invoiceTransFactor.getId();
		
		// When
		String viewName = invoiceTransFactorController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransFactorService).delete(id);
		assertEquals("redirect:/invoiceTransFactor", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		InvoiceTransFactor invoiceTransFactor = invoiceTransFactorFactoryForTest.newInvoiceTransFactor();
		Integer id = invoiceTransFactor.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(invoiceTransFactorService).delete(id);
		
		// When
		String viewName = invoiceTransFactorController.delete(redirectAttributes, id);
		
		// Then
		verify(invoiceTransFactorService).delete(id);
		assertEquals("redirect:/invoiceTransFactor", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "invoiceTransFactor.error.delete", exception);
	}
	
	
}
