package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;
import academy.wakanda.sorrileadsbe.application.repository.RespondentRepository;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class RespondentApplicationServiceTest {


    @InjectMocks
    private RespondentApplicationService respondentApplicationService;

    @Mock
    private RespondentRepository respondentRepository;


    @Test
    @DisplayName("Testa se cria respondent")
    void createRespondentTest() {
        // Given
        RespondentRequest respondentRequest = DataHelper.getTestRespondentRequest();
        Respondent testRespondent = DataHelper.getTestRespondent();
        when(respondentRepository.save(any(Respondent.class))).thenReturn(testRespondent);

        // When
        RespondentResponse response = respondentApplicationService.createRespondent(respondentRequest);

        // Then
        assertEquals(testRespondent.getIdRespondent(), response.getIdRespondent());
        verify(respondentRepository).save(any(Respondent.class));
    }

    @Test
    @DisplayName("testa se traz uma lista geral com todos respondents")
    void searchAllRespondentsTest() {
        // Given
        List<Respondent> respondentList = List.of(DataHelper.getTestRespondent());
        when(respondentRepository.searchAllRespondents()).thenReturn(respondentList);

        // When
        List<RespondentListResponse> responses = respondentApplicationService.searchAllRespondents();

        // Then
        assertFalse(responses.isEmpty());
        assertEquals(respondentList.size(), responses.size());
        verify(respondentRepository).searchAllRespondents();
    }

    @Test
    @DisplayName("testa trazer uma lista de respondents por escolha")
    void searchAllRespondentsPerChoiceTest() {
        // Given
        MultipleChoice choice = MultipleChoice.BOTOX;
        List<Respondent> respondents = List.of(DataHelper.getTestRespondent());
        when(respondentRepository.searchAllRespondentsPerChoice(choice)).thenReturn(respondents);

        // When
        List<RespondestsListResponsePerChoice> responses = respondentApplicationService.searchAllRespondentsPerChoice(choice);

        // Then
        assertFalse(responses.isEmpty());
        assertEquals(respondents.size(), responses.size());
        verify(respondentRepository).searchAllRespondentsPerChoice(choice);
    }
    @Test
    @DisplayName("testa buscar um respondent por Id")
    void getRespondentPerIdTest() {
        // Given
        UUID id = UUID.randomUUID();
        Respondent respondent = DataHelper.getTestRespondent();
        when(respondentRepository.getRespondentPerId(id)).thenReturn(respondent);

        // When
        RespondentDetailResponse response = respondentApplicationService.getRespondentPerId(id);

        // Then
        assertEquals(respondent.getName(), response.getName());
        verify(respondentRepository).getRespondentPerId(id);
    }
}