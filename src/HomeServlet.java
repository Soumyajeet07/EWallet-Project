package com.deloitte.ecommerce;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class HomeServlet extends HttpServlet {

    private Service service=new ServiceImpl(new DaoImpl());

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String signedOutVal = req.getParameter("signout");
        boolean sessionDestroyed = false;
        if (signedOutVal != null && signedOutVal.equals("true")) {
            session.invalidate();
            sessionDestroyed = true;
        }
        Object usernameObj=null;
        if (!sessionDestroyed) {
            mobileNoObj = session.getAttribute("mobileNo");
        }

        if (mobileNoObj == null || mobileNoObj.toString().isEmpty()) {
            resp.getWriter().println("you are not signed in yet");
            String signInLink = "<a href='form.html'>Sign In </a> ";
            writer.println(signInLink);
            return;
        }
        String mobileNo=mobileNoObj.toString();
        Customer c=service.getUserBymobileNo(mobileNo);
        int balance=user.getbalance();
        writer.println("Welcome " + mobileNo +" balance="+balance);
        String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
        writer.println(signoutLink);

    }


}







