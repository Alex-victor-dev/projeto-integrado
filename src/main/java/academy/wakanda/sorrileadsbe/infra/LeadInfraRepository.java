package academy.wakanda.sorrileadsbe.infra;

import academy.wakanda.sorrileadsbe.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Lead;
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
public class LeadInfraRepository implements LeadRepository {
    @Autowired
    private LeadSpringDataJPARepository leadSpringDataJPARepository;

    @Override
    public Lead save(Lead lead) {
        log.info("[start] RespondentInfraRepository - save");
        try {
        leadSpringDataJPARepository.save(lead);
        } catch(DataIntegrityViolationException e){
        throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um registro com esse phone!",e);
        }
        log.info("[finish] RespondentInfraRepository - save");
        return lead;
    }

    @Override
    public List<Lead> searchAllRespondents() {
        log.info("[start] RespondentInfraRepository - searchAllRespondents");
        List<Lead> allLeads = leadSpringDataJPARepository.findAll();
        log.info("[finish] RespondentInfraRepository - searchAllRespondents");
        return allLeads;
    }

    @Override
    public List<Lead> searchAllRespondentsPerChoice(MultipleChoice multipleChoice) {
        log.info("[start] RespondentInfraRepository - searchAllRespondentsPerChoice");
        List<Lead> allLeadPerChoice = leadSpringDataJPARepository.findByMultipleChoice(multipleChoice);
        if (allLeadPerChoice.isEmpty()) {
            throw APIException.build(HttpStatus.NOT_FOUND,
                    "Nenhum Respondent encontrado para a escolha múltipla!");
        }
        log.info("[finish] RespondentInfraRepository - searchAllRespondentsPerChoice");
        return allLeadPerChoice;
    }

    @Override
    public Lead getRespondentPerId(UUID idRespondent) {
        log.info("[start] RespondentInfraRepository - getRespondentPerId");
        Lead lead = leadSpringDataJPARepository
                .findById(idRespondent).orElseThrow(
                        ()-> APIException.build(HttpStatus.NOT_FOUND,
                               "Respondent não encontrado!" ));
        log.info("[finish] RespondentInfraRepository - getRespondentPerId");
        return lead;
    }
}