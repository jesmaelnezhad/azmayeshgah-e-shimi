/**
 * 
 */
package server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utility.DataManager;

/**
 * @author jam
 *
 */
@WebListener
public class Server implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        // Do your thing during webapp's startup.
    	// TODO: load data if datafile exists, load data structures, ...
    	String filePath = event.getServletContext().getInitParameter("itemsFilePath");
    	DataManager.getDM().initData(filePath);
//    	System.out.println("Number of items: " + DataManager.getDM().getInfo().toJSONString());
    }
    public void contextDestroyed(ServletContextEvent event) {
        // Do your thing during webapp's shutdown.
    	// TODO: save and exit
    }
}