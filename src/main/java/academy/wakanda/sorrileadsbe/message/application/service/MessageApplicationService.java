package academy.wakanda.sorrileadsbe.message.application.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import academy.wakanda.sorrileadsbe.message.application.api.MessageIntegratorResponse;
import academy.wakanda.sorrileadsbe.message.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.message.domain.MessageIntegrator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class MessageApplicationService implements MessageService {

	
	@Override
	public MessageIntegratorResponse sendMessage(@Valid MessageRequest messageRequest) {
		log.info("[inicia] MessageApplicationService - sendMessage");
		log.info("[finaliza] MessageApplicationService - sendMessage");
		MessageIntegrator 
		log.info("[messageRequest] {}", messageRequest);
		return null;
	}

}
