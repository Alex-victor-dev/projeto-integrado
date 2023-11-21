package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicResponse;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicUpdateRequest;

import java.util.UUID;

public interface ClinicService {
    ClinicResponse createClinic(ClinicRequest clinicRequest, WebhookService webhookService);
    void patchUpdateClinic(UUID idClinic, ClinicUpdateRequest clinicUpdateRequest);
}
