package academy.wakanda.sorrileadsbe.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class Respondent {

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
    private LocalDateTime registrationTime;

    public Status Respondent(String name, String phone, String email, MultipleChoice multipleChoice, String text)
            throws InstantiationException, IllegalAccessException {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.multipleChoice = multipleChoice;
        this.text = text;
        this.registrationTime = LocalDateTime.now();
        if (isValidForm()) {
                return Status.COMPLETED;
            } else {
                return Status.INCOMPLETED;
            }
        }

    private boolean isValidForm() {
        return name != null && !name.isBlank() &&
                phone != null && !phone.isBlank() &&
               multipleChoice!=null;
    }
}
