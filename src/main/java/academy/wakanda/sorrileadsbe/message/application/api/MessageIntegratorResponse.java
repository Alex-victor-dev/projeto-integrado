package academy.wakanda.sorrileadsbe.message.application.api;

import academy.wakanda.sorrileadsbe.message.domain.MessageIntegrator;
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

	public MessageIntegratorResponse(MessageIntegrator messageIntegrator) {
		this.zaapId = messageIntegrator.getZaapId();
		this.messageId = messageIntegrator.getMessageId();
		this.id = messageIntegrator.getId();
	}
}
