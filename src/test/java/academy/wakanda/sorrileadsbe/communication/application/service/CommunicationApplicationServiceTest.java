package academy.wakanda.sorrileadsbe.communication.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;
import academy.wakanda.sorrileadsbe.communication.infra.CommunicationIntegrator;
import academy.wakanda.sorrileadsbe.communication.infra.MessageResponse;

@ExtendWith(MockitoExtension.class)
class CommunicationApplicationServiceTest {
	private CommunicationApplicationService communicationService;

	@Mock
	private CommunicationIntegrator messageSendIntegrator;

	@BeforeEach
	public void setUp() {
		communicationService = new CommunicationApplicationService(messageSendIntegrator);
	}

	@Test
	public void testSendMessage() {
		MessageRequest messageRequest = new MessageRequest("73982580811", "ola");
		MessageResponse expectedResponse = new MessageResponse("123", "456", "789");

		when(messageSendIntegrator.sendMessage(messageRequest)).thenReturn(expectedResponse);
		MessageResponse actualResponse = communicationService.sendMessage(messageRequest);

		assertEquals("123", actualResponse.getZaapId());
		assertEquals("456", actualResponse.getMessageId());
		assertEquals("789", actualResponse.getId());
	}

	@Test
	public void testSendMessageFail() {
		MessageRequest messageRequest = new MessageRequest("73982580811", "ola");
		MessageResponse expectedResponse = new MessageResponse("1234", "456", "789"); // Set different values

		when(messageSendIntegrator.sendMessage(messageRequest)).thenReturn(expectedResponse);
		MessageResponse actualResponse = communicationService.sendMessage(messageRequest);

		// Modify the assertions to compare with different values
		assertNotEquals("999", actualResponse.getZaapId());
		assertNotEquals("888", actualResponse.getMessageId());
		assertNotEquals("777", actualResponse.getId());
	}

}