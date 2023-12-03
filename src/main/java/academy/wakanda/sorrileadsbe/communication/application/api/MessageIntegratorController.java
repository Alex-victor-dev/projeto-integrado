package academy.wakanda.sorrileadsbe.communication.application.api;

import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.service.CommunicationService;
import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MessageIntegratorController implements MessageIntegratorAPI {
	private final CommunicationService messageService;

	@Override
	public MessageResponse sendMessage(MessageRequest messageRequest, Clinic clinic) {
		log.info("[inicia] MessageIntegratorController - sendMessage");
		log.info("[messageRequest] {}", messageRequest);
		var messageIntegrator = messageService.sendMessage(messageRequest, clinic);
		log.info("[finaliza] MessageIntegratorController - sendMessage");
		return messageIntegrator;
	}

}
