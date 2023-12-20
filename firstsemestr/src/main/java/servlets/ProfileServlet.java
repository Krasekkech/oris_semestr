package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Client;
import model.ClientFriends;
import model.ClientProfile;
import service.ClientFriendService;
import service.ClientProfileService;
import service.ClientService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Сервлет для отображения странички с регистрационной формой
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("profile.ftl").forward(request, response);
    }

    private ClientProfileService service = new ClientProfileService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String birthdate = request.getParameter("birthdate");
        String userinfo = request.getParameter("userinfo");


        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setUsername(username);
        clientProfile.setName(name);
        clientProfile.setAge(age);
        clientProfile.setBirthdate(birthdate);
        clientProfile.setUserinfo(userinfo);
        System.out.println(clientProfile);
       clientProfile = service.update(clientProfile);

        String clientprofilelist = service.findByUserName(clientProfile.getUsername()).replace(" ", "_");
        HttpSession session = request.getSession();
        session.setAttribute("clientprofile", clientprofilelist);
        System.out.println(clientprofilelist);
}}
