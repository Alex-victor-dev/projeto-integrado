package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;
import academy.wakanda.sorrileadsbe.domain.MultipleChoice;

import java.util.List;
import java.util.UUID;

public interface RespondentService {
    RespondentResponse createRespondent(RespondentRequest respondentRequest);
    List<RespondentListResponse> searchAllRespondents();
    List<RespondestsListResponsePerChoice> searchAllRespondentsPerChoice(MultipleChoice multipleChoice);
    RespondentDetailResponse getRespondentPerId(UUID idRespondent);
}
