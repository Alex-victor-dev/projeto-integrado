package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;

import java.util.List;
import java.util.UUID;

public class RespondentListResponse {
    private UUID idRespondent;
    private String name;
    private String phone;
    private String email;
    private MultipleChoice multipleChoice;
    private String text;

    public static List<RespondentListResponse> convert(List<Respondent> respondents) {
        return null;
    }
}
