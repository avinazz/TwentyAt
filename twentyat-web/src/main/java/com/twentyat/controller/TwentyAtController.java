package com.twentyat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.googlecode.janrain4j.json.JSONException;
import com.googlecode.janrain4j.json.JSONObject;
import com.twentyat.exception.TwentyAtProviderException;
import com.twentyat.model.ContactPerson;
import com.twentyat.model.TwentyatGroup;
import com.twentyat.model.TwentyatUser;
import com.twentyat.service.SocialNetworkService;
import com.twentyat.service.TwentyAtService;

/**
 * Twentyat controller whose response it rendered to the browser as JSON
 * 
 * @author Bipin Sutariya
 */
@Controller
public class TwentyAtController {
	private static Logger logger = Logger.getLogger(TwentyAtController.class);


	private TwentyAtService twentyAtService;

	public void setTwentyAtService(TwentyAtService twentyAtService) {
		this.twentyAtService = twentyAtService;
	}

	/**
	 * Method to register new user Access this method by
	 * http://www.servername.com/register
	 *
	 * @return List of Object as JSON
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST, headers="Accept=application/json")	 
	public @ResponseBody List<Object> register(@RequestBody Object obj) {
	  Status status = new Status();		
      List<Object> returnObj = new ArrayList<Object>();
           try {
    	  JSONObject json = new JSONObject(obj.toString());
    	  String token=json.getString("token");
    	  String email=json.getString("email");
    	  String uuid=json.getString("uuid");	      
    	  logger.info("TOKEN : "+token);
    	  logger.info("EMAIL : "+email);
    	  logger.info("UUID : "+uuid);    	  
    	  if(null != token && null != email) {
    		  TwentyatUser user = twentyAtService.addTwentyAtUser(email, token, uuid);
    		  returnObj.add(user);
    		  status.setCode(0);
    		  status.setMessage("ok");
    		  returnObj.add(status);
    	  }
    	  else {
    		  logger.error("TOKEN and/or EMAIL is null or empty");
    		  status.setCode(2);
    		  status.setMessage("TOKEN and/or EMAIL is null or empty");
    		  returnObj.add(status);
    	  }
      } 
      catch (Exception e) {
    	  logger.error("ERROR : ADD USER : " + e);
    	  if (e.getMessage().contains("No Data found")){
    		  status.setCode(1);
    		  status.setMessage("auth_token is expired");
    		  returnObj.add(status);    		 
    	  }
    	  status.setCode(1);
    	  status.setMessage(e.getMessage());
    	  returnObj.add(status);    	  
      }
      return returnObj;
	}//end of register

	/**
	 * Method to login user Access this method by
	 * http://www.servername.com/login
	 *
	 * @return List of Object as JSON
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestBody Object token) {
		Status status = new Status();
		Map<String, Object> returnObj = new HashMap<String, Object>();
		if (null != token && !"".equals(token)) {
			String email = null;
			TwentyatUser user = null;
			logger.debug("Login Twenty user called");

			// Checking passed token is valid or not
			try {
			//	user = socialNetworkService.getUser(token.toString());
			} catch (Exception e) {
				logger.error("ERROR : LOGIN : " + e);
				if (e.getMessage().contains("No Data found")) {
					status.setCode(1);
					status.setMessage("auth_token is expired");
					returnObj.put("status", status);
					return returnObj;
				}
				status.setCode(1);
				status.setMessage(e.getMessage());
				returnObj.put("status", status);
				return returnObj;
			}

			// if token is valid then check user is already register with
			// twentyat app or not
			try {
				email = user.getEmail();
				TwentyatUser dbUser = twentyAtService
						.getTwentyAtUserByEMail(email);
				if (null != dbUser) {
					status.setCode(0);
					status.setMessage("ok");
					returnObj.put("status", status);
					returnObj.put("profile", user);
				} else {
					status.setCode(1);
					status.setMessage("User is not 20@ user, please register first");
					returnObj.put("status", status);
				}

			} catch (TwentyAtProviderException e) {
				logger.error("ERROR : LOGIN : " + e);
				status.setCode(1);
				status.setMessage(e.getMessage());

			} catch (Exception e) {
				logger.error("ERROR : LOGIN : " + e);
				status.setCode(1);
				status.setMessage(e.getMessage());
			}
			returnObj.put("status", status);
		} else {
			status.setCode(1);
			status.setMessage("{token} cannot be null or empty");
			returnObj.put("status", status);
		}
		return returnObj;
	}// end of login

	/**
	 * Method to create new group Access this method by
	 * http://www.servername.com/group/create/{userId}/{groupname}
	 * 
	 * @param String
	 *            userId (20@ userId)
	 * @param groupname
	 * @return List of Object as JSON
	 */
	@RequestMapping(value = "/create/group/{userId}/{groupname}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createGroup(@PathVariable String userId,
			@PathVariable String groupname) {
		Map<String, Object> returnObj = new HashMap<String, Object>();

		Status status = new Status();
		if (null != userId && !"".equals(userId) && null != groupname
				&& !"".equals(groupname)) {
			
			try {
				TwentyatUser user = twentyAtService.getUser(userId);
				TwentyatGroup group = new TwentyatGroup();
				group.setGroupName(groupname);
				group.setTwentyatUser(user);
				List<TwentyatGroup> groupUser = twentyAtService
						.getGroupByUserId(userId);
				if (groupUser == null || groupUser.size() == 0) {
					group = twentyAtService.saveGroup(group);

					status.setCode(0);
					status.setMessage("ok");

					returnObj.put("group", group);
					returnObj.put("status", status);
				} else {
					status.setCode(1);
					status.setMessage("User has already created one Group");
					returnObj.put("group", groupUser);
					returnObj.put("status", status);
				}
			} catch (TwentyAtProviderException e) {
				logger.error("ERROR : CREATE GROUP : " + e);
				status.setCode(1);
				status.setMessage(e.getMessage());
				returnObj.put("status", status);
			}
			return returnObj;
		} else {

			if (null == userId || "".equals(userId)) {
				status.setCode(1);
				status.setMessage("{userid} cannot be null or emplty");
				returnObj.put("stauts", status);
			}

			if (null == groupname || "".equals(groupname)) {
				status.setCode(1);
				status.setMessage("{groupname} cannot be null or emplty");
				returnObj.put("status", status);
			}
			return returnObj;
		}
	}

	/**
	 * Method to add new friend Access this method by
	 * http://www.servername.com/friends/add/{userId}/{friendsFacebookId}
	 * 
	 * @param String
	 *            user (20@ userId)
	 * @param ids
	 *            (colon separated multiple ids of friends (both facebookid or
	 *            uuid))
	 * 
	 * @return List of Object as JSON
	 */
	@RequestMapping(value = "/friends/add/{userId}/{facebookIds}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addFriend(@PathVariable String userId,
			@PathVariable String ids) {
		Map<String, Object> returnObj = new HashMap<String, Object>();

		Status status = new Status();
		if (null != userId && !"".equals(userId) && null != ids
				&& !"".equals(ids)) {
			try {
				TwentyatUser user = twentyAtService.getTwentyAtUserByID(userId);
				if (null != user) {
					String[] idArray = ids.split(":");
					for (String id : idArray) {
						try {
							Long idInt = new Long(id);
							logger.info(id
									+ " : is facebookId, looking in contact table for user information");
							ContactPerson contactPerson = twentyAtService
									.getContactPersonByFacebookId(idInt);

							TwentyatUser twentyAtUser = new TwentyatUser();

							// stwentyAtUser.setAddress(address);
						} catch (Exception e) {
							logger.info(id + " : is not facebookId");
						}
					}
				} else {
					status.setCode(1);
					status.setMessage("userid is not found in 20@");
					returnObj.put("status", status);
				}
			} catch (TwentyAtProviderException e) {
				logger.error("ERROR : ADD FRIEND : " + e);
				status.setCode(1);
				status.setMessage(e.getMessage());
				returnObj.put("status", status);
			}
		}
		return returnObj;
	}

	@RequestMapping(value = "/getmail", method = RequestMethod.POST, headers = "content-type=application/*")
	public void getMail(@RequestBody MultiValueMap<String, Object> param) {
		
		String str = "";
		for(Entry<String, List<Object>> entry : param.entrySet())
		{
			System.out.println("=====================");
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			if(entry.getKey().equals("subject")){
				str = entry.getValue().toString();
			}
			System.out.println("=================================================================================================================");
		}
		
		System.out.println("______The Subject is : " + str);
		String senderToken = getSenderToken(str);
		System.out.println("______The SenderInfo is : " + senderToken);
		System.out.println("______The SenderID is : " + getSenderID(senderToken));
		System.out.println("______The SubjectThread is : " + getSenderThread(senderToken));
		
	}
	
	private static String getSenderToken(String str){
		  if(str.contains("<")){
			  String[] getid = str.split("<");
		      String[] getid2 = getid[getid.length-1].split(">");
		      return getid2[0];
		  }else{
			  return "none";
		  }
	  }
	
	private static String getSenderID(String senderToken){
		  if(senderToken.contains("#")){
			  String[] getid = senderToken.split("#");
			  String[] getid2 = getid[0].split(":");
		      return getid2[1];
		  }else{
			  return "none";
		  }
	  }
	private static String getSenderThread(String senderToken){
		  if(senderToken.contains("#")){
			  String[] getid = senderToken.split("#");
		      return getid[1];
		  }else{
			  return "none";
		  }
	  }
}
