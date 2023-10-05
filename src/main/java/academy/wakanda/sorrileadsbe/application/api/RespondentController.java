package academy.wakanda.sorrileadsbe.application.api;


import academy.wakanda.sorrileadsbe.application.service.RespondentService;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class RespondentController implements RespondentApi {
    @Autowired
    private RespondentService respondentService;

    @Override
    public RespondentResponse postRespondent(List<RespondentRequest> respondentRequest) {
        log.info("[start] RespondentController - postRespondent");
        RespondentResponse respondentCreated = respondentService.createRespondent(respondentRequest.get(0));
        log.info("[finish] RespondentController - postRespondent");
        return respondentCreated;
    }

    @Override
    public List<RespondentListResponse> getListRespondents() {
        log.info("[start] RespondentController - getListRespondents");
        List<RespondentListResponse> respondents = respondentService.searchAllRespondents();
        log.info("[finish] RespondentController - getListRespondents");
        return respondents;
    }

    @Override
    public List<RespondestsListResponsePerChoice> getRespondentsPerChoice(MultipleChoice multipleChoice) {
        log.info("[start] RespondentController - getRespondentsPerChoice");
        List<RespondestsListResponsePerChoice> respondents = respondentService.searchAllRespondentsPerChoice(multipleChoice);
        log.info("[finish] RespondentController - getRespondentsPerChoice");
        return respondents;
    }

    @Override
    public RespondentDetailResponse getRespondentPerId(UUID idRespondent) {
        log.info("[start] RespondentController - getRespondentPerId");
        log.info("[idRespondent] {}", idRespondent);
        RespondentDetailResponse detailedResponse = respondentService.getRespondentPerId(idRespondent);
        log.info("[finish] RespondentController - getRespondentPerId");
        return detailedResponse;
    }
}