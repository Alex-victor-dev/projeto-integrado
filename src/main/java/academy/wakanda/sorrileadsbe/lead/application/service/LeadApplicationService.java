package academy.wakanda.sorrileadsbe.lead.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicRepository;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.service.CommunicationService;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadListResponse;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadResponse;
import academy.wakanda.sorrileadsbe.lead.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.lead.domain.Lead;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class LeadApplicationService implements LeadService {

	private final LeadRepository leadRepository;
	private final CommunicationService communicationService;
	private ClinicRepository clinicRepository;

	@Override
	public LeadResponse createLead(LeadRequest leadRequest) {
		log.info("[start]  LeadApplicationService- createLead");
		Lead lead = leadRepository.save(new Lead(leadRequest));
		lead.enviaMensagem(communicationService, leadRepository);
		log.info("[finish]  LeadApplicationService - createLead");
		return new LeadResponse(lead);

	}

	@Override
	public List<LeadListResponse> getLeadsByClinicUrl(UUID idClinic) {
		log.info("[start]  LeadApplicationService- getLeadsByClinicUrl");
		clinicRepository.buscaClinicPerId(idClinic);
		log.info("[idClinic] {}", idClinic);
		List<Lead> leadsList = leadRepository.getLeadsByClinicUrl(idClinic);
		return LeadListResponse.converte(leadsList);
	}
}