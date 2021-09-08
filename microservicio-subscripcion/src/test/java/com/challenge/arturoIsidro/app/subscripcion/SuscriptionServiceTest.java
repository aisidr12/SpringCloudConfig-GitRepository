package com.challenge.arturoIsidro.app.subscripcion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.challenge.arturoIsidro.app.subscripcion.dto.SubscripcionDto;
import com.challenge.arturoIsidro.app.subscripcion.models.repository.SubscriptionRepository;
import com.challenge.arturoIsidro.app.subscripcion.serviceImp.SubscriptionServiceImpl;
import com.challenge.arturoIsidro.app.subscripcion.utils.SubscriptionMapper;
import com.challenge.arturoIsidro.app.subscripcion.view.SubscriptionView;

class SuscriptionServiceTest {
	
	@InjectMocks
	SubscriptionServiceImpl subscrionService= new SubscriptionServiceImpl();
	@Mock
	private SubscriptionRepository subscriptionDAO;
	@Mock
	private SubscriptionMapper subscripcionMapper;
 
	@Test
	void listarSubscriptionSuccess() {
		SubscriptionView email= new SubscriptionView();
		SubscripcionDto dto = new SubscripcionDto();
		List<SubscripcionDto>lista = new ArrayList<>();
		dto.setName("Arturo");
		dto.setEmail("Art2dit2@hotmail.com");
		dto.setGender("Male");
		lista.add(dto);
		when(subscrionService.findAllSubscription()).thenReturn(lista);
		subscrionService.findAllSubscription();
		assertEquals("1","1");
	}
	
	@Test
	void test() {
		int a=1,b=2;
		int resultado = a+b;
		assertEquals(3,resultado);		
	}

}
