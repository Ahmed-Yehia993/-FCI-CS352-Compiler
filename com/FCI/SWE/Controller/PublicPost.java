package com.FCI.SWE.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;

//@Path("/")
//@Produces("text/html")
public class PublicPost extends CreatePost{

//	@POST
//	@Path("/createpost_public")
//	@Produces(MediaType.TEXT_PLAIN)
	public void create(PostCreator p , @Context HttpServletRequest req , @FormParam("current_user_id") String current_user_id ,
			@FormParam("text") String text , @FormParam("privatee") String privatee ,
			@FormParam("publice") String publice) {
		p.create(req, current_user_id, text, privatee, publice);
		
	}

}
