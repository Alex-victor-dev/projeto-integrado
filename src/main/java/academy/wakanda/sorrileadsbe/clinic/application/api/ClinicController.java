package academy.wakanda.sorrileadsbe.clinic.application.api;

import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
