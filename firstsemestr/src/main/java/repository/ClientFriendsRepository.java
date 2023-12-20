package repository;

import model.ClientFriends;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientFriendsRepository {
    public ClientFriends save(ClientFriends clientFriends) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "insert into clientfriends (username, friendusername) " +
                            "values (?, ?)"
            );


            statement.setString(1, clientFriends.getUsername());
            statement.setString(2, clientFriends.getFriendusername());

            int resultSet = statement.executeUpdate();

            statement.close();

            return clientFriends;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String findByUserName(String username) {
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "select username, friendusername from clientfriends where username = ? "
            );

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            String result = resultSetToJson(resultSet);

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String resultSetToJson(ResultSet resultSet) throws Exception {
        StringBuilder json = new StringBuilder();
        json.append("[");
        while (resultSet.next()) {
            json.append("{");
            json.append("\"username\":\"").append(resultSet.getString("username")).append("\",");
            json.append("\"friendusername\":\"").append(resultSet.getString("friendusername")).append("\"");
            json.append("},");
        }
        json.deleteCharAt(json.length() - 1);
        json.append("]");
        return json.toString();
    }
}
