package academy.wakanda.sorrileadsbe.communication.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;

@FeignClient(name = "messageClientIntegrator", url = "${sorrileads.zapi.server}")
public interface CommunicationZapiClientIntegrator {

	@PostMapping("/instances/{idInstancia}/token/{token}/send-text")
    MessageResponse sendMessage(@RequestBody MessageRequest messageRequest,
                                @PathVariable("idInstancia") String idInstancia,
                                @PathVariable("token") String token,
                                @RequestHeader("Client-Token") String clientToken);
}