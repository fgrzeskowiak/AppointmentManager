package com.projectsite.controller;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.projectsite.service.UserService;
import com.projectsite.model.User;
 
@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
    }
      
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user;
        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");
        String email = request.getParameter("inputEmail");
        UserService userService = new UserService();
        user = userService.addUser(username, email, password);
        request.getSession(true).setAttribute("user", user);
        String url = "j_security_check?j_username=" + username + "&j_password=" + password;
        String redirectUrl = response.encodeRedirectURL(url);
        response.sendRedirect(redirectUrl);
    }
    
 
}