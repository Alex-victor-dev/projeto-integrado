package academy.wakanda.sorrileadsbe.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class RespondentFormJson {
    private String date;
    @JsonProperty("answers")
    private AnswersJson answersJson;
}