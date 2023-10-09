package academy.wakanda.sorrileadsbe.testedb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TesteDbRepository extends JpaRepository<TesteDb, UUID> {
}
