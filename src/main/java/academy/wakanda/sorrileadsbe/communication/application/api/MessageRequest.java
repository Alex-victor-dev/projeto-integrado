package academy.wakanda.sorrileadsbe.communication.application.api;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MessageRequest {
	@NotBlank(message = "O número de telefone não pode estar em branco")
	@Size(min = 10, max = 15, message = "O número de telefone deve ter entre 10 e 15 caracteres")
	private String phone;
	private String message;
}