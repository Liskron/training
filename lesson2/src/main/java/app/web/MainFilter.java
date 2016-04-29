package app.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (isAuthorized(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            redirectToStaticPage(servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isAuthorized(ServletRequest servletRequest) {
        return servletRequest.getParameter("user_id") != null;
    }

    private void redirectToStaticPage(ServletResponse servletResponse) throws IOException {
        ((HttpServletResponse) servletResponse).sendRedirect("/secret2.jsp");
    }

}
