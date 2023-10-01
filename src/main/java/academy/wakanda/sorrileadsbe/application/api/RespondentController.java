package academy.wakanda.sorrileadsbe.application.api;


import academy.wakanda.sorrileadsbe.application.service.RespondentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class RespondentController implements RespondentApi {


    private RespondentService respondentService;

    @SneakyThrows
    @Override
    public RespondentResponse postRespondent(RespondentRequest respondentRequest) {
        log.info("[start] RespondentController - postRespondent");
        RespondentResponse respondentCriado = respondentService.criaRespondent(respondentRequest);
        log.info("[finish] RespondentController - postRespondent");
        return null;
    }
}
