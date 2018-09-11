package request_handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.MultipartStream.ItemInputStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Item;
import model.User;
import utility.DataManager;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = request.getParameter("query");
		
		if(query == null) {
			response.getWriter().println("");
			return;
		}
		
		JSONObject result = new JSONObject();
		JSONArray schema = new JSONArray();
		String [] schemaFields = null;
		JSONArray results = new JSONArray();
		
		User user = User.getUser(request);
		if(user == null) {
			result.put("status", "failed");
			response.getWriter().print(result.toJSONString());
			return;
		}
		
		Map<Integer, Item> resultItems = DataManager.getDM().getMainContainer().search(query);
		
		// filter the interesting items out
		List<Integer> interestingOnes = new ArrayList<>();
		for(Integer id : resultItems.keySet()) {
			if(user.handler.hasInterestingItem(id)) {
				interestingOnes.add(id);
			}
		}
		// remove interesting ones
		for(int id : interestingOnes) {
			resultItems.remove(id);
		}
		
		// add items to the returning data
		for(Map.Entry<Integer, Item> entry : resultItems.entrySet()) {
			Item item = entry.getValue();
			int id = entry.getKey();
			if(schemaFields == null) {
				schemaFields = item.getSchema();
			}
			JSONObject itemObj = item.getData();
			itemObj.put("id", id);
			results.add(itemObj);
		}
		if(schemaFields == null) {
			response.getWriter().println("");
			return;
		}
		for(String field: schemaFields) {
			schema.add(field);
		}
		schema.add("id");
		result.put("schema", schema);
		result.put("data", results);
		
		response.getWriter().println(result.toJSONString());
		return;
	}

}
