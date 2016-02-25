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
import org.demo.bean.StockPriceList;
import org.demo.bean.StockExtraFields;
import org.demo.bean.StockCategory;
import org.demo.test.StockPriceListFactoryForTest;
import org.demo.test.StockExtraFieldsFactoryForTest;
import org.demo.test.StockCategoryFactoryForTest;

//--- Services 
import org.demo.business.service.StockPriceListService;
import org.demo.business.service.StockExtraFieldsService;
import org.demo.business.service.StockCategoryService;

//--- List Items 
import org.demo.web.listitem.StockExtraFieldsListItem;
import org.demo.web.listitem.StockCategoryListItem;

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
public class StockPriceListControllerTest {
	
	@InjectMocks
	private StockPriceListController stockPriceListController;
	@Mock
	private StockPriceListService stockPriceListService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockExtraFieldsService stockExtraFieldsService; // Injected by Spring
	@Mock
	private StockCategoryService stockCategoryService; // Injected by Spring

	private StockPriceListFactoryForTest stockPriceListFactoryForTest = new StockPriceListFactoryForTest();
	private StockExtraFieldsFactoryForTest stockExtraFieldsFactoryForTest = new StockExtraFieldsFactoryForTest();
	private StockCategoryFactoryForTest stockCategoryFactoryForTest = new StockCategoryFactoryForTest();

	List<StockExtraFields> stockExtraFieldss = new ArrayList<StockExtraFields>();
	List<StockCategory> stockCategorys = new ArrayList<StockCategory>();

	private void givenPopulateModel() {
		StockExtraFields stockExtraFields1 = stockExtraFieldsFactoryForTest.newStockExtraFields();
		StockExtraFields stockExtraFields2 = stockExtraFieldsFactoryForTest.newStockExtraFields();
		List<StockExtraFields> stockExtraFieldss = new ArrayList<StockExtraFields>();
		stockExtraFieldss.add(stockExtraFields1);
		stockExtraFieldss.add(stockExtraFields2);
		when(stockExtraFieldsService.findAll()).thenReturn(stockExtraFieldss);

		StockCategory stockCategory1 = stockCategoryFactoryForTest.newStockCategory();
		StockCategory stockCategory2 = stockCategoryFactoryForTest.newStockCategory();
		List<StockCategory> stockCategorys = new ArrayList<StockCategory>();
		stockCategorys.add(stockCategory1);
		stockCategorys.add(stockCategory2);
		when(stockCategoryService.findAll()).thenReturn(stockCategorys);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockPriceList> list = new ArrayList<StockPriceList>();
		when(stockPriceListService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockPriceListController.list(model);
		
		// Then
		assertEquals("stockPriceList/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockPriceListController.formForCreate(model);
		
		// Then
		assertEquals("stockPriceList/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockPriceList)modelMap.get("stockPriceList")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockPriceList/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockPriceList stockPriceList = stockPriceListFactoryForTest.newStockPriceList();
		Integer id = stockPriceList.getId();
		when(stockPriceListService.findById(id)).thenReturn(stockPriceList);
		
		// When
		String viewName = stockPriceListController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockPriceList/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceList, (StockPriceList) modelMap.get("stockPriceList"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockPriceList/update", modelMap.get("saveAction"));
		
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockPriceList stockPriceList = stockPriceListFactoryForTest.newStockPriceList();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockPriceList stockPriceListCreated = new StockPriceList();
		when(stockPriceListService.create(stockPriceList)).thenReturn(stockPriceListCreated); 
		
		// When
		String viewName = stockPriceListController.create(stockPriceList, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockPriceList/form/"+stockPriceList.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceListCreated, (StockPriceList) modelMap.get("stockPriceList"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockPriceList stockPriceList = stockPriceListFactoryForTest.newStockPriceList();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockPriceListController.create(stockPriceList, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceList/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceList, (StockPriceList) modelMap.get("stockPriceList"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockPriceList/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
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

		StockPriceList stockPriceList = stockPriceListFactoryForTest.newStockPriceList();
		
		Exception exception = new RuntimeException("test exception");
		when(stockPriceListService.create(stockPriceList)).thenThrow(exception);
		
		// When
		String viewName = stockPriceListController.create(stockPriceList, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceList/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceList, (StockPriceList) modelMap.get("stockPriceList"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockPriceList/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockPriceList.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockPriceList stockPriceList = stockPriceListFactoryForTest.newStockPriceList();
		Integer id = stockPriceList.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockPriceList stockPriceListSaved = new StockPriceList();
		stockPriceListSaved.setId(id);
		when(stockPriceListService.update(stockPriceList)).thenReturn(stockPriceListSaved); 
		
		// When
		String viewName = stockPriceListController.update(stockPriceList, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockPriceList/form/"+stockPriceList.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceListSaved, (StockPriceList) modelMap.get("stockPriceList"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockPriceList stockPriceList = stockPriceListFactoryForTest.newStockPriceList();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockPriceListController.update(stockPriceList, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceList/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceList, (StockPriceList) modelMap.get("stockPriceList"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockPriceList/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
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

		StockPriceList stockPriceList = stockPriceListFactoryForTest.newStockPriceList();
		
		Exception exception = new RuntimeException("test exception");
		when(stockPriceListService.update(stockPriceList)).thenThrow(exception);
		
		// When
		String viewName = stockPriceListController.update(stockPriceList, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceList/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceList, (StockPriceList) modelMap.get("stockPriceList"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockPriceList/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockPriceList.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		@SuppressWarnings("unchecked")
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockPriceList stockPriceList = stockPriceListFactoryForTest.newStockPriceList();
		Integer id = stockPriceList.getId();
		
		// When
		String viewName = stockPriceListController.delete(redirectAttributes, id);
		
		// Then
		verify(stockPriceListService).delete(id);
		assertEquals("redirect:/stockPriceList", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockPriceList stockPriceList = stockPriceListFactoryForTest.newStockPriceList();
		Integer id = stockPriceList.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockPriceListService).delete(id);
		
		// When
		String viewName = stockPriceListController.delete(redirectAttributes, id);
		
		// Then
		verify(stockPriceListService).delete(id);
		assertEquals("redirect:/stockPriceList", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockPriceList.error.delete", exception);
	}
	
	
}
