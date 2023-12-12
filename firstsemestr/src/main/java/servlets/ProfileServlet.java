package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Client;
import model.ClientProfile;
import service.ClientProfileService;
import service.ClientService;

import java.io.IOException;

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

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // извлекаем из запроса параметры формы
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String birthdate = request.getParameter("birthdate");

        // создаем нового пользователя
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setId(id);
        clientProfile.setName(name);
        clientProfile.setAge(age);
        clientProfile.setBirthdate(birthdate);

        // TODO - добавить проверку на уникальность логина
        // пытаемся добавить его в БД
        clientProfile = service.save(clientProfile);

        // Создаем сессию для пользователя, в атрибутах которой сохраним его идентификаторы
        HttpSession session = request.getSession();

        // будем хранить в сессии имя клиента и его id для работы с БД
        session.setAttribute("clientbirthdate", clientProfile.getBirthdate());
        session.setAttribute("clientage", clientProfile.getAge());

        // будем хранить в сессии имя клиента и его id для работы с БД

}}
