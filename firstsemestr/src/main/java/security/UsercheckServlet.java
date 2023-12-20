package security;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Client;
import model.ClientProfile;
import service.ClientFriendService;
import service.ClientProfileService;
import service.ClientService;
import java.io.IOException;

/**
 * Сервлет принимает данные формы со страницы  /login
 * аутентифицирует пользователя по логину и паролю
 * перенаправляет:
 *  - при успешной аутентификации на главную страницу
 *  - при ошибке в логине или пароле вновь на страницу с шаблоном login.ftl с сообщением об ошибке
 */
@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {

    private ClientService service = new ClientService();
    private ClientProfileService profileservice = new ClientProfileService();
    private ClientFriendService friendservice = new ClientFriendService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("usercheck servlet");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Client client = service.findByUserName(username);




        if (client != null && client.getPassword().equals(password)) {

            HttpSession session = request.getSession();

            String clientprofilelist = profileservice.findByUserName(client.getUserName()).replace(" ", "_");
            String clientfriendslist = friendservice.findByUserName(client.getUserName());
            System.out.println(clientprofilelist);
            session.setAttribute("clientprofile", clientprofilelist);
            session.setAttribute("clientfriends", clientfriendslist);
            session.setAttribute("clientusername", username);


            response.sendRedirect("/firstsemestr_war_exploded/profile");

        } else {
            request.setAttribute("message", "Неверный пароль или логин");

            request.getRequestDispatcher("login.ftl").forward(request, response);
        }
    }
}
