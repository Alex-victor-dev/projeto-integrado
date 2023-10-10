package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;
import academy.wakanda.sorrileadsbe.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Lead;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class LeadApplicationService implements LeadService {
    @Autowired
    private LeadRepository leadRepository;

    @Override
    public LeadResponse createRespondent(LeadRequest leadRequest) {
        log.info("[start] RespondentApplicationService - createRespondent");
        Lead lead = leadRepository.save(new Lead(leadRequest));
        log.info("[finish] RespondentApplicationService - createRespondent");
        return LeadResponse.builder()
                .idRespondent(lead.getIdRespondent())
                .build();
    }

    @Override
    public List<LeadListResponse> searchAllRespondents() {
        log.info("[start] RespondentApplicationService - searchAllRespondents");
        List<Lead> leads = leadRepository.searchAllRespondents();
        log.info("[finish] RespondentApplicationService - searchAllRespondents");
        return LeadListResponse.convert(leads);
    }

    @Override
    public List<LeadListResponsePerChoice> searchAllRespondentsPerChoice(MultipleChoice multipleChoice) {
        log.info("[start] RespondentApplicationService - searchAllRespondentsPerChoice");
        List<Lead> leads = leadRepository.searchAllRespondentsPerChoice(multipleChoice);
        log.info("[finish] RespondentApplicationService - searchAllRespondentsPerChoice");
        return LeadListResponsePerChoice.convert(leads);
    }

    @Override
    public LeadDetailResponse getRespondentPerId(UUID idRespondent) {
        log.info("[start] RespondentApplicationService - getRespondentPerId");
        Lead lead = leadRepository.getRespondentPerId(idRespondent);
        log.info("[finish] RespondentApplicationService - getRespondentPerId");
        return new LeadDetailResponse(lead);
    }
}