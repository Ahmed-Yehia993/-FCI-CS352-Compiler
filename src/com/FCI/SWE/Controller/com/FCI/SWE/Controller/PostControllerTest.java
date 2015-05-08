package com.FCI.SWE.Controller.com.FCI.SWE.Controller;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FCI.SWE.Controller.PostController;

public class PostControllerTest {
	public PostController post = new PostController();

	@DataProvider(name = "CreatePostTest")
	public static Object[][] CreatePostTest() {
		Object[][] x = { { true, 1, "first post", "privatee", "publice" } };
		return x;
	}

	@Test(dataProvider = "CreatePostTest")
	public void CreatePost(boolean result, String userId, String text,
			String privcy, String publicc) {

		Assert.assertEquals(result,
				post.CreatePost(null, userId, text, privcy, publicc));
		// throw new RuntimeException("Test not implemented");
	}

	@DataProvider(name = "likepostTest")
	public static Object[][] likepostTest() {
		Object[][] x = { { true, 1, 2 }, { false, 3, 5 } };
		return x;
	}

	@Test(dataProvider = "likepostTest")
	public void likepost(boolean result, String userId, String postId) {
		Assert.assertEquals(result, post.likepost(null, userId, postId));
		// throw new RuntimeException("Test not implemented");
	}
	

}
