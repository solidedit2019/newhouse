package com.kgc.house.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HouseFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        String url = request.getRequestURI();
        String path = url.substring(url.lastIndexOf("/")+1);
        if(path.equals("login.jsp")||path.equals("regs.jsp")||path.equals("getUserName")||path.equals("register")||path.equals("loginAction")){
            chain.doFilter(req, resp);
        }else {
            HttpSession session = request.getSession();
            Object users = session.getAttribute("users");
            if (users == null) {
                response.sendRedirect("login.jsp");
            } else {
                chain.doFilter(req, resp);
            }

        }
//
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
