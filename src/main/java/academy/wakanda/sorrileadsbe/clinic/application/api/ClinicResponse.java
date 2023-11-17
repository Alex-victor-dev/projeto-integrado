package academy.wakanda.sorrileadsbe.clinic.application.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClinicResponse {

    private UUID idClinic;
}
