package academy.wakanda.sorrileadsbe.lead.application.api;

import academy.wakanda.sorrileadsbe.lead.application.service.LeadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class LeadController implements LeadApi {
    private final LeadService leadService;

    @Override
    public LeadResponse postLead(LeadRequest leadRequest, UUID idClinic) {
        log.info("[start]  LeadController - postLead");
        LeadResponse leadCreated = leadService.createLead(leadRequest, idClinic);
        log.info("[finish]  LeadController - postLead");
        return leadCreated;
    }
}