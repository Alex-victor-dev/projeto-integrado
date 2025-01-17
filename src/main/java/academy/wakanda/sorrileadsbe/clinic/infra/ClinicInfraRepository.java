package academy.wakanda.sorrileadsbe.clinic.infra;

import academy.wakanda.sorrileadsbe.clinic.application.service.ClinicRepository;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

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
    public Clinic buscaClinicPerId(UUID idClinic) {
        log.info("[start] ClinicInfraRepository - buscaClinicPerId");
        Clinic clinic  = clinicSpringDataJPARepository.findById(idClinic)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Clínica não encontrada!"));
        log.info("[finish] ClinicInfraRepository - buscaClinicPerId");
        return clinic;
    }

    @Override
    public Optional<Clinic> findByEmail(String email) {
        log.info("[start] ClinicInfraRepository - findByEmail");
        Optional<Clinic> clinic = clinicSpringDataJPARepository.findByEmail(email);
        log.info("[finish] ClinicInfraRepository - findByEmail");
        return clinic;
    }

}
