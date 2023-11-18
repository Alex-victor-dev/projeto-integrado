package academy.wakanda.sorrileadsbe.clinic.application.service;

import academy.wakanda.sorrileadsbe.clinic.application.api.*;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<ClinicListResponse> buscaAllClinics() {
        log.info("[start] ClinicApplicationService - buscaAllClinics");
        List<Clinic> clinics = clinicRepository.buscaAllClinics();
        log.info("[finish] ClinicApplicationService - buscaAllClinics");
        return ClinicListResponse.converte(clinics);
    }

    @Override
    public ClinicDetailedResponse buscaClinicPerId(UUID idClinic) {
    log.info("[start] ClinicApplicationService - buscaClinicPerId");
    Clinic clinic = clinicRepository.buscaClinicPerId(idClinic);
    log.info("[finish] ClinicApplicationService - buscaClinicPerId");
    return new ClinicDetailedResponse(clinic);
    }

    @Override
    public void deleteClinicPerId(UUID idClinic) {
        log.info("[start] ClinicApplicationService - deleteClinicPerId");
        Clinic clinic = clinicRepository.buscaClinicPerId(idClinic);
        clinicRepository.deleteClinic(clinic);
        log.info("[start] ClinicApplicationService - deleteClinicPerId");

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
