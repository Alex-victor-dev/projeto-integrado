package academy.wakanda.sorrileadsbe.infra;

import academy.wakanda.sorrileadsbe.domain.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LeadSpringDataJPARepository extends JpaRepository<Lead, UUID> {

}