package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.RespondentRequest;
import academy.wakanda.sorrileadsbe.domain.*;

import java.util.UUID;

public class DataHelper {

    public static Respondent getTestRespondent() {
        return new Respondent(createSampleRespondentRequest());
    }

    public static RespondentRequest createSampleRespondentRequest() {
        AnswersJson answersJson = new AnswersJson("Vastiane",
                "71982099941", "vastiane@gmail.com",
                "BOTOX",
                "Sim");
        RespondentFormJson respondentFormJson = new RespondentFormJson
                ("2023-10-08", answersJson);
        return new RespondentRequest(new FormJson
                ("Test Form", "123456"), respondentFormJson);
    }

    public static RespondentRequest createSampleRespondentRequestInvalid() {
        AnswersJson answersJson = new AnswersJson("Vastiane",
                "73981272306", "vastiane@gmail.com",
                "B",
                "Sim");
        RespondentFormJson respondentFormJson = new RespondentFormJson
                ("2023-10-08", answersJson);
        return new RespondentRequest(new FormJson
                ("Test Form", "123456"), respondentFormJson);
    }
}
