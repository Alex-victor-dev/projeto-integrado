package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicRepository;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.service.CommunicationService;
import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;
import academy.wakanda.sorrileadsbe.handler.APIException;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadResponse;
import academy.wakanda.sorrileadsbe.lead.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.lead.application.service.LeadApplicationService;
import academy.wakanda.sorrileadsbe.lead.domain.Lead;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LeadApplicationServiceTest {

    @InjectMocks
    private LeadApplicationService leadApplicationService;

    @Mock
    private LeadRepository leadRepository;
    @Mock
    private ClinicRepository clinicRepository;

    @Test
    @DisplayName("Testa se cria Lead")
    void createRespondentTest() {
        // Given
        UUID idClinic = UUID.randomUUID();
        Clinic clinic = DataHelper.createTestClinic(); // Não precisa mais do setIdClinic
        when(clinicRepository.buscaClinicPerId(idClinic)).thenReturn(clinic);

        LeadRequest leadRequest = DataHelper.createSimpleJsonLead();
        Lead testLead = new Lead(leadRequest, idClinic);
        when(leadRepository.save(any(Lead.class))).thenReturn(testLead);

        // Mock do CommunicationService para evitar a segunda chamada de save dentro de enviaMensagem
        CommunicationService mockCommunicationService = mock(CommunicationService.class);
        when(mockCommunicationService.sendMessage(any())).thenReturn(new MessageResponse());

        // Atualize a injeção de dependência no leadApplicationService
        leadApplicationService = new LeadApplicationService(leadRepository, mockCommunicationService, clinicRepository);

        // When
        LeadResponse response = leadApplicationService.createLead(leadRequest, idClinic);

        // Then
        assertEquals(testLead.getIdLead(), response.getIdLead());
        verify(leadRepository, atLeastOnce()).save(any(Lead.class)); // Verifica se save foi chamado pelo menos uma vez
    }

    @Test
    @DisplayName("Testa se propaga Apiexception!")
    void createRespondentInvalidTest() {
        // Given
        UUID idClinic = UUID.randomUUID();
        LeadRequest leadRequest = DataHelper.createSimpleJsonLead();

        // Mock the behavior for clinicRepository to throw an exception when clinic is not found
        when(clinicRepository.buscaClinicPerId(idClinic))
                .thenThrow(APIException.build(HttpStatus.NOT_FOUND, "Clínica não encontrada!"));

        // When & Then
        APIException e = assertThrows(APIException.class, () -> leadApplicationService.createLead(leadRequest, idClinic));

        assertEquals(HttpStatus.NOT_FOUND, e.getStatusException());
        assertEquals("Clínica não encontrada!", e.getMessage());
    }
}