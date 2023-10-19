package academy.wakanda.sorrileadsbe.lead.application.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnswersJson {
    @JsonProperty("Qual seu nome?")
    private String nome;
    @JsonProperty("Qual é o seu Whatsapp?")
    private String whatsapp;
    @JsonProperty("Qual seu e-mail?")
    private String email;
    @JsonProperty("Qual Especialidade você precisa de tratamento?")
    private String especialidade;
    @JsonProperty("Quer nos fazer uma pergunta específica?")
    private String perguntaEspecifica;
}