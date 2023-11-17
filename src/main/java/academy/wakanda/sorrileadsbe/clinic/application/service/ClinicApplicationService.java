package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ClinicApplicationService implements ClinicService {
    @Override
    public ClinicResponse createClinic(ClinicRequest clinicRequest) {
        log.info("[start] ClinicApplicationService -  createClinic");
        log.info("[finish] ClinicApplicationService -  createClinic");
        return null;
    }
}
