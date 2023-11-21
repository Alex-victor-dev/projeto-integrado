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

import academy.wakanda.sorrileadsbe.lead.application.api.EspecialidadeInteressada;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.application.repository.LeadRepository;
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
	private UUID IdClinic;
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
	@Column(name = "enviouMensagenDeBoasVindas")
	private boolean enviouMensagenDeBoasVindas;

	public Lead(LeadRequest leadRequest) {
		this.name = leadRequest.getNome();
		this.phone = leadRequest.getPhone();
		this.email = leadRequest.getEmail();
		this.especialidadeInteressada = EspecialidadeInteressada.fromString(leadRequest.getEspecialidadeInteressada());
		this.perguntaEspecificaLead = leadRequest.getPerguntaEspecificaLead();
		this.registrationDate = leadRequest.getRegistrationDate();
	}

	public void enviaMensagem(CommunicationService communicationService, LeadRepository leadRepository) {
		try {
			log.info("[Inicia] - Lead - enviaMensagem");
			MessageResponse response = communicationService
					.sendMessage(new MessageRequest(this.phone, MENSAGEM_BOAS_VINDAS));
			verificaSeEnviouMensagem(response);
		} catch (Exception e) {
			log.error("[ERROR] - Lead - enviaMensagem", e);
			this.enviouMensagenDeBoasVindas = false;
		}
		leadRepository.save(this);
		log.info("[finaliza] - Lead - enviaMensagem. Resultado: {}", this.enviouMensagenDeBoasVindas);
	}

	private void verificaSeEnviouMensagem(MessageResponse response) {
		if (enviouMensagem(response)) {
			this.enviouMensagenDeBoasVindas = true;
		} else {
			this.enviouMensagenDeBoasVindas = false;
		}
	}

	private Boolean enviouMensagem(MessageResponse response) {
		return Optional.ofNullable(response).map(MessageResponse::enviouMensagem).orElse(false);
	}

	private static final String MENSAGEM_BOAS_VINDAS = "Olá! Seja bem-vindo à nossa Clínica 🔝\r\n"
			+ "Estamos animadas para te ajudar nesta jornada por um Sorriso mais bonito e saudável 🤗\r\n"
			+ "Em breve uma das nossas secretárias vai continuar seu atendimento! 👩🏽‍💼";
}
