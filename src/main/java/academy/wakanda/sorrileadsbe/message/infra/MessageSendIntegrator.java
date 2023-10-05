package academy.wakanda.sorrileadsbe.message.infra;

import javax.validation.Valid;

import academy.wakanda.sorrileadsbe.message.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.message.domain.MessageIntegrator;

public interface MessageSendIntegrator {

	MessageIntegrator sendMessage(@Valid MessageRequest messageRequest);

}
