package academy.wakanda.sorrileadsbe.domain;

import academy.wakanda.sorrileadsbe.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.application.service.DataHelper;
import academy.wakanda.sorrileadsbe.handler.APIException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LeadTest {
    @Test
    @DisplayName("testa se o Respondent é criado através do Request")
    void shouldCreateRespondentFromRespondentRequest() {
        // Given
        LeadRequest request = DataHelper.createSampleRespondentRequest();

        // When
        Lead lead = new Lead(request);

        // Then
        assertEquals("Vastiane", lead.getName());
        assertEquals("71982099941", lead.getPhone());
        assertEquals("vastiane@gmail.com", lead.getEmail());
        assertEquals(EspecialidadeInteressada.BOTOX, lead.getEspecialidadeInteressada());
        assertEquals("Sim", lead.getPerguntaEspecificaLead());
        assertEquals("2023-10-08", lead.getRegistrationDate());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar Respondent com MultipleChoice não correspondente.")
    void shouldThrowExceptionWhenCreatingRespondentWithBlankMandatoryFields(){

        LeadRequest request = DataHelper.createSampleRespondentRequestInvalid();

        APIException ex = assertThrows(APIException.class, () -> new Lead(request));
        assertEquals(HttpStatus.BAD_REQUEST, ex.getStatusException());
    }
}