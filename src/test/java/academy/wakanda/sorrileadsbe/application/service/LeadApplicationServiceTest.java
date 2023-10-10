package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;
import academy.wakanda.sorrileadsbe.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Lead;
import academy.wakanda.sorrileadsbe.handler.APIException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

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
    @DisplayName("Testa se cria respondent")
    void createRespondentTest() {
        // Given
        LeadRequest leadRequest = DataHelper.createSampleRespondentRequest();
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
        LeadRequest leadRequest = DataHelper.createSampleRespondentRequest();

        when(leadRepository.save(any(Lead.class))).thenThrow(APIException.build(HttpStatus.BAD_REQUEST, "Já existe um registro com esse phone!"));

        APIException e = assertThrows(APIException.class, () -> leadApplicationService.createLead(leadRequest) );
        assertEquals(HttpStatus.BAD_REQUEST, e.getStatusException());
        assertEquals("Já existe um registro com esse phone!", e.getMessage());
    }

    @Test
    @DisplayName("testa se traz uma lista geral com todos respondents")
    void searchAllRespondentsTest() {
        // Given
        List<Lead> leadList = List.of(DataHelper.getTestRespondent());
        when(leadRepository.searchAllRespondents()).thenReturn(leadList);

        // When
        List<LeadListResponse> responses = leadApplicationService.searchAllRespondents();

        // Then
        assertFalse(responses.isEmpty());
        assertEquals(leadList.size(), responses.size());
        verify(leadRepository).searchAllRespondents();
    }

    @Test
    @DisplayName("testa trazer uma lista de respondents por escolha")
    void searchAllRespondentsPerChoiceTest() {
        // Given
        MultipleChoice choice = MultipleChoice.BOTOX;
        List<Lead> leads = List.of(DataHelper.getTestRespondent());
        when(leadRepository.searchAllRespondentsPerChoice(choice)).thenReturn(leads);

        // When
        List<LeadListResponsePerChoice> responses = leadApplicationService.searchAllRespondentsPerChoice(choice);

        // Then
        assertFalse(responses.isEmpty());
        assertEquals(leads.size(), responses.size());
        verify(leadRepository).searchAllRespondentsPerChoice(choice);
    }
    @Test
    @DisplayName("testa buscar um respondent por Id")
    void getRespondentPerIdTest() {
        // Given
        UUID id = UUID.randomUUID();
        Lead lead = DataHelper.getTestRespondent();
        when(leadRepository.getRespondentPerId(id)).thenReturn(lead);

        // When
        LeadDetailResponse response = leadApplicationService.getRespondentPerId(id);

        // Then
        assertEquals(lead.getName(), response.getName());
        verify(leadRepository).getRespondentPerId(id);
    }
}