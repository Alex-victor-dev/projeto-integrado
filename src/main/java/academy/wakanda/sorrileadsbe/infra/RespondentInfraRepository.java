package academy.wakanda.sorrileadsbe.infra;

import academy.wakanda.sorrileadsbe.application.repository.RespondentRepository;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class RespondentInfraRepository implements RespondentRepository {

    @Autowired
    private RespondentSpringDataJPARepository respondentSpringDataJPARepository;

    @Override
    public Respondent salva(Respondent respondent) {
        log.info("[start] RespondentInfraRepository - salvar");
        respondentSpringDataJPARepository.save(respondent);
        log.info("[finish] RespondentInfraRepository - salvar");
        return respondent;
    }
}
