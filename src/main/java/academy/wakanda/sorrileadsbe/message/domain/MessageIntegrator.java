package academy.wakanda.sorrileadsbe.message.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageIntegrator {

	@JsonProperty("phone")
	@NotBlank(message = "O número de telefone não pode estar em branco")
	@Size(min = 10, max = 15, message = "O número de telefone deve ter entre 10 e 15 caracteres")
	private String telefone;

	@JsonProperty("message")
	@NotBlank(message = "A mensagem não pode estar em branco")
	private String mensagem;

	@JsonProperty("zaapId")
	private String idZap;

	@JsonProperty("messageId")
	private String idMessage;

	@JsonProperty("id")
	private String idPhone;

}