package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.application.api.AnswersJson;
import academy.wakanda.sorrileadsbe.domain.Lead;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class DataHelper {

    public static Lead getTestLead() {
        return new Lead(createSimpleJsonLead());
    }

    public static LeadRequest createSimpleJsonLead() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        LeadRequest leadRequest;
        try {
            TypeReference<List<LeadRequest>> typeReference = new TypeReference<>() {};
            leadRequest = objectMapper.readValue(
                    DataHelper.class.getResourceAsStream("/mocks/request-sucesso.json"),
                    LeadRequest.class

             );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo JSON", e);
        }
        return leadRequest;
    }

    public static AnswersJson createAnswersJsonFromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        AnswersJson answersJson;

        try {
            answersJson = objectMapper.readValue(
                    DataHelper.class.getResourceAsStream("/mocks/answersTest.json"),
                    AnswersJson.class
            );

            return answersJson;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo JSON", e);
        }
    }
}