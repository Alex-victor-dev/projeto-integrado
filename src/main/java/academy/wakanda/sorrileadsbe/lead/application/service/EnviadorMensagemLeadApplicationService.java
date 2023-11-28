package academy.wakanda.sorrileadsbe.lead.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicRepository;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.service.CommunicationService;
import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;
import academy.wakanda.sorrileadsbe.lead.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.lead.domain.Lead;
import academy.wakanda.sorrileadsbe.lead.domain.MensagemBoasVindasLead;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class EnviadorMensagemLeadApplicationService implements EnviadorMensagemLeadService {
	private final LeadRepository leadRepository;
	private final CommunicationService communicationService;
	private final ClinicRepository clinicRepository;

	@Override
	public void enviaMensagemBoasVindas(Lead lead) {
		try {
			log.info("[Inicia] - Lead - enviaMensagem");
			Clinic clinic = clinicRepository.buscaClinicPerId(lead.getIdClinic());
			MensagemBoasVindasLead mensagemBoasVindasLead = new MensagemBoasVindasLead(clinic, lead);
			MessageResponse response = communicationService
					.sendMessage(mensagemBoasVindasLead.getMessage());
			lead.verificaSeEnviouMensagem(response);
		} catch (Exception e) {
			log.error("[ERROR] - Lead - enviaMensagem", e);
			lead.falhaEnviarMensagemBoasVindas();
		}
		leadRepository.save(lead);
		log.info("[finaliza] - Lead - enviaMensagem. Resultado: {}", lead.isEnviouMensagenDeBoasVindas());
	}

}
