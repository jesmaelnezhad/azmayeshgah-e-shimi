package model;

import java.util.HashMap;
import java.util.Map;

public abstract class Handler {

	public static Map<Integer, Handler> handlers = new HashMap<>();
	public static Handler getHandler(Integer userId) {
		if(handlers.containsKey(userId)) {
			return handlers.get(userId);
		}else {
			return null;
		}
	}
	public static void saveHandler(Integer userId, Handler object) {
		handlers.put(userId, object);
	}
}