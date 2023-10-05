package academy.wakanda.sorrileadsbe.message.application.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageIntegratorResponse {
	@NonNull
	private String zaapId;
	@NonNull
	private String messageId;
	@NonNull
	private String id;

}
