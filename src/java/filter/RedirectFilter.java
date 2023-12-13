
package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RedirectFilter implements Filter {

    public RedirectFilter() {
    }    
    
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String resource = uri.substring(lastIndex+1);
        String url;
        
        System.out.println("a");
        
        try{
            ServletContext context = request.getServletContext();
            Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
               
            url = siteMap.getProperty(resource);
            
            if (url != null){
                RequestDispatcher rd = httpRequest.getRequestDispatcher(url);
                rd.forward(request, response);
            }else {
                chain.doFilter(request, response);
            }
            
        } catch (Exception e){
            
        }
    }
    
    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
        
    }

    
}
