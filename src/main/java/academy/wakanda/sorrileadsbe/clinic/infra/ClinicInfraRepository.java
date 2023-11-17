package academy.wakanda.sorrileadsbe.clinic.infra;

import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicRepository;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClinicInfraRepository implements ClinicRepository {
    private final ClinicSpringDataJPARepository clinicSpringDataJPARepository;
    @Override
    public Clinic save(Clinic clinic) {
        log.info("[start]  ClinicInfraRepository - save");
        clinicSpringDataJPARepository.save(clinic);
        log.info("[finish]  ClinicInfraRepository - save");
        return clinic;
    }

    @Override
    public List<Clinic> buscaAllClinics() {
        log.info("[start]  ClinicInfraRepository - buscaAllClinics");
        List<Clinic> allClinics = clinicSpringDataJPARepository.findAll();
        log.info("[finish]  ClinicInfraRepository - buscaAllClinics");
        return allClinics;
    }
}
