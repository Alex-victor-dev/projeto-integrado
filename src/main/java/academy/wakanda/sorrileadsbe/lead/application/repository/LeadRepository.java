package academy.wakanda.sorrileadsbe.lead.application.repository;

import java.util.List;
import java.util.UUID;

import academy.wakanda.sorrileadsbe.lead.domain.Lead;

public interface LeadRepository {
	Lead save(Lead lead);

	List<Lead> getLeadsByClinicUrl(UUID idClinic);

}