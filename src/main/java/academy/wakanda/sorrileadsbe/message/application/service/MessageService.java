package academy.wakanda.sorrileadsbe.message.application.service;

import academy.wakanda.sorrileadsbe.message.application.api.MessageIntegratorResponse;
import academy.wakanda.sorrileadsbe.message.application.api.MessageRequest;

public interface MessageService {

	MessageIntegratorResponse sendMessage(MessageRequest messageRequest);

}
