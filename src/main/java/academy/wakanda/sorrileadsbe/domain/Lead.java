package academy.wakanda.sorrileadsbe.domain;

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
        this.name = leadRequest.getRespondentForm().getAnswersJson().getNome();
        this.phone = leadRequest.getRespondentForm().getAnswersJson().getWhatsapp();
        this.email = leadRequest.getRespondentForm().getAnswersJson().getEmail();
        this.especialidadeInteressada = EspecialidadeInteressada.fromString(leadRequest.getRespondentForm().getAnswersJson().getEspecialidade());
        this.perguntaEspecificaLead = leadRequest.getRespondentForm().getAnswersJson().getPerguntaEspecifica();
        this.registrationDate = leadRequest.getRespondentForm().getDate();
    }
}