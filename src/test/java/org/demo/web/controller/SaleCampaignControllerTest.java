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
import org.demo.bean.SaleCampaign;
import org.demo.bean.StockExtraFields;
import org.demo.bean.StockCategory;
import org.demo.test.SaleCampaignFactoryForTest;
import org.demo.test.StockExtraFieldsFactoryForTest;
import org.demo.test.StockCategoryFactoryForTest;

//--- Services 
import org.demo.business.service.SaleCampaignService;
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
public class SaleCampaignControllerTest {
	
	@InjectMocks
	private SaleCampaignController saleCampaignController;
	@Mock
	private SaleCampaignService saleCampaignService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private StockExtraFieldsService stockExtraFieldsService; // Injected by Spring
	@Mock
	private StockCategoryService stockCategoryService; // Injected by Spring

	private SaleCampaignFactoryForTest saleCampaignFactoryForTest = new SaleCampaignFactoryForTest();
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
		
		List<SaleCampaign> list = new ArrayList<SaleCampaign>();
		when(saleCampaignService.findAll()).thenReturn(list);
		
		// When
		String viewName = saleCampaignController.list(model);
		
		// Then
		assertEquals("saleCampaign/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = saleCampaignController.formForCreate(model);
		
		// Then
		assertEquals("saleCampaign/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((SaleCampaign)modelMap.get("saleCampaign")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/saleCampaign/create", modelMap.get("saveAction"));
		
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
		
		SaleCampaign saleCampaign = saleCampaignFactoryForTest.newSaleCampaign();
		Integer id = saleCampaign.getId();
		when(saleCampaignService.findById(id)).thenReturn(saleCampaign);
		
		// When
		String viewName = saleCampaignController.formForUpdate(model, id);
		
		// Then
		assertEquals("saleCampaign/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleCampaign, (SaleCampaign) modelMap.get("saleCampaign"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/saleCampaign/update", modelMap.get("saveAction"));
		
		List<StockCategoryListItem> stockCategoryListItems = (List<StockCategoryListItem>) modelMap.get("listOfStockCategoryItems");
		assertEquals(2, stockCategoryListItems.size());
		
		List<StockExtraFieldsListItem> stockExtraFieldsListItems = (List<StockExtraFieldsListItem>) modelMap.get("listOfStockExtraFieldsItems");
		assertEquals(2, stockExtraFieldsListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		SaleCampaign saleCampaign = saleCampaignFactoryForTest.newSaleCampaign();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		SaleCampaign saleCampaignCreated = new SaleCampaign();
		when(saleCampaignService.create(saleCampaign)).thenReturn(saleCampaignCreated); 
		
		// When
		String viewName = saleCampaignController.create(saleCampaign, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/saleCampaign/form/"+saleCampaign.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleCampaignCreated, (SaleCampaign) modelMap.get("saleCampaign"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SaleCampaign saleCampaign = saleCampaignFactoryForTest.newSaleCampaign();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = saleCampaignController.create(saleCampaign, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("saleCampaign/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleCampaign, (SaleCampaign) modelMap.get("saleCampaign"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/saleCampaign/create", modelMap.get("saveAction"));
		
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

		SaleCampaign saleCampaign = saleCampaignFactoryForTest.newSaleCampaign();
		
		Exception exception = new RuntimeException("test exception");
		when(saleCampaignService.create(saleCampaign)).thenThrow(exception);
		
		// When
		String viewName = saleCampaignController.create(saleCampaign, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("saleCampaign/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleCampaign, (SaleCampaign) modelMap.get("saleCampaign"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/saleCampaign/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "saleCampaign.error.create", exception);
		
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
		
		SaleCampaign saleCampaign = saleCampaignFactoryForTest.newSaleCampaign();
		Integer id = saleCampaign.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		SaleCampaign saleCampaignSaved = new SaleCampaign();
		saleCampaignSaved.setId(id);
		when(saleCampaignService.update(saleCampaign)).thenReturn(saleCampaignSaved); 
		
		// When
		String viewName = saleCampaignController.update(saleCampaign, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/saleCampaign/form/"+saleCampaign.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleCampaignSaved, (SaleCampaign) modelMap.get("saleCampaign"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SaleCampaign saleCampaign = saleCampaignFactoryForTest.newSaleCampaign();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = saleCampaignController.update(saleCampaign, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("saleCampaign/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleCampaign, (SaleCampaign) modelMap.get("saleCampaign"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/saleCampaign/update", modelMap.get("saveAction"));
		
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

		SaleCampaign saleCampaign = saleCampaignFactoryForTest.newSaleCampaign();
		
		Exception exception = new RuntimeException("test exception");
		when(saleCampaignService.update(saleCampaign)).thenThrow(exception);
		
		// When
		String viewName = saleCampaignController.update(saleCampaign, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("saleCampaign/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleCampaign, (SaleCampaign) modelMap.get("saleCampaign"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/saleCampaign/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "saleCampaign.error.update", exception);
		
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
		
		SaleCampaign saleCampaign = saleCampaignFactoryForTest.newSaleCampaign();
		Integer id = saleCampaign.getId();
		
		// When
		String viewName = saleCampaignController.delete(redirectAttributes, id);
		
		// Then
		verify(saleCampaignService).delete(id);
		assertEquals("redirect:/saleCampaign", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		SaleCampaign saleCampaign = saleCampaignFactoryForTest.newSaleCampaign();
		Integer id = saleCampaign.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(saleCampaignService).delete(id);
		
		// When
		String viewName = saleCampaignController.delete(redirectAttributes, id);
		
		// Then
		verify(saleCampaignService).delete(id);
		assertEquals("redirect:/saleCampaign", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "saleCampaign.error.delete", exception);
	}
	
	
}
