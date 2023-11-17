package academy.wakanda.sorrileadsbe.clinic.application.api;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ClinicListResponse {
    private UUID idClinic;
    private String nameClinic;
    private String phone;
    private String email;
    private String urlZapi;
    private LocalDateTime dataCadastro;
}
