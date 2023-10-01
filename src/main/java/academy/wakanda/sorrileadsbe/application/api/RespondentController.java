package academy.wakanda.sorrileadsbe.application.api;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class RespondentController implements RespondentApi {


    @Override
    public RespondentResponse postRespondent(RespondentRequest respondentRequest) {
        log.info("[start] RespondentController - postRespondent");
        log.info("[finish] RespondentController - postRespondent");
        return null;
    }
}
