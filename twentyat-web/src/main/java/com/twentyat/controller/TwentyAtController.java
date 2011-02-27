package com.twentyat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.User;
import com.twentyat.service.FacebookService;
import com.twentyat.service.TwentyAtService;

/**
 * Sample controller whose response it rendered to the browser as JSON
 * @author Bipin Sutariya
 */
@Controller
public class TwentyAtController
{
	private static Logger logger = Logger.getLogger(TwentyAtController.class);
	
	private FacebookService facebookService;
	public void setFacebookService(FacebookService facebookService) {
		this.facebookService = facebookService;
	}
	
	private TwentyAtService twentyAtService;
	public void setTwentyAtService(TwentyAtService twentyAtService) {
		this.twentyAtService = twentyAtService;
	}
	
	/**
	 * Method to register new user 
	 * Access this method by http://localhost:8080/twentyat-web/register/firstname/lastname/email/mobilephone/photourl/token
	 * 
	 * @param String firstname
	 * @param String lastname
	 * @param String email
	 * @param String mobilephone
	 * @param String photourl
	 * @param String token
	 * @return List of Object as JSON
	 */
    @RequestMapping( value = "/register/{firstname}/{lastname}/{email}/{mobilephone}/{photourl}/{token}", method = RequestMethod.GET )
    @ResponseBody
    public List<Object> addTwentyAtUser(@PathVariable String firstname, @PathVariable String lastname, 
    		@PathVariable String email, @PathVariable String mobilephone, @PathVariable String photourl, @PathVariable String token)
    {
    	
    	List<Object> returnObj = new ArrayList<Object>();
    	
    	Status status = new Status();
    	
    	UUID uuid = UUID.randomUUID();
    	
    	User user = new User();
    	
    	user.setTwentyAtUserId(uuid.toString());
    	user.setEmail(email);
    	user.setFirstName(firstname);
    	user.setLastName(lastname);
    	user.setMobilePhone(mobilephone);
    	user.setPhoto(photourl);
    	
    	try {
			user = facebookService.addTwentyAtUser(user, token);
			returnObj.add(user);
			status.setCode(0);
			status.setMessage("success");
			returnObj.add(status);
			
			return returnObj;
		} catch (TwentyAtProviderException e) {
			status.setCode(1);
			status.setMessage(e.getMessage());
			
		} catch(Exception e) {
			status.setCode(1);
			status.setMessage(e.getMessage());
		}
    	
		returnObj.add(status);
		return returnObj;
    }
    
}