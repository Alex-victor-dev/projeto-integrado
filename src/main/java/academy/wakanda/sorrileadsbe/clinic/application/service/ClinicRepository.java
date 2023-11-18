package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;

import java.util.List;
import java.util.UUID;

public interface ClinicRepository {
    Clinic save(Clinic clinic);

    List<Clinic> buscaAllClinics();

    Clinic buscaClinicPerId(UUID idClinic);

    void deleteClinic(Clinic clinic);
}
