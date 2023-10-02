package academy.wakanda.sorrileadsbe.application.repository;

import academy.wakanda.sorrileadsbe.domain.MultipleChoice;
import academy.wakanda.sorrileadsbe.domain.Respondent;

import java.util.List;

public interface RespondentRepository {
    Respondent save(Respondent respondent);

    List<Respondent> searchAllRespondents();

    List<Respondent> searchAllRespondentsPerChoice(MultipleChoice multipleChoice);
}
