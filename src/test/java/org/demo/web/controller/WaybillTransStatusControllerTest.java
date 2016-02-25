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
import org.demo.bean.WaybillTransStatus;
//--- Services 
import org.demo.business.service.WaybillTransStatusService;
import org.demo.test.WaybillTransStatusFactoryForTest;
import org.demo.web.common.Message;
import org.demo.web.common.MessageHelper;
import org.demo.web.common.MessageType;
//--- List Items 
import org.demo.web.listitem.WaybillTransStatusListItem;
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
public class WaybillTransStatusControllerTest {
	
	@InjectMocks
	private WaybillTransStatusController waybillTransStatusController;
	@Mock
	private WaybillTransStatusService waybillTransStatusService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private WaybillTransStatusFactoryForTest waybillTransStatusFactoryForTest = new WaybillTransStatusFactoryForTest();

	List<WaybillTransStatus> waybillTransStatuss = new ArrayList<WaybillTransStatus>();

	private void givenPopulateModel() {
		WaybillTransStatus waybillTransStatus1 = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		WaybillTransStatus waybillTransStatus2 = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		List<WaybillTransStatus> waybillTransStatuss = new ArrayList<WaybillTransStatus>();
		waybillTransStatuss.add(waybillTransStatus1);
		waybillTransStatuss.add(waybillTransStatus2);
		when(waybillTransStatusService.findAll()).thenReturn(waybillTransStatuss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<WaybillTransStatus> list = new ArrayList<WaybillTransStatus>();
		when(waybillTransStatusService.findAll()).thenReturn(list);
		
		// When
		String viewName = waybillTransStatusController.list(model);
		
		// Then
		assertEquals("waybillTransStatus/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = waybillTransStatusController.formForCreate(model);
		
		// Then
		assertEquals("waybillTransStatus/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((WaybillTransStatus)modelMap.get("waybillTransStatus")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransStatus/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransStatus waybillTransStatus = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		Integer id = waybillTransStatus.getId();
		when(waybillTransStatusService.findById(id)).thenReturn(waybillTransStatus);
		
		// When
		String viewName = waybillTransStatusController.formForUpdate(model, id);
		
		// Then
		assertEquals("waybillTransStatus/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatus, (WaybillTransStatus) modelMap.get("waybillTransStatus"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransStatus/update", modelMap.get("saveAction"));
		
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransStatus waybillTransStatus = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransStatus waybillTransStatusCreated = new WaybillTransStatus();
		when(waybillTransStatusService.create(waybillTransStatus)).thenReturn(waybillTransStatusCreated); 
		
		// When
		String viewName = waybillTransStatusController.create(waybillTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransStatus/form/"+waybillTransStatus.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatusCreated, (WaybillTransStatus) modelMap.get("waybillTransStatus"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransStatus waybillTransStatus = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransStatusController.create(waybillTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatus, (WaybillTransStatus) modelMap.get("waybillTransStatus"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransStatus/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
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

		WaybillTransStatus waybillTransStatus = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransStatusService.create(waybillTransStatus)).thenThrow(exception);
		
		// When
		String viewName = waybillTransStatusController.create(waybillTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatus, (WaybillTransStatus) modelMap.get("waybillTransStatus"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/waybillTransStatus/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransStatus.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		WaybillTransStatus waybillTransStatus = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		Integer id = waybillTransStatus.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		WaybillTransStatus waybillTransStatusSaved = new WaybillTransStatus();
		waybillTransStatusSaved.setId(id);
		when(waybillTransStatusService.update(waybillTransStatus)).thenReturn(waybillTransStatusSaved); 
		
		// When
		String viewName = waybillTransStatusController.update(waybillTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/waybillTransStatus/form/"+waybillTransStatus.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatusSaved, (WaybillTransStatus) modelMap.get("waybillTransStatus"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		WaybillTransStatus waybillTransStatus = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = waybillTransStatusController.update(waybillTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatus, (WaybillTransStatus) modelMap.get("waybillTransStatus"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransStatus/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
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

		WaybillTransStatus waybillTransStatus = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		
		Exception exception = new RuntimeException("test exception");
		when(waybillTransStatusService.update(waybillTransStatus)).thenThrow(exception);
		
		// When
		String viewName = waybillTransStatusController.update(waybillTransStatus, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("waybillTransStatus/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(waybillTransStatus, (WaybillTransStatus) modelMap.get("waybillTransStatus"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/waybillTransStatus/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "waybillTransStatus.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<WaybillTransStatusListItem> waybillTransStatusListItems = (List<WaybillTransStatusListItem>) modelMap.get("listOfWaybillTransStatusItems");
		assertEquals(2, waybillTransStatusListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransStatus waybillTransStatus = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		Integer id = waybillTransStatus.getId();
		
		// When
		String viewName = waybillTransStatusController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransStatusService).delete(id);
		assertEquals("redirect:/waybillTransStatus", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		WaybillTransStatus waybillTransStatus = waybillTransStatusFactoryForTest.newWaybillTransStatus();
		Integer id = waybillTransStatus.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(waybillTransStatusService).delete(id);
		
		// When
		String viewName = waybillTransStatusController.delete(redirectAttributes, id);
		
		// Then
		verify(waybillTransStatusService).delete(id);
		assertEquals("redirect:/waybillTransStatus", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "waybillTransStatus.error.delete", exception);
	}
	
	
}
