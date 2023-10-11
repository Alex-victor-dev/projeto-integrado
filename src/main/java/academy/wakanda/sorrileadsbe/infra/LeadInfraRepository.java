package academy.wakanda.sorrileadsbe.infra;

import academy.wakanda.sorrileadsbe.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.domain.Lead;
import academy.wakanda.sorrileadsbe.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataIntegrityViolationException;

@Repository
@Log4j2
@RequiredArgsConstructor
public class LeadInfraRepository implements LeadRepository {
    @Autowired
    private final LeadSpringDataJPARepository leadSpringDataJPARepository;

    @Override
    public Lead save(Lead lead) {
        log.info("[start] LeadInfraRepository - save");
        try {
        leadSpringDataJPARepository.save(lead);
        } catch(DataIntegrityViolationException e){
        throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um registro com esse phone!",e);
        }
        log.info("[finish] LeadInfraRepository - save");
        return lead;
    }
}