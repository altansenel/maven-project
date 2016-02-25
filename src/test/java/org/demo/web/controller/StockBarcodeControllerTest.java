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
import org.demo.bean.StockBarcode;
import org.demo.bean.Stock;
import org.demo.test.StockBarcodeFactoryForTest;
import org.demo.test.StockFactoryForTest;

//--- Services 
import org.demo.business.service.StockBarcodeService;
import org.demo.business.service.StockService;

//--- List Items 
import org.demo.web.listitem.StockListItem;

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
public class StockBarcodeControllerTest {
	
	@InjectMocks
	private StockBarcodeController stockBarcodeController;
	@Mock
	private StockBarcodeService stockBarcodeService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockService stockService; // Injected by Spring

	private StockBarcodeFactoryForTest stockBarcodeFactoryForTest = new StockBarcodeFactoryForTest();
	private StockFactoryForTest stockFactoryForTest = new StockFactoryForTest();

	List<Stock> stocks = new ArrayList<Stock>();

	private void givenPopulateModel() {
		Stock stock1 = stockFactoryForTest.newStock();
		Stock stock2 = stockFactoryForTest.newStock();
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(stock1);
		stocks.add(stock2);
		when(stockService.findAll()).thenReturn(stocks);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockBarcode> list = new ArrayList<StockBarcode>();
		when(stockBarcodeService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockBarcodeController.list(model);
		
		// Then
		assertEquals("stockBarcode/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockBarcodeController.formForCreate(model);
		
		// Then
		assertEquals("stockBarcode/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockBarcode)modelMap.get("stockBarcode")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockBarcode/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockBarcode stockBarcode = stockBarcodeFactoryForTest.newStockBarcode();
		Integer id = stockBarcode.getId();
		when(stockBarcodeService.findById(id)).thenReturn(stockBarcode);
		
		// When
		String viewName = stockBarcodeController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockBarcode/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockBarcode, (StockBarcode) modelMap.get("stockBarcode"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockBarcode/update", modelMap.get("saveAction"));
		
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockBarcode stockBarcode = stockBarcodeFactoryForTest.newStockBarcode();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockBarcode stockBarcodeCreated = new StockBarcode();
		when(stockBarcodeService.create(stockBarcode)).thenReturn(stockBarcodeCreated); 
		
		// When
		String viewName = stockBarcodeController.create(stockBarcode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockBarcode/form/"+stockBarcode.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockBarcodeCreated, (StockBarcode) modelMap.get("stockBarcode"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockBarcode stockBarcode = stockBarcodeFactoryForTest.newStockBarcode();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockBarcodeController.create(stockBarcode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockBarcode/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockBarcode, (StockBarcode) modelMap.get("stockBarcode"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockBarcode/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
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

		StockBarcode stockBarcode = stockBarcodeFactoryForTest.newStockBarcode();
		
		Exception exception = new RuntimeException("test exception");
		when(stockBarcodeService.create(stockBarcode)).thenThrow(exception);
		
		// When
		String viewName = stockBarcodeController.create(stockBarcode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockBarcode/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockBarcode, (StockBarcode) modelMap.get("stockBarcode"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockBarcode/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockBarcode.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockBarcode stockBarcode = stockBarcodeFactoryForTest.newStockBarcode();
		Integer id = stockBarcode.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockBarcode stockBarcodeSaved = new StockBarcode();
		stockBarcodeSaved.setId(id);
		when(stockBarcodeService.update(stockBarcode)).thenReturn(stockBarcodeSaved); 
		
		// When
		String viewName = stockBarcodeController.update(stockBarcode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockBarcode/form/"+stockBarcode.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockBarcodeSaved, (StockBarcode) modelMap.get("stockBarcode"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockBarcode stockBarcode = stockBarcodeFactoryForTest.newStockBarcode();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockBarcodeController.update(stockBarcode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockBarcode/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockBarcode, (StockBarcode) modelMap.get("stockBarcode"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockBarcode/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
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

		StockBarcode stockBarcode = stockBarcodeFactoryForTest.newStockBarcode();
		
		Exception exception = new RuntimeException("test exception");
		when(stockBarcodeService.update(stockBarcode)).thenThrow(exception);
		
		// When
		String viewName = stockBarcodeController.update(stockBarcode, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockBarcode/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockBarcode, (StockBarcode) modelMap.get("stockBarcode"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockBarcode/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockBarcode.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockBarcode stockBarcode = stockBarcodeFactoryForTest.newStockBarcode();
		Integer id = stockBarcode.getId();
		
		// When
		String viewName = stockBarcodeController.delete(redirectAttributes, id);
		
		// Then
		verify(stockBarcodeService).delete(id);
		assertEquals("redirect:/stockBarcode", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockBarcode stockBarcode = stockBarcodeFactoryForTest.newStockBarcode();
		Integer id = stockBarcode.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockBarcodeService).delete(id);
		
		// When
		String viewName = stockBarcodeController.delete(redirectAttributes, id);
		
		// Then
		verify(stockBarcodeService).delete(id);
		assertEquals("redirect:/stockBarcode", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockBarcode.error.delete", exception);
	}
	
	
}
