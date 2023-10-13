package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.AnswersJson;
import academy.wakanda.sorrileadsbe.domain.FormJson;
import academy.wakanda.sorrileadsbe.domain.RespondentFormJson;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Optional;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeadRequest {

  @JsonProperty("form")
   private FormJson formJson;
    @JsonProperty("respondent")
    private RespondentFormJson respondentForm;

    public String getNome() {
        return Optional.ofNullable(this.respondentForm)
                .map(RespondentFormJson::getAnswersJson)
                .map(AnswersJson::getNome)
                .orElse(null);
    }

    public String getPhone() {
        return Optional.ofNullable(this.respondentForm)
                .map(RespondentFormJson::getAnswersJson)
                .map(AnswersJson::getWhatsapp)
                .orElse(null);
    }

    public String getEmail() {
        return Optional.ofNullable(this.respondentForm)
                .map(RespondentFormJson::getAnswersJson)
                .map(AnswersJson::getEmail)
                .orElse(null);
    }

    public String getEspecialidadeInteressada() {
        return Optional.ofNullable(this.respondentForm)
                .map(RespondentFormJson::getAnswersJson)
                .map(AnswersJson::getEspecialidade)
                .orElse(null);
    }

    public String getPerguntaEspecificaLead() {
        return Optional.ofNullable(this.respondentForm)
                .map(RespondentFormJson::getAnswersJson)
                .map(AnswersJson::getPerguntaEspecifica)
                .orElse(null);
    }

    public String getRegistrationDate() {
        return Optional.ofNullable(this.respondentForm)
                .map(RespondentFormJson::getDate)
                .orElse(null);
    }



}