package academy.wakanda.sorrileadsbe.lead.domain;


import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.clinic.infra.ClinicInfraRepository;
import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.communication.application.service.CommunicationService;
import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;
import academy.wakanda.sorrileadsbe.lead.application.api.EspecialidadeInteressada;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.application.repository.LeadRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

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
	@Column(name= "idClinic")
	private UUID idClinic;
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


	public Lead(LeadRequest leadRequest, UUID idClinic) {
		this.idClinic = idClinic;
		this.name =leadRequest.getNome();
		this.phone = leadRequest.getPhone();
		this.email = leadRequest.getEmail();
		this.especialidadeInteressada = EspecialidadeInteressada.fromString(leadRequest.getEspecialidadeInteressada());
		this.perguntaEspecificaLead = leadRequest.getPerguntaEspecificaLead();
		this.registrationDate = leadRequest.getRegistrationDate();
	}

	public void enviaMensagem(CommunicationService communicationService, LeadRepository leadRepository, ClinicInfraRepository clinicInfraRepository) {
		try {
			log.info("[Inicia] - Lead - enviaMensagem");
			log.info("ID da Clínica do Lead: {}", this.idClinic);

			Clinic clinic = clinicInfraRepository.buscaClinicPerId(this.idClinic);
			log.info("Clínica encontrada: {}", clinic);

			if (clinic == null) {
				log.error("Não foi encontrada uma clínica com o ID fornecido: {}", this.idClinic);
				throw new IllegalStateException("Clínica não encontrada para o ID: " + this.idClinic);
			}

			if (clinic.getFraseBoasVindas() == null) {
				log.error("A clínica encontrada não possui frase de boas-vindas. Clínica: {}", clinic);
				throw new IllegalStateException("Frase de boas-vindas não encontrada para a clínica: " + clinic);
			}

			String mensagemPersonalizada = clinic.getFraseBoasVindas() + "\n" + MENSAGEM_PADRAO_PERSONALIZADA;
			log.info("Enviando mensagem para o Lead: Nome: {}, ID da Clínica: {}, Mensagem: {}", this.name, this.idClinic, mensagemPersonalizada);

			MessageResponse response = communicationService.sendMessage(new MessageRequest(this.phone, mensagemPersonalizada));
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

	private static final String MENSAGEM_PADRAO_PERSONALIZADA = "{nome},vimos que você se interessou " +
			"por {nome do tratamento}.🔝\r\n"
			+ "E que também adicionou esse comentário: {descrição personalizada}<optional>\r\n"
			+ "Estamos animados para te ajudar nesta jornada por um Sorriso mais bonito e saudável 🤗\r\n"
			+ "Em breve uma das nossas secretárias vai continuar seu atendimento! 👩🏽‍💼";

}

