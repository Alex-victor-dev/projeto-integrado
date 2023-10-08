package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class RespondentDetailResponse {
    private String name;
    private String phone;
    private String email;
    private MultipleChoice multipleChoice;
    private String text;
    private String registrationDate;
    public RespondentDetailResponse(Respondent respondent) {
        this.name = respondent.getName();
        this.phone = respondent.getPhone();
        this.email = respondent.getEmail();
        this.multipleChoice = respondent.getMultipleChoice();
        this.text = respondent.getText();
        this.registrationDate = respondent.getRegistrationDate();
    }
}
