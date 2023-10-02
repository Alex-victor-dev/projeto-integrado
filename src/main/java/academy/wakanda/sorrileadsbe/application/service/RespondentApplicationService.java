package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.RespondentListResponse;
import academy.wakanda.sorrileadsbe.application.api.RespondentRequest;
import academy.wakanda.sorrileadsbe.application.api.RespondentResponse;
import academy.wakanda.sorrileadsbe.application.repository.RespondentRepository;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
