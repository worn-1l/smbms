package org.bowen.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author bowencoder
 * @date 2021/12/18 10:22
 */
public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
