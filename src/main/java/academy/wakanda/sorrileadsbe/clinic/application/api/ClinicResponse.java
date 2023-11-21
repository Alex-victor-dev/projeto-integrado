package academy.wakanda.sorrileadsbe.clinic.application.api;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClinicResponse {

    private UUID idClinic;
    private String webhookUrl;

    public ClinicResponse(Clinic clinic, String webhookUrl){
        this.idClinic = clinic.getIdClinic();
        this.webhookUrl = webhookUrl;
    }
}
