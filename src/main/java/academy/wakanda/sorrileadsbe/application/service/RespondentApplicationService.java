package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;
import academy.wakanda.sorrileadsbe.application.repository.RespondentRepository;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class RespondentApplicationService implements RespondentService {

    @Autowired
    private RespondentRepository respondentRepository;

    @SneakyThrows
    @Override
    public RespondentResponse createRespondent(RespondentRequest respondentRequest) {
        log.info("[start] RespondentApplicationService - createRespondent");
        Respondent respondent = respondentRepository.save(new Respondent(respondentRequest));
        log.info("[finish] RespondentApplicationService - createRespondent");
        return RespondentResponse.builder()
                .idRespondent(respondent.getIdRespondent())
                .build();
    }
    @Override
    public List<RespondentListResponse> searchAllRespondents() {
        log.info("[start] RespondentApplicationService - searchAllRespondents");
        List<Respondent> respondents = respondentRepository.searchAllRespondents();
        log.info("[finish] RespondentApplicationService - searchAllRespondents");
        return RespondentListResponse.convert(respondents);
    }

    @Override
    public List<RespondestsListResponsePerChoice> searchAllRespondentsPerChoice(MultipleChoice multipleChoice) {
        log.info("[start] RespondentApplicationService - searchAllRespondentsPerChoice");
        List<Respondent> respondents = respondentRepository.searchAllRespondentsPerChoice(multipleChoice);
        log.info("[finish] RespondentApplicationService - searchAllRespondentsPerChoice");
        return RespondestsListResponsePerChoice.convert(respondents);
    }

    @Override
    public RespondentDetailResponse getRespondentPerId(UUID idRespondent) {
        log.info("[start] RespondentApplicationService - getRespondentPerId");
        Respondent respondent = respondentRepository.getRespondentPerId(idRespondent);
        log.info("[finish] RespondentApplicationService - getRespondentPerId");
        return new RespondentDetailResponse(respondent);
    }
}
