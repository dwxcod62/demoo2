
package setup;
    
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import utils.PropertiesReader;


public class SetUpListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public SetUpListener() {
    }

    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String siteListLoc = context.getInitParameter("SITE_LIST");
        System.out.println(siteListLoc);
        
        Properties siteListProperty = PropertiesReader.getProperties(context, siteListLoc);
        context.setAttribute("SITE_MAP", siteListProperty);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
    }
}
