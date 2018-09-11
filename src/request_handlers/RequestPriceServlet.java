package request_handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.InterestingItem;
import model.Offer;
import model.ProbeRepository;
import model.User;
import utility.DataManager;

/**
 * Servlet implementation class RequestPriceServlet
 */
@WebServlet("/RequestPriceServlet")
public class RequestPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPriceServlet() {
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
		
		ProbeRepository<InterestingItem, Offer> probeRepos = DataManager.getDM().getProbeRepository();
		
		List<InterestingItem> items = user.handler.getInterestingItems();
		
		for(InterestingItem item: items) {
			int questionId = probeRepos.registerNewQuestion(item, user.getId());
			user.handler.addProbingQuestionId(questionId);
		}
		
		user.handler.clearInterestingItems();
		
		response.sendRedirect("./customer_offers.jsp");
	}

}
