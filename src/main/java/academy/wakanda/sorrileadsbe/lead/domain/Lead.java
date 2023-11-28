package academy.wakanda.sorrileadsbe.lead.domain;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;
import academy.wakanda.sorrileadsbe.lead.application.api.EspecialidadeInteressada;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
	@Column(name = "idClinic")
	private UUID idClinic;
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
	@Column(name = "enviouMensagenDeBoasVindas")
	private boolean enviouMensagenDeBoasVindas;

	public Lead(LeadRequest leadRequest, UUID idClinic) {
		this.idClinic = idClinic;
		this.name = leadRequest.getNome();
		this.phone = leadRequest.getPhone();
		this.email = leadRequest.getEmail();
		this.especialidadeInteressada = EspecialidadeInteressada.fromString(leadRequest.getEspecialidadeInteressada());
		this.perguntaEspecificaLead = leadRequest.getPerguntaEspecificaLead();
		this.registrationDate = leadRequest.getRegistrationDate();
	}

	public void verificaSeEnviouMensagem(MessageResponse response) {
		if (enviouMensagem(response)) {
			this.enviouMensagenDeBoasVindas = true;
		} else {
			this.enviouMensagenDeBoasVindas = false;
		}
	}

	private Boolean enviouMensagem(MessageResponse response) {
		return Optional.ofNullable(response).map(MessageResponse::enviouMensagem).orElse(false);
	}

	public void falhaEnviarMensagemBoasVindas() {
		this.enviouMensagenDeBoasVindas = false;
	}
}