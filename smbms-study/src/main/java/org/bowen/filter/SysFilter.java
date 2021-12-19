package org.bowen.filter;

import org.bowen.pojo.User;
import org.bowen.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bowencoder
 * @date 2021/12/18 22:06
 */
public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);

        if(user==null){
            response.sendRedirect("/smbms/error.jsp");
        }else {
            chain.doFilter(req,resp);
        }
    }

    public void destroy() {

    }
}
