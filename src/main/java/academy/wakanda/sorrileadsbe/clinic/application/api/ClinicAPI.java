package academy.wakanda.sorrileadsbe.clinic.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/clinic")
public interface ClinicAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClinicResponse postClinic(@Valid @RequestBody ClinicRequest clinicRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ClinicListResponse> getAllClinics();

    @GetMapping(value = "/{idClinic}")
    @ResponseStatus(code = HttpStatus.OK)
    ClinicDetailedResponse getClinicPerId(@PathVariable UUID idClinic);
}

