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
        //Передаем управление диспетчеру , говоря, что требуется обработать сервлет по пути
        // profile.ftl
        request.getRequestDispatcher("profile.ftl").forward(request, response);
    }

    private ClientProfileService service = new ClientProfileService();
    //private ClientFriendService friendservice = new ClientFriendService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // извлекаем из запроса параметры формы
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String birthdate = request.getParameter("birthdate");
        String userinfo = request.getParameter("userinfo");
       // String friendusername = request.getParameter("friendusername");


        // создаем нового пользователя
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setUsername(username);
        clientProfile.setName(name);
        clientProfile.setAge(age);
        clientProfile.setBirthdate(birthdate);
        clientProfile.setUserinfo(userinfo);
        System.out.println(clientProfile);
        //ClientProfile clientprofile1 = service.findByUserName(username);
        // TODO - добавить проверку на уникальность логина
        // пытаемся добавить его в БД
       clientProfile = service.update(clientProfile);

        String clientprofilelist = service.findByUserName(clientProfile.getUsername());
        //String clientfriendslist = friendservice.findByUserName(clientProfile.getUsername());
        System.out.println("f");
        // Создаем сессию для пользователя, в атрибутах которой сохраним его идентификаторы
        HttpSession session = request.getSession();
        session.setAttribute("clientprofile", clientprofilelist);
        //session.setAttribute("clientfriends", clientfriendslist);
        System.out.println(clientprofilelist);
        // будем хранить в сессии имя клиента и его id для работы с БД
        session.setAttribute("clientbirthdate", clientProfile.getBirthdate());
        session.setAttribute("clientage", clientProfile.getAge());
}}
