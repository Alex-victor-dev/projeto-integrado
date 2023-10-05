package academy.wakanda.sorrileadsbe.communication.infra;

import org.springframework.stereotype.Component;

import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@RequiredArgsConstructor
public class CommunicationInfraIntegrator implements CommunicationIntegrator {

	private final CommunicationZapiClientIntegrator zapiClientIntegrator;

	@Override
	public MessageResponse sendMessage(MessageRequest messageRequest) {
		log.info("[inicia] CommunicationInfraIntegrator - sendMessage");
		MessageResponse messageResponse = zapiClientIntegrator.sendMessage(messageRequest);
		log.info("[messageResponse] {}", messageResponse);
		log.info("[finaliza] CommunicationInfraIntegrator - sendMessage");
		return messageResponse;
	}
}
