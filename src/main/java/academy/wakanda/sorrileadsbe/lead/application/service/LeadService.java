package academy.wakanda.sorrileadsbe.lead.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadRequest;
import academy.wakanda.sorrileadsbe.lead.application.api.LeadResponse;

public interface LeadService {
    LeadResponse createLead(LeadRequest leadRequest);
}
