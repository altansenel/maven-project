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
import org.demo.bean.ChqbllDetailPartial;
import org.demo.bean.Safe;
import org.demo.bean.SafeTrans;
import org.demo.bean.ChqbllPayrollDetail;
import org.demo.test.ChqbllDetailPartialFactoryForTest;
import org.demo.test.SafeFactoryForTest;
import org.demo.test.SafeTransFactoryForTest;
import org.demo.test.ChqbllPayrollDetailFactoryForTest;

//--- Services 
import org.demo.business.service.ChqbllDetailPartialService;
import org.demo.business.service.SafeService;
import org.demo.business.service.SafeTransService;
import org.demo.business.service.ChqbllPayrollDetailService;

//--- List Items 
import org.demo.web.listitem.SafeListItem;
import org.demo.web.listitem.SafeTransListItem;
import org.demo.web.listitem.ChqbllPayrollDetailListItem;

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
public class ChqbllDetailPartialControllerTest {
	
	@InjectMocks
	private ChqbllDetailPartialController chqbllDetailPartialController;
	@Mock
	private ChqbllDetailPartialService chqbllDetailPartialService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;
	@Mock
	private SafeService safeService; // Injected by Spring
	@Mock
	private SafeTransService safeTransService; // Injected by Spring
	@Mock
	private ChqbllPayrollDetailService chqbllPayrollDetailService; // Injected by Spring

	private ChqbllDetailPartialFactoryForTest chqbllDetailPartialFactoryForTest = new ChqbllDetailPartialFactoryForTest();
	private SafeFactoryForTest safeFactoryForTest = new SafeFactoryForTest();
	private SafeTransFactoryForTest safeTransFactoryForTest = new SafeTransFactoryForTest();
	private ChqbllPayrollDetailFactoryForTest chqbllPayrollDetailFactoryForTest = new ChqbllPayrollDetailFactoryForTest();

	List<Safe> safes = new ArrayList<Safe>();
	List<SafeTrans> safeTranss = new ArrayList<SafeTrans>();
	List<ChqbllPayrollDetail> chqbllPayrollDetails = new ArrayList<ChqbllPayrollDetail>();

	private void givenPopulateModel() {
		Safe safe1 = safeFactoryForTest.newSafe();
		Safe safe2 = safeFactoryForTest.newSafe();
		List<Safe> safes = new ArrayList<Safe>();
		safes.add(safe1);
		safes.add(safe2);
		when(safeService.findAll()).thenReturn(safes);

		SafeTrans safeTrans1 = safeTransFactoryForTest.newSafeTrans();
		SafeTrans safeTrans2 = safeTransFactoryForTest.newSafeTrans();
		List<SafeTrans> safeTranss = new ArrayList<SafeTrans>();
		safeTranss.add(safeTrans1);
		safeTranss.add(safeTrans2);
		when(safeTransService.findAll()).thenReturn(safeTranss);

		ChqbllPayrollDetail chqbllPayrollDetail1 = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		ChqbllPayrollDetail chqbllPayrollDetail2 = chqbllPayrollDetailFactoryForTest.newChqbllPayrollDetail();
		List<ChqbllPayrollDetail> chqbllPayrollDetails = new ArrayList<ChqbllPayrollDetail>();
		chqbllPayrollDetails.add(chqbllPayrollDetail1);
		chqbllPayrollDetails.add(chqbllPayrollDetail2);
		when(chqbllPayrollDetailService.findAll()).thenReturn(chqbllPayrollDetails);

	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<ChqbllDetailPartial> list = new ArrayList<ChqbllDetailPartial>();
		when(chqbllDetailPartialService.findAll()).thenReturn(list);
		
		// When
		String viewName = chqbllDetailPartialController.list(model);
		
		// Then
		assertEquals("chqbllDetailPartial/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = chqbllDetailPartialController.formForCreate(model);
		
		// Then
		assertEquals("chqbllDetailPartial/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((ChqbllDetailPartial)modelMap.get("chqbllDetailPartial")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllDetailPartial/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeTransListItem> safeTransListItems = (List<SafeTransListItem>) modelMap.get("listOfSafeTransItems");
		assertEquals(2, safeTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		Integer id = chqbllDetailPartial.getId();
		when(chqbllDetailPartialService.findById(id)).thenReturn(chqbllDetailPartial);
		
		// When
		String viewName = chqbllDetailPartialController.formForUpdate(model, id);
		
		// Then
		assertEquals("chqbllDetailPartial/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailPartial, (ChqbllDetailPartial) modelMap.get("chqbllDetailPartial"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllDetailPartial/update", modelMap.get("saveAction"));
		
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		List<SafeTransListItem> safeTransListItems = (List<SafeTransListItem>) modelMap.get("listOfSafeTransItems");
		assertEquals(2, safeTransListItems.size());
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllDetailPartial chqbllDetailPartialCreated = new ChqbllDetailPartial();
		when(chqbllDetailPartialService.create(chqbllDetailPartial)).thenReturn(chqbllDetailPartialCreated); 
		
		// When
		String viewName = chqbllDetailPartialController.create(chqbllDetailPartial, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllDetailPartial/form/"+chqbllDetailPartial.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailPartialCreated, (ChqbllDetailPartial) modelMap.get("chqbllDetailPartial"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllDetailPartialController.create(chqbllDetailPartial, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllDetailPartial/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailPartial, (ChqbllDetailPartial) modelMap.get("chqbllDetailPartial"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllDetailPartial/create", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeTransListItem> safeTransListItems = (List<SafeTransListItem>) modelMap.get("listOfSafeTransItems");
		assertEquals(2, safeTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
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

		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllDetailPartialService.create(chqbllDetailPartial)).thenThrow(exception);
		
		// When
		String viewName = chqbllDetailPartialController.create(chqbllDetailPartial, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllDetailPartial/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailPartial, (ChqbllDetailPartial) modelMap.get("chqbllDetailPartial"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/chqbllDetailPartial/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllDetailPartial.error.create", exception);
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeTransListItem> safeTransListItems = (List<SafeTransListItem>) modelMap.get("listOfSafeTransItems");
		assertEquals(2, safeTransListItems.size());
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		Integer id = chqbllDetailPartial.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		ChqbllDetailPartial chqbllDetailPartialSaved = new ChqbllDetailPartial();
		chqbllDetailPartialSaved.setId(id);
		when(chqbllDetailPartialService.update(chqbllDetailPartial)).thenReturn(chqbllDetailPartialSaved); 
		
		// When
		String viewName = chqbllDetailPartialController.update(chqbllDetailPartial, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/chqbllDetailPartial/form/"+chqbllDetailPartial.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailPartialSaved, (ChqbllDetailPartial) modelMap.get("chqbllDetailPartial"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = chqbllDetailPartialController.update(chqbllDetailPartial, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllDetailPartial/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailPartial, (ChqbllDetailPartial) modelMap.get("chqbllDetailPartial"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllDetailPartial/update", modelMap.get("saveAction"));
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeTransListItem> safeTransListItems = (List<SafeTransListItem>) modelMap.get("listOfSafeTransItems");
		assertEquals(2, safeTransListItems.size());
		
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

		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		
		Exception exception = new RuntimeException("test exception");
		when(chqbllDetailPartialService.update(chqbllDetailPartial)).thenThrow(exception);
		
		// When
		String viewName = chqbllDetailPartialController.update(chqbllDetailPartial, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("chqbllDetailPartial/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(chqbllDetailPartial, (ChqbllDetailPartial) modelMap.get("chqbllDetailPartial"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/chqbllDetailPartial/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "chqbllDetailPartial.error.update", exception);
		
		@SuppressWarnings("unchecked")
		List<ChqbllPayrollDetailListItem> chqbllPayrollDetailListItems = (List<ChqbllPayrollDetailListItem>) modelMap.get("listOfChqbllPayrollDetailItems");
		assertEquals(2, chqbllPayrollDetailListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeListItem> safeListItems = (List<SafeListItem>) modelMap.get("listOfSafeItems");
		assertEquals(2, safeListItems.size());
		
		@SuppressWarnings("unchecked")
		List<SafeTransListItem> safeTransListItems = (List<SafeTransListItem>) modelMap.get("listOfSafeTransItems");
		assertEquals(2, safeTransListItems.size());
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		Integer id = chqbllDetailPartial.getId();
		
		// When
		String viewName = chqbllDetailPartialController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllDetailPartialService).delete(id);
		assertEquals("redirect:/chqbllDetailPartial", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		ChqbllDetailPartial chqbllDetailPartial = chqbllDetailPartialFactoryForTest.newChqbllDetailPartial();
		Integer id = chqbllDetailPartial.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(chqbllDetailPartialService).delete(id);
		
		// When
		String viewName = chqbllDetailPartialController.delete(redirectAttributes, id);
		
		// Then
		verify(chqbllDetailPartialService).delete(id);
		assertEquals("redirect:/chqbllDetailPartial", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "chqbllDetailPartial.error.delete", exception);
	}
	
	
}
