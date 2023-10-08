package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.RespondentRequest;
import academy.wakanda.sorrileadsbe.domain.*;

import java.util.UUID;

public class DataHelper {

    public static Respondent getTestRespondent() {
        return Respondent.builder().
                idRespondent(UUID.randomUUID())
                .name("Lucas")
                .phone("74982099941")
                .email("lucas@gmail.com")
                .multipleChoice(MultipleChoice.BOTOX)
                .text("quero ficar linda!")
                .registrationDate("2023-10-08")
                .build();
    }

    public static RespondentRequest getTestRespondentRequest() {
        FormJson formJson = getTestFormJson();
        RespondentFormJson respondentFormJson = getTestRespondentFormJson();
        return new RespondentRequest(formJson, respondentFormJson);
    }

    public static FormJson getTestFormJson() {
        return new FormJson("Test Form", "123456");
    }

    public static RespondentFormJson getTestRespondentFormJson() {
        AnswersJson answersJson = new AnswersJson("Vastiane",
                "71982099941", "vastiane@gmail.com",
                "BOTOX", "Sim");
        return new RespondentFormJson("2023/10/08", answersJson);
    }

}
