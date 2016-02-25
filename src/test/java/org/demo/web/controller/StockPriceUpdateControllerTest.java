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
import org.demo.bean.StockPriceUpdate;
import org.demo.bean.StockExtraFields;
import org.demo.bean.StockCategory;
import org.demo.test.StockPriceUpdateFactoryForTest;
import org.demo.test.StockExtraFieldsFactoryForTest;
import org.demo.test.StockCategoryFactoryForTest;

//--- Services 
import org.demo.business.service.StockPriceUpdateService;
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
public class StockPriceUpdateControllerTest {
	
	@InjectMocks
	private StockPriceUpdateController stockPriceUpdateController;
	@Mock
	private StockPriceUpdateService stockPriceUpdateService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockExtraFieldsService stockExtraFieldsService; // Injected by Spring
	@Mock
	private StockCategoryService stockCategoryService; // Injected by Spring

	private StockPriceUpdateFactoryForTest stockPriceUpdateFactoryForTest = new StockPriceUpdateFactoryForTest();
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
		
		List<StockPriceUpdate> list = new ArrayList<StockPriceUpdate>();
		when(stockPriceUpdateService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockPriceUpdateController.list(model);
		
		// Then
		assertEquals("stockPriceUpdate/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockPriceUpdateController.formForCreate(model);
		
		// Then
		assertEquals("stockPriceUpdate/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockPriceUpdate)modelMap.get("stockPriceUpdate")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockPriceUpdate/create", modelMap.get("saveAction"));
		
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
		
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		Integer id = stockPriceUpdate.getId();
		when(stockPriceUpdateService.findById(id)).thenReturn(stockPriceUpdate);
		
		// When
		String viewName = stockPriceUpdateController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockPriceUpdate/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdate, (StockPriceUpdate) modelMap.get("stockPriceUpdate"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockPriceUpdate/update", modelMap.get("saveAction"));
		
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockPriceUpdate stockPriceUpdateCreated = new StockPriceUpdate();
		when(stockPriceUpdateService.create(stockPriceUpdate)).thenReturn(stockPriceUpdateCreated); 
		
		// When
		String viewName = stockPriceUpdateController.create(stockPriceUpdate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockPriceUpdate/form/"+stockPriceUpdate.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdateCreated, (StockPriceUpdate) modelMap.get("stockPriceUpdate"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockPriceUpdateController.create(stockPriceUpdate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceUpdate/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdate, (StockPriceUpdate) modelMap.get("stockPriceUpdate"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockPriceUpdate/create", modelMap.get("saveAction"));
		
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

		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		
		Exception exception = new RuntimeException("test exception");
		when(stockPriceUpdateService.create(stockPriceUpdate)).thenThrow(exception);
		
		// When
		String viewName = stockPriceUpdateController.create(stockPriceUpdate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceUpdate/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdate, (StockPriceUpdate) modelMap.get("stockPriceUpdate"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockPriceUpdate/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockPriceUpdate.error.create", exception);
		
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
		
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		Integer id = stockPriceUpdate.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockPriceUpdate stockPriceUpdateSaved = new StockPriceUpdate();
		stockPriceUpdateSaved.setId(id);
		when(stockPriceUpdateService.update(stockPriceUpdate)).thenReturn(stockPriceUpdateSaved); 
		
		// When
		String viewName = stockPriceUpdateController.update(stockPriceUpdate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockPriceUpdate/form/"+stockPriceUpdate.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdateSaved, (StockPriceUpdate) modelMap.get("stockPriceUpdate"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockPriceUpdateController.update(stockPriceUpdate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceUpdate/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdate, (StockPriceUpdate) modelMap.get("stockPriceUpdate"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockPriceUpdate/update", modelMap.get("saveAction"));
		
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

		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		
		Exception exception = new RuntimeException("test exception");
		when(stockPriceUpdateService.update(stockPriceUpdate)).thenThrow(exception);
		
		// When
		String viewName = stockPriceUpdateController.update(stockPriceUpdate, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockPriceUpdate/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockPriceUpdate, (StockPriceUpdate) modelMap.get("stockPriceUpdate"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockPriceUpdate/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockPriceUpdate.error.update", exception);
		
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
		
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		Integer id = stockPriceUpdate.getId();
		
		// When
		String viewName = stockPriceUpdateController.delete(redirectAttributes, id);
		
		// Then
		verify(stockPriceUpdateService).delete(id);
		assertEquals("redirect:/stockPriceUpdate", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockPriceUpdate stockPriceUpdate = stockPriceUpdateFactoryForTest.newStockPriceUpdate();
		Integer id = stockPriceUpdate.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockPriceUpdateService).delete(id);
		
		// When
		String viewName = stockPriceUpdateController.delete(redirectAttributes, id);
		
		// Then
		verify(stockPriceUpdateService).delete(id);
		assertEquals("redirect:/stockPriceUpdate", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockPriceUpdate.error.delete", exception);
	}
	
	
}
