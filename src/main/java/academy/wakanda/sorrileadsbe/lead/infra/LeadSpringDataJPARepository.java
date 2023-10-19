package academy.wakanda.sorrileadsbe.lead.infra;

import academy.wakanda.sorrileadsbe.lead.domain.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LeadSpringDataJPARepository extends JpaRepository<Lead, UUID> {

}