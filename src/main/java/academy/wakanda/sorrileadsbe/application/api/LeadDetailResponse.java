package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Lead;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class LeadDetailResponse {
    private String name;
    private String phone;
    private String email;
    private MultipleChoice multipleChoice;
    private String text;
    private String registrationDate;
    public LeadDetailResponse(Lead lead) {
        this.name = lead.getName();
        this.phone = lead.getPhone();
        this.email = lead.getEmail();
        this.multipleChoice = lead.getMultipleChoice();
        this.text = lead.getText();
        this.registrationDate = lead.getRegistrationDate();
    }
}
