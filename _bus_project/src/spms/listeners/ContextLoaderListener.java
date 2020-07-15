package spms.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import spms.context.ApplicationContext;
public class ContextLoaderListener implements ServletContextListener{
	static ApplicationContext appLicationContext;
	
	public static ApplicationContext getApplicationContext(){
		return appLicationContext;
	}

	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext sc = event.getServletContext();
			
			String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			appLicationContext = new ApplicationContext(propertiesPath);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
