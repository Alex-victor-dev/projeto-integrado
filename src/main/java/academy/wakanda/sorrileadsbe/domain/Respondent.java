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
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Respondent {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name= "id", updatable = false, unique = true, nullable = false)
    private UUID idRespondent;
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
    @Email
    private String email;
    @NotNull
    private MultipleChoice multipleChoice;
    private String text;

    private Status status;
    private LocalDateTime date;


    public Respondent(RespondentRequest respondentRequest)
            throws InstantiationException, IllegalAccessException {
        this.name = respondentRequest.getName();
        this.phone = respondentRequest.getPhone();
        this.email = respondentRequest.getEmail();
        this.multipleChoice = respondentRequest.getMultipleChoice();
        this.text = respondentRequest.getText();
        this.status = Status.INCOMPLETED ;
        this.date = LocalDateTime.now();
        }


    public void amendStatus() {
        this.status = Status.COMPLETED;}

}
