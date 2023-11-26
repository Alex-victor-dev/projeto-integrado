package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;

import java.util.Optional;
import java.util.UUID;

public interface ClinicRepository {
    Clinic save(Clinic clinic);

    Clinic buscaClinicPerId(UUID idClinic);

    Optional<Clinic> findByEmail(String email);


}
