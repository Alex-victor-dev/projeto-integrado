package academy.wakanda.sorrileadsbe.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/respondent")
public interface RespondentApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    RespondentResponse postRespondent (@Valid @RequestBody RespondentRequest respondentRequest);

}
