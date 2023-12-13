
package filter;

import dto.Account;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RoleRedirectFilter implements Filter {

    public RoleRedirectFilter() {
    }    
    
    public void doFilter(ServletRequest request,    ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String url = null;
        String uri = httpRequest.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String resource = uri.substring(lastIndex+1);
        
        HttpSession session = httpRequest.getSession(false);
        Account acc = null;
        
        if (session == null) {
            chain.doFilter(request, response);
        }
           
        
        if (session.getAttribute("USER") != null && ("".equals(resource) || "sussces".equals(resource) || "loginPage".equals(resource) || resource.isEmpty())){
            acc = (Account) session.getAttribute("USER");
            if(acc != null) {
                url = "homePage";
                httpResponse.sendRedirect(url);
            } else chain.doFilter(request, response);
        } else chain.doFilter(request, response);
    }

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
       
    }
    
}
