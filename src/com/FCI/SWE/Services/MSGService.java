package com.FCI.SWE.Services;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.FCI.SWE.Models.FriendShip;
import com.FCI.SWE.Models.Message;
import com.FCI.SWE.Models.User;


/**
 * THIS CLASS CONTAINS REST SERVICES, ALSO CONTAINS ACTION FUNCTION FOR WEB
 * APPLICATION
 * 
 * @AUTHOR AHMED YEHIA
 * @VERSION 1.0
 * @SINCE 2014-02-12
 *
 */
@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class MSGService {
       
	@POST
	@Path("/sendmessageService")
	public String sendMessageService(@FormParam("recieverID") String recieverID, @FormParam("text")String text) {
		JSONObject object = new JSONObject();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();	
		String timeStamp = dateFormat.format(cal.getTime());
		Message m = new Message(String.valueOf(User.getCurrentActiveUser().getId()), recieverID, timeStamp, text);
		if (m.sendMessage())
			object.put("Status", "OK");
		else
			object.put("Status", "Failed");

		return object.toString();
	}
//	@POST
//	@Path("/msgnotification")
//	public String msgNotificationService() {
//		System.out.println("ssss");
//		Vector<Message> msg = Message.getMessage(String.valueOf(User
//				.getCurrentActiveUser().getId()));
//		
//		System.out.println(msg.size());
//		JSONArray returnedJson = new JSONArray();
//		for (Message m : msg)
//		{
//			JSONObject object = new JSONObject();
//			object.put("text", m.getText());
//			object.put("sender",m.getSender()); 
//			object.put("id", m.getid());
//			object.put("receiver", m.getReceiver());
//			object.put("timestamp",m.getTimeStap());	   
//			returnedJson.add(object);
//		}
//
//		return returnedJson.toJSONString();
//	}
}