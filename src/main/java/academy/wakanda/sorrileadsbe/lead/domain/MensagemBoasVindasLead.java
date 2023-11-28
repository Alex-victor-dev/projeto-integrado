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
		String mensagemPersonalizada = clinic.obtemMensagemBoasVindas();
		return new MessageRequest(lead.getPhone(), mensagemPersonalizada);
	}

}
