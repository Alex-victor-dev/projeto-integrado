package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;

public interface ClinicRepository {
    Clinic save(Clinic clinic);
}
