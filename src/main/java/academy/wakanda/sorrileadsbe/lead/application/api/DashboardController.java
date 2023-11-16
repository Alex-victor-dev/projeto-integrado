package academy.wakanda.sorrileadsbe.lead.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class DashboardController implements DashboardAPI {

	@Override
	public List<LeadListResponse> getLeadsByClinicUrl(String urlClinica) {
		log.info("[start]  DashboardController - getLeadsByClinicUrl");
		log.info("[finish]  DashboardController - getLeadsByClinicUrl");
		return null;
	}

}
