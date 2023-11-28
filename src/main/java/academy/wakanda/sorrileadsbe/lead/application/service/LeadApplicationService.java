package academy.wakanda.sorrileadsbe.lead.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import academy.wakanda.sorrileadsbe.clinic.infra.ClinicInfraRepository;
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
	private final ClinicInfraRepository clinicInfraRepository;

	@Override
	public LeadResponse createLead(LeadRequest leadRequest, UUID idClinic) {
		log.info("[start] LeadApplicationService - createLead");
		clinicInfraRepository.buscaClinicPerId(idClinic);
		Lead lead = leadRepository.save(new Lead(leadRequest, idClinic));
		lead.enviaMensagem(communicationService, leadRepository, clinicInfraRepository);
		log.info("[finish] LeadApplicationService - createLead");
		return new LeadResponse(lead.getIdLead());
	}

	@Override
	public List<LeadListResponse> getLeadsByClinicUrl(UUID idClinic) {
		log.info("[start]  LeadApplicationService- getLeadsByClinicUrl");
		log.info("[idClinic] {}", idClinic);
		clinicInfraRepository.buscaClinicPerId(idClinic);
		List<Lead> leadsList = leadRepository.getLeadsByClinicUrl(idClinic);
		log.info("[finish]  LeadApplicationService- getLeadsByClinicUrl");
		return LeadListResponse.converte(leadsList);
	}

}
