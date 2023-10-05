package academy.wakanda.sorrileadsbe.message.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class MessageIntegratorController implements MessageIntegratorAPI {

	@Override
	public MessageIntegratorResponse sendMessage(@Valid MessageRequest messageRequest) {
		log.info("[inicia] MessageIntegratorController - sendMessage");
		log.info("[finaliza] MessageIntegratorController - sendMessage");
		log.info("[messageRequest] {}", messageRequest);
		return null;
	}

}
