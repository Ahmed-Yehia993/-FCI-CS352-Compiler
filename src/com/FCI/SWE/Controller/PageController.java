package com.FCI.SWE.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.Page;
import com.FCI.SWE.Models.Post;

@Path("/")
@Produces("text/html")
public class PageController {

	@POST
	@Path("/createpage")
	@Produces(MediaType.TEXT_PLAIN)
	public String CreatePage(@Context HttpServletRequest req , @FormParam("current_user_id") String current_user_id ,
			@FormParam("pagename") String pagename) {
		current_user_id = (String) req.getSession().getAttribute("current_user_id"); 
		String serviceUrl = "http://localhost:8888/rest/CreatePageService";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "pagename=" + pagename + "&current_user_id=" + current_user_id; 

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000); // 60 Seconds
			connection.setReadTimeout(60000); // 60 Seconds

			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("Failed"))
				return "Error , try again";
			if (object.get("Status").equals("OK"))
				return "Page Created Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return null;

	}
    

	@POST
	@Path("/mypages")
	@Produces("text/html")
	public Response mypages(@Context HttpServletRequest req , @FormParam("current_user_id") String current_user_id) {
		current_user_id = (String) req.getSession().getAttribute("current_user_id"); 
		String serviceUrl = "http://localhost:8888/rest/myPagesService";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "&current_user_id=" + current_user_id;
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000); // 60 Seconds
			connection.setReadTimeout(60000); // 60 Seconds

			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");

			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			Map<String, Vector<Page>> PassedMsg = new HashMap<String, Vector<Page>>();
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(retJson);
			Vector<Page> msg = new Vector<Page>();
			for (int i = 0; i < array.size(); i++) {
				JSONObject object;
				object = (JSONObject) array.get(i);
				msg.add(Page.parsePageInfo(object.toJSONString()));
			} 
			PassedMsg.put("PageList", msg);
			return Response.ok(new Viewable("/jsp/mypages", PassedMsg))
					.build();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return null;
	}
	
	@POST
	@Path("/searchaboutpage")
	@Produces("text/html")
	public Response searchaboutpage(@Context HttpServletRequest req , @FormParam("current_user_id") String current_user_id,
			@FormParam("pagename") String pagename) {
		current_user_id = (String) req.getSession().getAttribute("current_user_id"); 
		String serviceUrl = "http://localhost:8888/rest/SearchAboutPageService";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "&current_user_id=" + current_user_id + "&pagename=" + pagename;
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000); // 60 Seconds
			connection.setReadTimeout(60000); // 60 Seconds

			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");

			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			Map<String, Vector<Page>> PassedMsg = new HashMap<String, Vector<Page>>();
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(retJson);
			Vector<Page> msg = new Vector<Page>();
			for (int i = 0; i < array.size(); i++) {
				JSONObject object;
				object = (JSONObject) array.get(i);
				msg.add(Page.parsePageInfo(object.toJSONString()));
			} 
			PassedMsg.put("PageList", msg);
			return Response.ok(new Viewable("/jsp/searchaboutpage", PassedMsg))
					.build();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return null;
	}
	
	@POST
	@Path("/showpage")
	@Produces("text/html")
	public Response showpage(@Context HttpServletRequest req , @FormParam("current_user_id") String current_user_id,
			@FormParam("pageid") String pageid) {
		
		current_user_id = (String) req.getSession().getAttribute("current_user_id"); 
		req.getSession(true).setAttribute("current_page_id",pageid);
		req.getSession(true).setAttribute("current_page_name",Page.getPageNameByID(pageid));
		
		if (Page.isLiked(current_user_id,pageid))  
			req.getSession(true).setAttribute("like","1");
		else 
			req.getSession(true).setAttribute("like","0");
		
		if (Page.getPageOwnerByID(pageid).equals(current_user_id))  
			req.getSession(true).setAttribute("owner","1");
		else 
			req.getSession(true).setAttribute("owner","0");
		
		String serviceUrl = "http://localhost:8888/rest/ShowPageService";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "&current_user_id=" + current_user_id + "&pageid=" + pageid;
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000); // 60 Seconds
			connection.setReadTimeout(60000); // 60 Seconds

			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");

			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			Map<String, Vector<Post>> PassedMsg = new HashMap<String, Vector<Post>>();
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(retJson);
			Vector<Post> msg = new Vector<Post>();
			for (int i = 0; i < array.size(); i++) {
				JSONObject object;
				object = (JSONObject) array.get(i);
				msg.add(Post.parsePostInfo(object.toJSONString()));
			} 
			
			//System.out.println(msg.get(0).gettext() + " " + msg.get(0).getCreationTime());
			
			PassedMsg.put("PagePostsList", msg);
			return Response.ok(new Viewable("/jsp/showpage", PassedMsg))
					.build();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return null;
	}
	
	@POST
	@Path("/pagepost")
	@Produces(MediaType.TEXT_PLAIN)
	public String pagepost(@Context HttpServletRequest req , @FormParam("current_user_id") String current_user_id ,
			@FormParam("text") String text , @FormParam("current_page_id") String current_page_id) {
		
		current_user_id = (String) req.getSession().getAttribute("current_user_id");
		current_page_id = (String) req.getSession().getAttribute("current_page_id"); 
		
		String serviceUrl = "http://localhost:8888/rest/CreatePagePostService";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "text=" + text + "&current_user_id=" + current_user_id 
					+ "&current_page_id=" + current_page_id; 

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000); // 60 Seconds
			connection.setReadTimeout(60000); // 60 Seconds

			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("Failed"))
				return "Error , try again";
			if (object.get("Status").equals("OK"))
				return "Post Created Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return null;

	}
	
	@POST
	@Path("/likepage")
	@Produces(MediaType.TEXT_PLAIN)
	public String likepage(@Context HttpServletRequest req , @FormParam("current_user_id") String current_user_id ,
			@FormParam("current_page_id") String current_page_id) {
		
		current_user_id = (String) req.getSession().getAttribute("current_user_id");
		current_page_id = (String) req.getSession().getAttribute("current_page_id"); 
				
		String serviceUrl = "http://localhost:8888/rest/LikePageService";
		try {
			URL url = new URL(serviceUrl);
			String urlParameters = "&current_user_id=" + current_user_id 
					+ "&current_page_id=" + current_page_id; 

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(60000); // 60 Seconds
			connection.setReadTimeout(60000); // 60 Seconds

			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(urlParameters);
			writer.flush();
			String line, retJson = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while ((line = reader.readLine()) != null) {
				retJson += line;
			}
			writer.close();
			reader.close();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("Failed"))
				return "Error , try again";
			if (object.get("Status").equals("OK"))
				return "Done Successfully";
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return null;

	}
}