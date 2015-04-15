package com.FCI.SWE.Services;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.FCI.SWE.Models.FriendShip;
import com.FCI.SWE.Models.Message;
import com.FCI.SWE.Models.Page;
import com.FCI.SWE.Models.Post;
import com.FCI.SWE.Models.User;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class PostService {

	@POST
	@Path("/CreatePostService")
	public String CreatePageService(@FormParam("current_user_id") String CurrentUserID,
			@FormParam("text") String text , @FormParam("privatee") String privatee ,
			@FormParam("publice") String publice) {
		
		JSONObject object = new JSONObject(); 
		String privacy = "public";
		
		if(publice.equals("null"))
			privacy = "private";
		
		if (Post.CreatePost(text, CurrentUserID, privacy))
			object.put("Status", "OK");
		else
			object.put("Status", "Failed");

		return object.toString();
	}
	
	@POST
	@Path("/LikePostService")
	public String LikePostService(@FormParam("current_user_id") String CurrentUserID,
			@FormParam("post_id") String post_id) {
		
		JSONObject object = new JSONObject();
		if (Post.likePost(CurrentUserID,post_id))
			object.put("Status", "OK");
		else
			object.put("Status", "Failed");

		return object.toString();
	}
	
	@POST
	@Path("/SharePostService")
	public String SharePostService(@FormParam("current_user_id") String CurrentUserID,
			@FormParam("post_id") String post_id) {
		
		JSONObject object = new JSONObject();
		if (Post.UpdateSharesCounter(CurrentUserID,post_id))
			object.put("Status", "OK");
		else
			object.put("Status", "Failed");

		return object.toString();
	}
	
	@POST
	@Path("/TimeLineService")
	public String TimeLineService(@FormParam("current_user_id") String CurrentUserID ) {
		Vector<Post> post = Page.getUserTimeLine(CurrentUserID);

		JSONArray returnedJson = new JSONArray();
		for (Post p : post) {
			JSONObject object = new JSONObject();
			object.put("ownerID", p.getOwnerID());
			object.put("pageID", p.getpageID());
			object.put("text", p.gettext());
			object.put("privacy", p.getprivacy());
			object.put("hashTag", p.getHashTag());
			object.put("CreationTime", p.getCreationTime());
			object.put("NumberOFLike", p.getNumberOFLike());
			object.put("NumberOFShare", p.getNumberOFShare());
			object.put("id", p.getId());
			returnedJson.add(object);
		}

		return returnedJson.toJSONString();
	}
	@POST
	@Path("/PostsService")
	public String PostsService(@FormParam("current_user_id") String CurrentUserID ) {
		Vector<Post> post = Page.getUserHomePosts(CurrentUserID);

		JSONArray returnedJson = new JSONArray();
		for (Post p : post) {
			JSONObject object = new JSONObject();
			object.put("ownerID", p.getOwnerID());
			object.put("pageID", p.getpageID());
			object.put("text", p.gettext());
			object.put("privacy", p.getprivacy());
			object.put("hashTag", p.getHashTag());
			object.put("CreationTime", p.getCreationTime());
			object.put("NumberOFLike", p.getNumberOFLike());
			object.put("NumberOFShare", p.getNumberOFShare());
			object.put("id", p.getId());
			returnedJson.add(object);
		}

		return returnedJson.toJSONString();
	}
	
	@POST
	@Path("/SearchTagService")
	public String SearchTagService(@FormParam("current_user_id") String CurrentUserID ,
			@FormParam("tagname") String tagname) {
		Vector<Post> post = Page.getTagsPosts(tagname);

		JSONArray returnedJson = new JSONArray();
		for (Post p : post) {
			JSONObject object = new JSONObject();
			object.put("ownerID", p.getOwnerID());
			object.put("pageID", p.getpageID());
			object.put("text", p.gettext());
			object.put("privacy", p.getprivacy());
			object.put("hashTag", p.getHashTag());
			object.put("CreationTime", p.getCreationTime());
			object.put("NumberOFLike", p.getNumberOFLike());
			object.put("NumberOFShare", p.getNumberOFShare());
			object.put("id", p.getId());
			returnedJson.add(object);
		}

		return returnedJson.toJSONString();
	}
	
}