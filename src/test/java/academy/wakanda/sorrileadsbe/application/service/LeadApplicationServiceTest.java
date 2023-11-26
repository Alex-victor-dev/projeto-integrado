package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicRepository;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
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

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LeadApplicationServiceTest {

    @InjectMocks
    private LeadApplicationService leadApplicationService;

    @Mock
    private LeadRepository leadRepository;
    @Mock
    private ClinicRepository clinicRepository;

    /*@Test
    @DisplayName("Testa se cria Lead")
    void createRespondentTest() {
        // Given
        LeadRequest leadRequest = DataHelper.createSimpleJsonLead();
        Lead testLead = DataHelper.getTestLead();
        when(leadRepository.save(any(Lead.class))).thenReturn(testLead);

        // When
        LeadResponse response = leadApplicationService.createLead(leadRequest, idClinic);

        // Then
        assertEquals(testLead.getIdLead(), response.getIdLead());
        verify(leadRepository, times(2)).save(any(Lead.class));
    }*/

    @Test
    @DisplayName("Testa se cria Lead")
    void createRespondentTest() {
        // Given
        UUID idClinic = UUID.randomUUID();
        Clinic clinic = DataHelper.createTestClinic(); // Não precisa mais do setIdClinic
        when(clinicRepository.findById(idClinic)).thenReturn(Optional.of(clinic));

        LeadRequest leadRequest = DataHelper.createSimpleJsonLead();
        Lead testLead = new Lead(leadRequest);
        testLead.associateWithClinic(clinic); // Associe a clínica ao lead

        when(leadRepository.save(any(Lead.class))).thenReturn(testLead);

        // When
        LeadResponse response = leadApplicationService.createLead(leadRequest, idClinic);

        // Then
        assertEquals(testLead.getIdLead(), response.getIdLead());
        verify(leadRepository).save(any(Lead.class));
    }

    @Test
    @DisplayName("Testa se propaga Apiexception!")
    void createRespondentInvalidTest() {
        // Given
        UUID idClinic = UUID.randomUUID();
        LeadRequest leadRequest = DataHelper.createSimpleJsonLead();

        // Mock the behavior for clinicRepository to simulate clinic not found
        when(clinicRepository.findById(idClinic)).thenReturn(Optional.empty());

        // Configure leadRepository.save to throw an exception
        when(leadRepository.save(any(Lead.class))).thenThrow(APIException.build(HttpStatus.BAD_REQUEST, "Já existe um registro com esse phone!"));

        // When
        APIException e = assertThrows(APIException.class, () -> leadApplicationService.createLead(leadRequest, idClinic));

        // Then
        assertEquals(HttpStatus.BAD_REQUEST, e.getStatusException());
        assertEquals("Já existe um registro com esse phone!", e.getMessage());
    }
}