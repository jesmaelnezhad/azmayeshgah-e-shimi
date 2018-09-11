package request_handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.InterestingItem;
import model.User;

/**
 * Servlet implementation class InterestingItemsServlet
 */
@WebServlet("/InterestingItemsServlet")
public class InterestingItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterestingItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JSONObject result = new JSONObject();
		
		User user = User.getUser(request);
		if(user == null) {
			result.put("status", "failed");
			response.getWriter().print(result.toJSONString());
			return;
		}
		
		JSONArray itemsArray = new JSONArray();
		List<InterestingItem> items = user.handler.getInterestingItems();
		String [] schema = null;
		for(InterestingItem item: items) {
			if(schema == null) {
				schema = item.getSchema();
			}
			itemsArray.add(item.toJSON());
		}
		if(schema == null) {
			response.getWriter().print("");
			return;
		}
		JSONArray schemaArray = new JSONArray();
		for(String field : schema) {
			schemaArray.add(field);
		}
		
		result.put("schema", schemaArray);
		result.put("data", itemsArray);
		
		
		response.getWriter().print(result.toJSONString());
	}

}
