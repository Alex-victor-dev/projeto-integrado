package academy.wakanda.sorrileadsbe.message.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public interface MessageIntegratorAPI {

	@PostMapping("/send-message")
	@ResponseStatus(value = HttpStatus.CREATED)
	MessageIntegratorResponse sendMessage(@Valid @RequestBody MessageRequest messageRequest);
}
