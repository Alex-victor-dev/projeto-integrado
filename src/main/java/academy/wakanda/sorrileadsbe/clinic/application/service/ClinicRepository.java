package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;

import java.util.List;

public interface ClinicRepository {
    Clinic save(Clinic clinic);

    List<Clinic> buscaAllClinics();
}
