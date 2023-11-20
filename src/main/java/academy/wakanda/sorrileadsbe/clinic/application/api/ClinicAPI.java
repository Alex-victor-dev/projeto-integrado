package academy.wakanda.sorrileadsbe.clinic.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/clinic")
public interface ClinicAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClinicResponse postClinic(@Valid @RequestBody ClinicRequest clinicRequest);

    @PatchMapping(value = "/{idClinic}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchUpdateClinic(@PathVariable UUID idClinic,
                            @Valid @RequestBody ClinicUpdateRequest clinicUpdateRequest);

}

