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
import org.demo.bean.ChqbllType;
import org.demo.test.ChqbllTypeFactoryForTest;

//--- Services 
import org.demo.business.service.ChqbllTypeService;


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
public class ChqbllTypeControllerTest {
	
	@InjectMocks
	private ChqbllTypeController chqbllTypeController;
	@Mock
	private ChqbllTypeService chqbllTypeService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private ChqbllTypeFactoryForTest chqbllTypeFactoryForTest = new ChqbllTypeFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<ChqbllType> list = new ArrayList<ChqbllType>();
		when(chqbllTypeService.findAll()).thenReturn(list);
		
		// When
		String viewName = chqbllTypeController.list(model);
		
		// Then
		assertEquals("chqbllType/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = chqbllTypeController.formForCreate(model);
		
		// Then
		assertEquals("chqbllType/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ChqbllType)modelMap.get("chqbllType")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllType/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();
		Integer id = chqbllType.getId();
		when(chqbllTypeService.findById(id)).thenReturn(chqbllType);
		
		// When
		String viewName = chqbllTypeController.formForUpdate(model, id);
		
		// Then
		assertEquals("chqbllType/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllType, (ChqbllType) modelMap.get("chqbllType"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllType/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllType chqbllTypeCreated = new ChqbllType();
		when(chqbllTypeService.create(chqbllType)).thenReturn(chqbllTypeCreated); 
		
		// When
		String viewName = chqbllTypeController.create(chqbllType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllType/form/"+chqbllType.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTypeCreated, (ChqbllType) modelMap.get("chqbllType"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllTypeController.create(chqbllType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllType/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllType, (ChqbllType) modelMap.get("chqbllType"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllType/create", modelMap.get("saveAction"));
		
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

		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllTypeService.create(chqbllType)).thenThrow(exception);
		
		// When
		String viewName = chqbllTypeController.create(chqbllType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllType/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllType, (ChqbllType) modelMap.get("chqbllType"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllType/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllType.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();
		Integer id = chqbllType.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllType chqbllTypeSaved = new ChqbllType();
		chqbllTypeSaved.setId(id);
		when(chqbllTypeService.update(chqbllType)).thenReturn(chqbllTypeSaved); 
		
		// When
		String viewName = chqbllTypeController.update(chqbllType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllType/form/"+chqbllType.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTypeSaved, (ChqbllType) modelMap.get("chqbllType"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllTypeController.update(chqbllType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllType/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllType, (ChqbllType) modelMap.get("chqbllType"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllType/update", modelMap.get("saveAction"));
		
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

		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllTypeService.update(chqbllType)).thenThrow(exception);
		
		// When
		String viewName = chqbllTypeController.update(chqbllType, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllType/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllType, (ChqbllType) modelMap.get("chqbllType"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllType/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllType.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();
		Integer id = chqbllType.getId();
		
		// When
		String viewName = chqbllTypeController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllTypeService).delete(id);
		assertEquals("redirect:/chqbllType", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllType chqbllType = chqbllTypeFactoryForTest.newChqbllType();
		Integer id = chqbllType.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(chqbllTypeService).delete(id);
		
		// When
		String viewName = chqbllTypeController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllTypeService).delete(id);
		assertEquals("redirect:/chqbllType", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "chqbllType.error.delete", exception);
	}
	
	
}
