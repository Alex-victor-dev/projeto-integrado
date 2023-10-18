package academy.wakanda.sorrileadsbe.application.api;

import academy.wakanda.sorrileadsbe.application.api.AnswersJson;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RespondentFormJson {
    private String date;
    @JsonProperty("answers")
    private AnswersJson answersJson;

}