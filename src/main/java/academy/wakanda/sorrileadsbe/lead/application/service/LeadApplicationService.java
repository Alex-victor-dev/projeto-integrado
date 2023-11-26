package academy.wakanda.sorrileadsbe.lead.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicRepository;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.service.CommunicationService;
import academy.wakanda.sorrileadsbe.handler.APIException;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadResponse;
import academy.wakanda.sorrileadsbe.lead.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.lead.domain.Lead;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class LeadApplicationService implements LeadService {

	private final LeadRepository leadRepository;
	private final CommunicationService communicationService;
	private final ClinicRepository clinicRepository;

	@Override
	public LeadResponse createLead(LeadRequest leadRequest, UUID idClinic) {
		log.info("[start] LeadApplicationService - createLead");
		Clinic clinic = clinicRepository.findById(idClinic)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Clinica não encontrada!"));
		Lead lead = new Lead(leadRequest);
		lead.associateWithClinic(clinic);
		lead = leadRepository.save(lead);
		lead.enviaMensagem(communicationService, leadRepository);
		log.info("[finish] LeadApplicationService - createLead");
		return new LeadResponse(lead);
	}
}