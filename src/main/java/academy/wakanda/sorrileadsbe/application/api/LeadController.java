package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.application.service.LeadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class LeadController implements LeadApi {
    @Autowired
    private LeadService leadService;

    @Override
    public LeadResponse postLead(List<LeadRequest> leadRequest) {
        log.info("[start] RespondentController - postLead");
        LeadResponse leadCreated = leadService.createLead(leadRequest.get(0));
        log.info("[finish] RespondentController - postLead");
        return leadCreated;
    }
}