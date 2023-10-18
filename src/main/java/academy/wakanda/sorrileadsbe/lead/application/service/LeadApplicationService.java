package academy.wakanda.sorrileadsbe.lead.application.service;

import academy.wakanda.sorrileadsbe.communication.application.service.CommunicationService;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadResponse;
import academy.wakanda.sorrileadsbe.lead.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.lead.domain.Lead;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class LeadApplicationService implements LeadService {

	private final LeadRepository leadRepository;
	private final CommunicationService communicationService;

	@Override
	public LeadResponse createLead(LeadRequest leadRequest) {
		log.info("[start]  LeadApplicationService- createLead");
		Lead lead = leadRepository.save(new Lead(leadRequest));
		lead.enviaMensagem(communicationService, leadRepository);
		log.info("[finish]  LeadApplicationService - createLead");
		return new LeadResponse(lead);

	}
}