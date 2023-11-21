package academy.wakanda.sorrileadsbe.clinic.application.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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