package academy.wakanda.sorrileadsbe.domain;

import academy.wakanda.sorrileadsbe.application.api.RespondentRequest;
import academy.wakanda.sorrileadsbe.application.service.DataHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RespondentTest {
    @Test
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
}