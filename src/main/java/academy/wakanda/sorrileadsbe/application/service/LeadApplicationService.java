package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;
import academy.wakanda.sorrileadsbe.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.domain.Lead;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class LeadApplicationService implements LeadService {
    private final LeadRepository leadRepository;

    @Override
    public LeadResponse createLead(LeadRequest leadRequest) {
        log.info("[start]  LeadApplicationService- createLead");
        Lead lead = leadRepository.save(new Lead(leadRequest));
        log.info("[finish]  LeadApplicationService - createLead");
        return LeadResponse.builder()
                .idLead(lead.getIdLead()).build();
    }
}