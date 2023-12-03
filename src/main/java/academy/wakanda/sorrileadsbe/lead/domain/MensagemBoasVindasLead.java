package academy.wakanda.sorrileadsbe.lead.domain;

import academy.wakanda.sorrileadsbe.clinic.domain.Clinic;
import academy.wakanda.sorrileadsbe.communication.application.api.MessageRequest;

public class MensagemBoasVindasLead {

	private Clinic clinic;
	private Lead lead;

	public MensagemBoasVindasLead(Clinic clinic, Lead lead) {
		this.clinic = clinic;
		this.lead = lead;
	}

	public MessageRequest getMessage() {
		String mensagemPadrao = clinic.obtemMensagemBoasVindas();
		String mensagemPersonalizada = constructorPersonalizedMessage(mensagemPadrao);
		return new MessageRequest(lead.getPhone(), mensagemPersonalizada);
	}

	public String constructorPersonalizedMessage(String mensagemPadrao) {
		String descricaoPersonalizada = lead.getPerguntaEspecificaLead();
		mensagemPadrao = verificaDescrição(descricaoPersonalizada, mensagemPadrao);
		String mensagemPersonalizada = mensagemPadrao
				.replace("{nome}", "*" + lead.getName() + "*")
				.replace("{nome do tratamento}", "*" + lead.getEspecialidadeInteressada().toString().replace("_", " ") + "*");
		return mensagemPersonalizada;
	}

	public String verificaDescrição(String descricaoPersonalizada, String mensagemPadrao) {
		if (descricaoPersonalizada != null && !descricaoPersonalizada.isEmpty()) {
			mensagemPadrao = mensagemPadrao.replace("{descrição personalizada}", "*" + descricaoPersonalizada + "*");
		} else {
			mensagemPadrao = mensagemPadrao
					.replace("E que também adicionou esse comentário: {descrição personalizada} 📝\r\n", "");
		}
		return mensagemPadrao;
	}
}