package academy.wakanda.sorrileadsbe.domain;

import academy.wakanda.sorrileadsbe.handler.APIException;
import org.springframework.http.HttpStatus;

public enum MultipleChoice {
    APARELHO_FIXO_OU_INVISÍVEL, IMPLANTES_E_PRÓTESES, LIMPEZA_E_REVISAO_GERAL,
    CLAREAMENTO_DENTAL, BOTOX, FACETAS_DE_RESINA_OU_PORCELANA, OUTROS_PROBLEMAS;

    public static MultipleChoice fromString(String text) {
        for (MultipleChoice choice : MultipleChoice.values()) {
            if (choice.name().equalsIgnoreCase(text.replace(" ", "_"))) {
                return choice;
            }
        }
        throw APIException.build(HttpStatus.BAD_REQUEST,
                "Nenhum valor correspondente para" + text);
    }
}