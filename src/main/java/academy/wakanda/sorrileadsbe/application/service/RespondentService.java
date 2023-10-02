package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.RespondentListResponse;
import academy.wakanda.sorrileadsbe.application.api.RespondentRequest;
import academy.wakanda.sorrileadsbe.application.api.RespondentResponse;

import java.util.List;

public interface RespondentService {
    RespondentResponse createRespondent(RespondentRequest respondentRequest);
    List<RespondentListResponse> searchAllRespondents();

}
