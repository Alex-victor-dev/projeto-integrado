package academy.wakanda.sorrileadsbe.infra;

import academy.wakanda.sorrileadsbe.application.repository.RespondentRepository;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class RespondentInfraRepository implements RespondentRepository {

    @Autowired
    private RespondentSpringDataJPARepository respondentSpringDataJPARepository;

    @Override
    public Respondent save(Respondent respondent) {
        log.info("[start] RespondentInfraRepository - save");
        respondentSpringDataJPARepository.save(respondent);
        log.info("[finish] RespondentInfraRepository - save");
        return respondent;
    }

    @Override
    public List<Respondent> searchAllRespondents() {
        log.info("[start] RespondentInfraRepository - searchAllRespondents");
        List<Respondent> allRespondents = respondentSpringDataJPARepository.findAll();
        log.info("[finish] RespondentInfraRepository - searchAllRespondents");
        return allRespondents;
    }

    @Override
    public List<Respondent> searchAllRespondentsPerChoice(MultipleChoice multipleChoice) {
        log.info("[start] RespondentInfraRepository - searchAllRespondentsPerChoice");
        log.info("[finish] RespondentInfraRepository - searchAllRespondentsPerChoice");
        return null;
    }
}
