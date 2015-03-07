package com.FCI.SWE.Services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.simple.JSONObject;

import com.FCI.SWE.Models.FriendShip;
import com.FCI.SWE.Models.User;

/**
 * This class contains REST services, also contains action function for web
 * application
 * 
 * @author Mohamed Samir
 * @version 1.0
 * @since 2014-02-12
 *
 */
@Path("/")
@Produces("text/html")
public class Service {

	/*
	 * @GET
	 * 
	 * @Path("/index") public Response index() { return Response.ok(new
	 * Viewable("/jsp/entryPoint")).build(); }
	 */

	/**
	 * Registration Rest service, this service will be called to make
	 * registration. This function will store user data in data store
	 * 
	 * @param uname
	 *            provided user name
	 * @param email
	 *            provided user email
	 * @param pass
	 *            provided password
	 * @return Status json
	 */
	@POST
	@Path("/RegistrationService")
	public String registrationService(@FormParam("uname") String uname,
			@FormParam("email") String email, @FormParam("password") String pass) {
		User user = new User(uname, email, pass);
		JSONObject object = new JSONObject();
		if(user.saveUser()){
			object.put("Status", "OK");
		}
		else{
			object.put("Status", "Failed");
		}
		return object.toString();
	}

	/**
	 * Login Rest Service, this service will be called to make login process
	 * also will check user data and returns new user from datastore
	 * 
	 * @param uname
	 *            provided user name
	 * @param pass
	 *            provided user password
	 * @return user in json format
	 */
	@POST
	@Path("/LoginService")
	public String loginService(@FormParam("uname") String uname,
			@FormParam("password") String pass) {
		JSONObject object = new JSONObject();
		User user = User.getUser(uname, pass);
		if (user == null) {
			object.put("Status", "Failed");

		} else {
			object.put("Status", "OK");
			object.put("name", user.getName());
			object.put("email", user.getEmail());
			object.put("password", user.getPass());
			object.put("id", user.getId());
		}

		return object.toString();

	}

	@POST
	@Path("/LogoutService")
	public String LogoutService() {
		System.out.println("HERE logout 2");
		JSONObject object = new JSONObject();
		User.logout();
		object.put("Status", "OK");
		return object.toString();
	}

	@POST
	@Path("/addFriendService")
	public String addFriendService(@FormParam("recieverID") String recieverID
			) {
		JSONObject object = new JSONObject();
		if (FriendShip
				.sendRequest(
						String.valueOf(User.getCurrentActiveUser().getId()),
						recieverID))
			object.put("Status", "OK");
		else
			object.put("Status", "Failed");

		return object.toString();
	}
    
	@POST
	@Path("/unFriendService")
	public String unFriendService(@FormParam("recieverID") String recieverID
			) {
		JSONObject object = new JSONObject();
		if (FriendShip
				.unFriendRequest(
						String.valueOf(User.getCurrentActiveUser().getId()),
						recieverID))
			object.put("Status", "OK");
		else
			object.put("Status", "Failed");

		return object.toString();
	}
	
	@POST
	@Path("/preaddFriendService")
	public String preaddFriendService() {
		
		JSONObject object = new JSONObject();
		long[] temp = FriendShip.getUsers(String.valueOf(User
				.getCurrentActiveUser().getId()));
		object.put("size", temp.length + "");
		for (int i = 0; i < temp.length; i++) {
			User user = User.getUser(temp[i]);
			object.put("name" + i, user.getName());
			object.put("email" + i, user.getEmail());
			object.put("id" + i, user.getId());
			// System.out.println(re[i].getId());
		}

		return object.toString();
	}
   
	@POST
	@Path("/preacceptFriendService")
	public String preacceptFriendService() {
		JSONObject object = new JSONObject();
		long[] temp = FriendShip.getNotifications(String.valueOf(User
				.getCurrentActiveUser().getId()));
		object.put("size", temp.length + "");
		System.out.println(temp.length);
		for (int i = 0; i < temp.length; i++) {			
			User user = User.getUser(temp[i]);
			object.put("name" + i, user.getName());
			object.put("email" + i, user.getEmail());
			object.put("id" + i, user.getId());
			// System.out.println(re[i].getId());
		}

		return object.toString();
	}
    
	@POST
	@Path("/acceptFriendService")
	public String acceptFriendService(@FormParam("recieverID") String recieverID) {
		JSONObject object = new JSONObject();
		if (FriendShip
				.acceptFriendRequest(
						String.valueOf(User.getCurrentActiveUser().getId()),
						recieverID))
			object.put("Status", "OK");
		else
			object.put("Status", "Failed");

		return object.toString();
	}
	@POST
	@Path("/myFriendsService")
	public String myFriendsService() {
		
		JSONObject object = new JSONObject();
		long[] temp = FriendShip.getMyFriends(String.valueOf(User
				.getCurrentActiveUser().getId()));
		object.put("size", temp.length + "");
		for (int i = 0; i < temp.length; i++) {
			User user = User.getUser(temp[i]);
			object.put("name" + i, user.getName());
			object.put("email" + i, user.getEmail());
			object.put("id" + i, user.getId());
			// System.out.println(re[i].getId());
		}

		return object.toString();
	}
}