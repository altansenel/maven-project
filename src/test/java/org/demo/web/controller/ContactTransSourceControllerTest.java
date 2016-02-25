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
import org.demo.bean.ContactTransSource;
import org.demo.test.ContactTransSourceFactoryForTest;

//--- Services 
import org.demo.business.service.ContactTransSourceService;


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
public class ContactTransSourceControllerTest {
	
	@InjectMocks
	private ContactTransSourceController contactTransSourceController;
	@Mock
	private ContactTransSourceService contactTransSourceService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private ContactTransSourceFactoryForTest contactTransSourceFactoryForTest = new ContactTransSourceFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<ContactTransSource> list = new ArrayList<ContactTransSource>();
		when(contactTransSourceService.findAll()).thenReturn(list);
		
		// When
		String viewName = contactTransSourceController.list(model);
		
		// Then
		assertEquals("contactTransSource/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = contactTransSourceController.formForCreate(model);
		
		// Then
		assertEquals("contactTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ContactTransSource)modelMap.get("contactTransSource")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactTransSource/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactTransSource contactTransSource = contactTransSourceFactoryForTest.newContactTransSource();
		Integer id = contactTransSource.getId();
		when(contactTransSourceService.findById(id)).thenReturn(contactTransSource);
		
		// When
		String viewName = contactTransSourceController.formForUpdate(model, id);
		
		// Then
		assertEquals("contactTransSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTransSource, (ContactTransSource) modelMap.get("contactTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactTransSource/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ContactTransSource contactTransSource = contactTransSourceFactoryForTest.newContactTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ContactTransSource contactTransSourceCreated = new ContactTransSource();
		when(contactTransSourceService.create(contactTransSource)).thenReturn(contactTransSourceCreated); 
		
		// When
		String viewName = contactTransSourceController.create(contactTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/contactTransSource/form/"+contactTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTransSourceCreated, (ContactTransSource) modelMap.get("contactTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactTransSource contactTransSource = contactTransSourceFactoryForTest.newContactTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = contactTransSourceController.create(contactTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTransSource, (ContactTransSource) modelMap.get("contactTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactTransSource/create", modelMap.get("saveAction"));
		
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

		ContactTransSource contactTransSource = contactTransSourceFactoryForTest.newContactTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(contactTransSourceService.create(contactTransSource)).thenThrow(exception);
		
		// When
		String viewName = contactTransSourceController.create(contactTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTransSource, (ContactTransSource) modelMap.get("contactTransSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/contactTransSource/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "contactTransSource.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ContactTransSource contactTransSource = contactTransSourceFactoryForTest.newContactTransSource();
		Integer id = contactTransSource.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ContactTransSource contactTransSourceSaved = new ContactTransSource();
		contactTransSourceSaved.setId(id);
		when(contactTransSourceService.update(contactTransSource)).thenReturn(contactTransSourceSaved); 
		
		// When
		String viewName = contactTransSourceController.update(contactTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/contactTransSource/form/"+contactTransSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTransSourceSaved, (ContactTransSource) modelMap.get("contactTransSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ContactTransSource contactTransSource = contactTransSourceFactoryForTest.newContactTransSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = contactTransSourceController.update(contactTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTransSource, (ContactTransSource) modelMap.get("contactTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactTransSource/update", modelMap.get("saveAction"));
		
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

		ContactTransSource contactTransSource = contactTransSourceFactoryForTest.newContactTransSource();
		
		Exception exception = new RuntimeException("test exception");
		when(contactTransSourceService.update(contactTransSource)).thenThrow(exception);
		
		// When
		String viewName = contactTransSourceController.update(contactTransSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("contactTransSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(contactTransSource, (ContactTransSource) modelMap.get("contactTransSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/contactTransSource/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "contactTransSource.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ContactTransSource contactTransSource = contactTransSourceFactoryForTest.newContactTransSource();
		Integer id = contactTransSource.getId();
		
		// When
		String viewName = contactTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(contactTransSourceService).delete(id);
		assertEquals("redirect:/contactTransSource", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ContactTransSource contactTransSource = contactTransSourceFactoryForTest.newContactTransSource();
		Integer id = contactTransSource.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(contactTransSourceService).delete(id);
		
		// When
		String viewName = contactTransSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(contactTransSourceService).delete(id);
		assertEquals("redirect:/contactTransSource", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "contactTransSource.error.delete", exception);
	}
	
	
}
