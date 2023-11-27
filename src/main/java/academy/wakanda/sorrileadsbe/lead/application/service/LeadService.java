package academy.wakanda.sorrileadsbe.lead.application.service;

import java.util.List;
import java.util.UUID;

import academy.wakanda.sorrileadsbe.lead.application.api.LeadListResponse;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadResponse;

public interface LeadService {

	List<LeadListResponse> getLeadsByClinicUrl(UUID idClinic);

	LeadResponse createLead(LeadRequest leadRequest, UUID idClinic);
}
