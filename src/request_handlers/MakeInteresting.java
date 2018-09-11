package request_handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.InterestingItem;
import model.Item;
import model.User;
import utility.DataManager;

/**
 * Servlet implementation class MakeInteresting
 */
@WebServlet("/MakeInteresting")
public class MakeInteresting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeInteresting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject result = new JSONObject();
		
		String idStr = request.getParameter("id");
		String extraInfo = request.getParameter("extra_info");
		String action = request.getParameter("action"); 
		User user = User.getUser(request);
		if(user == null) {
			result.put("status", "failed");
			response.getWriter().print(result.toJSONString());
			return;
		}
		
		if(action != null && action.equals("remove")) {
			int id = 0;
			try {
				id = Integer.parseInt(idStr);
			} catch (NumberFormatException e) {
				result.put("status", "failed");
				response.getWriter().print(result.toJSONString());
				return;
			}
			
			user.handler.removeInterestingItem(id);
			response.getWriter().print("");
			return;
		}
		
		if(idStr == null || extraInfo == null) {
			result.put("status", "failed");
			response.getWriter().print(result.toJSONString());
			return;
		}
		
		int id = 0;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			result.put("status", "failed");
			response.getWriter().print(result.toJSONString());
			return;
		}
		
		Item item = DataManager.getDM().getMainContainer().getItemById(id);
		if(item == null) {
			result.put("status", "failed");
			response.getWriter().print(result.toJSONString());
			return;
		}
		
		user.handler.addInterestingItem(new InterestingItem(id, item, extraInfo));
		
		response.getWriter().print("");
	}

}
