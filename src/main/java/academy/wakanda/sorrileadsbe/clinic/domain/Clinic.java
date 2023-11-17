package academy.wakanda.sorrileadsbe.clinic.domain;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    @NotBlank(message = "A URL do ZAPI é obrigatória.")
    @Pattern(regexp = "^https://api\\.z-api\\.io/instances/[a-zA-Z0-9]{32}/token/[a-zA-Z0-9]{32}/send-text$",
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

}
