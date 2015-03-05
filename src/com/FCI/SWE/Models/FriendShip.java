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

	public static long[] tempFriend;

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
		/*
		 * 
		 * Query gaeQuery1 = new Query("notification"); PreparedQuery pq1 =
		 * datastore.prepare(gaeQuery1);
		 * 
		 * for (Entity entity : pq1.asIterable()) { if
		 * (Long.parseLong(entity.getProperty("senderID").toString()) == ID)
		 * lis.remove(Long.parseLong(entity.getProperty("receiverID")
		 * .toString())); else if (Long
		 * .parseLong(entity.getProperty("receiverID").toString()) == ID)
		 * lis.remove(Long.parseLong(entity.getProperty("senderID")
		 * .toString())); }
		 * 
		 * Query gaeQuery2 = new Query("friends"); PreparedQuery pq2 =
		 * datastore.prepare(gaeQuery2);
		 * 
		 * for (Entity entity : pq2.asIterable()) { if
		 * (Long.parseLong(entity.getProperty("ID1").toString()) == ID)
		 * lis.remove(Long.parseLong(entity.getProperty("ID2").toString()));
		 * else if (Long.parseLong(entity.getProperty("ID2").toString()) == ID)
		 * lis.remove(Long.parseLong(entity.getProperty("ID1").toString())); }
		 */

		Iterator iterator = lis.iterator();
		long[] temp = new long[lis.size()];
		int i = 0;
		while (iterator.hasNext()) {
			temp[i] = (long) iterator.next();
			i++;
		}
		tempFriend = temp;
		return tempFriend;
	}
}
