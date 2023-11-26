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
    public ClinicResponse(Clinic clinic){
        this.idClinic = clinic.getIdClinic();
    }
}
