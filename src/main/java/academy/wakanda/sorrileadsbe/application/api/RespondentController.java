package academy.wakanda.sorrileadsbe.application.api;


import academy.wakanda.sorrileadsbe.application.service.RespondentService;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class RespondentController implements RespondentApi {

    @Autowired
    private RespondentService respondentService;

    @SneakyThrows
    @Override
    public RespondentResponse postRespondent(RespondentRequest respondentRequest) {
        log.info("[start] RespondentController - postRespondent");
        RespondentResponse respondentCreated = respondentService.createRespondent(respondentRequest);
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
}
