package academy.wakanda.sorrileadsbe.communication.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageResponse {

	@JsonProperty("zaapId")
	private String zaapId;

	@JsonProperty("messageId")
	private String messageId;

	@JsonProperty("id")
	private String id;

}