package academy.wakanda.sorrileadsbe.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/lead")
public interface LeadApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    LeadResponse postLead(@Valid @RequestBody LeadRequest leadRequest);
}