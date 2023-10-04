package academy.wakanda.sorrileadsbe.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class RespondentFormJson {
    private String status;
    private String date;
    private String score;
    @JsonProperty("respondent_id")
    private String respondentId;
    @JsonProperty("answers")
    private AnswersJson answersJson;
    @JsonProperty("raw_answers")
    private List<RawAnswerJson> raw_answersJson;

}
