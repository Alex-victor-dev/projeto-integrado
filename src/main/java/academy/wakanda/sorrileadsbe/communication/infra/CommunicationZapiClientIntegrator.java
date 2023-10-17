package academy.wakanda.sorrileadsbe.communication.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;

@FeignClient(name = "messageClientIntegrator", url = "${sorrileads.zapi.server}/instances/${sorrileads.zapi.id-instancia}/token/${sorrileads.zapi.token}")
public interface CommunicationZapiClientIntegrator {

	@PostMapping("/send-text")
	MessageResponse sendMessage(@RequestBody  MessageRequest messageRequest) ;

}
