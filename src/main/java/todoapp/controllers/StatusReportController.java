package todoapp.controllers;

import java.util.List;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import todoapp.models.StatusReport;
import todoapp.repositories.StatusReportRepository;

@CrossOrigin
@RestController
@RequestMapping("/userapi/{userId}")
public class StatusReportController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusReportController.class);
	@Autowired
	 StatusReportRepository  statusReportRepository;
	
	@RequestMapping(value="/statusreport", method=RequestMethod.GET)
	public List<StatusReport> getAllStatusReport(@PathVariable("userId") String userId) {
		LOGGER.info("get "+userId);
		return statusReportRepository.findByUserId(userId);
	}

	@RequestMapping(value="/statusreport", method=RequestMethod.POST)
	public StatusReport createStatusReport(@RequestBody StatusReport statusReport,@PathVariable("userId") String userId) {
		LOGGER.info("put "+userId);
		statusReport.setUserId(userId);
		return statusReportRepository.save(statusReport);
	}

	
	@RequestMapping(value="/statusreport/{id}", method=RequestMethod.DELETE)
	public void deleteStatusReport(@PathVariable("id") String id) {
		statusReportRepository.delete(id);
	}
}
