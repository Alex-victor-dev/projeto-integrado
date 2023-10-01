package academy.wakanda.sorrileadsbe.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
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


    public Respondent(String name, String phone, String email, MultipleChoice multipleChoice, String text)
            throws InstantiationException, IllegalAccessException {
        this.idRespondent = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.multipleChoice = multipleChoice;
        this.text = text;
        this.status = Status.INCOMPLETED ;
        this.date = LocalDateTime.now();
        }


    public void amendStatus() {
        this.status = Status.COMPLETED;}

}
