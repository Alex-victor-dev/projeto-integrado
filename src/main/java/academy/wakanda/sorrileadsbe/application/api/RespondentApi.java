package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/respondent")
public interface RespondentApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    RespondentResponse postRespondent (@Valid @RequestBody RespondentRequest respondentRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<RespondentListResponse> getListRespondents ();

    @GetMapping(value = "/{multipleChoice}" )
    @ResponseStatus(code = HttpStatus.OK)
    List<RespondestsListResponsePerChoice> getRespondentsPerChoice
            (@PathVariable MultipleChoice multipleChoice);

    @GetMapping(value = "/v2/{idRespondent}")
    @ResponseStatus(code = HttpStatus.OK)
    RespondentDetailResponse getRespondentPerId(@PathVariable UUID idRespondent);

}
