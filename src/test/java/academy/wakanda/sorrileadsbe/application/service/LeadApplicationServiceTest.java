package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;
import academy.wakanda.sorrileadsbe.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.domain.Lead;
import academy.wakanda.sorrileadsbe.handler.APIException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LeadApplicationServiceTest {

    @InjectMocks
    private LeadApplicationService leadApplicationService;

    @Mock
    private LeadRepository leadRepository;

    @Test
    @DisplayName("Testa se cria Lead")
    void createRespondentTest() {
        // Given
        LeadRequest leadRequest = DataHelper.createSimpleJsonLead();
        Lead testLead = DataHelper.getTestRespondent();
        when(leadRepository.save(any(Lead.class))).thenReturn(testLead);

        // When
        LeadResponse response = leadApplicationService.createLead(leadRequest);

        // Then
        assertEquals(testLead.getIdLead(), response.getIdLead());
        verify(leadRepository).save(any(Lead.class));
    }

    @Test
    @DisplayName("Testa se propaga Apiexception!")
    void createRespondentInvalidTest() {
        LeadRequest leadRequest = DataHelper.createSimpleJsonLead();

        when(leadRepository.save(any(Lead.class))).thenThrow(APIException.build(HttpStatus.BAD_REQUEST, "Já existe um registro com esse phone!"));

        APIException e = assertThrows(APIException.class, () -> leadApplicationService.createLead(leadRequest) );
        assertEquals(HttpStatus.BAD_REQUEST, e.getStatusException());
        assertEquals("Já existe um registro com esse phone!", e.getMessage());
    }
}