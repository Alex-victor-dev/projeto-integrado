package academy.wakanda.sorrileadsbe.domain;

import academy.wakanda.sorrileadsbe.lead.application.api.EspecialidadeInteressada;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.application.service.DataHelper;
import academy.wakanda.sorrileadsbe.lead.domain.Lead;
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
        assertEquals("teste1", lead.getName());
        assertEquals("55 71982099941", lead.getPhone());
        assertEquals("teste@gmail.com", lead.getEmail());
        assertEquals(EspecialidadeInteressada.CLAREAMENTO_DENTAL, lead.getEspecialidadeInteressada());
        assertEquals("sim", lead.getPerguntaEspecificaLead());
        assertEquals("2023-11-19 12:56:45", lead.getRegistrationDate());
    }
}