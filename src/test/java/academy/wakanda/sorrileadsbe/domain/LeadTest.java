package academy.wakanda.sorrileadsbe.domain;

import academy.wakanda.sorrileadsbe.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.application.service.DataHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class LeadTest {
    @Test
    @DisplayName("testa se o Respondent é criado através do Request")
    void shouldCreateRespondentFromRespondentRequest() {
        // Given
        LeadRequest request = DataHelper.createSimpleJsonLead();

        // When
        Lead lead = new Lead(request);

        // Then
        assertEquals("Vastiane", lead.getName());
        assertEquals("55 73995791888", lead.getPhone());
        assertEquals("vastiane@gmail.com", lead.getEmail());
        assertEquals(EspecialidadeInteressada.BOTOX, lead.getEspecialidadeInteressada());
        assertEquals("sim", lead.getPerguntaEspecificaLead());
        assertEquals("2023-09-27 13:00:00", lead.getRegistrationDate());
    }
}