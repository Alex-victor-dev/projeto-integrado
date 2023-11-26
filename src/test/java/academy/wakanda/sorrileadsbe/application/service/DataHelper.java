package academy.wakanda.sorrileadsbe.application.service;


import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.lead.application.api.AnswersJson;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.domain.Lead;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DataHelper {

    public static Lead getTestLead() {
        LeadRequest leadRequest = createSimpleJsonLead();
        Lead lead = new Lead(leadRequest);
        Clinic clinic = createTestClinic(); // Cria uma clínica para o teste
        lead.associateWithClinic(clinic); // Associa a clínica ao lead
        return lead;
    }

    public static Clinic createTestClinic() {
        // Crie um ClinicRequest com dados de teste
        ClinicRequest clinicRequest = new ClinicRequest();
        clinicRequest.setNameClinic("Test Clinic");
        clinicRequest.setPhone("123456789");
        clinicRequest.setEmail("test@example.com");
        clinicRequest.setKeyZapi("keyZapi");
        clinicRequest.setTokenZapi("tokenZapi");

        // Use o ClinicRequest para criar uma nova clínica
        return new Clinic(clinicRequest);
    }

    public static LeadRequest createSimpleJsonLead() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.readValue(
                    DataHelper.class.getResourceAsStream("/mocks/request-sucesso.json"),
                    LeadRequest.class
            );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo JSON", e);
        }
    }

    public static AnswersJson createAnswersJsonFromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.readValue(
                    DataHelper.class.getResourceAsStream("/mocks/answersTest.json"),
                    AnswersJson.class
            );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo JSON", e);
        }
    }
}
