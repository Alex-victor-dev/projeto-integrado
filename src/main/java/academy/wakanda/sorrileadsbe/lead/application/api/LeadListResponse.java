package academy.wakanda.sorrileadsbe.lead.application.api;

import java.util.List;
import java.util.stream.Collectors;

import academy.wakanda.sorrileadsbe.lead.domain.Lead;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeadListResponse {

	private String name;
	private String phone;
	private String email;
	private EspecialidadeInteressada especialidadeInteressada;

	public LeadListResponse(Lead leads) {
		this.name = leads.getName();
		this.phone = leads.getPhone();
		this.email = leads.getEmail();
		this.especialidadeInteressada = leads.getEspecialidadeInteressada();
	}

	public static List<LeadListResponse> converte(List<Lead> leadsList) {
		return leadsList.stream()
				.map(LeadListResponse::new)
				.collect(Collectors.toList());

	}

}
