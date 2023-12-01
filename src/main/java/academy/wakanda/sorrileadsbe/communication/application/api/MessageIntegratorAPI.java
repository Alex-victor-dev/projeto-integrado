package academy.wakanda.sorrileadsbe.communication.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;

@RestController
@RequestMapping
public interface MessageIntegratorAPI {

	@PostMapping("/send-text")
	@ResponseStatus(value = HttpStatus.CREATED)
	MessageResponse sendMessage(@Valid @RequestBody MessageRequest messageRequest, Clinic clinic);
}
