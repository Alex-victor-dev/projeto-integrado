package academy.wakanda.sorrileadsbe.clinic.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ClinicController implements ClinicAPI {
    @Override
    public ClinicResponse postClinic(ClinicRequest clinicRequest) {
        log.info("[start] ClinicController - postClinic ");

        log.info("[finish] ClinicController - postClinic ");

        return null;
    }
}
