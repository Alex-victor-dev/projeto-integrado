package academy.wakanda.sorrileadsbe.message.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import academy.wakanda.sorrileadsbe.message.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.message.domain.MessageIntegrator;

@FeignClient(name = "messageInfraClient", url = "https://api.z-api.io/instances/SUA_INSTANCIA/token/SEU_TOKEN/send-text")
public interface MessageClientIntegrator {

	@PostMapping("send-text")
	MessageIntegrator sendMessage(@RequestParam("suaInstancia") String instancia,
								  @RequestParam("seuToken") String token,
								  @RequestBody MessageRequest messageRequest);

}
