package academy.wakanda.sorrileadsbe.communication.application.service;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;

public interface CommunicationService {

	MessageResponse sendMessage(MessageRequest messageRequest, Clinic clinic);

}
