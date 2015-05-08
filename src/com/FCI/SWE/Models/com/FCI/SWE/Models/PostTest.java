package com.FCI.SWE.Models.com.FCI.SWE.Models;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FCI.SWE.Models.Post;

public class PostTest {
	
	@DataProvider(name="isLikePostTest")
	public static Object[][] isLikedTest() {
 		Object[][] x = { { true, "1","2" }, { false, "2","2" }};
 		return x;
 	}
  

  @Test(dataProvider="isLikePostTest")
  public void isLikePost(boolean result,String userId,String postId) {
	  Assert.assertEquals(result, Post.isLikePost(userId, postId));
    //throw new RuntimeException("Test not implemented");
  }
}
