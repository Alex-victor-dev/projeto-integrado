package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;

import java.util.List;
import java.util.UUID;

public interface LeadService {
    LeadResponse createLead(LeadRequest leadRequest);
    List<LeadListResponse> searchAllRespondents();
    List<LeadListResponsePerChoice> searchAllRespondentsPerChoice(MultipleChoice multipleChoice);
    LeadDetailResponse getRespondentPerId(UUID idRespondent);
}
