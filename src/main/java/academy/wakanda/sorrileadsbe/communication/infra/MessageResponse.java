package academy.wakanda.sorrileadsbe.communication.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MessageResponse {

	@JsonProperty("zaapId")
	private String zaapId;

	@JsonProperty("messageId")
	private String messageId;

	@JsonProperty("id")
	private String id;

}