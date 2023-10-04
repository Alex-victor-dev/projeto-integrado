package academy.wakanda.sorrileadsbe.domain;

import lombok.Value;

@Value
public class RawAnswerJson {
    private QuestionJson question;
    private Object answer;
}
