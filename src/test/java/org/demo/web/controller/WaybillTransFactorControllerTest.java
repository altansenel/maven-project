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
import org.demo.bean.WaybillTransFactor;
import org.demo.bean.StockCostFactor;
import org.demo.bean.WaybillTrans;
import org.demo.test.WaybillTransFactorFactoryForTest;
import org.demo.test.StockCostFactorFactoryForTest;
import org.demo.test.WaybillTransFactoryForTest;

//--- Services 
import org.demo.business.service.WaybillTransFactorService;
import org.demo.business.service.StockCostFactorService;
import org.demo.business.service.WaybillTransService;

//--- List Items 
import org.demo.web.listitem.StockCostFactorListItem;
import org.demo.web.listitem.WaybillTransListItem;

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
public class WaybillTransFactorControllerTest {
	
	@InjectMocks
	private WaybillTransFactorController waybillTransFactorController;
	@Mock
	private WaybillTransFactorService waybillTransFactorService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockCostFactorService stockCostFactorService; // Injected by Spring
	@Mock
	private WaybillTransService waybillTransService; // Injected by Spring

	private WaybillTransFactorFactoryForTest waybillTransFactorFactoryForTest = new WaybillTransFactorFactoryForTest();
	private StockCostFactorFactoryForTest stockCostFactorFactoryForTest = new StockCostFactorFactoryForTest();
	private WaybillTransFactoryForTest waybillTransFactoryForTest = new WaybillTransFactoryForTest();

	List<StockCostFactor> stockCostFactors = new ArrayList<StockCostFactor>();
	List<WaybillTrans> waybillTranss = new ArrayList<WaybillTrans>();

	private void givenPopulateModel() {
		StockCostFactor stockCostFactor1 = stockCostFactorFactoryForTest.newStockCostFactor();
		StockCostFactor stockCostFactor2 = stockCostFactorFactoryForTest.newStockCostFactor();
		List<StockCostFactor> stockCostFactors = new ArrayList<StockCostFactor>();
		stockCostFactors.add(stockCostFactor1);
		stockCostFactors.add(stockCostFactor2);
		when(stockCostFactorService.findAll()).thenReturn(stockCostFactors);

		WaybillTrans waybillTrans1 = waybillTransFactoryForTest.newWaybillTrans();
		WaybillTrans waybillTrans2 = waybillTransFactoryForTest.newWaybillTrans();
		List<WaybillTrans> waybillTranss = new ArrayList<WaybillTrans>();
		waybillTranss.add(waybillTrans1);
		waybillTranss.add(waybillTrans2);
		when(waybillTransService.findAll()).thenReturn(waybillTranss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<WaybillTransFactor> list = new ArrayList<WaybillTransFactor>();
		when(waybillTransFactorService.findAll()).thenReturn(list);
		
		// When
		String viewName = waybillTransFactorController.list(model);
		
		// Then
		assertEquals("waybillTransFactor/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = waybillTransFactorController.formForCreate(model);
		
		// Then
		assertEquals("waybillTransFactor/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((WaybillTransFactor)modelMap.get("waybillTransFactor")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransFactor/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransFactor waybillTransFactor = waybillTransFactorFactoryForTest.newWaybillTransFactor();
		Integer id = waybillTransFactor.getId();
		when(waybillTransFactorService.findById(id)).thenReturn(waybillTransFactor);
		
		// When
		String viewName = waybillTransFactorController.formForUpdate(model, id);
		
		// Then
		assertEquals("waybillTransFactor/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransFactor, (WaybillTransFactor) modelMap.get("waybillTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransFactor/update", modelMap.get("saveAction"));
		
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransFactor waybillTransFactor = waybillTransFactorFactoryForTest.newWaybillTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransFactor waybillTransFactorCreated = new WaybillTransFactor();
		when(waybillTransFactorService.create(waybillTransFactor)).thenReturn(waybillTransFactorCreated); 
		
		// When
		String viewName = waybillTransFactorController.create(waybillTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransFactor/form/"+waybillTransFactor.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransFactorCreated, (WaybillTransFactor) modelMap.get("waybillTransFactor"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransFactor waybillTransFactor = waybillTransFactorFactoryForTest.newWaybillTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransFactorController.create(waybillTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransFactor, (WaybillTransFactor) modelMap.get("waybillTransFactor"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransFactor/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
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

		WaybillTransFactor waybillTransFactor = waybillTransFactorFactoryForTest.newWaybillTransFactor();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransFactorService.create(waybillTransFactor)).thenThrow(exception);
		
		// When
		String viewName = waybillTransFactorController.create(waybillTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransFactor, (WaybillTransFactor) modelMap.get("waybillTransFactor"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransFactor/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransFactor.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransFactor waybillTransFactor = waybillTransFactorFactoryForTest.newWaybillTransFactor();
		Integer id = waybillTransFactor.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransFactor waybillTransFactorSaved = new WaybillTransFactor();
		waybillTransFactorSaved.setId(id);
		when(waybillTransFactorService.update(waybillTransFactor)).thenReturn(waybillTransFactorSaved); 
		
		// When
		String viewName = waybillTransFactorController.update(waybillTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransFactor/form/"+waybillTransFactor.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransFactorSaved, (WaybillTransFactor) modelMap.get("waybillTransFactor"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransFactor waybillTransFactor = waybillTransFactorFactoryForTest.newWaybillTransFactor();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransFactorController.update(waybillTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransFactor, (WaybillTransFactor) modelMap.get("waybillTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransFactor/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
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

		WaybillTransFactor waybillTransFactor = waybillTransFactorFactoryForTest.newWaybillTransFactor();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransFactorService.update(waybillTransFactor)).thenThrow(exception);
		
		// When
		String viewName = waybillTransFactorController.update(waybillTransFactor, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransFactor/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransFactor, (WaybillTransFactor) modelMap.get("waybillTransFactor"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransFactor/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransFactor.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCostFactorListItem> stockCostFactorListItems = (List<StockCostFactorListItem>) modelMap.get("listOfStockCostFactorItems");
		assertEquals(2, stockCostFactorListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransFactor waybillTransFactor = waybillTransFactorFactoryForTest.newWaybillTransFactor();
		Integer id = waybillTransFactor.getId();
		
		// When
		String viewName = waybillTransFactorController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransFactorService).delete(id);
		assertEquals("redirect:/waybillTransFactor", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransFactor waybillTransFactor = waybillTransFactorFactoryForTest.newWaybillTransFactor();
		Integer id = waybillTransFactor.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(waybillTransFactorService).delete(id);
		
		// When
		String viewName = waybillTransFactorController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransFactorService).delete(id);
		assertEquals("redirect:/waybillTransFactor", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "waybillTransFactor.error.delete", exception);
	}
	
	
}
