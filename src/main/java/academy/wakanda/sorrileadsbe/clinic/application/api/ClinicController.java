package academy.wakanda.sorrileadsbe.clinic.application.api;

import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClinicController implements ClinicAPI {
    private final ClinicService clinicService;

    @Override
    public ClinicResponse postClinic(ClinicRequest clinicRequest) {
        log.info("[start] ClinicController - postClinic ");
        ClinicResponse clinicCreated = clinicService.createClinic(clinicRequest);
        log.info("[finish] ClinicController - postClinic ");
        return clinicCreated;
    }
    @Override
    public void patchUpdateClinic(UUID idClinic, ClinicUpdateRequest clinicUpdateRequest) {
        log.info("[start] ClinicController - patchUpdateClinic");
        log.info("[idClinic] {}", idClinic);
        clinicService.patchUpdateClinic(idClinic, clinicUpdateRequest);
        log.info("[finish] ClinicController - patchUpdateClinic");
    }
}
