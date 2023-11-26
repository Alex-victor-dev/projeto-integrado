package academy.wakanda.sorrileadsbe.lead.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/lead/{idClinic}/clinic")
public interface LeadApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    LeadResponse postLead(@Valid @RequestBody LeadRequest leadRequest, @PathVariable UUID idClinic);

}