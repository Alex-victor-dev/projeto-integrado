package academy.wakanda.sorrileadsbe.lead.application.api;

public enum EspecialidadeInteressada {
	APARELHO_FIXO_OU_INVISÍVEL, IMPLANTES_E_PRÓTESES, LIMPEZA_E_REVISAO_GERAL,
    CLAREAMENTO_DENTAL, FACETAS_DE_RESINA_OU_PORCELANA, TRATAMENTO_DE_CANAL, EXTRAÇÔES_CIRÚRGICAS,
    BOTOX, HARMONIZAÇÃO_FACIAL, CIRURGIA_ORTOGNÁTICA, PERIODONTIA, REABILITAÇÃO_TOTAL,
    TRATAMENTO_DE_BRUXISMO, OUTROS_PROBLEMAS;;

    public static EspecialidadeInteressada fromString(String text) {
        for (EspecialidadeInteressada choice : EspecialidadeInteressada.values()) {
            if (choice.name().equalsIgnoreCase(text.replace(" ", "_"))) {
                return choice;
            }
        }
        return OUTROS_PROBLEMAS;
    }
}