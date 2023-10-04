package academy.wakanda.sorrileadsbe.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class AnswersJson {

    @JsonProperty("Qual seu nome?")
    private String nome;

    @JsonProperty("Qual seu é o Whatsapp?")
    private String whatsapp;

    @JsonProperty("Qual seu e-mail?")
    private String email;

    @JsonProperty("Qual Especialidade você precisa de tratamento?")
    private String especialidade;

    @JsonProperty("Quer nos fazer uma pergunta específica?")
    private String perguntaEspecifica;


}
