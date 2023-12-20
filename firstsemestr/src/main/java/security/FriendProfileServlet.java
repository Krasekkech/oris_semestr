package security;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ClientFriends;
import service.ClientFriendService;

import java.io.IOException;

@WebServlet("/friendprofile")
public class FriendProfileServlet extends HttpServlet {


    private ClientFriendService service = new ClientFriendService();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String friendusername = request.getParameter("friendusername");

        ClientFriends clientFriends = new ClientFriends();
        System.out.println("g");
        clientFriends.setUsername(username);
        clientFriends.setFriendusername(friendusername);
        clientFriends = service.save(clientFriends);

        String clientfriendslist = service.findByUserName(clientFriends.getUsername()).replace(" ", "_");

        HttpSession session = request.getSession();
        session.setAttribute("friendprofile", clientfriendslist);
        System.out.println(clientfriendslist);


    }
}
