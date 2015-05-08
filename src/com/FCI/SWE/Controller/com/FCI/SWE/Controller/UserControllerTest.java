package com.FCI.SWE.Controller.com.FCI.SWE.Controller;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FCI.SWE.Controller.UserController;

public class UserControllerTest {
	UserController user = new UserController();

	@DataProvider(name = "unFriendTest")
	public static Object[][] unFriendTest() {
		Object[][] x = { { "now, you become unfriend with him", 1, 2 },
				{ null, 3, 5 } };
		return x;
	}

	@Test(dataProvider = "unFriendTest")
	public void unFriend(String result, String senderId, String reciverId) {
		Assert.assertEquals(result, user.unFriend(null, senderId, reciverId));
		// throw new RuntimeException("Test not implemented");
	}

	@DataProvider(name = "addfrind")
	public static Object[][] addfrindTest() {
		Object[][] x = { { "sent Successfully", 1, 2 }, { null, 3, 5 } };
		return x;
	}

	@Test(dataProvider = "addfrind")
	public void addfrind(String result, String senderId, String reciverId) {
		Assert.assertEquals(result, user.addFriend(null, senderId, reciverId));
		// throw new RuntimeException("Test not implemented");
	}

	@DataProvider(name = "accfrind")
	public static Object[][] accfrindTest() {
		Object[][] x = { { "you become Friends with him now :) :)", 1, 2 },
				{ null, 3, 5 } };
		return x;
	}

	@Test(dataProvider = "accfrind")
	public void accfrind(String result, String senderId, String reciverId) {
		Assert.assertEquals(result,
				user.acceptFriend(null, senderId, reciverId));
		// throw new RuntimeException("Test not implemented");
	}

}
