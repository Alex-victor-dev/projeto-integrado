package academy.wakanda.sorrileadsbe.domain;

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

import academy.wakanda.sorrileadsbe.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.communication.application.service.CommunicationService;
import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
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
	@Column(name = "resultado")
	private boolean enviouMensagenDeBoasVindas;

	public Lead(LeadRequest leadRequest) {
		this.name = leadRequest.getNome();
		this.phone = leadRequest.getPhone();
		this.email = leadRequest.getEmail();
		this.especialidadeInteressada = EspecialidadeInteressada.fromString(leadRequest.getEspecialidadeInteressada());
		this.perguntaEspecificaLead = leadRequest.getPerguntaEspecificaLead();
		this.registrationDate = leadRequest.getRegistrationDate();
	}

	public void enviaMensagem(CommunicationService communicationService, LeadRepository leadRepository,
			MessageRequest messageRequest) {
		try {
			log.info("[Inicia] - Lead - enviaMensagem");
			MessageResponse response = communicationService.sendMessage(messageRequest);
			if (response != null && response.getZaapId() != null && response.getMessageId() != null
					&& response.getId() != null) {
				this.enviouMensagenDeBoasVindas = true;
			} else {
				this.enviouMensagenDeBoasVindas = false;
			}
		} catch (Exception e) {
			this.enviouMensagenDeBoasVindas = false;
		}
		leadRepository.save(this);
		log.info("[finaliza] - Lead - enviaMensagem. Resultado: {}", this.enviouMensagenDeBoasVindas);
	}
}
