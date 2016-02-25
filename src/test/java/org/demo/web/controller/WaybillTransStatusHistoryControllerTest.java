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
import org.demo.bean.WaybillTransStatusHistory;
import org.demo.test.WaybillTransStatusHistoryFactoryForTest;

//--- Services 
import org.demo.business.service.WaybillTransStatusHistoryService;


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
public class WaybillTransStatusHistoryControllerTest {
	
	@InjectMocks
	private WaybillTransStatusHistoryController waybillTransStatusHistoryController;
	@Mock
	private WaybillTransStatusHistoryService waybillTransStatusHistoryService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private WaybillTransStatusHistoryFactoryForTest waybillTransStatusHistoryFactoryForTest = new WaybillTransStatusHistoryFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<WaybillTransStatusHistory> list = new ArrayList<WaybillTransStatusHistory>();
		when(waybillTransStatusHistoryService.findAll()).thenReturn(list);
		
		// When
		String viewName = waybillTransStatusHistoryController.list(model);
		
		// Then
		assertEquals("waybillTransStatusHistory/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = waybillTransStatusHistoryController.formForCreate(model);
		
		// Then
		assertEquals("waybillTransStatusHistory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((WaybillTransStatusHistory)modelMap.get("waybillTransStatusHistory")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransStatusHistory/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransStatusHistory waybillTransStatusHistory = waybillTransStatusHistoryFactoryForTest.newWaybillTransStatusHistory();
		Integer id = waybillTransStatusHistory.getId();
		when(waybillTransStatusHistoryService.findById(id)).thenReturn(waybillTransStatusHistory);
		
		// When
		String viewName = waybillTransStatusHistoryController.formForUpdate(model, id);
		
		// Then
		assertEquals("waybillTransStatusHistory/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatusHistory, (WaybillTransStatusHistory) modelMap.get("waybillTransStatusHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransStatusHistory/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransStatusHistory waybillTransStatusHistory = waybillTransStatusHistoryFactoryForTest.newWaybillTransStatusHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransStatusHistory waybillTransStatusHistoryCreated = new WaybillTransStatusHistory();
		when(waybillTransStatusHistoryService.create(waybillTransStatusHistory)).thenReturn(waybillTransStatusHistoryCreated); 
		
		// When
		String viewName = waybillTransStatusHistoryController.create(waybillTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransStatusHistory/form/"+waybillTransStatusHistory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatusHistoryCreated, (WaybillTransStatusHistory) modelMap.get("waybillTransStatusHistory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransStatusHistory waybillTransStatusHistory = waybillTransStatusHistoryFactoryForTest.newWaybillTransStatusHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransStatusHistoryController.create(waybillTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatusHistory, (WaybillTransStatusHistory) modelMap.get("waybillTransStatusHistory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransStatusHistory/create", modelMap.get("saveAction"));
		
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

		WaybillTransStatusHistory waybillTransStatusHistory = waybillTransStatusHistoryFactoryForTest.newWaybillTransStatusHistory();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransStatusHistoryService.create(waybillTransStatusHistory)).thenThrow(exception);
		
		// When
		String viewName = waybillTransStatusHistoryController.create(waybillTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatusHistory, (WaybillTransStatusHistory) modelMap.get("waybillTransStatusHistory"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransStatusHistory/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransStatusHistory.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransStatusHistory waybillTransStatusHistory = waybillTransStatusHistoryFactoryForTest.newWaybillTransStatusHistory();
		Integer id = waybillTransStatusHistory.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransStatusHistory waybillTransStatusHistorySaved = new WaybillTransStatusHistory();
		waybillTransStatusHistorySaved.setId(id);
		when(waybillTransStatusHistoryService.update(waybillTransStatusHistory)).thenReturn(waybillTransStatusHistorySaved); 
		
		// When
		String viewName = waybillTransStatusHistoryController.update(waybillTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransStatusHistory/form/"+waybillTransStatusHistory.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatusHistorySaved, (WaybillTransStatusHistory) modelMap.get("waybillTransStatusHistory"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransStatusHistory waybillTransStatusHistory = waybillTransStatusHistoryFactoryForTest.newWaybillTransStatusHistory();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransStatusHistoryController.update(waybillTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatusHistory, (WaybillTransStatusHistory) modelMap.get("waybillTransStatusHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransStatusHistory/update", modelMap.get("saveAction"));
		
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

		WaybillTransStatusHistory waybillTransStatusHistory = waybillTransStatusHistoryFactoryForTest.newWaybillTransStatusHistory();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransStatusHistoryService.update(waybillTransStatusHistory)).thenThrow(exception);
		
		// When
		String viewName = waybillTransStatusHistoryController.update(waybillTransStatusHistory, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransStatusHistory/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatusHistory, (WaybillTransStatusHistory) modelMap.get("waybillTransStatusHistory"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransStatusHistory/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransStatusHistory.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransStatusHistory waybillTransStatusHistory = waybillTransStatusHistoryFactoryForTest.newWaybillTransStatusHistory();
		Integer id = waybillTransStatusHistory.getId();
		
		// When
		String viewName = waybillTransStatusHistoryController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransStatusHistoryService).delete(id);
		assertEquals("redirect:/waybillTransStatusHistory", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransStatusHistory waybillTransStatusHistory = waybillTransStatusHistoryFactoryForTest.newWaybillTransStatusHistory();
		Integer id = waybillTransStatusHistory.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(waybillTransStatusHistoryService).delete(id);
		
		// When
		String viewName = waybillTransStatusHistoryController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransStatusHistoryService).delete(id);
		assertEquals("redirect:/waybillTransStatusHistory", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "waybillTransStatusHistory.error.delete", exception);
	}
	
	
}
