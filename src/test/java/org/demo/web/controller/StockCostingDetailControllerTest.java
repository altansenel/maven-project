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
import org.demo.bean.StockCostingDetail;
import org.demo.bean.Stock;
import org.demo.bean.StockCosting;
import org.demo.test.StockCostingDetailFactoryForTest;
import org.demo.test.StockFactoryForTest;
import org.demo.test.StockCostingFactoryForTest;

//--- Services 
import org.demo.business.service.StockCostingDetailService;
import org.demo.business.service.StockService;
import org.demo.business.service.StockCostingService;

//--- List Items 
import org.demo.web.listitem.StockListItem;
import org.demo.web.listitem.StockCostingListItem;

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
public class StockCostingDetailControllerTest {
	
	@InjectMocks
	private StockCostingDetailController stockCostingDetailController;
	@Mock
	private StockCostingDetailService stockCostingDetailService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockService stockService; // Injected by Spring
	@Mock
	private StockCostingService stockCostingService; // Injected by Spring

	private StockCostingDetailFactoryForTest stockCostingDetailFactoryForTest = new StockCostingDetailFactoryForTest();
	private StockFactoryForTest stockFactoryForTest = new StockFactoryForTest();
	private StockCostingFactoryForTest stockCostingFactoryForTest = new StockCostingFactoryForTest();

	List<Stock> stocks = new ArrayList<Stock>();
	List<StockCosting> stockCostings = new ArrayList<StockCosting>();

	private void givenPopulateModel() {
		Stock stock1 = stockFactoryForTest.newStock();
		Stock stock2 = stockFactoryForTest.newStock();
		List<Stock> stocks = new ArrayList<Stock>();
		stocks.add(stock1);
		stocks.add(stock2);
		when(stockService.findAll()).thenReturn(stocks);

		StockCosting stockCosting1 = stockCostingFactoryForTest.newStockCosting();
		StockCosting stockCosting2 = stockCostingFactoryForTest.newStockCosting();
		List<StockCosting> stockCostings = new ArrayList<StockCosting>();
		stockCostings.add(stockCosting1);
		stockCostings.add(stockCosting2);
		when(stockCostingService.findAll()).thenReturn(stockCostings);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockCostingDetail> list = new ArrayList<StockCostingDetail>();
		when(stockCostingDetailService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockCostingDetailController.list(model);
		
		// Then
		assertEquals("stockCostingDetail/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockCostingDetailController.formForCreate(model);
		
		// Then
		assertEquals("stockCostingDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockCostingDetail)modelMap.get("stockCostingDetail")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCostingDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCostingDetail stockCostingDetail = stockCostingDetailFactoryForTest.newStockCostingDetail();
		Integer id = stockCostingDetail.getId();
		when(stockCostingDetailService.findById(id)).thenReturn(stockCostingDetail);
		
		// When
		String viewName = stockCostingDetailController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockCostingDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingDetail, (StockCostingDetail) modelMap.get("stockCostingDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCostingDetail/update", modelMap.get("saveAction"));
		
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockCostingDetail stockCostingDetail = stockCostingDetailFactoryForTest.newStockCostingDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockCostingDetail stockCostingDetailCreated = new StockCostingDetail();
		when(stockCostingDetailService.create(stockCostingDetail)).thenReturn(stockCostingDetailCreated); 
		
		// When
		String viewName = stockCostingDetailController.create(stockCostingDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockCostingDetail/form/"+stockCostingDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingDetailCreated, (StockCostingDetail) modelMap.get("stockCostingDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCostingDetail stockCostingDetail = stockCostingDetailFactoryForTest.newStockCostingDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockCostingDetailController.create(stockCostingDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostingDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingDetail, (StockCostingDetail) modelMap.get("stockCostingDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCostingDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
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

		StockCostingDetail stockCostingDetail = stockCostingDetailFactoryForTest.newStockCostingDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(stockCostingDetailService.create(stockCostingDetail)).thenThrow(exception);
		
		// When
		String viewName = stockCostingDetailController.create(stockCostingDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostingDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingDetail, (StockCostingDetail) modelMap.get("stockCostingDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCostingDetail/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockCostingDetail.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockCostingDetail stockCostingDetail = stockCostingDetailFactoryForTest.newStockCostingDetail();
		Integer id = stockCostingDetail.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockCostingDetail stockCostingDetailSaved = new StockCostingDetail();
		stockCostingDetailSaved.setId(id);
		when(stockCostingDetailService.update(stockCostingDetail)).thenReturn(stockCostingDetailSaved); 
		
		// When
		String viewName = stockCostingDetailController.update(stockCostingDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockCostingDetail/form/"+stockCostingDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingDetailSaved, (StockCostingDetail) modelMap.get("stockCostingDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCostingDetail stockCostingDetail = stockCostingDetailFactoryForTest.newStockCostingDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockCostingDetailController.update(stockCostingDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostingDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingDetail, (StockCostingDetail) modelMap.get("stockCostingDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCostingDetail/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
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

		StockCostingDetail stockCostingDetail = stockCostingDetailFactoryForTest.newStockCostingDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(stockCostingDetailService.update(stockCostingDetail)).thenThrow(exception);
		
		// When
		String viewName = stockCostingDetailController.update(stockCostingDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCostingDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCostingDetail, (StockCostingDetail) modelMap.get("stockCostingDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCostingDetail/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockCostingDetail.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockCostingListItem> stockCostingListItems = (List<StockCostingListItem>) modelMap.get("listOfStockCostingItems");
		assertEquals(2, stockCostingListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockListItem> stockListItems = (List<StockListItem>) modelMap.get("listOfStockItems");
		assertEquals(2, stockListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockCostingDetail stockCostingDetail = stockCostingDetailFactoryForTest.newStockCostingDetail();
		Integer id = stockCostingDetail.getId();
		
		// When
		String viewName = stockCostingDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(stockCostingDetailService).delete(id);
		assertEquals("redirect:/stockCostingDetail", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockCostingDetail stockCostingDetail = stockCostingDetailFactoryForTest.newStockCostingDetail();
		Integer id = stockCostingDetail.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockCostingDetailService).delete(id);
		
		// When
		String viewName = stockCostingDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(stockCostingDetailService).delete(id);
		assertEquals("redirect:/stockCostingDetail", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockCostingDetail.error.delete", exception);
	}
	
	
}
