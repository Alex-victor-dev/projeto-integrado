package academy.wakanda.sorrileadsbe.application.api;


import academy.wakanda.sorrileadsbe.application.service.RespondentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class RespondentController implements RespondentApi {

    @Autowired
    private RespondentService respondentService;

    @SneakyThrows
    @Override
    public RespondentResponse postRespondent(RespondentRequest respondentRequest) {
        log.info("[start] RespondentController - postRespondent");
        RespondentResponse respondentCriado = respondentService.criaRespondent(respondentRequest);
        log.info("[finish] RespondentController - postRespondent");
        return respondentCriado;
    }

    @Override
    public List<RespondentListResponse> getListRespondents() {
        log.info("[start] RespondentController - getListRespondents");

        log.info("[finish] RespondentController - getListRespondents");
        return null;
    }
}
