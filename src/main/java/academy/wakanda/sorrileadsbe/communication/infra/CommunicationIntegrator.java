package academy.wakanda.sorrileadsbe.communication.infra;

import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;

public interface CommunicationIntegrator {

	MessageResponse sendMessage(MessageRequest messageRequest);

}
