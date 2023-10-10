package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Lead;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class LeadListResponse {
    private UUID idLead;
    private String name;
    private String phone;
    private String email;
    private MultipleChoice multipleChoice;
    private String text;
    private String registrationDate;

    public static List<LeadListResponse> convert(List<Lead> leads) {
        return leads.stream()
                .map(LeadListResponse::new)
                .collect(Collectors.toList());
    }

    public LeadListResponse(Lead lead) {
        this.idLead = lead.getIdLead();
        this.name = lead.getName();
        this.phone = lead.getPhone();
        this.email = lead.getEmail();
        this.multipleChoice = lead.getMultipleChoice();
        this.text = lead.getText();
        this.registrationDate = lead.getRegistrationDate();
    }
}
