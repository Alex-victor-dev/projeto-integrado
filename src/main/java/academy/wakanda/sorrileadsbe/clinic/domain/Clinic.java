package academy.wakanda.sorrileadsbe.clinic.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicUpdateRequest;
import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicRepository;
import academy.wakanda.sorrileadsbe.handler.APIException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@Table(name = "clinic")
@NoArgsConstructor
public class Clinic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID idClinic;
	@NotBlank
	private String nameClinic;
	@NotBlank
	private String phone;
	@Email
	@Column(unique = true)
	private String email;
	@Column
	private String webhookUrl;
	@NotBlank
	private String keyZapi;
	@NotBlank
	private String tokenZapi;
	private LocalDateTime dataCadastro;
	@NotBlank
	private String fraseBoasVindas;
	@NotBlank
	private String clientToken;

	public Clinic(ClinicRequest clinicRequest) {
		this.nameClinic = clinicRequest.getNameClinic();
		this.phone = clinicRequest.getPhone();
		this.email = clinicRequest.getEmail();
		this.keyZapi = clinicRequest.getKeyZapi();
		this.tokenZapi = clinicRequest.getTokenZapi();
		this.clientToken = clinicRequest.getClientToken();
		this.fraseBoasVindas = clinicRequest.getFraseBoasVindas();
		this.dataCadastro = LocalDateTime.now();

	}

	public void update(ClinicUpdateRequest clinicUpdateRequest) {
		this.nameClinic = clinicUpdateRequest.getNameClinic();
		this.phone = clinicUpdateRequest.getPhone();
		this.email = clinicUpdateRequest.getEmail();
		this.keyZapi = clinicUpdateRequest.getKeyZapi();
		this.tokenZapi = clinicUpdateRequest.getTokenZapi();
		this.clientToken = clinicUpdateRequest.getClientToken();
		this.fraseBoasVindas = clinicUpdateRequest.getFraseBoasVindas();
	}

	public static void validateEmail(String email, ClinicRepository clinicRepository) {
		clinicRepository.findByEmail(email).ifPresent(c -> {
			throw APIException.build(HttpStatus.BAD_REQUEST, "E-mail já cadastrado no sistema.");
		});
	}

	public void relacionaWebhookUrl(ClinicRepository clinicRepository, String webhookUrl) {
		this.webhookUrl = webhookUrl;
		clinicRepository.save(this);
	}

	public String obtemMensagemBoasVindas() {
		if (this.getFraseBoasVindas() != null) {
			return "\n" + this.getFraseBoasVindas() + "\n" + MENSAGEM_PADRAO_PERSONALIZADA;
		} else {
			return MENSAGEM_PADRAO_PERSONALIZADA;
		}
	}

	private static final String MENSAGEM_PADRAO_PERSONALIZADA = "{nome}, vimos que você se interessou "
			+ "por {nome do tratamento}.🔝\r\n"
			+ "E que também adicionou esse comentário: {descrição personalizada} 📝\r\n"
			+ "Estamos animados para te ajudar nesta jornada por um Sorriso mais bonito e saudável.🤗\r\n"
			+ "Em breve uma das nossas secretárias continuará seu atendimento! 👩🏽‍💼";

}
