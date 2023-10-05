package academy.wakanda.sorrileadsbe.message.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageIntegrator {

	@JsonProperty("zaapId")
	private String idZap;
	@JsonProperty("messageId")
	private String idMessage;
	@JsonProperty("id")
	private String idPhone;

}
