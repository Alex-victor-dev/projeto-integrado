package academy.wakanda.sorrileadsbe.infra;

import academy.wakanda.sorrileadsbe.application.repository.RespondentRepository;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import academy.wakanda.sorrileadsbe.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class RespondentInfraRepository implements RespondentRepository {
    @Autowired
    private RespondentSpringDataJPARepository respondentSpringDataJPARepository;

    @Override
    public Respondent save(Respondent respondent) {
        log.info("[start] RespondentInfraRepository - save");
        try {
        respondentSpringDataJPARepository.save(respondent);
        } catch(DataIntegrityViolationException e){
        throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um registro com esse phone!",e);
        }
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
        List<Respondent> allRespondentsPerChoice = respondentSpringDataJPARepository.findByMultipleChoice(multipleChoice);
        if (allRespondentsPerChoice.isEmpty()) {
            throw APIException.build(HttpStatus.NOT_FOUND,
                    "Nenhum Respondent encontrado para a escolha múltipla!");
        }
        log.info("[finish] RespondentInfraRepository - searchAllRespondentsPerChoice");
        return allRespondentsPerChoice;
    }

    @Override
    public Respondent getRespondentPerId(UUID idRespondent) {
        log.info("[start] RespondentInfraRepository - getRespondentPerId");
        Respondent respondent = respondentSpringDataJPARepository
                .findById(idRespondent).orElseThrow(
                        ()-> APIException.build(HttpStatus.NOT_FOUND,
                               "Respondent não encontrado!" ));
        log.info("[finish] RespondentInfraRepository - getRespondentPerId");
        return respondent;
    }
}