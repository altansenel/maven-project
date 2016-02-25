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
import org.demo.bean.ChqbllTransDetail;
import org.demo.bean.ChqbllPayrollDetail;
import org.demo.bean.ChqbllTrans;
import org.demo.test.ChqbllTransDetailFactoryForTest;
import org.demo.test.ChqbllPayrollDetailFactoryForTest;
import org.demo.test.ChqbllTransFactoryForTest;

//--- Services 
import org.demo.business.service.ChqbllTransDetailService;
import org.demo.business.service.ChqbllPayrollDetailService;
import org.demo.business.service.ChqbllTransService;

//--- List Items 
import org.demo.web.listitem.ChqbllPayrollDetailListItem;
import org.demo.web.listitem.ChqbllTransListItem;

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
public class ChqbllTransDetailControllerTest {
	
	@InjectMocks
	private ChqbllTransDetailController chqbllTransDetailController;
	@Mock
	private ChqbllTransDetailService chqbllTransDetailService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private ChqbllPayrollDetailService chqbllPayrollDetailService; // Injected by Spring
	@Mock
	private ChqbllTransService chqbllTransService; // Injected by Spring

	private ChqbllTransDetailFactoryForTest chqbllTransDetailFactoryForTest = new ChqbllTransDetailFactoryForTest();
	private ChqbllPayrollDetailFactoryForTest chqbllPayrollDetailFactoryForTest = new ChqbllPayrollDetailFactoryForTest();
	private ChqbllTransFactoryForTest chqbllTransFactoryForTest = new ChqbllTransFactoryForTest();

	List<ChqbllPayrollDetail> chqbllPayrollDetails = new ArrayList<ChqbllPayrollDetail>();
	List<ChqbllTrans> chqbllTranss = new ArrayList<ChqbllTrans>();

	private void givenPopulateModel() {
		ChqbllPayrollDetail chqbllPayrollDetail1 = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		ChqbllPayrollDetail chqbllPayrollDetail2 = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		List<ChqbllPayrollDetail> chqbllPayrollDetails = new ArrayList<ChqbllPayrollDetail>();
		chqbllPayrollDetails.add(chqbllPayrollDetail1);
		chqbllPayrollDetails.add(chqbllPayrollDetail2);
		when(chqbllPayrollDetailService.findAll()).thenReturn(chqbllPayrollDetails);

		ChqbllTrans chqbllTrans1 = chqbllTransFactoryForTest.newChqbllTrans();
		ChqbllTrans chqbllTrans2 = chqbllTransFactoryForTest.newChqbllTrans();
		List<ChqbllTrans> chqbllTranss = new ArrayList<ChqbllTrans>();
		chqbllTranss.add(chqbllTrans1);
		chqbllTranss.add(chqbllTrans2);
		when(chqbllTransService.findAll()).thenReturn(chqbllTranss);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<ChqbllTransDetail> list = new ArrayList<ChqbllTransDetail>();
		when(chqbllTransDetailService.findAll()).thenReturn(list);
		
		// When
		String viewName = chqbllTransDetailController.list(model);
		
		// Then
		assertEquals("chqbllTransDetail/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = chqbllTransDetailController.formForCreate(model);
		
		// Then
		assertEquals("chqbllTransDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ChqbllTransDetail)modelMap.get("chqbllTransDetail")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllTransDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllTransListItem> chqbllTransListItems = (List<ChqbllTransListItem>) modelMap.get("listOfChqbllTransItems");
		assertEquals(2, chqbllTransListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllTransDetail chqbllTransDetail = chqbllTransDetailFactoryForTest.newChqbllTransDetail();
		Integer id = chqbllTransDetail.getId();
		when(chqbllTransDetailService.findById(id)).thenReturn(chqbllTransDetail);
		
		// When
		String viewName = chqbllTransDetailController.formForUpdate(model, id);
		
		// Then
		assertEquals("chqbllTransDetail/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTransDetail, (ChqbllTransDetail) modelMap.get("chqbllTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllTransDetail/update", modelMap.get("saveAction"));
		
		List<ChqbllTransListItem> chqbllTransListItems = (List<ChqbllTransListItem>) modelMap.get("listOfChqbllTransItems");
		assertEquals(2, chqbllTransListItems.size());
		
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllTransDetail chqbllTransDetail = chqbllTransDetailFactoryForTest.newChqbllTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllTransDetail chqbllTransDetailCreated = new ChqbllTransDetail();
		when(chqbllTransDetailService.create(chqbllTransDetail)).thenReturn(chqbllTransDetailCreated); 
		
		// When
		String viewName = chqbllTransDetailController.create(chqbllTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllTransDetail/form/"+chqbllTransDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTransDetailCreated, (ChqbllTransDetail) modelMap.get("chqbllTransDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllTransDetail chqbllTransDetail = chqbllTransDetailFactoryForTest.newChqbllTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllTransDetailController.create(chqbllTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTransDetail, (ChqbllTransDetail) modelMap.get("chqbllTransDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllTransDetail/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllTransListItem> chqbllTransListItems = (List<ChqbllTransListItem>) modelMap.get("listOfChqbllTransItems");
		assertEquals(2, chqbllTransListItems.size());
		
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

		ChqbllTransDetail chqbllTransDetail = chqbllTransDetailFactoryForTest.newChqbllTransDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllTransDetailService.create(chqbllTransDetail)).thenThrow(exception);
		
		// When
		String viewName = chqbllTransDetailController.create(chqbllTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTransDetail, (ChqbllTransDetail) modelMap.get("chqbllTransDetail"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllTransDetail/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllTransDetail.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllTransListItem> chqbllTransListItems = (List<ChqbllTransListItem>) modelMap.get("listOfChqbllTransItems");
		assertEquals(2, chqbllTransListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllTransDetail chqbllTransDetail = chqbllTransDetailFactoryForTest.newChqbllTransDetail();
		Integer id = chqbllTransDetail.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllTransDetail chqbllTransDetailSaved = new ChqbllTransDetail();
		chqbllTransDetailSaved.setId(id);
		when(chqbllTransDetailService.update(chqbllTransDetail)).thenReturn(chqbllTransDetailSaved); 
		
		// When
		String viewName = chqbllTransDetailController.update(chqbllTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllTransDetail/form/"+chqbllTransDetail.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTransDetailSaved, (ChqbllTransDetail) modelMap.get("chqbllTransDetail"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllTransDetail chqbllTransDetail = chqbllTransDetailFactoryForTest.newChqbllTransDetail();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllTransDetailController.update(chqbllTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTransDetail, (ChqbllTransDetail) modelMap.get("chqbllTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllTransDetail/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ChqbllTransListItem> chqbllTransListItems = (List<ChqbllTransListItem>) modelMap.get("listOfChqbllTransItems");
		assertEquals(2, chqbllTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
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

		ChqbllTransDetail chqbllTransDetail = chqbllTransDetailFactoryForTest.newChqbllTransDetail();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllTransDetailService.update(chqbllTransDetail)).thenThrow(exception);
		
		// When
		String viewName = chqbllTransDetailController.update(chqbllTransDetail, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllTransDetail/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllTransDetail, (ChqbllTransDetail) modelMap.get("chqbllTransDetail"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllTransDetail/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllTransDetail.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<ChqbllTransListItem> chqbllTransListItems = (List<ChqbllTransListItem>) modelMap.get("listOfChqbllTransItems");
		assertEquals(2, chqbllTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllTransDetail chqbllTransDetail = chqbllTransDetailFactoryForTest.newChqbllTransDetail();
		Integer id = chqbllTransDetail.getId();
		
		// When
		String viewName = chqbllTransDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllTransDetailService).delete(id);
		assertEquals("redirect:/chqbllTransDetail", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllTransDetail chqbllTransDetail = chqbllTransDetailFactoryForTest.newChqbllTransDetail();
		Integer id = chqbllTransDetail.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(chqbllTransDetailService).delete(id);
		
		// When
		String viewName = chqbllTransDetailController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllTransDetailService).delete(id);
		assertEquals("redirect:/chqbllTransDetail", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "chqbllTransDetail.error.delete", exception);
	}
	
	
}
