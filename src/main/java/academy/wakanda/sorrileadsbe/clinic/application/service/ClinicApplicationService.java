package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicResponse;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClinicApplicationService implements ClinicService {
    private final ClinicRepository clinicRepository;

    @Override
    public ClinicResponse createClinic(ClinicRequest clinicRequest) {
        log.info("[start] ClinicApplicationService -  createClinic");
        Clinic clinic= clinicRepository.save(new Clinic(clinicRequest));
        log.info("[finish] ClinicApplicationService -  createClinic");
        return new ClinicResponse(clinic);
    }
}
