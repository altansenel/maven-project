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
import org.demo.bean.WaybillTransRelation;
import org.demo.bean.WaybillTrans;
import org.demo.test.WaybillTransRelationFactoryForTest;
import org.demo.test.WaybillTransFactoryForTest;

//--- Services 
import org.demo.business.service.WaybillTransRelationService;
import org.demo.business.service.WaybillTransService;

//--- List Items 
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
public class WaybillTransRelationControllerTest {
	
	@InjectMocks
	private WaybillTransRelationController waybillTransRelationController;
	@Mock
	private WaybillTransRelationService waybillTransRelationService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private WaybillTransService waybillTransService; // Injected by Spring

	private WaybillTransRelationFactoryForTest waybillTransRelationFactoryForTest = new WaybillTransRelationFactoryForTest();
	private WaybillTransFactoryForTest waybillTransFactoryForTest = new WaybillTransFactoryForTest();

	List<WaybillTrans> waybillTranss = new ArrayList<WaybillTrans>();

	private void givenPopulateModel() {
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
		
		List<WaybillTransRelation> list = new ArrayList<WaybillTransRelation>();
		when(waybillTransRelationService.findAll()).thenReturn(list);
		
		// When
		String viewName = waybillTransRelationController.list(model);
		
		// Then
		assertEquals("waybillTransRelation/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = waybillTransRelationController.formForCreate(model);
		
		// Then
		assertEquals("waybillTransRelation/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((WaybillTransRelation)modelMap.get("waybillTransRelation")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransRelation/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransRelation waybillTransRelation = waybillTransRelationFactoryForTest.newWaybillTransRelation();
		Integer id = waybillTransRelation.getId();
		when(waybillTransRelationService.findById(id)).thenReturn(waybillTransRelation);
		
		// When
		String viewName = waybillTransRelationController.formForUpdate(model, id);
		
		// Then
		assertEquals("waybillTransRelation/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransRelation, (WaybillTransRelation) modelMap.get("waybillTransRelation"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransRelation/update", modelMap.get("saveAction"));
		
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransRelation waybillTransRelation = waybillTransRelationFactoryForTest.newWaybillTransRelation();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransRelation waybillTransRelationCreated = new WaybillTransRelation();
		when(waybillTransRelationService.create(waybillTransRelation)).thenReturn(waybillTransRelationCreated); 
		
		// When
		String viewName = waybillTransRelationController.create(waybillTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransRelation/form/"+waybillTransRelation.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransRelationCreated, (WaybillTransRelation) modelMap.get("waybillTransRelation"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransRelation waybillTransRelation = waybillTransRelationFactoryForTest.newWaybillTransRelation();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransRelationController.create(waybillTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransRelation/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransRelation, (WaybillTransRelation) modelMap.get("waybillTransRelation"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransRelation/create", modelMap.get("saveAction"));
		
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

		WaybillTransRelation waybillTransRelation = waybillTransRelationFactoryForTest.newWaybillTransRelation();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransRelationService.create(waybillTransRelation)).thenThrow(exception);
		
		// When
		String viewName = waybillTransRelationController.create(waybillTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransRelation/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransRelation, (WaybillTransRelation) modelMap.get("waybillTransRelation"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransRelation/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransRelation.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransRelation waybillTransRelation = waybillTransRelationFactoryForTest.newWaybillTransRelation();
		Integer id = waybillTransRelation.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransRelation waybillTransRelationSaved = new WaybillTransRelation();
		waybillTransRelationSaved.setId(id);
		when(waybillTransRelationService.update(waybillTransRelation)).thenReturn(waybillTransRelationSaved); 
		
		// When
		String viewName = waybillTransRelationController.update(waybillTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransRelation/form/"+waybillTransRelation.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransRelationSaved, (WaybillTransRelation) modelMap.get("waybillTransRelation"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransRelation waybillTransRelation = waybillTransRelationFactoryForTest.newWaybillTransRelation();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransRelationController.update(waybillTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransRelation/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransRelation, (WaybillTransRelation) modelMap.get("waybillTransRelation"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransRelation/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
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

		WaybillTransRelation waybillTransRelation = waybillTransRelationFactoryForTest.newWaybillTransRelation();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransRelationService.update(waybillTransRelation)).thenThrow(exception);
		
		// When
		String viewName = waybillTransRelationController.update(waybillTransRelation, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransRelation/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransRelation, (WaybillTransRelation) modelMap.get("waybillTransRelation"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransRelation/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransRelation.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<WaybillTransListItem> waybillTransListItems = (List<WaybillTransListItem>) modelMap.get("listOfWaybillTransItems");
		assertEquals(2, waybillTransListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransRelation waybillTransRelation = waybillTransRelationFactoryForTest.newWaybillTransRelation();
		Integer id = waybillTransRelation.getId();
		
		// When
		String viewName = waybillTransRelationController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransRelationService).delete(id);
		assertEquals("redirect:/waybillTransRelation", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransRelation waybillTransRelation = waybillTransRelationFactoryForTest.newWaybillTransRelation();
		Integer id = waybillTransRelation.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(waybillTransRelationService).delete(id);
		
		// When
		String viewName = waybillTransRelationController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransRelationService).delete(id);
		assertEquals("redirect:/waybillTransRelation", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "waybillTransRelation.error.delete", exception);
	}
	
	
}
