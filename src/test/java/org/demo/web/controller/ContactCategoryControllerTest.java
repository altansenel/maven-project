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
import org.demo.bean.ContactCategory;
import org.demo.test.ContactCategoryFactoryForTest;

//--- Services 
import org.demo.business.service.ContactCategoryService;


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
public class ContactCategoryControllerTest {
	
	@InjectMocks
	private ContactCategoryController contactCategoryController;
	@Mock
	private ContactCategoryService contactCategoryService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private ContactCategoryFactoryForTest contactCategoryFactoryForTest = new ContactCategoryFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<ContactCategory> list = new ArrayList<ContactCategory>();
		when(contactCategoryService.findAll()).thenReturn(list);
		
		// When
		String viewName = contactCategoryController.list(model);
		
		// Then
		assertEquals("contactCategory/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = contactCategoryController.formForCreate(model);
		
		// Then
		assertEquals("contactCategory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ContactCategory)modelMap.get("contactCategory")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactCategory/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactCategory contactCategory = contactCategoryFactoryForTest.newContactCategory();
		Integer id = contactCategory.getId();
		when(contactCategoryService.findById(id)).thenReturn(contactCategory);
		
		// When
		String viewName = contactCategoryController.formForUpdate(model, id);
		
		// Then
		assertEquals("contactCategory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactCategory, (ContactCategory) modelMap.get("contactCategory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactCategory/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ContactCategory contactCategory = contactCategoryFactoryForTest.newContactCategory();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ContactCategory contactCategoryCreated = new ContactCategory();
		when(contactCategoryService.create(contactCategory)).thenReturn(contactCategoryCreated); 
		
		// When
		String viewName = contactCategoryController.create(contactCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/contactCategory/form/"+contactCategory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactCategoryCreated, (ContactCategory) modelMap.get("contactCategory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactCategory contactCategory = contactCategoryFactoryForTest.newContactCategory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = contactCategoryController.create(contactCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactCategory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactCategory, (ContactCategory) modelMap.get("contactCategory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactCategory/create", modelMap.get("saveAction"));
		
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

		ContactCategory contactCategory = contactCategoryFactoryForTest.newContactCategory();
		
		Exception exception = new RuntimeException("test exception");
		when(contactCategoryService.create(contactCategory)).thenThrow(exception);
		
		// When
		String viewName = contactCategoryController.create(contactCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactCategory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactCategory, (ContactCategory) modelMap.get("contactCategory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactCategory/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "contactCategory.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ContactCategory contactCategory = contactCategoryFactoryForTest.newContactCategory();
		Integer id = contactCategory.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ContactCategory contactCategorySaved = new ContactCategory();
		contactCategorySaved.setId(id);
		when(contactCategoryService.update(contactCategory)).thenReturn(contactCategorySaved); 
		
		// When
		String viewName = contactCategoryController.update(contactCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/contactCategory/form/"+contactCategory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactCategorySaved, (ContactCategory) modelMap.get("contactCategory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactCategory contactCategory = contactCategoryFactoryForTest.newContactCategory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = contactCategoryController.update(contactCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactCategory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactCategory, (ContactCategory) modelMap.get("contactCategory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactCategory/update", modelMap.get("saveAction"));
		
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

		ContactCategory contactCategory = contactCategoryFactoryForTest.newContactCategory();
		
		Exception exception = new RuntimeException("test exception");
		when(contactCategoryService.update(contactCategory)).thenThrow(exception);
		
		// When
		String viewName = contactCategoryController.update(contactCategory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactCategory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactCategory, (ContactCategory) modelMap.get("contactCategory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactCategory/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "contactCategory.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ContactCategory contactCategory = contactCategoryFactoryForTest.newContactCategory();
		Integer id = contactCategory.getId();
		
		// When
		String viewName = contactCategoryController.delete(redirectAttributes, id);
		
		// Then
		verify(contactCategoryService).delete(id);
		assertEquals("redirect:/contactCategory", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ContactCategory contactCategory = contactCategoryFactoryForTest.newContactCategory();
		Integer id = contactCategory.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(contactCategoryService).delete(id);
		
		// When
		String viewName = contactCategoryController.delete(redirectAttributes, id);
		
		// Then
		verify(contactCategoryService).delete(id);
		assertEquals("redirect:/contactCategory", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "contactCategory.error.delete", exception);
	}
	
	
}
