package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicRequest;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicResponse;
import academy.wakanda.sorrileadsbe.clinic.application.api.ClinicUpdateRequest;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.handler.APIException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
@Builder
public class ClinicApplicationService implements ClinicService {
    private final ClinicRepository clinicRepository;

    @Override
    public ClinicResponse createClinic(ClinicRequest clinicRequest) {
        log.info("[start] ClinicApplicationService -  createClinic");
        Clinic clinic = new Clinic(clinicRequest);
        clinic.validateZapiUrl()
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "URL do ZAPI inválida."));
        Clinic savedClinic = clinicRepository.save(clinic);
        log.info("[finish] ClinicApplicationService - createClinic");
        return new ClinicResponse(savedClinic);
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