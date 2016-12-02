package edu.hziee.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest req, 
			ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		
		String loginURL = request.getContextPath() + "/login";
        
		boolean loginRequest = request.getRequestURI().equals(loginURL);
		boolean resourceRequest = request.getRequestURI()
			       .startsWith(request.getContextPath() + "/resources"+ "/");
		boolean loggedIn = (session != null)
				&& (session.getAttribute("userName") != null);

		if (loggedIn || loginRequest || resourceRequest) {
			if (!resourceRequest) { // Prevent browser from caching restricted resources. See also http://stackoverflow.com/q/4194207/157882
                response.setHeader("Cache-Control",
                		"no-cache, no-store, must-revalidate"); // HTTP 1.1.
                response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                response.setDateHeader("Expires", 0); // Proxies.
            }
		}
		else{
	        String returnUrl = request.getRequestURI();
			response.sendRedirect(loginURL+"?returnUrl="+returnUrl); // So, just perform standard synchronous redirect.
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
