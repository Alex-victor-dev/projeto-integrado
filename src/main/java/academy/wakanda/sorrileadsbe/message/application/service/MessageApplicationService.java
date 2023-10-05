package academy.wakanda.sorrileadsbe.message.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.sorrileadsbe.message.application.api.MessageIntegratorResponse;
import academy.wakanda.sorrileadsbe.message.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.message.domain.MessageIntegrator;
import academy.wakanda.sorrileadsbe.message.infra.MessageSendIntegrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessageApplicationService implements MessageService {

	private final MessageSendIntegrator messageSendIntegrator;

	@Override
	public MessageIntegratorResponse sendMessage(MessageRequest messageRequest) {
		log.info("[inicia] MessageApplicationService - sendMessage");
		log.info("[messageRequest] {}", messageRequest);
		MessageIntegrator messageIntegrator = messageSendIntegrator.sendMessage(messageRequest);
		log.info("[finaliza] MessageApplicationService - sendMessage");
		return new MessageIntegratorResponse(messageIntegrator);
	}

}
