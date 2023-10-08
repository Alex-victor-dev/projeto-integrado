package academy.wakanda.sorrileadsbe.domain;

import academy.wakanda.sorrileadsbe.application.api.RespondentRequest;
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
class RespondentTest {
    @Test
    @DisplayName("testa se o Respondent é criado através do Request")
    void shouldCreateRespondentFromRespondentRequest() {
        // Given
        RespondentRequest request = DataHelper.createSampleRespondentRequest();

        // When
        Respondent respondent = new Respondent(request);

        // Then
        assertEquals("Vastiane", respondent.getName());
        assertEquals("71982099941", respondent.getPhone());
        assertEquals("vastiane@gmail.com", respondent.getEmail());
        assertEquals(MultipleChoice.BOTOX, respondent.getMultipleChoice());
        assertEquals("Sim", respondent.getText());
        assertEquals("2023-10-08", respondent.getRegistrationDate());
    }

    @Test
    @DisplayName("Deve lançar exceção ao criar Respondent com MultipleChoice não correspondente.")
    void shouldThrowExceptionWhenCreatingRespondentWithBlankMandatoryFields(){

        RespondentRequest request = DataHelper.createSampleRespondentRequestInvalid();

        APIException ex = assertThrows(APIException.class, () -> new Respondent(request));
        assertEquals(HttpStatus.BAD_REQUEST, ex.getStatusException());
    }
}