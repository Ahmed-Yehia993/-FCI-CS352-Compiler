package com.FCI.SWE.Models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class Message {
	
	private long id;
	public String senderID;
	public String groupID;
	public String receiverID;
	public String text;
	public String timestamp;

	public Message() {

	}

	public Message(String string, String receiver, String groupID,
			String timestamp, String text) {
		this.senderID = string;
		this.receiverID = receiver;
		this.timestamp = timestamp;
		this.groupID = groupID;
		this.text = text;
	}

	private void setId(long id) {
		this.id = id;
	}
    
	private void setTimeStamp(String timestamp) {
		this.timestamp = timestamp;
	}

	private void setText(String text) {
		this.text = text;
	}

	private void setReceiver(String receiverID) {
		this.receiverID = receiverID;
	}
    
	private void setGroupID(String groupid) {
		this.groupID = groupid;
	}
	
	private void setSender(String string) {
		this.senderID = string;
	}
	
	public String getText() {
		return text;
	}

	public long getid() {
		return id;
	}

	public String getGroupID() {
		return groupID;
	}
	
	public String getTimeStamp() {
		return timestamp;
	}

	public String getReceiverID() {
		return receiverID;
	}

	public String getSenderID() {
		return senderID;
	}

	public static Message parseMessageInfo(String json) {
		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(json);
			Message msg = new Message();
			msg.setSender(object.get("senderID").toString());
			msg.setGroupID(object.get("groupID").toString());
			msg.setText(object.get("text").toString());
			msg.setReceiver(object.get("receiverID").toString());
			msg.setTimeStamp(object.get("timestamp").toString());
			msg.setId(Long.parseLong(object.get("id").toString()));
			return msg;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}



	public void MessageNotification(long senderID2, String ids[], long groupID,
			String timestamp, String text) {
		DatastoreService datastorenotifi = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuerynotifi = new Query("msgnotification");
		PreparedQuery pq1 = datastorenotifi.prepare(gaeQuerynotifi);
		List<Entity> list1 = pq1.asList(FetchOptions.Builder.withDefaults());

		for (int i = 0; i < ids.length; i++) {
			PreparedQuery pqqq = datastorenotifi.prepare(gaeQuerynotifi);
			List<Entity> list = pqqq
					.asList(FetchOptions.Builder.withDefaults());
			if (list.size() != 0) {
				Entity msg = new Entity("msgnotification", list
						.get(list.size() - 1).getKey().getId() + 1);
				if (ids.length == 1)
					msg.setProperty("GroupID", -1);
				else
					msg.setProperty("GroupID", groupID);
				msg.setProperty("senderID", senderID2);
				msg.setProperty("receiverID", ids[i]);
				msg.setProperty("timestamp", timestamp);
				msg.setProperty("text", text);
				datastorenotifi.put(msg);
			} else {
				Entity msg = new Entity("msgnotification", 1);
				if (ids.length == 1)
					msg.setProperty("GroupID", -1);
				else
					msg.setProperty("GroupID", groupID);
				msg.setProperty("senderID", senderID2);
				msg.setProperty("receiverID", ids[i]);
				msg.setProperty("timestamp", timestamp);
				msg.setProperty("text", text);
				datastorenotifi.put(msg);
			}

		}

	}

	public Boolean sendMessage() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("messages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		long GroupID;
		if (list.size() == 0)
			GroupID = 1;
		else
			GroupID = (Long) list.get(list.size() - 1).getKey().getId() + 1;
		String[] ids = receiverID.split("/");

		// for (int i = 0; i < ids.length; i++) {
		// Query gaeQuery = new Query("messages");
		// PreparedQuery pq = datastore.prepare(gaeQuery);
		// List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
		if (list.size() != 0) {
			Entity msg = new Entity("messages", list.get(list.size() - 1)
					.getKey().getId() + 1);
			if (ids.length == 1)
				msg.setProperty("GroupID", -1);
			else
				msg.setProperty("GroupID", GroupID);
			msg.setProperty("senderID", this.senderID);
			msg.setProperty("receiverID", this.receiverID);
			msg.setProperty("timestamp", this.timestamp);
			msg.setProperty("text", this.text);
			datastore.put(msg);
		} else {
			Entity msg = new Entity("messages", 1);
			if (ids.length == 1)
				msg.setProperty("GroupID", -1);
			else
				msg.setProperty("GroupID", GroupID);
			msg.setProperty("senderID", this.senderID);
			msg.setProperty("receiverID", this.receiverID);
			msg.setProperty("timestamp", this.timestamp);
			msg.setProperty("text", this.text);
			datastore.put(msg);
		}

		// }

		MessageNotification(Long.valueOf(this.senderID), ids, GroupID,
				this.timestamp, this.text);
		return true;

	}

	public static Message getMsg(long id , long currentserID) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		Query gaeQuery = new Query("messages");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		//System.out.println("id : " + id + "  , r : " + currentserID);
		if (id < 0) {
			id *= -1;			
			for (Entity entity : pq.asIterable()) {
				if (entity.getProperty("receiverID").toString().equals(String.valueOf(currentserID)) &&
						Long.parseLong(entity.getProperty("senderID").toString()) == id) {
//					System.out.println("id : " + id);
//					System.out.println("r : " + currentserID);
					
					Message returnedMsg = new Message(entity.getProperty(
							"senderID").toString(), entity.getProperty(
							"receiverID").toString(), entity.getProperty(
							"GroupID").toString(), entity.getProperty(
							"timestamp").toString(), entity.getProperty("text")
							.toString());
					returnedMsg.setId(entity.getKey().getId());
					
//					System.out.println(returnedMsg.getSender() + " " + returnedMsg.getTimeStap() + " "
//							+ returnedMsg.getText());
//					
					return returnedMsg;
				}
			}
		} else {
			for (Entity entity : pq.asIterable()) {
				if (Long.parseLong(entity.getProperty("GroupID").toString()) == id) {
					//System.out.println("second cond");
					Message returnedMsg = new Message(entity.getProperty(
							"senderID").toString(), entity.getProperty(
							"receiverID").toString(), entity.getProperty(
							"GroupID").toString(), entity.getProperty(
							"timestamp").toString(), entity.getProperty("text")
							.toString());
					returnedMsg.setId(entity.getKey().getId());
//					System.out.println(returnedMsg.getSender() + " " + returnedMsg.getTimeStap() + " "
//							+ returnedMsg.getText());
					return returnedMsg;
				}
			}
		}
		return null;
	}

	public static Vector<Message> getMessageNotification(String id) {
		long ID = Long.parseLong(id);

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		HashSet<Long> lis = new HashSet<>();

		Query gaeQuery = new Query("msgnotification");
		PreparedQuery pq = datastore.prepare(gaeQuery);

		for (Entity entity : pq.asIterable()) {
			if (Long.parseLong(entity.getProperty("receiverID").toString()) == ID){
				if (Long.parseLong(entity.getProperty("GroupID").toString()) == -1)
					lis.add(-1
							* Long.parseLong(entity.getProperty("senderID")
									.toString()));
				else
					lis.add(Long.parseLong(entity.getProperty("GroupID")
							.toString()));
			}
		}
		Iterator iterator = lis.iterator();
		Vector<Message> temp = new Vector<Message>();
		while (iterator.hasNext()) {
			Message msg = new Message();
			msg = Message.getMsg((long) iterator.next(),ID);
//			System.out.println(msg.receiverID + " " + msg.senderID + " "
//					+ msg.text);
			temp.add(msg);
		}
		return temp;
	}

}
