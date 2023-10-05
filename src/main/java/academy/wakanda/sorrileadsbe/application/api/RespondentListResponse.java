package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class RespondentListResponse {
    private UUID idRespondent;
    private String name;
    private String phone;
    private String email;
    private MultipleChoice multipleChoice;
    private String text;
    private String registrationDate;

    public static List<RespondentListResponse> convert(List<Respondent> respondents) {
        return respondents.stream()
                .map(RespondentListResponse::new)
                .collect(Collectors.toList());
    }

    public RespondentListResponse(Respondent respondent) {
        this.idRespondent = respondent.getIdRespondent();
        this.name = respondent.getName();
        this.phone = respondent.getPhone();
        this.email = respondent.getEmail();
        this.multipleChoice = respondent.getMultipleChoice();
        this.text = respondent.getText();
        this.registrationDate = respondent.getRegistrationDate();
    }
}
