package academy.wakanda.sorrileadsbe.domain;

import academy.wakanda.sorrileadsbe.application.api.AnswersJson;
import academy.wakanda.sorrileadsbe.application.service.DataHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AnswersJsonTest {

    @Test
    void testAnswersJsonFromJsonFile() {
        // Usando o DataHelper para criar um objeto a partir de um arquivo JSON
        AnswersJson answersJson = DataHelper.createAnswersJsonFromJsonFile();

        // Realize as asserções para verificar se os valores foram lidos corretamente
        assertEquals("Vastiane", answersJson.getNome());
        assertEquals("55 73995791888", answersJson.getWhatsapp());
        assertEquals("vastiane@gmail.com", answersJson.getEmail());
        assertEquals("BOTOX", answersJson.getEspecialidade());
        assertEquals("sim", answersJson.getPerguntaEspecifica());
    }
}