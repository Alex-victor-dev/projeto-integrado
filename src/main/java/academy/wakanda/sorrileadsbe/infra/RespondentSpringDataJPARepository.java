package academy.wakanda.sorrileadsbe.infra;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RespondentSpringDataJPARepository extends JpaRepository<Respondent, UUID> {
    List<Respondent> findByMultipleChoice(MultipleChoice multipleChoice);
}