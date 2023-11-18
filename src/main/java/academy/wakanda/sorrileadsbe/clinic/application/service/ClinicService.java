package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.api.*;

import java.util.List;
import java.util.UUID;

public interface ClinicService {
    ClinicResponse createClinic(ClinicRequest clinicRequest);

    List<ClinicListResponse> buscaAllClinics();

    ClinicDetailedResponse buscaClinicPerId(UUID idClinic);

    void deleteClinicPerId(UUID idClinic);

    void patchUpdateClinic(UUID idClinic, ClinicUpdateRequest clinicUpdateRequest);
}
