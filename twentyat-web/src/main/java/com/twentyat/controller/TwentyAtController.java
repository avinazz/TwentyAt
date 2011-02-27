package com.twentyat.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twentyat.exception.SifrProviderException;
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
	
    @RequestMapping( value = "/register/{firstname}/{lastname}/{email}/{mobilephone}/{photourl}/{token}", method = RequestMethod.PUT )
    @ResponseBody
    public Object addTwentyAtUser(@PathVariable String firstname, @PathVariable String lastname, 
    		@PathVariable String email, @PathVariable String mobilephone, @PathVariable String photourl, @PathVariable String token)
    {
    	
    	return null;
    }
    
}