package academy.wakanda.sorrileadsbe.application.repository;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Lead;

import java.util.List;
import java.util.UUID;

public interface LeadRepository {
   

    List<Lead> searchAllRespondents();

    List<Lead> searchAllRespondentsPerChoice(MultipleChoice multipleChoice);

    Lead getRespondentPerId(UUID idRespondent);

    Lead save(Lead lead);
}
