package academy.wakanda.sorrileadsbe.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicRepository;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.handler.APIException;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadResponse;
import academy.wakanda.sorrileadsbe.lead.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.lead.application.service.EnviadorMensagemLeadService;
import academy.wakanda.sorrileadsbe.lead.application.service.LeadApplicationService;
import academy.wakanda.sorrileadsbe.lead.domain.Lead;

@ExtendWith(MockitoExtension.class)
class LeadApplicationServiceTest {

	@InjectMocks
	private LeadApplicationService leadApplicationService;

	@Mock
	private LeadRepository leadRepository;
	@Mock
	private ClinicRepository clinicRepository;
	@Mock
	private EnviadorMensagemLeadService enviadorMensagemLeadService;

	@Test
	@DisplayName("Testa se cria Lead")
	void createRespondentTest() {
		UUID idClinic = UUID.randomUUID();
		LeadRequest leadRequest = DataHelper.createSimpleJsonLead();
		Lead lead = new Lead(leadRequest, idClinic);
		Clinic clinic = DataHelper.createTestClinic();
		when(leadRepository.save(any(Lead.class))).thenReturn(lead);
		when(clinicRepository.buscaClinicPerId(idClinic)).thenReturn(clinic);
		LeadResponse leadResponse = leadApplicationService.createLead(leadRequest, idClinic);

		verify(clinicRepository, times(1)).buscaClinicPerId(idClinic);
		verify(leadRepository, times(1)).save(any(Lead.class));
		verify(enviadorMensagemLeadService, times(1)).enviaMensagemBoasVindas(any(Lead.class));
		assertNotNull(leadResponse);
	}

	@Test
	@DisplayName("Testa se propaga Apiexception!")
	void createRespondentInvalidTest() {
		// Given
		UUID idClinic = UUID.randomUUID();
		LeadRequest leadRequest = DataHelper.createSimpleJsonLead();

		// Mock the behavior for clinicRepository to throw an exception when clinic is
		// not found
		when(clinicRepository.buscaClinicPerId(idClinic))
				.thenThrow(APIException.build(HttpStatus.NOT_FOUND, "Clínica não encontrada!"));

		// When & Then
		APIException e = assertThrows(APIException.class,
				() -> leadApplicationService.createLead(leadRequest, idClinic));

		assertEquals(HttpStatus.NOT_FOUND, e.getStatusException());
		assertEquals("Clínica não encontrada!", e.getMessage());
	}
}