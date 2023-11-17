package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicListResponse;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicResponse;

import java.util.List;

public interface ClinicService {
    ClinicResponse createClinic(ClinicRequest clinicRequest);

    List<ClinicListResponse> buscaAllClinics();
}
