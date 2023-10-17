package academy.wakanda.sorrileadsbe.communication.application.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import academy.wakanda.sorrileadsbe.application.api.LeadRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MessageRequest {
	@NotBlank(message = "O número de telefone não pode estar em branco")
	@Size(min = 10, max = 15, message = "O número de telefone deve ter entre 10 e 15 caracteres")
	private String phone;
	private String message;

	public MessageRequest(LeadRequest leadRequest) {
		this.phone = leadRequest.getPhone();
		this.message = "Olá! Seja bem-vindo à nossa Clínica 🔝\r\n"
				+ "Estamos animadas para te ajudar nesta jornada por um Sorriso mais bonito e saudável 🤗\r\n"
				+ "Em breve uma das nossas secretárias vai continuar seu atendimento! 👩🏽‍💼";
	}

}