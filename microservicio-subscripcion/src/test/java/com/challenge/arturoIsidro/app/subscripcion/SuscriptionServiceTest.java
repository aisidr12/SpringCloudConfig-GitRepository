package com.challenge.arturoIsidro.app.subscripcion;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.arturoIsidro.app.subscripcion.dto.SubscripcionDto;
import com.challenge.arturoIsidro.app.subscripcion.exceptions.SubscriptionInternalError;
import com.challenge.arturoIsidro.app.subscripcion.exceptions.SubscriptionNotFound;
import com.challenge.arturoIsidro.app.subscripcion.models.entity.SubscriptionEntity;
import com.challenge.arturoIsidro.app.subscripcion.models.repository.SubscriptionRepository;
import com.challenge.arturoIsidro.app.subscripcion.serviceImp.SubscriptionServiceImpl;
import com.challenge.arturoIsidro.app.subscripcion.utils.SubscriptionMapper;
import com.challenge.arturoIsidro.app.subscripcion.view.SubscriptionView;

@ExtendWith(MockitoExtension.class)
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
		List<SubscripcionDto>listado = subscrionService.findAllSubscription();
		assertEquals(lista.size(), listado.size());
		System.out.println("Lista " + lista);
		System.out.println("Listado " + listado);
		assertEquals(lista,listado);
	}
	@Test
	@DisplayName("Error al crear Subscripcion")
	void creacionSubscrionFail() {
		SubscripcionDto dto = new SubscripcionDto();
		SubscripcionDto dto2 = new SubscripcionDto();
		List<SubscripcionDto>lista = new ArrayList<>();
		dto.setName("Arturo");
		dto.setEmail("Art2dit2@hotmail.com");
		dto.setGender("Male");
		dto.setBirthDate("12/11/1990");
		dto.setNewsletterActivated("0");
		SubscriptionEntity entidad = subscripcionMapper.dtoToEntity(dto);
		try {
			when(subscriptionDAO.save(Matchers.any(SubscriptionEntity.class))).thenReturn(null);
			dto2 = subscrionService.createSubscription(dto);			
			assertEquals(dto.getEmail(), dto2.getEmail());
			assertEquals(dto.getName(), dto2.getName());
		} catch (SubscriptionInternalError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	@DisplayName("Creacion de suscripciones")
	void creacionSusbcripcionSuccess() {
		SubscripcionDto dto = new SubscripcionDto();
		SubscripcionDto dto2 = new SubscripcionDto();
		List<SubscripcionDto>lista = new ArrayList<>();
		dto.setName("Arturo");
		dto.setEmail("Art2dit2@hotmail.com");
		dto.setGender("Male");
		dto.setBirthDate("12/11/1990");
		dto.setNewsletterActivated("0");
		SubscriptionEntity entidad = subscripcionMapper.dtoToEntity(dto);
		try {
			when(subscrionService.createSubscription(dto)).thenReturn(dto);
			dto2 = subscrionService.createSubscription(dto);			
			assertEquals(dto.getEmail(), dto2.getEmail());
			assertEquals(dto.getName(), dto2.getName());
		} catch (SubscriptionInternalError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Buscar suscripcion por Id")
	void findSubscriptionById() {
		SubscripcionDto dto = new SubscripcionDto();
		dto.setIdSubscripcion("1L");
		dto.setName("Arturo");
		dto.setEmail("Art2dit2@hotmail.com");
		dto.setGender("Male");
		dto.setBirthDate("12/11/1990");
		dto.setNewsletterActivated("0");
		try {
			when(subscrionService.findSubscriptionById(1L)).thenReturn(dto);
			assertEquals("Arturo", dto.getName());
			assertEquals("Art2dit2@hotmail.com", dto.getEmail());
			assertEquals("Male",dto.getGender());
		} catch (SubscriptionNotFound e) {
			System.out.println(e.getMsgError());
		}
	}
	
	
}
