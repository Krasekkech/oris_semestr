package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Запрашиваем сессию, запрещая создавать новую в случае отсутствия
        // т.к. на этот момент клиент уже должен был успешно пройти аутентификацию (все запросы для проверки перехватывает фильтр),
        // то сессия должна существовать (по логике КОНКРЕТНО ЭТОГО приложения)
        HttpSession session = request.getSession(false);
        String clientName = (String)session.getAttribute("clientname");
        Long clientId = (Long)session.getAttribute("clientid");

        // кладем в атрибуты запроса данные, эти атрибуты будут обработаны шаблонизатором
        request.setAttribute("clientid", clientId);
        request.setAttribute("clientname", clientName);
        request.setAttribute("hello", "Hello for freemarker!");

        //Передаем управление диспетчеру , говоря, что требуется обработать сервлет по пути
        // index.ftl
        request.getRequestDispatcher("index.ftl").forward(request, response);
    }
}


