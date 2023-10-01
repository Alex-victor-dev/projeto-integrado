package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.RespondentRequest;
import academy.wakanda.sorrileadsbe.application.api.RespondentResponse;

public interface RespondentService {
    RespondentResponse criaRespondent(RespondentRequest respondentRequest) ;
}
