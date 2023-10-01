package academy.wakanda.sorrileadsbe.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/respondent")
public interface RespondentApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    RespondentResponse postRespondent ( RespondentRequest respondentRequest);

}
