package academy.wakanda.sorrileadsbe.infra;

import academy.wakanda.sorrileadsbe.domain.Respondent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RespondentSpringDataJPARepository extends JpaRepository<Respondent, UUID> {

}
