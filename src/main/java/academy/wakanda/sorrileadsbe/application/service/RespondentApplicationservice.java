package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.RespondentRequest;
import academy.wakanda.sorrileadsbe.application.api.RespondentResponse;
import academy.wakanda.sorrileadsbe.application.repository.RespondentRepository;
import academy.wakanda.sorrileadsbe.domain.Respondent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class RespondentApplicationservice implements RespondentService {

    private RespondentRepository respondentRepository;

    @SneakyThrows
    @Override
    public RespondentResponse criaRespondent(RespondentRequest respondentRequest) {
        log.info("[start] RespondentApplicationservice - criaRespondent");
        Respondent respondent = respondentRepository.salva(new Respondent(respondentRequest));
        log.info("[finish] RespondentApplicationservice - criaRespondent");
        return RespondentResponse.builder()
                .idRespondent(respondent.getIdRespondent())
                .build();
    }
}
