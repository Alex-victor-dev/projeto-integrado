package academy.wakanda.sorrileadsbe.domain;

import academy.wakanda.sorrileadsbe.application.api.EspecialidadeInteressada;
import academy.wakanda.sorrileadsbe.application.api.LeadRequest;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Entity
@Table(name = "lead")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID idLead;
    @NotBlank
    private String name;
    @NotBlank
    @Column(unique = true)
    private String phone;
    @Email
    private String email;
    @NotNull
    private EspecialidadeInteressada especialidadeInteressada;
    private String perguntaEspecificaLead;
    private String registrationDate;

    public Lead(LeadRequest leadRequest) {
        this.name = leadRequest.getNome();
        this.phone = leadRequest.getPhone();
        this.email = leadRequest.getEmail();
        this.especialidadeInteressada = EspecialidadeInteressada.fromString(leadRequest.getEspecialidadeInteressada());
        this.perguntaEspecificaLead = leadRequest.getPerguntaEspecificaLead();
        this.registrationDate = leadRequest.getRegistrationDate();
    }
}