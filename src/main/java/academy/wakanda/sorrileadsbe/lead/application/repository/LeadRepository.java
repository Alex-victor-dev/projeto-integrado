package academy.wakanda.sorrileadsbe.lead.application.repository;

import academy.wakanda.sorrileadsbe.lead.domain.Lead;

public interface LeadRepository {
    Lead save(Lead lead);
}