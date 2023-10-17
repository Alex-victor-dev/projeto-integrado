package academy.wakanda.sorrileadsbe.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RespondentFormJson {
    private String date;
    @JsonProperty("answers")
    private AnswersJson answersJson;

}