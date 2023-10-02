package academy.wakanda.sorrileadsbe.application.repository;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;

import java.util.List;
import java.util.UUID;

public interface RespondentRepository {
    Respondent save(Respondent respondent);

    List<Respondent> searchAllRespondents();

    List<Respondent> searchAllRespondentsPerChoice(MultipleChoice multipleChoice);

    Respondent getRespondentPerId(UUID idRespondent);
}
