package com.FCI.SWE.ModelsTest.com;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FCI.SWE.Models.User;

public class UserTest {

	@DataProvider(name = "getUserNameTest")
	public static Object[][] getUserStringTest() {
		Object[][] x = { { "ahmed", 1 }, { "ibrahim", 2 }, { "asd", 3 } };
		return x;
	}

	@Test(dataProvider = "getUserNameTest")
	public void getUserNameByID(String result, long id) {
		Assert.assertEquals(result, User.getUserNameByID(String.valueOf(id)));

		// throw new RuntimeException("Test not implemented");
	}

	@DataProvider(name = "getUserTest")
	public static Object[][] getUserTest() {
		Object[][] x = { { new User("ahmed","ahmed.com","123") , "ahmed","ahmed.com"}};
		return x;
	}

	@Test(dataProvider = "getUserTest")
	public void getUser(User result, String userName,String passWord) {
		Assert.assertEquals(result, User.getUser(userName,passWord));

		// throw new RuntimeException("Test not implemented");
	}

}
