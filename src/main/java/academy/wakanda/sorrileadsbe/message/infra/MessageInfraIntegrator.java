package academy.wakanda.sorrileadsbe.message.infra;

import org.springframework.stereotype.Service;

import academy.wakanda.sorrileadsbe.message.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.message.domain.MessageIntegrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessageInfraIntegrator implements MessageSendIntegrator {

	private final MessageClientIntegrator messageClientIntegrator;
	
	@Override
	public MessageIntegrator sendMessage(MessageRequest messageRequest) {
		log.info("[inicia] MessageInfraIntegrator - sendMessage");
		MessageIntegrator messageIntegrator = messageClientIntegrator.sendMessage(INSTANCIA,TOKEN,messageRequest);
		log.info("[finaliza] MessageInfraIntegrator - sendMessage");
		return null;
	}

	private static final String INSTANCIA = null;
	private static final String TOKEN = null;

}
