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
import org.demo.bean.ContactExtraFields;
import org.demo.test.ContactExtraFieldsFactoryForTest;

//--- Services 
import org.demo.business.service.ContactExtraFieldsService;


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
public class ContactExtraFieldsControllerTest {
	
	@InjectMocks
	private ContactExtraFieldsController contactExtraFieldsController;
	@Mock
	private ContactExtraFieldsService contactExtraFieldsService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private ContactExtraFieldsFactoryForTest contactExtraFieldsFactoryForTest = new ContactExtraFieldsFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<ContactExtraFields> list = new ArrayList<ContactExtraFields>();
		when(contactExtraFieldsService.findAll()).thenReturn(list);
		
		// When
		String viewName = contactExtraFieldsController.list(model);
		
		// Then
		assertEquals("contactExtraFields/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = contactExtraFieldsController.formForCreate(model);
		
		// Then
		assertEquals("contactExtraFields/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ContactExtraFields)modelMap.get("contactExtraFields")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactExtraFields/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactExtraFields contactExtraFields = contactExtraFieldsFactoryForTest.newContactExtraFields();
		Integer id = contactExtraFields.getId();
		when(contactExtraFieldsService.findById(id)).thenReturn(contactExtraFields);
		
		// When
		String viewName = contactExtraFieldsController.formForUpdate(model, id);
		
		// Then
		assertEquals("contactExtraFields/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactExtraFields, (ContactExtraFields) modelMap.get("contactExtraFields"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactExtraFields/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ContactExtraFields contactExtraFields = contactExtraFieldsFactoryForTest.newContactExtraFields();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ContactExtraFields contactExtraFieldsCreated = new ContactExtraFields();
		when(contactExtraFieldsService.create(contactExtraFields)).thenReturn(contactExtraFieldsCreated); 
		
		// When
		String viewName = contactExtraFieldsController.create(contactExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/contactExtraFields/form/"+contactExtraFields.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactExtraFieldsCreated, (ContactExtraFields) modelMap.get("contactExtraFields"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactExtraFields contactExtraFields = contactExtraFieldsFactoryForTest.newContactExtraFields();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = contactExtraFieldsController.create(contactExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactExtraFields, (ContactExtraFields) modelMap.get("contactExtraFields"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactExtraFields/create", modelMap.get("saveAction"));
		
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

		ContactExtraFields contactExtraFields = contactExtraFieldsFactoryForTest.newContactExtraFields();
		
		Exception exception = new RuntimeException("test exception");
		when(contactExtraFieldsService.create(contactExtraFields)).thenThrow(exception);
		
		// When
		String viewName = contactExtraFieldsController.create(contactExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactExtraFields, (ContactExtraFields) modelMap.get("contactExtraFields"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactExtraFields/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "contactExtraFields.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ContactExtraFields contactExtraFields = contactExtraFieldsFactoryForTest.newContactExtraFields();
		Integer id = contactExtraFields.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ContactExtraFields contactExtraFieldsSaved = new ContactExtraFields();
		contactExtraFieldsSaved.setId(id);
		when(contactExtraFieldsService.update(contactExtraFields)).thenReturn(contactExtraFieldsSaved); 
		
		// When
		String viewName = contactExtraFieldsController.update(contactExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/contactExtraFields/form/"+contactExtraFields.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactExtraFieldsSaved, (ContactExtraFields) modelMap.get("contactExtraFields"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactExtraFields contactExtraFields = contactExtraFieldsFactoryForTest.newContactExtraFields();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = contactExtraFieldsController.update(contactExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactExtraFields, (ContactExtraFields) modelMap.get("contactExtraFields"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactExtraFields/update", modelMap.get("saveAction"));
		
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

		ContactExtraFields contactExtraFields = contactExtraFieldsFactoryForTest.newContactExtraFields();
		
		Exception exception = new RuntimeException("test exception");
		when(contactExtraFieldsService.update(contactExtraFields)).thenThrow(exception);
		
		// When
		String viewName = contactExtraFieldsController.update(contactExtraFields, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactExtraFields/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactExtraFields, (ContactExtraFields) modelMap.get("contactExtraFields"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactExtraFields/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "contactExtraFields.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ContactExtraFields contactExtraFields = contactExtraFieldsFactoryForTest.newContactExtraFields();
		Integer id = contactExtraFields.getId();
		
		// When
		String viewName = contactExtraFieldsController.delete(redirectAttributes, id);
		
		// Then
		verify(contactExtraFieldsService).delete(id);
		assertEquals("redirect:/contactExtraFields", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ContactExtraFields contactExtraFields = contactExtraFieldsFactoryForTest.newContactExtraFields();
		Integer id = contactExtraFields.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(contactExtraFieldsService).delete(id);
		
		// When
		String viewName = contactExtraFieldsController.delete(redirectAttributes, id);
		
		// Then
		verify(contactExtraFieldsService).delete(id);
		assertEquals("redirect:/contactExtraFields", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "contactExtraFields.error.delete", exception);
	}
	
	
}
