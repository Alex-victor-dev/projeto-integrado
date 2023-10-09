package academy.wakanda.sorrileadsbe.testedb;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class TesteDbAPI {
    private final TesteDbRepository testeDbRepository;

    @GetMapping("/test-db")
    public TesteDb testDb() {
        log.info("[start] SorrileadsBeApplication - testDb");
        TesteDb testeDb = testeDbRepository.findAll().stream().findFirst().orElseThrow();
        log.info("[finish] SorrileadsBeApplication - testDb");
        return testeDb;
    }
}
