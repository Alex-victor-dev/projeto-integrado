package academy.wakanda.sorrileadsbe.clinic.application.api;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@ToString
public class ClinicDetailedResponse {
    private UUID idClinic;
    private String nameClinic;
    private String phone;
    private String email;
    private String urlZapi;
    private LocalDateTime dataCadastro;

    public ClinicDetailedResponse(Clinic clinic) {
        this.idClinic = clinic.getIdClinic();
        this.nameClinic = clinic.getNameClinic();
        this.phone = clinic.getPhone();
        this.email = clinic.getEmail();
        this.urlZapi = clinic.getUrlZapi();
        this.dataCadastro = clinic.getDataCadastro();
    }
}
