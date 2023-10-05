package academy.wakanda.sorrileadsbe.domain;

import academy.wakanda.sorrileadsbe.application.api.RespondentRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "respondent")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Respondent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID idRespondent;
    @NotBlank
    private String name;
    @NotBlank
    @Column(unique = true)
    private String phone;
    @Email
    private String email;
    @NotNull
    private MultipleChoice multipleChoice;
    private String text;
    private String registrationDate;

    public Respondent(RespondentRequest respondentRequest) {
        this.name = respondentRequest.getRespondentForm().getAnswersJson().getNome();
        this.phone = respondentRequest.getRespondentForm().getAnswersJson().getWhatsapp();
        this.email = respondentRequest.getRespondentForm().getAnswersJson().getEmail();
        this.multipleChoice = MultipleChoice.fromString(respondentRequest.getRespondentForm().getAnswersJson().getEspecialidade());
        this.text = respondentRequest.getRespondentForm().getAnswersJson().getPerguntaEspecifica();
        this.registrationDate = respondentRequest.getRespondentForm().getDate();
    }
}