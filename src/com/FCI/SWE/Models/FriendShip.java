package com.FCI.SWE.Models;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class FriendShip {

	public static boolean sendRequest(String senderID, String receiverID) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("notification");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		if (list.size() != 0) {
			Entity request = new Entity("notification", list
					.get(list.size() - 1).getKey().getId() + 1);

			request.setProperty("senderID", senderID);
			request.setProperty("receiverID", receiverID);
			datastore.put(request);
		}
		else{
			Entity request = new Entity("notification", 1);
            
			request.setProperty("senderID", senderID);
			request.setProperty("receiverID", receiverID);
			datastore.put(request);
		}

		return true;

	}
	public static boolean unFriendRequest(String senderID, String receiverID) {
		long ID1 = Long.parseLong(senderID);
		long ID2 = Long.parseLong(receiverID);
		
		DatastoreService data = DatastoreServiceFactory
				.getDatastoreService();
		Query gaQuery = new Query("friends");
		PreparedQuery p = data.prepare(gaQuery);
		List<Entity> lis = p.asList(FetchOptions.Builder.withDefaults());
//		System.out.println(senderID + " " + receiverID);		
		for (Entity entity : p.asIterable()) {
			if(entity.getProperty("friendID1").toString().equals(senderID) && entity.getProperty("friendID2").toString().equals(receiverID) || 
					entity.getProperty("friendID2").toString().equals(senderID) && entity.getProperty("friendID1").toString().equals(receiverID))
			{
				Entity req = new Entity("friends", entity.getKey().getId());
				data.delete(entity.getKey());
				//req.setProperty("friendID1", String.valueOf(-1));
				//req.setProperty("friendID2",  String.valueOf(-1));
			    //data.put(req);
			}
		}
		return true;

	}
	public static boolean acceptFriendRequest(String senderID, String receiverID) {
		long ID1 = Long.parseLong(senderID);
		long ID2 = Long.parseLong(receiverID);
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("friends");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		if (list.size() != 0) {
			Entity request = new Entity("friends", list
					.get(list.size() - 1).getKey().getId() + 1);

			request.setProperty("friendID1", senderID);
			request.setProperty("friendID2", receiverID);
			datastore.put(request);
		}
		else{
			Entity request = new Entity("friends", 1);

			request.setProperty("friendID1", senderID);
			request.setProperty("friendID2", receiverID);
			datastore.put(request);
		}
		
		DatastoreService data = DatastoreServiceFactory
				.getDatastoreService();
		Query gaQuery = new Query("notification");
		PreparedQuery p = data.prepare(gaQuery);
		List<Entity> lis = p.asList(FetchOptions.Builder.withDefaults());
		System.out.println(senderID + " " + receiverID);		
		for (Entity entity : p.asIterable()) {
			if(entity.getProperty("senderID").toString().equals(senderID) && entity.getProperty("receiverID").toString().equals(receiverID) || 
					entity.getProperty("receiverID").toString().equals(senderID) && entity.getProperty("senderID").toString().equals(receiverID))
			{
				Entity req = new Entity("notification", entity.getKey().getId());
				data.delete(entity.getKey());
				//req.setProperty("senderID", String.valueOf(-1));
				//req.setProperty("receiverID",  String.valueOf(-1));
			    //datastore.put(req);
			}
		}
		return true;

	}
	
	public static long[] getUsers(String id) {

		long ID = Long.parseLong(id);

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		HashSet<Long> lis = new HashSet<>();

		Query gaeQuery = new Query("users");
		PreparedQuery pq = datastore.prepare(gaeQuery);

		for (Entity entity : pq.asIterable()) {
			lis.add(entity.getKey().getId());
		}

		lis.remove(ID);
		
		  
		  Query gaeQuery1 = new Query("notification"); PreparedQuery pq1 =
		  datastore.prepare(gaeQuery1);
		  
		  for (Entity entity : pq1.asIterable()) { if
		  (Long.parseLong(entity.getProperty("senderID").toString()) == ID)
		  lis.remove(Long.parseLong(entity.getProperty("receiverID")
		  .toString())); else if (Long
		  .parseLong(entity.getProperty("receiverID").toString()) == ID)
		  lis.remove(Long.parseLong(entity.getProperty("senderID")
		  .toString())); }
		  
		  Query gaeQuery2 = new Query("friends"); PreparedQuery pq2 =
		  datastore.prepare(gaeQuery2);
		  
		  for (Entity entity : pq2.asIterable()) { if
		  (Long.parseLong(entity.getProperty("friendID1").toString()) == ID)
		  lis.remove(Long.parseLong(entity.getProperty("friendID2").toString()));
		  else if (Long.parseLong(entity.getProperty("friendID2").toString()) == ID)
		  lis.remove(Long.parseLong(entity.getProperty("friendID1").toString())); }
		 

		Iterator iterator = lis.iterator();
		long[] temp = new long[lis.size()];
		int i = 0;
		while (iterator.hasNext()) {
			temp[i] = (long) iterator.next();
			i++;
		}
		return temp;
	}

	public static long[] getMyFriends(String id) {

		long ID = Long.parseLong(id);

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		HashSet<Long> lis = new HashSet<>();

		Query gaeQuery = new Query("friends");
		PreparedQuery pq = datastore.prepare(gaeQuery);

		for (Entity entity : pq.asIterable()) {
			if(entity.getProperty("friendID1").toString().equals(id))
			     lis.add(Long.parseLong(entity.getProperty("friendID2").toString()));
			else if(entity.getProperty("friendID2").toString().equals(id))
			     lis.add(Long.parseLong(entity.getProperty("friendID1").toString()));
		}
		Iterator iterator = lis.iterator();
		long[] temp = new long[lis.size()];
		int i = 0;
		while (iterator.hasNext()) {
			temp[i] = (long) iterator.next();
			i++;
		}
		return temp;
	}
	
	public static long[] getNotifications(String id) {

		long ID = Long.parseLong(id);

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		HashSet<Long> lis = new HashSet<>();

		Query gaeQuery = new Query("notification");
		PreparedQuery pq = datastore.prepare(gaeQuery);

		for (Entity entity : pq.asIterable()) {
			if(entity.getProperty("receiverID").toString().equals(id))
			     lis.add(Long.parseLong(entity.getProperty("senderID").toString()));
		}

		Iterator iterator = lis.iterator();
		long[] temp = new long[lis.size()];
		int i = 0;
		while (iterator.hasNext()) {
			temp[i] = (long) iterator.next();
			i++;
		}
		return temp;
	}

}
