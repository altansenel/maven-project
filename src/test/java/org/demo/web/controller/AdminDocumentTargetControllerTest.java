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
import org.demo.bean.AdminDocumentTarget;
import org.demo.test.AdminDocumentTargetFactoryForTest;

//--- Services 
import org.demo.business.service.AdminDocumentTargetService;


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
public class AdminDocumentTargetControllerTest {
	
	@InjectMocks
	private AdminDocumentTargetController adminDocumentTargetController;
	@Mock
	private AdminDocumentTargetService adminDocumentTargetService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private AdminDocumentTargetFactoryForTest adminDocumentTargetFactoryForTest = new AdminDocumentTargetFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<AdminDocumentTarget> list = new ArrayList<AdminDocumentTarget>();
		when(adminDocumentTargetService.findAll()).thenReturn(list);
		
		// When
		String viewName = adminDocumentTargetController.list(model);
		
		// Then
		assertEquals("adminDocumentTarget/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = adminDocumentTargetController.formForCreate(model);
		
		// Then
		assertEquals("adminDocumentTarget/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((AdminDocumentTarget)modelMap.get("adminDocumentTarget")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminDocumentTarget/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminDocumentTarget adminDocumentTarget = adminDocumentTargetFactoryForTest.newAdminDocumentTarget();
		Integer id = adminDocumentTarget.getId();
		when(adminDocumentTargetService.findById(id)).thenReturn(adminDocumentTarget);
		
		// When
		String viewName = adminDocumentTargetController.formForUpdate(model, id);
		
		// Then
		assertEquals("adminDocumentTarget/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentTarget, (AdminDocumentTarget) modelMap.get("adminDocumentTarget"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminDocumentTarget/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminDocumentTarget adminDocumentTarget = adminDocumentTargetFactoryForTest.newAdminDocumentTarget();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminDocumentTarget adminDocumentTargetCreated = new AdminDocumentTarget();
		when(adminDocumentTargetService.create(adminDocumentTarget)).thenReturn(adminDocumentTargetCreated); 
		
		// When
		String viewName = adminDocumentTargetController.create(adminDocumentTarget, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminDocumentTarget/form/"+adminDocumentTarget.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentTargetCreated, (AdminDocumentTarget) modelMap.get("adminDocumentTarget"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminDocumentTarget adminDocumentTarget = adminDocumentTargetFactoryForTest.newAdminDocumentTarget();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminDocumentTargetController.create(adminDocumentTarget, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocumentTarget/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentTarget, (AdminDocumentTarget) modelMap.get("adminDocumentTarget"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminDocumentTarget/create", modelMap.get("saveAction"));
		
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

		AdminDocumentTarget adminDocumentTarget = adminDocumentTargetFactoryForTest.newAdminDocumentTarget();
		
		Exception exception = new RuntimeException("test exception");
		when(adminDocumentTargetService.create(adminDocumentTarget)).thenThrow(exception);
		
		// When
		String viewName = adminDocumentTargetController.create(adminDocumentTarget, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocumentTarget/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentTarget, (AdminDocumentTarget) modelMap.get("adminDocumentTarget"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/adminDocumentTarget/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminDocumentTarget.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		AdminDocumentTarget adminDocumentTarget = adminDocumentTargetFactoryForTest.newAdminDocumentTarget();
		Integer id = adminDocumentTarget.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		AdminDocumentTarget adminDocumentTargetSaved = new AdminDocumentTarget();
		adminDocumentTargetSaved.setId(id);
		when(adminDocumentTargetService.update(adminDocumentTarget)).thenReturn(adminDocumentTargetSaved); 
		
		// When
		String viewName = adminDocumentTargetController.update(adminDocumentTarget, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/adminDocumentTarget/form/"+adminDocumentTarget.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentTargetSaved, (AdminDocumentTarget) modelMap.get("adminDocumentTarget"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		AdminDocumentTarget adminDocumentTarget = adminDocumentTargetFactoryForTest.newAdminDocumentTarget();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = adminDocumentTargetController.update(adminDocumentTarget, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocumentTarget/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentTarget, (AdminDocumentTarget) modelMap.get("adminDocumentTarget"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminDocumentTarget/update", modelMap.get("saveAction"));
		
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

		AdminDocumentTarget adminDocumentTarget = adminDocumentTargetFactoryForTest.newAdminDocumentTarget();
		
		Exception exception = new RuntimeException("test exception");
		when(adminDocumentTargetService.update(adminDocumentTarget)).thenThrow(exception);
		
		// When
		String viewName = adminDocumentTargetController.update(adminDocumentTarget, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("adminDocumentTarget/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(adminDocumentTarget, (AdminDocumentTarget) modelMap.get("adminDocumentTarget"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/adminDocumentTarget/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "adminDocumentTarget.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminDocumentTarget adminDocumentTarget = adminDocumentTargetFactoryForTest.newAdminDocumentTarget();
		Integer id = adminDocumentTarget.getId();
		
		// When
		String viewName = adminDocumentTargetController.delete(redirectAttributes, id);
		
		// Then
		verify(adminDocumentTargetService).delete(id);
		assertEquals("redirect:/adminDocumentTarget", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		AdminDocumentTarget adminDocumentTarget = adminDocumentTargetFactoryForTest.newAdminDocumentTarget();
		Integer id = adminDocumentTarget.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(adminDocumentTargetService).delete(id);
		
		// When
		String viewName = adminDocumentTargetController.delete(redirectAttributes, id);
		
		// Then
		verify(adminDocumentTargetService).delete(id);
		assertEquals("redirect:/adminDocumentTarget", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "adminDocumentTarget.error.delete", exception);
	}
	
	
}
