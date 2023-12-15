package security;

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
 * Сервлет принимает данные формы со страницы  /regpage
 * добавляет пользователя в систему
 * перенаправляет:
 *  - при успешном добавлении на главную страницу
 * TODO - при проблемах с данными формы вернуть на страницу регистрации
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private ClientService service = new ClientService();
    private ClientProfileService profileservice = new ClientProfileService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // извлекаем из запроса параметры формы
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Client clientcheck = service.findByUserName(username);

        if(clientcheck == null){
        // создаем нового пользователя
        Client client = new Client();
        client.setName(name);
        client.setPhoneNumber(phone);
        client.setPassword(password);
        client.setUserName(username);

        // TODO - добавить проверку на уникальность логина
        // пытаемся добавить его в БД
        client = service.save(client);

        // Создаем сессию для пользователя, в атрибутах которой сохраним его идентификаторы
        HttpSession session = request.getSession();

        //client = service.copy(client);

        ClientProfile clientProfile = new ClientProfile();
        //clientProfile.setId(null);
        clientProfile.setUsername(username);
        clientProfile.setName(null);
        clientProfile.setAge(null);
        clientProfile.setBirthdate(null);
        clientProfile.setUserinfo(null);
        clientProfile = profileservice.save(clientProfile);


        // String clientprofilelist = profileservice.findById(client.getId());

        // будем хранить в сессии имя клиента и его id для работы с БД
        session.setAttribute("clientname", client.getName());
        session.setAttribute("clientid", client.getId());
        session.setAttribute("clientusername", client.getUserName());
        //session.setAttribute("clientprofile", clientprofilelist);

        // перенаправляем на главную страницу
        response.sendRedirect("/firstsemestr_war_exploded/login");}
        else {
            request.setAttribute("message", "Данный логин занят");
            request.getRequestDispatcher("regpage.ftl").forward(request, response);
        }
    }
}
