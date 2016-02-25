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
import org.demo.bean.GlobalCurrencyRateDetail;
import org.demo.bean.GlobalCurrencyRate;
import org.demo.test.GlobalCurrencyRateDetailFactoryForTest;
import org.demo.test.GlobalCurrencyRateFactoryForTest;

//--- Services 
import org.demo.business.service.GlobalCurrencyRateDetailService;
import org.demo.business.service.GlobalCurrencyRateService;

//--- List Items 
import org.demo.web.listitem.GlobalCurrencyRateListItem;

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
public class GlobalCurrencyRateDetailControllerTest {
	
	@InjectMocks
	private GlobalCurrencyRateDetailController globalCurrencyRateDetailController;
	@Mock
	private GlobalCurrencyRateDetailService globalCurrencyRateDetailService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private GlobalCurrencyRateService globalCurrencyRateService; // Injected by Spring

	private GlobalCurrencyRateDetailFactoryForTest globalCurrencyRateDetailFactoryForTest = new GlobalCurrencyRateDetailFactoryForTest();
	private GlobalCurrencyRateFactoryForTest globalCurrencyRateFactoryForTest = new GlobalCurrencyRateFactoryForTest();

	List<GlobalCurrencyRate> globalCurrencyRates = new ArrayList<GlobalCurrencyRate>();

	private void givenPopulateModel() {
		GlobalCurrencyRate globalCurrencyRate1 = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		GlobalCurrencyRate globalCurrencyRate2 = globalCurrencyRateFactoryForTest.newGlobalCurrencyRate();
		List<GlobalCurrencyRate> globalCurrencyRates = new ArrayList<GlobalCurrencyRate>();
		globalCurrencyRates.add(globalCurrencyRate1);
		globalCurrencyRates.add(globalCurrencyRate2);
		when(globalCurrencyRateService.findAll()).thenReturn(globalCurrencyRates);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<GlobalCurrencyRateDetail> list = new ArrayList<GlobalCurrencyRateDetail>();
		when(globalCurrencyRateDetailService.findAll()).thenReturn(list);
		
		// When
		String viewName = globalCurrencyRateDetailController.list(model);
		
		// Then
		assertEquals("globalCurrencyRateDetail/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = globalCurrencyRateDetailController.formForCreate(model);
		
		// Then
		assertEquals("globalCurrencyRateDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((GlobalCurrencyRateDetail)modelMap.get("globalCurrencyRateDetail")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalCurrencyRateDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalCurrencyRateListItem> globalCurrencyRateListItems = (List<GlobalCurrencyRateListItem>) modelMap.get("listOfGlobalCurrencyRateItems");
		assertEquals(2, globalCurrencyRateListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalCurrencyRateDetail globalCurrencyRateDetail = globalCurrencyRateDetailFactoryForTest.newGlobalCurrencyRateDetail();
		Integer id = globalCurrencyRateDetail.getId();
		when(globalCurrencyRateDetailService.findById(id)).thenReturn(globalCurrencyRateDetail);
		
		// When
		String viewName = globalCurrencyRateDetailController.formForUpdate(model, id);
		
		// Then
		assertEquals("globalCurrencyRateDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRateDetail, (GlobalCurrencyRateDetail) modelMap.get("globalCurrencyRateDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalCurrencyRateDetail/update", modelMap.get("saveAction"));
		
		List<GlobalCurrencyRateListItem> globalCurrencyRateListItems = (List<GlobalCurrencyRateListItem>) modelMap.get("listOfGlobalCurrencyRateItems");
		assertEquals(2, globalCurrencyRateListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalCurrencyRateDetail globalCurrencyRateDetail = globalCurrencyRateDetailFactoryForTest.newGlobalCurrencyRateDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalCurrencyRateDetail globalCurrencyRateDetailCreated = new GlobalCurrencyRateDetail();
		when(globalCurrencyRateDetailService.create(globalCurrencyRateDetail)).thenReturn(globalCurrencyRateDetailCreated); 
		
		// When
		String viewName = globalCurrencyRateDetailController.create(globalCurrencyRateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalCurrencyRateDetail/form/"+globalCurrencyRateDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRateDetailCreated, (GlobalCurrencyRateDetail) modelMap.get("globalCurrencyRateDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalCurrencyRateDetail globalCurrencyRateDetail = globalCurrencyRateDetailFactoryForTest.newGlobalCurrencyRateDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalCurrencyRateDetailController.create(globalCurrencyRateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrencyRateDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRateDetail, (GlobalCurrencyRateDetail) modelMap.get("globalCurrencyRateDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalCurrencyRateDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalCurrencyRateListItem> globalCurrencyRateListItems = (List<GlobalCurrencyRateListItem>) modelMap.get("listOfGlobalCurrencyRateItems");
		assertEquals(2, globalCurrencyRateListItems.size());
		
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

		GlobalCurrencyRateDetail globalCurrencyRateDetail = globalCurrencyRateDetailFactoryForTest.newGlobalCurrencyRateDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(globalCurrencyRateDetailService.create(globalCurrencyRateDetail)).thenThrow(exception);
		
		// When
		String viewName = globalCurrencyRateDetailController.create(globalCurrencyRateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrencyRateDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRateDetail, (GlobalCurrencyRateDetail) modelMap.get("globalCurrencyRateDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/globalCurrencyRateDetail/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalCurrencyRateDetail.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<GlobalCurrencyRateListItem> globalCurrencyRateListItems = (List<GlobalCurrencyRateListItem>) modelMap.get("listOfGlobalCurrencyRateItems");
		assertEquals(2, globalCurrencyRateListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		GlobalCurrencyRateDetail globalCurrencyRateDetail = globalCurrencyRateDetailFactoryForTest.newGlobalCurrencyRateDetail();
		Integer id = globalCurrencyRateDetail.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		GlobalCurrencyRateDetail globalCurrencyRateDetailSaved = new GlobalCurrencyRateDetail();
		globalCurrencyRateDetailSaved.setId(id);
		when(globalCurrencyRateDetailService.update(globalCurrencyRateDetail)).thenReturn(globalCurrencyRateDetailSaved); 
		
		// When
		String viewName = globalCurrencyRateDetailController.update(globalCurrencyRateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/globalCurrencyRateDetail/form/"+globalCurrencyRateDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRateDetailSaved, (GlobalCurrencyRateDetail) modelMap.get("globalCurrencyRateDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		GlobalCurrencyRateDetail globalCurrencyRateDetail = globalCurrencyRateDetailFactoryForTest.newGlobalCurrencyRateDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = globalCurrencyRateDetailController.update(globalCurrencyRateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrencyRateDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRateDetail, (GlobalCurrencyRateDetail) modelMap.get("globalCurrencyRateDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalCurrencyRateDetail/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<GlobalCurrencyRateListItem> globalCurrencyRateListItems = (List<GlobalCurrencyRateListItem>) modelMap.get("listOfGlobalCurrencyRateItems");
		assertEquals(2, globalCurrencyRateListItems.size());
		
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

		GlobalCurrencyRateDetail globalCurrencyRateDetail = globalCurrencyRateDetailFactoryForTest.newGlobalCurrencyRateDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(globalCurrencyRateDetailService.update(globalCurrencyRateDetail)).thenThrow(exception);
		
		// When
		String viewName = globalCurrencyRateDetailController.update(globalCurrencyRateDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("globalCurrencyRateDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(globalCurrencyRateDetail, (GlobalCurrencyRateDetail) modelMap.get("globalCurrencyRateDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/globalCurrencyRateDetail/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "globalCurrencyRateDetail.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<GlobalCurrencyRateListItem> globalCurrencyRateListItems = (List<GlobalCurrencyRateListItem>) modelMap.get("listOfGlobalCurrencyRateItems");
		assertEquals(2, globalCurrencyRateListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalCurrencyRateDetail globalCurrencyRateDetail = globalCurrencyRateDetailFactoryForTest.newGlobalCurrencyRateDetail();
		Integer id = globalCurrencyRateDetail.getId();
		
		// When
		String viewName = globalCurrencyRateDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(globalCurrencyRateDetailService).delete(id);
		assertEquals("redirect:/globalCurrencyRateDetail", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		GlobalCurrencyRateDetail globalCurrencyRateDetail = globalCurrencyRateDetailFactoryForTest.newGlobalCurrencyRateDetail();
		Integer id = globalCurrencyRateDetail.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(globalCurrencyRateDetailService).delete(id);
		
		// When
		String viewName = globalCurrencyRateDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(globalCurrencyRateDetailService).delete(id);
		assertEquals("redirect:/globalCurrencyRateDetail", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "globalCurrencyRateDetail.error.delete", exception);
	}
	
	
}
