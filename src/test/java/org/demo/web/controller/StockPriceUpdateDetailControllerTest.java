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
import org.demo.bean.StockPriceUpdateDetail;
import org.demo.bean.StockPriceUpdate;
import org.demo.test.StockPriceUpdateDetailFactoryForTest;
import org.demo.test.StockPriceUpdateFactoryForTest;

//--- Services 
import org.demo.business.service.StockPriceUpdateDetailService;
import org.demo.business.service.StockPriceUpdateService;

//--- List Items 
import org.demo.web.listitem.StockPriceUpdateListItem;

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
public class StockPriceUpdateDetailControllerTest {
	
	@InjectMocks
	private StockPriceUpdateDetailController stockPriceUpdateDetailController;
	@Mock
	private StockPriceUpdateDetailService stockPriceUpdateDetailService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockPriceUpdateService stockPriceUpdateService; // Injected by Spring

	private StockPriceUpdateDetailFactoryForTest stockPriceUpdateDetailFactoryForTest = new StockPriceUpdateDetailFactoryForTest();
	private StockPriceUpdateFactoryForTest stockPriceUpdateFactoryForTest = new StockPriceUpdateFactoryForTest();

	List<StockPriceUpdate> stockPriceUpdates = new ArrayList<StockPriceUpdate>();

	private void givenPopulateModel() {
		StockPriceUpdate stockPriceUpdate1 = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		StockPriceUpdate stockPriceUpdate2 = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		List<StockPriceUpdate> stockPriceUpdates = new ArrayList<StockPriceUpdate>();
		stockPriceUpdates.add(stockPriceUpdate1);
		stockPriceUpdates.add(stockPriceUpdate2);
		when(stockPriceUpdateService.findAll()).thenReturn(stockPriceUpdates);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockPriceUpdateDetail> list = new ArrayList<StockPriceUpdateDetail>();
		when(stockPriceUpdateDetailService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockPriceUpdateDetailController.list(model);
		
		// Then
		assertEquals("stockPriceUpdateDetail/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockPriceUpdateDetailController.formForCreate(model);
		
		// Then
		assertEquals("stockPriceUpdateDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockPriceUpdateDetail)modelMap.get("stockPriceUpdateDetail")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockPriceUpdateDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockPriceUpdateListItem> stockPriceUpdateListItems = (List<StockPriceUpdateListItem>) modelMap.get("listOfStockPriceUpdateItems");
		assertEquals(2, stockPriceUpdateListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockPriceUpdateDetail stockPriceUpdateDetail = stockPriceUpdateDetailFactoryForTest.newStockPriceUpdateDetail();
		Integer id = stockPriceUpdateDetail.getId();
		when(stockPriceUpdateDetailService.findById(id)).thenReturn(stockPriceUpdateDetail);
		
		// When
		String viewName = stockPriceUpdateDetailController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockPriceUpdateDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdateDetail, (StockPriceUpdateDetail) modelMap.get("stockPriceUpdateDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockPriceUpdateDetail/update", modelMap.get("saveAction"));
		
		List<StockPriceUpdateListItem> stockPriceUpdateListItems = (List<StockPriceUpdateListItem>) modelMap.get("listOfStockPriceUpdateItems");
		assertEquals(2, stockPriceUpdateListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockPriceUpdateDetail stockPriceUpdateDetail = stockPriceUpdateDetailFactoryForTest.newStockPriceUpdateDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockPriceUpdateDetail stockPriceUpdateDetailCreated = new StockPriceUpdateDetail();
		when(stockPriceUpdateDetailService.create(stockPriceUpdateDetail)).thenReturn(stockPriceUpdateDetailCreated); 
		
		// When
		String viewName = stockPriceUpdateDetailController.create(stockPriceUpdateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockPriceUpdateDetail/form/"+stockPriceUpdateDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdateDetailCreated, (StockPriceUpdateDetail) modelMap.get("stockPriceUpdateDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockPriceUpdateDetail stockPriceUpdateDetail = stockPriceUpdateDetailFactoryForTest.newStockPriceUpdateDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockPriceUpdateDetailController.create(stockPriceUpdateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceUpdateDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdateDetail, (StockPriceUpdateDetail) modelMap.get("stockPriceUpdateDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockPriceUpdateDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockPriceUpdateListItem> stockPriceUpdateListItems = (List<StockPriceUpdateListItem>) modelMap.get("listOfStockPriceUpdateItems");
		assertEquals(2, stockPriceUpdateListItems.size());
		
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

		StockPriceUpdateDetail stockPriceUpdateDetail = stockPriceUpdateDetailFactoryForTest.newStockPriceUpdateDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(stockPriceUpdateDetailService.create(stockPriceUpdateDetail)).thenThrow(exception);
		
		// When
		String viewName = stockPriceUpdateDetailController.create(stockPriceUpdateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceUpdateDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdateDetail, (StockPriceUpdateDetail) modelMap.get("stockPriceUpdateDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockPriceUpdateDetail/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockPriceUpdateDetail.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockPriceUpdateListItem> stockPriceUpdateListItems = (List<StockPriceUpdateListItem>) modelMap.get("listOfStockPriceUpdateItems");
		assertEquals(2, stockPriceUpdateListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockPriceUpdateDetail stockPriceUpdateDetail = stockPriceUpdateDetailFactoryForTest.newStockPriceUpdateDetail();
		Integer id = stockPriceUpdateDetail.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockPriceUpdateDetail stockPriceUpdateDetailSaved = new StockPriceUpdateDetail();
		stockPriceUpdateDetailSaved.setId(id);
		when(stockPriceUpdateDetailService.update(stockPriceUpdateDetail)).thenReturn(stockPriceUpdateDetailSaved); 
		
		// When
		String viewName = stockPriceUpdateDetailController.update(stockPriceUpdateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockPriceUpdateDetail/form/"+stockPriceUpdateDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdateDetailSaved, (StockPriceUpdateDetail) modelMap.get("stockPriceUpdateDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockPriceUpdateDetail stockPriceUpdateDetail = stockPriceUpdateDetailFactoryForTest.newStockPriceUpdateDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockPriceUpdateDetailController.update(stockPriceUpdateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceUpdateDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdateDetail, (StockPriceUpdateDetail) modelMap.get("stockPriceUpdateDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockPriceUpdateDetail/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockPriceUpdateListItem> stockPriceUpdateListItems = (List<StockPriceUpdateListItem>) modelMap.get("listOfStockPriceUpdateItems");
		assertEquals(2, stockPriceUpdateListItems.size());
		
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

		StockPriceUpdateDetail stockPriceUpdateDetail = stockPriceUpdateDetailFactoryForTest.newStockPriceUpdateDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(stockPriceUpdateDetailService.update(stockPriceUpdateDetail)).thenThrow(exception);
		
		// When
		String viewName = stockPriceUpdateDetailController.update(stockPriceUpdateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceUpdateDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdateDetail, (StockPriceUpdateDetail) modelMap.get("stockPriceUpdateDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockPriceUpdateDetail/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockPriceUpdateDetail.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockPriceUpdateListItem> stockPriceUpdateListItems = (List<StockPriceUpdateListItem>) modelMap.get("listOfStockPriceUpdateItems");
		assertEquals(2, stockPriceUpdateListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockPriceUpdateDetail stockPriceUpdateDetail = stockPriceUpdateDetailFactoryForTest.newStockPriceUpdateDetail();
		Integer id = stockPriceUpdateDetail.getId();
		
		// When
		String viewName = stockPriceUpdateDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(stockPriceUpdateDetailService).delete(id);
		assertEquals("redirect:/stockPriceUpdateDetail", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockPriceUpdateDetail stockPriceUpdateDetail = stockPriceUpdateDetailFactoryForTest.newStockPriceUpdateDetail();
		Integer id = stockPriceUpdateDetail.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockPriceUpdateDetailService).delete(id);
		
		// When
		String viewName = stockPriceUpdateDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(stockPriceUpdateDetailService).delete(id);
		assertEquals("redirect:/stockPriceUpdateDetail", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockPriceUpdateDetail.error.delete", exception);
	}
	
	
}
