package academy.wakanda.sorrileadsbe.testedb;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class BootstrapDataInitializer implements ApplicationListener<ContextRefreshedEvent> {
    private final TesteDbRepository testeDbRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("[start] BootstrapDataInitializer - onApplicationEvent");
        if (!testeDbRepository.findAll().isEmpty()) {
           log.info("[já existe]");
           log.info("[finish] BootstrapDataInitializer - onApplicationEvent");
            return;
        }

        log.info("[não existe]");
        TesteDb newTesteDb = new TesteDb();
        newTesteDb.setNomeAplicacao("SORRILEADS");
        testeDbRepository.save(newTesteDb);
        log.info("[finish] BootstrapDataInitializer - onApplicationEvent");
    }
}
