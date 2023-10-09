package academy.wakanda.sorrileadsbe.testedb;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Entity
@Table(name = "teste_db")
@Log4j2
public class TesteDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    @Setter
    private String nomeAplicacao;
}
