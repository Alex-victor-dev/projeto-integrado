package academy.wakanda.sorrileadsbe.clinic.infra;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClinicSpringDataJPARepository extends JpaRepository<Clinic, UUID> {
    Optional<Clinic> findByEmail(String email);
}
