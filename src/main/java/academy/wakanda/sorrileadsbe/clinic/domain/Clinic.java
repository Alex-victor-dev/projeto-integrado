package academy.wakanda.sorrileadsbe.clinic.domain;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@ToString
@Entity
@Table(name = "clinic")
@NoArgsConstructor
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idClinic;
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
    private LocalDateTime dataCadastro;


    public Clinic(ClinicRequest clinicRequest) {
        this.nameClinic = clinicRequest.getNameClinic();
        this.phone = clinicRequest.getPhone();
        this.email = clinicRequest.getEmail();
        this.keyZapi = clinicRequest.getKeyZapi();
        this.tokenZapi = clinicRequest.getTokenZapi();
        this.dataCadastro = LocalDateTime.now();
    }

    public void update(ClinicUpdateRequest clinicUpdateRequest) {
        this.nameClinic = clinicUpdateRequest.getNameClinic();
        this.phone = clinicUpdateRequest.getPhone();
        this.email = clinicUpdateRequest.getEmail();
        this.keyZapi = clinicUpdateRequest.getKeyZapi();
        this.tokenZapi = clinicUpdateRequest.getTokenZapi();
    }
}