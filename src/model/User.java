package model;

import javax.servlet.http.HttpServletRequest;

public class User {

	public CustomerHandler handler = new CustomerHandler();
	public SellerHandler seller1 = new SellerHandler();
	public SellerHandler seller2 = new SellerHandler();
	private int userId = 1; 
	
	
	public int getId() {
		return userId;
	}
	
	public static User getUser(HttpServletRequest req) {
		return (User) req.getSession().getAttribute(Constants.LOGGED_IN_USER);
	}
	
	public static void setUser(User user, HttpServletRequest req) {
		req.getSession().setAttribute(Constants.LOGGED_IN_USER, user);
	}
	
	public static int getTotalNumberOfSellers() {
		return 2;
	}
	
	
	
}
