package academy.wakanda.sorrileadsbe.communication.infra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import academy.wakanda.sorrileadsbe.application.service.DataHelper;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.handler.APIException;
import feign.FeignException;

@ExtendWith(MockitoExtension.class)
public class CommunicationInfraIntegratorTest {

	@Mock
	private CommunicationZapiClientIntegrator zapiClientIntegrator;

	private CommunicationInfraIntegrator communicationInfraIntegrator;

	@BeforeEach
	void setUp() {
		communicationInfraIntegrator = new CommunicationInfraIntegrator(zapiClientIntegrator);
	}

	@Test
	void testSendMessage_Success() {
		MessageRequest messageRequest = new MessageRequest("73982580811", "Ola");
		MessageResponse expectedResponse = new MessageResponse("456", "123", "789");
		Clinic clinic = DataHelper.createTestClinic();

		when(zapiClientIntegrator.sendMessage(messageRequest, clinic.getKeyZapi(), clinic.getTokenZapi(), clinic.getClientToken())).thenReturn(expectedResponse);

		MessageResponse actualResponse = communicationInfraIntegrator.sendMessage(messageRequest, clinic);

		assertEquals(expectedResponse, actualResponse);
	}

	@Test
	void testSendMessage_FeignException() {
		MessageRequest messageRequest = new MessageRequest("73982580811", "Ola");
		FeignException feignException = mock(FeignException.class);
		Clinic clinic = DataHelper.createTestClinic();

		when(zapiClientIntegrator.sendMessage(messageRequest, clinic.getKeyZapi(), clinic.getTokenZapi(), clinic.getClientToken())).thenThrow(feignException);
		when(feignException.status()).thenReturn(HttpStatus.BAD_REQUEST.value());
		when(feignException.contentUTF8()).thenReturn("Error response message");

		assertThrows(APIException.class, () -> communicationInfraIntegrator.sendMessage(messageRequest, clinic));
	}

	@Test
	void testSendMessage_CustomException() {
	    MessageRequest messageRequest = new MessageRequest("73982580811", "Ola");
	    HttpStatus expectedStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	    String expectedErrorMessage = "Ocorreu uma exceção Não Tratada";
	    Clinic clinic = DataHelper.createTestClinic();

	    APIException customException = APIException.build(expectedStatus, expectedErrorMessage);

	    when(zapiClientIntegrator.sendMessage(messageRequest, expectedErrorMessage, expectedErrorMessage, expectedErrorMessage)).thenThrow(customException);

	    APIException apiException = assertThrows(APIException.class, () -> communicationInfraIntegrator.sendMessage(messageRequest, clinic));

	    // Verifique se a exceção lançada tem o mesmo status e mensagem de erro esperados
	    assertEquals(expectedStatus, apiException.getStatusException());
	    assertEquals(expectedErrorMessage, apiException.getMessage());
	}
	
}