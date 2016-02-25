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
import org.demo.bean.ChqbllPayrollSource;
import org.demo.test.ChqbllPayrollSourceFactoryForTest;

//--- Services 
import org.demo.business.service.ChqbllPayrollSourceService;


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
public class ChqbllPayrollSourceControllerTest {
	
	@InjectMocks
	private ChqbllPayrollSourceController chqbllPayrollSourceController;
	@Mock
	private ChqbllPayrollSourceService chqbllPayrollSourceService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private ChqbllPayrollSourceFactoryForTest chqbllPayrollSourceFactoryForTest = new ChqbllPayrollSourceFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<ChqbllPayrollSource> list = new ArrayList<ChqbllPayrollSource>();
		when(chqbllPayrollSourceService.findAll()).thenReturn(list);
		
		// When
		String viewName = chqbllPayrollSourceController.list(model);
		
		// Then
		assertEquals("chqbllPayrollSource/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = chqbllPayrollSourceController.formForCreate(model);
		
		// Then
		assertEquals("chqbllPayrollSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ChqbllPayrollSource)modelMap.get("chqbllPayrollSource")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllPayrollSource/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		Integer id = chqbllPayrollSource.getId();
		when(chqbllPayrollSourceService.findById(id)).thenReturn(chqbllPayrollSource);
		
		// When
		String viewName = chqbllPayrollSourceController.formForUpdate(model, id);
		
		// Then
		assertEquals("chqbllPayrollSource/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollSource, (ChqbllPayrollSource) modelMap.get("chqbllPayrollSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllPayrollSource/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllPayrollSource chqbllPayrollSourceCreated = new ChqbllPayrollSource();
		when(chqbllPayrollSourceService.create(chqbllPayrollSource)).thenReturn(chqbllPayrollSourceCreated); 
		
		// When
		String viewName = chqbllPayrollSourceController.create(chqbllPayrollSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllPayrollSource/form/"+chqbllPayrollSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollSourceCreated, (ChqbllPayrollSource) modelMap.get("chqbllPayrollSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllPayrollSourceController.create(chqbllPayrollSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayrollSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollSource, (ChqbllPayrollSource) modelMap.get("chqbllPayrollSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllPayrollSource/create", modelMap.get("saveAction"));
		
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

		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllPayrollSourceService.create(chqbllPayrollSource)).thenThrow(exception);
		
		// When
		String viewName = chqbllPayrollSourceController.create(chqbllPayrollSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayrollSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollSource, (ChqbllPayrollSource) modelMap.get("chqbllPayrollSource"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllPayrollSource/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllPayrollSource.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		Integer id = chqbllPayrollSource.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllPayrollSource chqbllPayrollSourceSaved = new ChqbllPayrollSource();
		chqbllPayrollSourceSaved.setId(id);
		when(chqbllPayrollSourceService.update(chqbllPayrollSource)).thenReturn(chqbllPayrollSourceSaved); 
		
		// When
		String viewName = chqbllPayrollSourceController.update(chqbllPayrollSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllPayrollSource/form/"+chqbllPayrollSource.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollSourceSaved, (ChqbllPayrollSource) modelMap.get("chqbllPayrollSource"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllPayrollSourceController.update(chqbllPayrollSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayrollSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollSource, (ChqbllPayrollSource) modelMap.get("chqbllPayrollSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllPayrollSource/update", modelMap.get("saveAction"));
		
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

		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllPayrollSourceService.update(chqbllPayrollSource)).thenThrow(exception);
		
		// When
		String viewName = chqbllPayrollSourceController.update(chqbllPayrollSource, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllPayrollSource/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllPayrollSource, (ChqbllPayrollSource) modelMap.get("chqbllPayrollSource"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllPayrollSource/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllPayrollSource.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		Integer id = chqbllPayrollSource.getId();
		
		// When
		String viewName = chqbllPayrollSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllPayrollSourceService).delete(id);
		assertEquals("redirect:/chqbllPayrollSource", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllPayrollSource chqbllPayrollSource = chqbllPayrollSourceFactoryForTest.newChqbllPayrollSource();
		Integer id = chqbllPayrollSource.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(chqbllPayrollSourceService).delete(id);
		
		// When
		String viewName = chqbllPayrollSourceController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllPayrollSourceService).delete(id);
		assertEquals("redirect:/chqbllPayrollSource", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "chqbllPayrollSource.error.delete", exception);
	}
	
	
}
