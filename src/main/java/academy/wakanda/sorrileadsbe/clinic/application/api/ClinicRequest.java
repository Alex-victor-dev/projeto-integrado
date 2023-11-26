package academy.wakanda.sorrileadsbe.clinic.application.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Getter
@Setter
@NoArgsConstructor
public class ClinicRequest {
    @NotBlank
    private String nameClinic;
    @NotBlank
    private String phone;
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    private String keyZapi;
    @NotBlank
    private String tokenZapi;

}
