package request_handlers;


import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ItemsHandler
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ItemsHandler" })
public class ItemsHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemsHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintStream out = new PrintStream(response.getOutputStream());
		out.print(this.getItems().toString());
	}
	
	
	JSONArray getItems() {
		JSONArray results = new JSONArray();
		results.add(this.getItem("584-08-7", 
				"Potassium carbonate", 
				"کربنات پتاسیم", 
				"400ml", 
				"در حال قیمت گیری"));
		
		results.add(this.getItem("91-20-3", 
				"Naphthalene", 
				"نفتالین", 
				"1000ml", 
				"در حال قیمت گیری"));
		
		results.add(this.getItem("68-22-6", 
				"Ethanol", 
				"اتانول", 
				"800ml", 
				"در حال قیمت گیری"));
		
		return results;
	}
	
	JSONObject getItem(String CAS, String name1, String name2, String size, String status) {
		JSONObject obj = new JSONObject();
		obj.put("CAS", CAS);
		obj.put("name1", name1);
		obj.put("name2", name2);
		obj.put("size", size);
		obj.put("status", status);
		return obj;
	}

}
