package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/respondent")
public interface LeadApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    LeadResponse postLead(@Valid @RequestBody List<LeadRequest> leadRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<LeadListResponse> getListRespondents ();

    @GetMapping(value = "/{multipleChoice}" )
    @ResponseStatus(code = HttpStatus.OK)
    List<LeadListResponsePerChoice> getRespondentsPerChoice
            (@PathVariable MultipleChoice multipleChoice);

    @GetMapping(value = "/id/{idRespondent}")
    @ResponseStatus(code = HttpStatus.OK)
    LeadDetailResponse getRespondentPerId(@PathVariable UUID idRespondent);
}