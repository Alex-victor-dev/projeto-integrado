package academy.wakanda.sorrileadsbe.lead.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.sorrileadsbe.lead.application.service.LeadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class DashboardController implements DashboardAPI {

	private final LeadService leadService;

	@Override
	public List<LeadListResponse> getLeadsByClinicUrl(UUID idClinic) {
		log.info("[start]  DashboardController - getLeadsByClinicUrl");
		List<LeadListResponse> leads = leadService.getLeadsByClinicUrl(idClinic);
		log.info("[finish]  DashboardController - getLeadsByClinicUrl");
		return leads;
	}

}
