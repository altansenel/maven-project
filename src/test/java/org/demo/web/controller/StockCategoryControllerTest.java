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
import org.demo.bean.StockCategory;
import org.demo.test.StockCategoryFactoryForTest;

//--- Services 
import org.demo.business.service.StockCategoryService;


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
public class StockCategoryControllerTest {
	
	@InjectMocks
	private StockCategoryController stockCategoryController;
	@Mock
	private StockCategoryService stockCategoryService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private StockCategoryFactoryForTest stockCategoryFactoryForTest = new StockCategoryFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<StockCategory> list = new ArrayList<StockCategory>();
		when(stockCategoryService.findAll()).thenReturn(list);
		
		// When
		String viewName = stockCategoryController.list(model);
		
		// Then
		assertEquals("stockCategory/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = stockCategoryController.formForCreate(model);
		
		// Then
		assertEquals("stockCategory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((StockCategory)modelMap.get("stockCategory")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCategory/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCategory stockCategory = stockCategoryFactoryForTest.newStockCategory();
		Integer id = stockCategory.getId();
		when(stockCategoryService.findById(id)).thenReturn(stockCategory);
		
		// When
		String viewName = stockCategoryController.formForUpdate(model, id);
		
		// Then
		assertEquals("stockCategory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCategory, (StockCategory) modelMap.get("stockCategory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCategory/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockCategory stockCategory = stockCategoryFactoryForTest.newStockCategory();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockCategory stockCategoryCreated = new StockCategory();
		when(stockCategoryService.create(stockCategory)).thenReturn(stockCategoryCreated); 
		
		// When
		String viewName = stockCategoryController.create(stockCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockCategory/form/"+stockCategory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCategoryCreated, (StockCategory) modelMap.get("stockCategory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCategory stockCategory = stockCategoryFactoryForTest.newStockCategory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockCategoryController.create(stockCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCategory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCategory, (StockCategory) modelMap.get("stockCategory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCategory/create", modelMap.get("saveAction"));
		
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

		StockCategory stockCategory = stockCategoryFactoryForTest.newStockCategory();
		
		Exception exception = new RuntimeException("test exception");
		when(stockCategoryService.create(stockCategory)).thenThrow(exception);
		
		// When
		String viewName = stockCategoryController.create(stockCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCategory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCategory, (StockCategory) modelMap.get("stockCategory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/stockCategory/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockCategory.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		StockCategory stockCategory = stockCategoryFactoryForTest.newStockCategory();
		Integer id = stockCategory.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		StockCategory stockCategorySaved = new StockCategory();
		stockCategorySaved.setId(id);
		when(stockCategoryService.update(stockCategory)).thenReturn(stockCategorySaved); 
		
		// When
		String viewName = stockCategoryController.update(stockCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/stockCategory/form/"+stockCategory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCategorySaved, (StockCategory) modelMap.get("stockCategory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		StockCategory stockCategory = stockCategoryFactoryForTest.newStockCategory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = stockCategoryController.update(stockCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCategory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCategory, (StockCategory) modelMap.get("stockCategory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCategory/update", modelMap.get("saveAction"));
		
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

		StockCategory stockCategory = stockCategoryFactoryForTest.newStockCategory();
		
		Exception exception = new RuntimeException("test exception");
		when(stockCategoryService.update(stockCategory)).thenThrow(exception);
		
		// When
		String viewName = stockCategoryController.update(stockCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("stockCategory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(stockCategory, (StockCategory) modelMap.get("stockCategory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/stockCategory/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "stockCategory.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockCategory stockCategory = stockCategoryFactoryForTest.newStockCategory();
		Integer id = stockCategory.getId();
		
		// When
		String viewName = stockCategoryController.delete(redirectAttributes, id);
		
		// Then
		verify(stockCategoryService).delete(id);
		assertEquals("redirect:/stockCategory", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		StockCategory stockCategory = stockCategoryFactoryForTest.newStockCategory();
		Integer id = stockCategory.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(stockCategoryService).delete(id);
		
		// When
		String viewName = stockCategoryController.delete(redirectAttributes, id);
		
		// Then
		verify(stockCategoryService).delete(id);
		assertEquals("redirect:/stockCategory", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "stockCategory.error.delete", exception);
	}
	
	
}
