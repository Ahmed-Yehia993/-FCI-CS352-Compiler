package com.FCI.SWE.Controller.com.FCI.SWE.Controller;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FCI.SWE.Controller.PageController;
import com.FCI.SWE.Controller.UserController;

public class PageControllerTest {
	PageController pag = new PageController();
	
	@DataProvider(name = "likepageTest")
	public static Object[][] likepageTest() {
		Object[][] x = { { "Done Successfully", 1, 2 },
				{ "Error , try again", 3, 7 } };
		return x;
	}

  @Test
  public void likepage(String result,String userId,String pageId) {
	  Assert.assertEquals(result,pag.likepage(null, userId, pageId) );
    //throw new RuntimeException("Test not implemented");
  }
}
