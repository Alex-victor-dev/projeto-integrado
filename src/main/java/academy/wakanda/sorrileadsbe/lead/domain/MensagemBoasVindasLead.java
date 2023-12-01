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
		String  mensagemPersonalizada = constructorPersonalizedMessage(mensagemPadrao);
		return new MessageRequest(lead.getPhone(),  mensagemPersonalizada);
	}

	private String constructorPersonalizedMessage(String mensagemPadrao) {
		String mensagemPersonalizada = mensagemPadrao
				.replace("{nome}", lead.getName())
				.replace("{nome do tratamento}", lead.getEspecialidadeInteressada().toString())
				.replace("{descrição personalizada}", lead.getPerguntaEspecificaLead());
		System.out.println(mensagemPersonalizada);
		return  mensagemPersonalizada;
	}
}
