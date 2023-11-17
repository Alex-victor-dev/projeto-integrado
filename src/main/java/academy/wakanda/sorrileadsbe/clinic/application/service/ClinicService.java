package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicResponse;

public interface ClinicService {
    ClinicResponse createClinic(ClinicRequest clinicRequest);
}
