package academy.wakanda.sorrileadsbe.lead.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import academy.wakanda.sorrileadsbe.handler.APIException;
import academy.wakanda.sorrileadsbe.lead.application.repository.LeadRepository;
import academy.wakanda.sorrileadsbe.lead.domain.Lead;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class LeadInfraRepository implements LeadRepository {
	private final LeadSpringDataJPARepository leadSpringDataJPARepository;

	@Override
	public Lead save(Lead lead) {
		log.info("[start] LeadInfraRepository - save");
		try {
			leadSpringDataJPARepository.save(lead);
		} catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um registro com esse phone!", e);
		}
		log.info("[finish] LeadInfraRepository - save");
		return lead;
	}

	@Override
	public List<Lead> getLeadsByClinicUrl(UUID idClinic) {
		log.info("[start] LeadInfraRepository - getLeadsByClinicUrl");
		List<Lead> leads = leadSpringDataJPARepository.findAllByIdClinic(idClinic);
		log.info("[finish] LeadInfraRepository - getLeadsByClinicUrl");
		return leads;
	}

}