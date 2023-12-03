package academy.wakanda.sorrileadsbe.lead.domain;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import academy.wakanda.sorrileadsbe.application.service.DataHelper;
import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;

@ExtendWith(MockitoExtension.class)
public class MensagemBoasVindasLeadTest {

	@InjectMocks
	private MensagemBoasVindasLead mensagemBoasVindasLead;

	@Mock
	private Clinic clinic;

	@Mock
	private Lead lead;

	@Test
	public void testGetMessage() {
		Clinic clinic = DataHelper.createTestClinic();
		Lead lead = DataHelper.getTestLead();
		String message = "{nome}, vimos que você se interessou "
				+ "por {nome do tratamento}.🔝\r\n"
				+ "E que também adicionou esse comentário: {descrição personalizada} 📝\r\n"
				+ "Estamos animados para te ajudar nesta jornada por um Sorriso mais bonito e saudável.🤗\r\n"
				+ "Em breve uma das nossas secretárias continuará seu atendimento! 👩🏽‍💼";

		MensagemBoasVindasLead mensagemBoasVindasLead = new MensagemBoasVindasLead(clinic, lead);
		MessageRequest messageRequest = mensagemBoasVindasLead.getMessage();

		assertEquals(message, clinic.obtemMensagemBoasVindas());
		assertEquals(lead.getPhone(), messageRequest.getPhone());
	}

    @Test
    public void testConstructorPersonalizedMessage() {
    	Clinic clinic = DataHelper.createTestClinic();
		Lead lead = DataHelper.getTestLead();
    	String message = "{nome}, vimos que você se interessou "
				+ "por {nome do tratamento}.🔝\r\n"
				+ "E que também adicionou esse comentário: {descrição personalizada} 📝\r\n"
				+ "Estamos animados para te ajudar nesta jornada por um Sorriso mais bonito e saudável.🤗\r\n"
				+ "Em breve uma das nossas secretárias continuará seu atendimento! 👩🏽‍💼";
    	
    	MensagemBoasVindasLead mensagemBoasVindasLead = new MensagemBoasVindasLead(clinic, lead);
        String mensagemPersonalizada = mensagemBoasVindasLead.constructorPersonalizedMessage(message);

        String personalizedMessage ="*teste1*, vimos que você se interessou "
        		+ "por *CLAREAMENTO DENTAL*.🔝\r\n"
                + "E que também adicionou esse comentário: *sim* 📝\r\n"
                + "Estamos animados para te ajudar nesta jornada por um Sorriso mais bonito e saudável.🤗\r\n"
                + "Em breve uma das nossas secretárias continuará seu atendimento! 👩🏽‍💼";;
        
        assertEquals(personalizedMessage, mensagemPersonalizada);
    }

	@Test
	public void testVerificaDescricao() {
		String mensagemPadraoSemDescricao = mensagemBoasVindasLead.verificaDescrição(null, "Mensagem padrão");
		assertEquals("Mensagem padrão", mensagemPadraoSemDescricao);

		String mensagemPadraoComDescricao = mensagemBoasVindasLead.verificaDescrição("Descrição", "Mensagem padrão");
		assertEquals("Mensagem padrão", mensagemPadraoComDescricao);
	}
}