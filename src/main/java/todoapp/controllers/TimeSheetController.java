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


import todoapp.models.TimeSheet;
import todoapp.models.Todo;
import todoapp.repositories.TimeSheetRepository;

@CrossOrigin
@RestController
@RequestMapping("/userapi/{userId}")
public class TimeSheetController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeSheetController.class);
	@Autowired
	 TimeSheetRepository  timeSheetRepository;
	
	@RequestMapping(value="/timesheet", method=RequestMethod.GET)
	public List<TimeSheet> getAllTimeSheetsss(@PathVariable("userId") String userId) {
		LOGGER.info("get history "+userId);
		return timeSheetRepository.findByUserId(userId);
	}
	
	
	@RequestMapping(value="/timesheet/history", method=RequestMethod.GET)
	public List<TimeSheet> getAllTimeSheets(@PathVariable("userId") String userId) {
		LOGGER.info("get history "+userId);
		return timeSheetRepository.findByUserIdAndCompletedIsTrue(userId);
	}
	
	@RequestMapping(value="/timesheet/current", method=RequestMethod.GET)
	public TimeSheet getAllTimeSheet(@PathVariable("userId") String userId) {
		LOGGER.info("get current "+userId);
		TimeSheet ts=timeSheetRepository.findByUserIdAndCompletedIsFalse(userId);
		if(ts==null){
			LOGGER.info("no current "+userId);
			return new TimeSheet(userId);
		}
		return ts;
	}
	
	@RequestMapping(value="/timesheet", method=RequestMethod.POST)
	public TimeSheet createTimeSheet(@RequestBody TimeSheet timeSheet,@PathVariable("userId") String userId) {
		LOGGER.info("create "+userId);
		timeSheet.setUserId(userId);
		return timeSheetRepository.save(timeSheet);
	}
	
	@RequestMapping(value="/timesheet/{id}", method=RequestMethod.PUT)
	public TimeSheet updateTimeSheet(@RequestBody TimeSheet timeSheet,@PathVariable("userId") String userId,@PathVariable("id") String id) {
		LOGGER.info("update "+userId);
		TimeSheet todoData = timeSheetRepository.findOne(id);
		if(todoData == null) {
			return new TimeSheet();
		}
		todoData.setDate(timeSheet.getDate());
		todoData.setDates(timeSheet.getDates());
		todoData.setHours(timeSheet.getHours());
		todoData.setCompleted(timeSheet.getCompleted());
		return timeSheetRepository.save(todoData);
	}

	
	@RequestMapping(value="/timesheet/{id}", method=RequestMethod.DELETE)
	public void deleteTimeSheet(@PathVariable("id") String id) {
		LOGGER.info("delete "+id);
		timeSheetRepository.delete(id);
	}
}
