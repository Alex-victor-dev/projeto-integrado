package academy.wakanda.sorrileadsbe.infra;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LeadSpringDataJPARepository extends JpaRepository<Lead, UUID> {
    List<Lead> findByMultipleChoice(MultipleChoice multipleChoice);
}