package academy.wakanda.sorrileadsbe.lead.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public interface DashboardAPI {

	@GetMapping("/{idClinic}/leads")
	@ResponseStatus(code = HttpStatus.OK)
	List<LeadListResponse> getLeadsByClinicUrl(@PathVariable("idClinic") UUID idClinic);
}