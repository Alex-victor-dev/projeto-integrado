package academy.wakanda.sorrileadsbe.communication.infra;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;

public interface CommunicationIntegrator {

	MessageResponse sendMessage(MessageRequest messageRequest, Clinic clinic);

}
