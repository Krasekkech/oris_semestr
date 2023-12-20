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


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private ClientService service = new ClientService();
    private ClientProfileService profileservice = new ClientProfileService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Client clientcheck = service.findByUserName(username);

        if(clientcheck == null){
            Client client = new Client();
            client.setName(name);
            client.setPhoneNumber(phone);
            client.setPassword(password);
            client.setUserName(username);


            client = service.save(client);

            HttpSession session = request.getSession();



            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setUsername(username);
            clientProfile.setName(null);
            clientProfile.setAge(null);
            clientProfile.setBirthdate(null);
            clientProfile.setUserinfo(null);
            clientProfile = profileservice.save(clientProfile);

            session.setAttribute("clientusername", client.getUserName());

            response.sendRedirect("/firstsemestr_war_exploded/login");}
        else {
            request.setAttribute("message", "Данный логин занят");
            request.getRequestDispatcher("regpage.ftl").forward(request, response);
        }
    }
}
