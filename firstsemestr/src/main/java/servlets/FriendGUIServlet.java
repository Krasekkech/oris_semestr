package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ClientFriends;
import model.ClientProfile;
import repository.ClientFriendsRepository;
import service.ClientFriendService;
import service.ClientProfileService;

import java.io.IOException;

@WebServlet("/friendsprofile")
public class FriendGUIServlet extends HttpServlet {

        @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String friend = request.getParameter("friendusername");
//        String s = service.findByUserName(friend);
//        HttpSession session = request.getSession();
//        session.setAttribute("friendprofile", s);
//        System.out.println(s);
        request.getRequestDispatcher("friendprofile.ftl").forward(request,response);
//
//
  }
    private ClientProfileService service = new ClientProfileService();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("friendusername");



        String clientfriendslist = service.findByUserName(username);

        HttpSession session = request.getSession();
        session.setAttribute("friendprofile", clientfriendslist);
        System.out.println(clientfriendslist);


    }
}

