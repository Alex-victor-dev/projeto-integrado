package academy.wakanda.sorrileadsbe.communication.infra;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.handler.APIException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@RequiredArgsConstructor
public class CommunicationInfraIntegrator implements CommunicationIntegrator {

	private final CommunicationZapiClientIntegrator zapiClientIntegrator;

	@Override
	public MessageResponse sendMessage(MessageRequest messageRequest) {
		log.info("[inicia] CommunicationInfraIntegrator - sendMessage");
		try {
			MessageResponse messageResponse = zapiClientIntegrator.sendMessage(messageRequest);
			log.info("[messageResponse] {}", messageResponse);
			return messageResponse;
			
		} catch (FeignException feignException) {
			log.error("Erro ao chamar a API externa com FeignException", feignException);
			throw APIException.build(HttpStatus.BAD_REQUEST, "Falha Na Integração com a API DO ZAPI");
		
		} catch (Exception e) {
			log.error("Ocorreu uma exceção não tratada", e);
			throw APIException.build(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu uma exceção Não Tratada");
			
		} finally {
			log.info("[finaliza] CommunicationInfraIntegrator - sendMessage");
		}
	}
}
