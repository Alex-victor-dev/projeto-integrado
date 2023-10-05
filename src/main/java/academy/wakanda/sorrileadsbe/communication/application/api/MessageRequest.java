package academy.wakanda.sorrileadsbe.communication.application.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageRequest {
	@NotBlank(message = "O número de telefone não pode estar em branco")
	@Size(min = 10, max = 15, message = "O número de telefone deve ter entre 10 e 15 caracteres")
	private String phone;
	private String message;
}