package academy.wakanda.sorrileadsbe.lead.application.service;

import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadResponse;

import java.util.UUID;

public interface LeadService {
    LeadResponse createLead(LeadRequest leadRequest, UUID idClinic);
}
