package web.filters;

import model.RoleEnum;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/premium.jsp")
public class PremiumPageFilter implements Filter {

    /**
     * Only admin and premium user have access to the premium page.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        User user = (User)session.getAttribute("user");

        if (user == null || !(RoleEnum.PREMIUM.equals(user.getRole()) || RoleEnum.ADMIN.equals(user.getRole()))) {
            httpResponse.sendRedirect("accessDenied.jsp");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
