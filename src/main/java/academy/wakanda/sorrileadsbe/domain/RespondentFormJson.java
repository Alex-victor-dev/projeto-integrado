package academy.wakanda.sorrileadsbe.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class RespondentFormJson {
    private String date;
    @JsonProperty("answers")
    private AnswersJson answersJson;

}