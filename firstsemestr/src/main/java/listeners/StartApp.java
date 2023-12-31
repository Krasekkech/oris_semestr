package listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import repository.DBConnection;

import java.sql.SQLException;

@WebListener
public class StartApp implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("start app ");
        try {
            DBConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("stop app ");
        DBConnection.destroyConnection();
    }
}
