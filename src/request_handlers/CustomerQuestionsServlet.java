package request_handlers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.InterestingItem;
import model.Offer;
import model.ProbeRepository;
import model.Question;
import model.User;
import utility.DataManager;

/**
 * Servlet implementation class CustomerQuestionsServlet
 */
@WebServlet("/CustomerQuestionsServlet")
public class CustomerQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerQuestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		JSONObject result = new JSONObject();
//		
//		User user = User.getUser(request);
//		if(user == null) {
//			result.put("status", "failed");
//			response.getWriter().print(result.toJSONString());
//			return;
//		}
//		
//		// Fetch the question ids from the customer handler
//		Set<Integer> questionIds = user.handler.getProbingQuestions();
//		if(questionIds.isEmpty()) {
//			response.getWriter().print("");
//			return;
//		}
//		
//		// fetch the questions from the repository
//		ProbeRepository<InterestingItem, Offer> probeRepos = 
//				DataManager.getDM().getProbeRepository();
//		Set<Question<InterestingItem, Offer>> questions = new HashSet<>();
//		for(int id: questionIds) {
//			questions.add(probeRepos.getQuestion(id));
//		}
//		
//		// prepare the schema and the data
//		JSONArray schema = null;
//		JSONArray data = new JSONArray();
//		for(Question<InterestingItem, Offer> question: questions) {
//			if(schema == null) {
//				schema = new JSONArray();
//				String [] questionSchema = question.getInfo().getSchema();
//				for(String field: questionSchema) {
//					schema.add(field);
//				}
//				result.put("schema", schema);
//			}
//			
//			if(! question.isComplete()) {
//				data.add(question.getInfo().toJSON());
//			}
//		}
//		result.put("data", data);
//		
//		response.getWriter().print(result.toJSONString());
//		
		response.getWriter().print(prepareTempData().toJSONString());
	}
	
	public JSONObject prepareTempData() {
		JSONObject result = new JSONObject();
		JSONArray schemaArray = new JSONArray();
		
		//// prepare schema
		//{"id", "name", "number", "casNumber", "formula", "extraInfo"}
		schemaArray.add("question_id");
		schemaArray.add("id");
		schemaArray.add("name");
		schemaArray.add("number");
		schemaArray.add("casNumber");
		schemaArray.add("formula");
		schemaArray.add("extraInfo");
		result.put("schema", schemaArray);
		
		//// prepare data
		JSONArray data = new JSONArray();
		JSONObject data1 = new JSONObject();
		data1.put("question_id", "1");
		data1.put("id", "12");
		data1.put("name", "Meta Ethanol");
		data1.put("number", "2");
		data1.put("casNumber", "12-423-23");
		data1.put("formula", "C2H4PH5");
		data1.put("extraInfo", "300ml");
		data.add(data1);
		
		JSONObject data2 = new JSONObject();
		data2.put("question_id", "2");
		data2.put("id", "54");
		data2.put("name", "Methanol");
		data2.put("number", "10");
		data2.put("casNumber", "42-42-36");
		data2.put("formula", "C2H5O6C4");
		data2.put("extraInfo", "1000g");
		data.add(data2);
		
		JSONObject data3 = new JSONObject();
		data3.put("question_id", "3");
		data3.put("id", "2");
		data3.put("name", "Banzonat Pottasium");
		data3.put("number", "34");
		data3.put("casNumber", "28-63-233");
		data3.put("formula", "C2H2H3O8P2");
		data3.put("extraInfo", "500ml");
		data.add(data3);
		
		JSONObject data4 = new JSONObject();
		data4.put("question_id", "4");
		data4.put("id", "65");
		data4.put("name", "Psudo-alcohol salt sodium acid");
		data4.put("number", "1");
		data4.put("casNumber", "120-43-13");
		data4.put("formula", "C2H5O4S4N2");
		data4.put("extraInfo", "2 300ml bottles");
		data.add(data4);
		
		result.put("data", data);
		return result;
	}

}
