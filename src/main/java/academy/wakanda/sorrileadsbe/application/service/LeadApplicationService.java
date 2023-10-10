package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;
import academy.wakanda.sorrileadsbe.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.domain.Lead;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class LeadApplicationService implements LeadService {
    @Autowired
    private LeadRepository leadRepository;

    @Override
    public LeadResponse createLead(LeadRequest leadRequest) {
        log.info("[start] RespondentApplicationService - createLead");
        Lead lead = leadRepository.save(new Lead(leadRequest));
        log.info("[finish] RespondentApplicationService - createLead");
        return LeadResponse.builder()
                .idLead(lead.getIdLead())
                .build();
    }
}