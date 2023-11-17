package academy.wakanda.sorrileadsbe.clinic.domain;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
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
    private String urlZapi;
    private LocalDateTime dataCadastro;


    public Clinic(ClinicRequest clinicRequest) {
        this.nameClinic = clinicRequest.getNameClinic();
        this.phone = clinicRequest.getPhone();
        this.email = clinicRequest.getEmail();
        this.urlZapi = clinicRequest.getUrlZapi();
        this.dataCadastro = LocalDateTime.now();
    }

}
