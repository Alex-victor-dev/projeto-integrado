package academy.wakanda.sorrileadsbe.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.wakanda.sorrileadsbe.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.application.api.LeadResponse;
import academy.wakanda.sorrileadsbe.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.communication.application.service.CommunicationService;
import academy.wakanda.sorrileadsbe.domain.Lead;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class LeadApplicationService implements LeadService {
	@Autowired
	private final LeadRepository leadRepository;
	private final CommunicationService communicationService;

	@Override
	public LeadResponse createLead(LeadRequest leadRequest) {
		log.info("[start]  LeadApplicationService- createLead");
		Lead lead = leadRepository.save(new Lead(leadRequest));
		MessageRequest messageRequest = new MessageRequest(leadRequest);
		lead.enviaMensagem(communicationService, messageRequest);
		log.info("[finish]  LeadApplicationService - createLead");
		return LeadResponse.builder().idLead(lead.getIdLead()).build();
	}

}