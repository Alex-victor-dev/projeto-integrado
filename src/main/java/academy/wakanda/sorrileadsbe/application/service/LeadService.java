package academy.wakanda.sorrileadsbe.application.service;

import academy.wakanda.sorrileadsbe.application.api.*;

public interface LeadService {
    LeadResponse createLead(LeadRequest leadRequest);
}
