package academy.wakanda.sorrileadsbe.message.application.api;

import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageRequest {
	
	@NotBlank
	private String phone;
	private String message;
}