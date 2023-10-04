package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.domain.FormJson;
import academy.wakanda.sorrileadsbe.domain.RespondentFormJson;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class RespondentRequest {

    @JsonProperty("form")
    private FormJson formJson;
    @JsonProperty("respondent")
    private RespondentFormJson respondentForm;

}