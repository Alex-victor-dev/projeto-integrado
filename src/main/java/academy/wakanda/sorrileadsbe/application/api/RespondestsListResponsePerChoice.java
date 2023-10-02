package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Value
public class RespondestsListResponsePerChoice {
    private UUID idRespondent;
    private String name;
    private String phone;
    private String email;
    private MultipleChoice multipleChoice;
    private String text;

    public static List<RespondestsListResponsePerChoice> convert(List<Respondent> respondents) {
        return respondents.stream()
                .map(RespondestsListResponsePerChoice::new)
                .collect(Collectors.toList());
    }

    public RespondestsListResponsePerChoice(Respondent respondent) {
        this.idRespondent = respondent.getIdRespondent();
        this.name = respondent.getName();
        this.phone = respondent.getPhone();
        this.email = respondent.getEmail();
        this.multipleChoice = respondent.getMultipleChoice();
        this.text = respondent.getText();
    }
}

