package academy.wakanda.sorrileadsbe.clinic.application.api;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ClinicUpdateRequest {
    private String nameClinic;
    private String phone;
    private String email;
    private String keyZapi;
    private String tokenZapi;
    private String fraseBoasVindas;
	private String clientToken;
}
