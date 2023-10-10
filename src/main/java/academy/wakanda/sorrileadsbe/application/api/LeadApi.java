package academy.wakanda.sorrileadsbe.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/respondent")
public interface LeadApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    LeadResponse postLead(@Valid @RequestBody List<LeadRequest> leadRequest);
}