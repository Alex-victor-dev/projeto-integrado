package academy.wakanda.sorrileadsbe.communication.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.communication.infra.CommunicationIntegrator;
import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class CommunicationApplicationService implements CommunicationService {

	private final CommunicationIntegrator messageSendIntegrator;
		

	@Override
	public MessageResponse sendMessage(MessageRequest messageRequest, Clinic clinic)  {
		log.info("[inicia] CommunicationApplicationService - sendMessage");
		log.info("[messageRequest] {}", messageRequest);
		MessageResponse messageIntegrator = messageSendIntegrator.sendMessage(messageRequest, clinic);
		log.info("[finaliza] CommunicationApplicationService - sendMessage");
		return  messageIntegrator;
	}

}
