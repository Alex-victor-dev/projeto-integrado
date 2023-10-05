package academy.wakanda.sorrileadsbe.communication.application.api;

import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;
import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.sorrileadsbe.communication.application.service.CommunicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MessageIntegratorController implements MessageIntegratorAPI {
	private final CommunicationService messageService;

	@Override
	public MessageResponse sendMessage(MessageRequest messageRequest) {
		log.info("[inicia] MessageIntegratorController - sendMessage");
		log.info("[messageRequest] {}", messageRequest);
		var messageIntegrator = messageService.sendMessage(messageRequest);
		log.info("[finaliza] MessageIntegratorController - sendMessage");
		return messageIntegrator;
	}

}
