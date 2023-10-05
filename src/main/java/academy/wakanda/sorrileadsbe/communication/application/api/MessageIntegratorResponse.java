package academy.wakanda.sorrileadsbe.communication.application.api;

import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageIntegratorResponse {

	private String zaapId;
	private String messageId;
	private String id;

	public MessageIntegratorResponse(MessageResponse messageIntegrator) {
		this.zaapId = messageIntegrator.getZaapId();
		this.messageId = messageIntegrator.getMessageId();
		this.id = messageIntegrator.getId();
	}
}
