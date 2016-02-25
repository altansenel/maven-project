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
import org.demo.bean.SaleSeller;
import org.demo.test.SaleSellerFactoryForTest;

//--- Services 
import org.demo.business.service.SaleSellerService;


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
public class SaleSellerControllerTest {
	
	@InjectMocks
	private SaleSellerController saleSellerController;
	@Mock
	private SaleSellerService saleSellerService;
	@Mock
	private MessageHelper messageHelper;
	@Mock
	private MessageSource messageSource;

	private SaleSellerFactoryForTest saleSellerFactoryForTest = new SaleSellerFactoryForTest();


	private void givenPopulateModel() {
	}

	@Test
	public void list() {
		// Given
		Model model = new ExtendedModelMap();
		
		List<SaleSeller> list = new ArrayList<SaleSeller>();
		when(saleSellerService.findAll()).thenReturn(list);
		
		// When
		String viewName = saleSellerController.list(model);
		
		// Then
		assertEquals("saleSeller/list", viewName);
		Map<String,?> modelMap = model.asMap();
		assertEquals(list, modelMap.get("list"));
	}
	
	@Test
	public void formForCreate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		// When
		String viewName = saleSellerController.formForCreate(model);
		
		// Then
		assertEquals("saleSeller/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertNull(((SaleSeller)modelMap.get("saleSeller")).getId());
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/saleSeller/create", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void formForUpdate() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SaleSeller saleSeller = saleSellerFactoryForTest.newSaleSeller();
		Integer id = saleSeller.getId();
		when(saleSellerService.findById(id)).thenReturn(saleSeller);
		
		// When
		String viewName = saleSellerController.formForUpdate(model, id);
		
		// Then
		assertEquals("saleSeller/form", viewName);
		
		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleSeller, (SaleSeller) modelMap.get("saleSeller"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/saleSeller/update", modelMap.get("saveAction"));
		
	}
	
	@Test
	public void createOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		SaleSeller saleSeller = saleSellerFactoryForTest.newSaleSeller();
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		SaleSeller saleSellerCreated = new SaleSeller();
		when(saleSellerService.create(saleSeller)).thenReturn(saleSellerCreated); 
		
		// When
		String viewName = saleSellerController.create(saleSeller, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/saleSeller/form/"+saleSeller.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleSellerCreated, (SaleSeller) modelMap.get("saleSeller"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void createBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SaleSeller saleSeller = saleSellerFactoryForTest.newSaleSeller();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = saleSellerController.create(saleSeller, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("saleSeller/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleSeller, (SaleSeller) modelMap.get("saleSeller"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/saleSeller/create", modelMap.get("saveAction"));
		
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

		SaleSeller saleSeller = saleSellerFactoryForTest.newSaleSeller();
		
		Exception exception = new RuntimeException("test exception");
		when(saleSellerService.create(saleSeller)).thenThrow(exception);
		
		// When
		String viewName = saleSellerController.create(saleSeller, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("saleSeller/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleSeller, (SaleSeller) modelMap.get("saleSeller"));
		assertEquals("create", modelMap.get("mode"));
		assertEquals("/saleSeller/create", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "saleSeller.error.create", exception);
		
	}

	@Test
	public void updateOk() {
		// Given
		Model model = new ExtendedModelMap();
		
		SaleSeller saleSeller = saleSellerFactoryForTest.newSaleSeller();
		Integer id = saleSeller.getId();

		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		SaleSeller saleSellerSaved = new SaleSeller();
		saleSellerSaved.setId(id);
		when(saleSellerService.update(saleSeller)).thenReturn(saleSellerSaved); 
		
		// When
		String viewName = saleSellerController.update(saleSeller, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("redirect:/saleSeller/form/"+saleSeller.getId(), viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleSellerSaved, (SaleSeller) modelMap.get("saleSeller"));
		assertEquals(null, modelMap.get("mode"));
		assertEquals(null, modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"save.ok"));
	}

	@Test
	public void updateBindingResultErrors() {
		// Given
		Model model = new ExtendedModelMap();
		
		givenPopulateModel();
		
		SaleSeller saleSeller = saleSellerFactoryForTest.newSaleSeller();
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		
		// When
		String viewName = saleSellerController.update(saleSeller, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("saleSeller/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleSeller, (SaleSeller) modelMap.get("saleSeller"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/saleSeller/update", modelMap.get("saveAction"));
		
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

		SaleSeller saleSeller = saleSellerFactoryForTest.newSaleSeller();
		
		Exception exception = new RuntimeException("test exception");
		when(saleSellerService.update(saleSeller)).thenThrow(exception);
		
		// When
		String viewName = saleSellerController.update(saleSeller, bindingResult, model, redirectAttributes, httpServletRequest);
		
		// Then
		assertEquals("saleSeller/form", viewName);

		Map<String,?> modelMap = model.asMap();
		
		assertEquals(saleSeller, (SaleSeller) modelMap.get("saleSeller"));
		assertEquals("update", modelMap.get("mode"));
		assertEquals("/saleSeller/update", modelMap.get("saveAction"));
		
		Mockito.verify(messageHelper).addException(model, "saleSeller.error.update", exception);
		
	}
	

	@Test
	public void deleteOK() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		SaleSeller saleSeller = saleSellerFactoryForTest.newSaleSeller();
		Integer id = saleSeller.getId();
		
		// When
		String viewName = saleSellerController.delete(redirectAttributes, id);
		
		// Then
		verify(saleSellerService).delete(id);
		assertEquals("redirect:/saleSeller", viewName);
		Mockito.verify(messageHelper).addMessage(redirectAttributes, new Message(MessageType.SUCCESS,"delete.ok"));
	}

	@Test
	public void deleteException() {
		// Given
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		
		SaleSeller saleSeller = saleSellerFactoryForTest.newSaleSeller();
		Integer id = saleSeller.getId();
		
		Exception exception = new RuntimeException("test exception");
		doThrow(exception).when(saleSellerService).delete(id);
		
		// When
		String viewName = saleSellerController.delete(redirectAttributes, id);
		
		// Then
		verify(saleSellerService).delete(id);
		assertEquals("redirect:/saleSeller", viewName);
		Mockito.verify(messageHelper).addException(redirectAttributes, "saleSeller.error.delete", exception);
	}
	
	
}
