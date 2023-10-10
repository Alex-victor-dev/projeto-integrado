package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.domain.*;

public class DataHelper {

    public static Lead getTestRespondent() {
        return new Lead(createSampleRespondentRequest());
    }

    public static LeadRequest createSampleRespondentRequest() {
        AnswersJson answersJson = new AnswersJson("Vastiane",
                "71982099941", "vastiane@gmail.com",
                "BOTOX",
                "Sim");
        RespondentFormJson respondentFormJson = new RespondentFormJson
                ("2023-10-08", answersJson);
        return new LeadRequest(new FormJson
                ("Test Form", "123456"), respondentFormJson);
    }

    public static LeadRequest createSampleRespondentRequestInvalid() {
        AnswersJson answersJson = new AnswersJson("",
                "73981272306", "vastiane@gmail.com",
                "B",
                "Sim");
        RespondentFormJson respondentFormJson = new RespondentFormJson
                ("2023-10-08", answersJson);
        return new LeadRequest(new FormJson
                ("Test Form", "123456"), respondentFormJson);
    }
}
