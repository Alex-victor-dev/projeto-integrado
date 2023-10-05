package academy.wakanda.sorrileadsbe.message.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.sorrileadsbe.message.application.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MessageIntegratorController implements MessageIntegratorAPI {

	private final MessageService messageService;

	@Override
	public MessageIntegratorResponse sendMessage(@Valid MessageRequest messageRequest) {
		log.info("[inicia] MessageIntegratorController - sendMessage");
		log.info("[finaliza] MessageIntegratorController - sendMessage");
		MessageIntegratorResponse messageIntegrator = messageService.sendMessage(messageRequest);
		log.info("[messageRequest] {}", messageRequest);
		return messageIntegrator;
	}

}
