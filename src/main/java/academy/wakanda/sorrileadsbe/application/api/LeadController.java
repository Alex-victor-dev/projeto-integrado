package academy.wakanda.sorrileadsbe.application.api;


import academy.wakanda.sorrileadsbe.application.service.LeadService;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class LeadController implements LeadApi {
    @Autowired
    private LeadService leadService;

    @Override
    public LeadResponse postRespondent(List<LeadRequest> leadRequest) {
        log.info("[start] RespondentController - postRespondent");
        LeadResponse respondentCreated = leadService.createRespondent(leadRequest.get(0));
        log.info("[finish] RespondentController - postRespondent");
        return respondentCreated;
    }

    @Override
    public List<LeadListResponse> getListRespondents() {
        log.info("[start] RespondentController - getListRespondents");
        List<LeadListResponse> respondents = leadService.searchAllRespondents();
        log.info("[finish] RespondentController - getListRespondents");
        return respondents;
    }

    @Override
    public List<LeadListResponsePerChoice> getRespondentsPerChoice(MultipleChoice multipleChoice) {
        log.info("[start] RespondentController - getRespondentsPerChoice");
        List<LeadListResponsePerChoice> respondents = leadService.searchAllRespondentsPerChoice(multipleChoice);
        log.info("[finish] RespondentController - getRespondentsPerChoice");
        return respondents;
    }

    @Override
    public LeadDetailResponse getRespondentPerId(UUID idRespondent) {
        log.info("[start] RespondentController - getRespondentPerId");
        log.info("[idRespondent] {}", idRespondent);
        LeadDetailResponse detailedResponse = leadService.getRespondentPerId(idRespondent);
        log.info("[finish] RespondentController - getRespondentPerId");
        return detailedResponse;
    }
}