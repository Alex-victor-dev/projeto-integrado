package academy.wakanda.sorrileadsbe.clinic.domain;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Optional;
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
    @NotBlank(message = "A URL do ZAPI é obrigatória.")
    @Pattern(regexp = "(?i)^https://api\\.z-api\\.io/instances/[A-Z0-9]{32}/token/[A-Z0-9]{24}/send-text$",
            message = "URL do ZAPI inválida.")
    private String urlZapi;
    private LocalDateTime dataCadastro;


    public Clinic(ClinicRequest clinicRequest) {
        this.nameClinic = clinicRequest.getNameClinic();
        this.phone = clinicRequest.getPhone();
        this.email = clinicRequest.getEmail();
        this.urlZapi = clinicRequest.getUrlZapi();
        this.dataCadastro = LocalDateTime.now();
    }

    public void update(ClinicUpdateRequest clinicUpdateRequest) {
        this.nameClinic = clinicUpdateRequest.getNameClinic();
        this.phone = clinicUpdateRequest.getPhone();
        this.email = clinicUpdateRequest.getEmail();
        this.urlZapi = clinicUpdateRequest.getUrlZapi();
    }

    public Optional<String> validateZapiUrl() {
        if (urlZapi.matches("(?i)^https://api\\.z-api\\.io/instances/[A-Z0-9]{32}/token/[A-Z0-9]{24}/send-text$")) {
            return Optional.of(urlZapi);
        } else {
            return Optional.empty();
        }
    }
}