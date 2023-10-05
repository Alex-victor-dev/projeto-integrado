package academy.wakanda.sorrileadsbe.message.infra;

import academy.wakanda.sorrileadsbe.message.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.message.domain.MessageIntegrator;

public interface MessageSendIntegrator {

	MessageIntegrator sendMessage(MessageRequest messageRequest);

}
