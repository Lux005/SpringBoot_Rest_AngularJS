package todoapp.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import todoapp.models.User;
import todoapp.repositories.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public User userLogout(@CookieValue(value = "user", defaultValue = "guest") String userCookie,HttpServletResponse response) {
		LOGGER.info("logout "+ userCookie);
		response.addCookie(new Cookie("user","guest"));
		return new User("guest","guest");
	}


	@RequestMapping(value="/check", method=RequestMethod.GET)
	public User userCheck(@CookieValue(value = "user", defaultValue = "guest") String userCookie) {
		LOGGER.info("check "+userCookie);
		User u=userRepository.findByUserId(userCookie);
		if(u==null)
			return new User("guest","guest");
		return u;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public User userLogin(@RequestBody User user,HttpServletResponse response) {
		LOGGER.info("put "+user.getUserId()+" pass "+user.getPassword());
		User u=userRepository.findByUserId(user.getUserId());
	
		if(u!=null && u.getPassword().equals(user.getPassword())){
			LOGGER.info("succ "+u.getUserId()+" pass "+u.getPassword());
			Cookie cc=new Cookie("user",u.getUserId());
			cc.setMaxAge(999999);
			response.addCookie(cc);
			return u;
		}
		
		else{
			response.addCookie(new Cookie("user", "guest"));
			return new User("guest","guest");
		}
			
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public User createUser(@Valid @RequestBody User user) {
		LOGGER.info("put "+user.getUserId());
		return userRepository.save(user);
			
	}
	

}
