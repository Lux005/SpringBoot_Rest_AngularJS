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


import todoapp.models.RequestLetter;
import todoapp.repositories.RequestLetterRepository;

@CrossOrigin
@RestController
@RequestMapping("/userapi/{userId}")
public class RequestLetterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLetterController.class);
	@Autowired
	RequestLetterRepository requestLetterRepository;
	
	@RequestMapping(value="/requestletter", method=RequestMethod.GET)
	public List<RequestLetter> getAllRequestLetters(@PathVariable("userId") String userId) {
		LOGGER.info("get "+userId);
		return requestLetterRepository.findByUserId(userId);
	}

	@RequestMapping(value="/requestletter", method=RequestMethod.POST)
	public RequestLetter createRequestLetter(@RequestBody RequestLetter requestLetter,@PathVariable("userId") String userId) {
		LOGGER.info("put "+userId);
		requestLetter.setUserId(userId);
		return requestLetterRepository.save(requestLetter);
	}

	
	@RequestMapping(value="/requestletter/{id}", method=RequestMethod.DELETE)
	public void deleteRequestLetter(@PathVariable("id") String id) {
		requestLetterRepository.delete(id);
	}
}
