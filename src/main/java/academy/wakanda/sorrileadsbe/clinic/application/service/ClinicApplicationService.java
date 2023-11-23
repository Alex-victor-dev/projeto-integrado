package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicResponse;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicUpdateRequest;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
@Builder
public class ClinicApplicationService implements ClinicService {
    private final ClinicRepository clinicRepository;
    private final WebhookService webhookService;

    @Override
    public ClinicResponse createClinic(ClinicRequest clinicRequest) {
        log.info("[start] ClinicApplicationService - createClinic");
        Clinic.validateEmail(clinicRequest.getEmail(), clinicRepository);
        Clinic clinic= clinicRepository.save(new Clinic(clinicRequest));
        String webhookUrl = webhookService.generateWebhookUrl(clinic.getIdClinic());
        clinic.relacionaWebhookUrl(clinicRepository, webhookUrl);
        log.info("[finish] ClinicApplicationService - createClinic");
        return new ClinicResponse(clinic);
    }

    @Override
    public void patchUpdateClinic(UUID idClinic, ClinicUpdateRequest clinicUpdateRequest) {
        log.info("[start] ClinicApplicationService - patchUpdateClinic");
        Clinic clinic = clinicRepository.buscaClinicPerId(idClinic);
        clinic.update(clinicUpdateRequest);
        clinicRepository.save(clinic);
        log.info("[finish] ClinicApplicationService - patchUpdateClinic");
    }
}