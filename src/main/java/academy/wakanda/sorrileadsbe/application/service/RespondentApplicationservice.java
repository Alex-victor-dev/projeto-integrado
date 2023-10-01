package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.RespondentRequest;
import academy.wakanda.sorrileadsbe.application.api.RespondentResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RespondentApplicationservice implements RespondentService {
    @Override
    public RespondentResponse criaRespondent(RespondentRequest respondentRequest) {
        log.info("[start] RespondentApplicationservice - criaRespondent");
        log.info("[finish] RespondentApplicationservice - criaRespondent");
        return null;
    }
}
