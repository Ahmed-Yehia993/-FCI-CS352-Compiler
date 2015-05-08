package com.FCI.SWE.Controller.com.FCI.SWE.Controller;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FCI.SWE.Controller.MSGController;

public class MSGControllerTest {
	MSGController msgob = new MSGController();

	@DataProvider(name = "SendMsgTest")
	public static Object[][] SendMsgTest() {
		Object[][] x = { { "Message send ", 1, 2, "helloo" },
				{ "Message send ", 3, 5, "ezaiiiik :D :D" } };
		return x;
	}

	@Test(dataProvider = "Message send ")
	public void SendMsg(String result, String senderId, String reciverIId,
			String msg) {
		Assert.assertEquals(result,
				msgob.SendMsg(null, senderId, reciverIId, msg));
		// throw new RuntimeException("Test not implemented");
	}

	@DataProvider(name = "acceptFriendTest")
	public static Object[][] acceptFriendTest() {
		Object[][] x = { { "seen", 1, 2, }, { "seen", 3, 5, } };
		return x;
	}

	@Test
	public void acceptFriend(String result, String userId, String msgId) {
		Assert.assertEquals(result, msgob.acceptFriend(null, userId, msgId));
		// throw new RuntimeException("Test not implemented");
	}
}
